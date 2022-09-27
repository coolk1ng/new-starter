package com.coolk1ng.job;

import com.coolk1ng.pojo.entity.DataNode;
import com.coolk1ng.service.DataJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 线程池
 *
 * @author coolk1ng
 * @since 2022/9/27 13:09
 */
@Component
public class BatchOperateJob {

    private static final Logger LOGGER = LoggerFactory.getLogger(BatchOperateJob.class);

    @Autowired
    private DataJobService dataJobService;

    /**
     * 批量插入
     *
     * @param list
     * @param batchSize
     * @return void
     */
    public void batchImport(List<DataNode> list, int batchSize) {
        // 数据总量
        int dataTotal = list.size();
        // 需要起的线程数
        int threadTotal = dataTotal / batchSize == 0 ? dataTotal / batchSize : dataTotal / batchSize + 1;
        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(threadTotal);
        try {
            CountDownLatch countDownLatch = new CountDownLatch(threadTotal);
            List<DataNode> subDataList;
            // 起始位置
            int fromIndex, toIndex;
            LOGGER.info("数据操作开始============================");
            for (int i = 0; i < threadTotal; i++) {
                fromIndex = i * batchSize;
                toIndex = Math.min(dataTotal, fromIndex + batchSize);
                //获取截取的list
                subDataList = list.subList(fromIndex, toIndex);
                ImportOperateJob importOperateJob = new ImportOperateJob(subDataList, countDownLatch,dataJobService);
                fixedThreadPool.execute(importOperateJob);
            }
            countDownLatch.await();
            LOGGER.info("数据操作完成============================");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        } finally {
            // 关闭线程池
            fixedThreadPool.shutdown();
        }
    }

}

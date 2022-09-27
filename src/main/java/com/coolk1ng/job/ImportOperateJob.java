package com.coolk1ng.job;

import com.coolk1ng.pojo.entity.DataNode;
import com.coolk1ng.service.DataJobService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.CollectionUtils;

import java.util.List;
import java.util.concurrent.CountDownLatch;

/**
 * 导入操作
 *
 * @author coolk1ng
 * @since 2022/9/27 13:12
 */
public class ImportOperateJob implements Runnable {

    private static final Logger LOGGER = LoggerFactory.getLogger(ImportOperateJob.class);

    private DataJobService dataJobService;

    private List<DataNode> list;
    private CountDownLatch countDownLatch;

    public ImportOperateJob(List<DataNode> list, CountDownLatch countDownLatch,DataJobService dataJobService) {
        this.dataJobService = dataJobService;
        this.list = list;
        this.countDownLatch = countDownLatch;
    }

    public ImportOperateJob() {
    }

    public DataJobService getDataJobService() {
        return dataJobService;
    }

    public void setDataJobService(DataJobService dataJobService) {
        this.dataJobService = dataJobService;
    }

    public List<DataNode> getList() {
        return list;
    }

    public void setList(List<DataNode> list) {
        this.list = list;
    }

    public CountDownLatch getCountDownLatch() {
        return countDownLatch;
    }

    public void setCountDownLatch(CountDownLatch countDownLatch) {
        this.countDownLatch = countDownLatch;
    }

    @Override
    public void run() {
        if (!CollectionUtils.isEmpty(list)) {
            // TODO 插入操作
            LOGGER.info("部分数据数据导入开始========");
            dataJobService.insertToDatabase(list);
            LOGGER.info("部分数据数据导入完成========");
        }
        // 发出完成信号
        countDownLatch.countDown();
    }
}

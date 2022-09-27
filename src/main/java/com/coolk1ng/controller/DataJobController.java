package com.coolk1ng.controller;

import com.coolk1ng.job.BatchOperateJob;
import com.coolk1ng.pojo.entity.DataNode;
import com.coolk1ng.service.DataJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author coolk1ng
 * @since 2022/9/27 11:06
 */
@RestController
@RequestMapping("/data")
public class DataJobController {

    @Autowired
    private DataJobService dataJobService;

    @Autowired
    private BatchOperateJob batchOperateJob;

    @Value("${file.path}")
    private String path;

    @GetMapping("/getDataList")
    public List<DataNode> getDataList() {
        return dataJobService.getListByFile(path);
    }

    @GetMapping("/startImport")
    public void startImport() {
        List<DataNode> dataList = dataJobService.getListByFile(path);
        batchOperateJob.batchImport(dataList,5000);
    }

    @GetMapping("/deleteAllData")
    public void deleteAllData() {
        dataJobService.deleteAllData();
    }

}

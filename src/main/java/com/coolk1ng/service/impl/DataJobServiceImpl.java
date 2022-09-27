package com.coolk1ng.service.impl;

import cn.hutool.core.io.file.FileReader;
import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.coolk1ng.mapper.DataJobMapper;
import com.coolk1ng.pojo.entity.DataNode;
import com.coolk1ng.service.DataJobService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author coolk1ng
 * @since 2022/9/27 11:05
 */
@Service("DataJobService")
public class DataJobServiceImpl implements DataJobService {

    @Autowired
    private DataJobMapper dataJobMapper;

    @Override
    public List<DataNode> getListByFile(String path) {
        FileReader fileReader = new FileReader(path);
        String str = fileReader.readString();
        JSONObject jsonObject = JSON.parseObject(str);
        List<DataNode> nodes = jsonObject.getJSONArray("results").getJSONObject(0)
                .getJSONArray("tables").getJSONObject(0).getJSONArray("rows").toJavaList(DataNode.class);
        return nodes;
    }

    @Override
    @Transactional
    public void insertToDatabase(List<DataNode> list) {
        dataJobMapper.batchImportJob(list);
    }

    @Override
    @Transactional
    public void deleteAllData() {
        dataJobMapper.deleteAllData();
    }


}

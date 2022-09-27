package com.coolk1ng.service;

import com.coolk1ng.pojo.entity.DataNode;

import java.util.List;

/**
 * 从文件中抽取收据
 *
 * @author coolk1ng
 * @since 2022/9/27 11:05
 */
public interface DataJobService {

    /**
     * 抽取收据
     * @param path
     * @return List<DataNode>
     */
    List<DataNode> getListByFile(String path);

    /**
     * 插入
     * @param list
     * @return ResResult
     */
    void insertToDatabase(List<DataNode> list);

    /**
     * 删除所有
     * @return void
     */
    void deleteAllData();
}

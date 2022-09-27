package com.coolk1ng.mapper;

import com.coolk1ng.pojo.entity.DataNode;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 数据操作Mapper
 *
 * @author coolk1ng
 * @since 2022/9/27 13:35
 */
@Mapper
public interface DataJobMapper {

    /**
     * 批量插入
     * @param list
     * @return void
     */
    void batchImportJob(List<DataNode> list);

    /**
     * 删除所有
     * @return void
     */
    void deleteAllData();
}

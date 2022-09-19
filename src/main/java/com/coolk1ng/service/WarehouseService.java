package com.coolk1ng.service;


import com.coolk1ng.base.ResResult;
import com.coolk1ng.pojo.dto.WarehouseDTO;
import com.coolk1ng.pojo.entity.WarehouseInfo;
import com.coolk1ng.pojo.vo.WarehouseVO;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 仓库基础信息(WarehouseInfo)表服务接口
 *
 * @author makejava
 * @since 2022-09-19 14:36:05
 */
public interface WarehouseService {

    /**
     * 查询列表
     * @param warehouseDTO
     * @return PageInfo<WarehouseVO>
     */
    PageInfo<WarehouseVO> getWarehouseList(WarehouseDTO warehouseDTO);

    /**
     * 新增,编辑
     * @param warehouseDTO
     * @return String
     */
    ResResult saveAndUpdateWarehouse(WarehouseDTO warehouseDTO);

    ResResult deleteWarehouse(WarehouseDTO warehouseDTO);

    List<WarehouseInfo> getAllWarehouse();

}

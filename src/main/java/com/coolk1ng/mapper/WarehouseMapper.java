package com.coolk1ng.mapper;

import com.coolk1ng.pojo.dto.WarehouseDTO;
import com.coolk1ng.pojo.vo.WarehouseVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * (WarehouseOrder)表数据库访问层
 *
 * @author makejava
 * @since 2022-09-19 14:43:14
 */
@Mapper
public interface WarehouseMapper {

    /**
     * 查询列表
     * @param warehouseDTO
     * @return List<WarehouseVO>
     */
    List<WarehouseVO> getWarehouseList(WarehouseDTO warehouseDTO);

    /**
     * 新增入库订单
     * @param warehouseDTO
     * @return void
     */
    void saveWarehouseOrder(WarehouseDTO warehouseDTO);

    /**
     * 新增仓库数据
     * @param warehouseDTO
     * @return void
     */
    void saveWarehouseInfo(WarehouseDTO warehouseDTO);

    /**
     * 编辑入库订单
     * @param warehouseDTO
     * @return void
     */
    void updateWarehouseOrder(WarehouseDTO warehouseDTO);

    /**
     * 编辑仓库数据
     * @param warehouseDTO
     * @return void
     */
    void updateWarehouseInfo(WarehouseDTO warehouseDTO);

    WarehouseVO getWarehouse(Integer id);

    void deleteWarehouseOrder(Integer id);

    void deleteWarehouseInfo(Integer id);

}


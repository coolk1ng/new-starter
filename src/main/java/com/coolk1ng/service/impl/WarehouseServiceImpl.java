package com.coolk1ng.service.impl;

import com.coolk1ng.mapper.WarehouseMapper;
import com.coolk1ng.pojo.dto.WarehouseDTO;
import com.coolk1ng.pojo.vo.WarehouseVO;
import com.coolk1ng.service.WarehouseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * 仓库基础信息(WarehouseInfo)表服务实现类
 *
 * @author coolk1ng
 * @since 2022-09-19 14:36:05
 */
@Service("warehouseService")
public class WarehouseServiceImpl implements WarehouseService {

    @Autowired
    private WarehouseMapper warehouseMapper;

    @Override
    public PageInfo<WarehouseVO> getWarehouseList(WarehouseDTO warehouseDTO) {
        PageHelper.startPage(warehouseDTO.getPageNum() == null ? 1 : warehouseDTO.getPageNum()
                , warehouseDTO.getPageSize() == null ? 5 : warehouseDTO.getPageSize());
        List<WarehouseVO> list = warehouseMapper.getWarehouseList(warehouseDTO);
        return new PageInfo<>(list);
    }

    @Override
    @Transactional
    public String saveAndUpdateWarehouse(WarehouseDTO warehouseDTO) {
        if (warehouseDTO.getId() == null) {
            // 新增
            warehouseMapper.saveWarehouseOrder(warehouseDTO);
            warehouseMapper.saveWarehouseInfo(warehouseDTO);
        }
        if (warehouseMapper.getWarehouse(warehouseDTO.getId()) == null) {
            return "不存在的记录";
        }
        // 编辑
        warehouseMapper.updateWarehouseInfo(warehouseDTO);
        warehouseMapper.updateWarehouseOrder(warehouseDTO);
        return "新增,编辑成功";
    }

    @Override
    @Transactional
    public void deleteWarehouse(WarehouseDTO warehouseDTO) {
        warehouseMapper.deleteWarehouseOrder(warehouseDTO.getId());
        WarehouseVO warehouse = warehouseMapper.getWarehouse(warehouseDTO.getId());
        warehouseMapper.deleteWarehouseInfo(warehouse.getWarehouse());
    }
}
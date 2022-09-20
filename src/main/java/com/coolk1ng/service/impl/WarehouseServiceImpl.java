package com.coolk1ng.service.impl;

import com.coolk1ng.base.ResResult;
import com.coolk1ng.mapper.WarehouseMapper;
import com.coolk1ng.pojo.dto.WarehouseDTO;
import com.coolk1ng.pojo.entity.WarehouseInfo;
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
    public ResResult saveAndUpdateWarehouse(WarehouseDTO warehouseDTO) {
        if (warehouseDTO.getId() == null) {
            // 新增
            warehouseMapper.saveWarehouseOrder(warehouseDTO);
            //warehouseMapper.saveWarehouseInfo(warehouseDTO);
            return ResResult.success("新增成功");
        }
        if (warehouseMapper.getWarehouse(warehouseDTO.getId()) == null) {
            return ResResult.fail("不存在的数据");
        }
        // 编辑
        //warehouseMapper.updateWarehouseInfo(warehouseDTO);
        warehouseMapper.updateWarehouseOrder(warehouseDTO);
        return ResResult.success("编辑成功");
    }

    @Override
    @Transactional
    public ResResult deleteWarehouse(Integer[] ids) {
        warehouseMapper.deleteWarehouseOrder(ids);
        //WarehouseVO warehouse = warehouseMapper.getWarehouse(warehouseDTO.getId());
        //warehouseMapper.deleteWarehouseInfo(warehouse.getWarehouse());
        return ResResult.success("删除成功");
    }

    @Override
    public List<WarehouseInfo> getAllWarehouse() {
        return warehouseMapper.getAllWarehouse();
    }
}

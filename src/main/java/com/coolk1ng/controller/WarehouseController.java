package com.coolk1ng.controller;

import com.alibaba.fastjson.JSON;
import com.coolk1ng.base.ResResult;
import com.coolk1ng.pojo.dto.WarehouseDTO;
import com.coolk1ng.service.WarehouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 仓库基础信息(WarehouseInfo)表控制层
 *
 * @author makejava
 * @since 2022-09-19 14:36:00
 */
@RestController
@RequestMapping(value = "/warehouseInfo")
public class WarehouseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(WarehouseController.class);

    @Autowired
    private WarehouseService warehouseService;

    @PostMapping(value = "/getWarehouseList")
    public ResResult getWarehouseList (@RequestBody WarehouseDTO warehouseDTO) {
        LOGGER.info("列表查询参数:{}", JSON.toJSONString(warehouseDTO));
        return ResResult.success(warehouseService.getWarehouseList(warehouseDTO));
    }

    @PostMapping(value = "/saveAndUpdateWarehouse")
    public ResResult saveAndUpdateWarehouse(@RequestBody WarehouseDTO warehouseDTO) {
        LOGGER.info("新增编辑参数:{}", JSON.toJSONString(warehouseDTO));
        return warehouseService.saveAndUpdateWarehouse(warehouseDTO);
    }

    @PostMapping(value = "/deleteWarehouse")
    public ResResult deleteWarehouse(@RequestBody WarehouseDTO warehouseDTO) {
        return warehouseService.deleteWarehouse(warehouseDTO);
    }
}


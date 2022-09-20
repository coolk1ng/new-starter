package com.coolk1ng.controller;

import com.alibaba.fastjson.JSON;
import com.coolk1ng.base.ResResult;
import com.coolk1ng.pojo.dto.WarehouseDTO;
import com.coolk1ng.service.WarehouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.ArrayList;

/**
 * 仓库基础信息(WarehouseInfo)表控制层
 *
 * @author makejava
 * @since 2022-09-19 14:36:00
 */
@RestController
@RequestMapping(value = "/warehouse")
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
    public ResResult saveAndUpdateWarehouse(@RequestBody @Valid WarehouseDTO warehouseDTO, BindingResult bindingResult) {
        LOGGER.info("新增编辑参数:{}", JSON.toJSONString(warehouseDTO));
        if (bindingResult.hasErrors()) {
            ArrayList<String> errors = new ArrayList<>();
            bindingResult.getAllErrors().forEach(item -> {
                errors.add(item.getDefaultMessage());
            });
            return ResResult.fail(errors);
        }
        return warehouseService.saveAndUpdateWarehouse(warehouseDTO);
    }

    @PostMapping(value = "/deleteWarehouse")
    public ResResult deleteWarehouse(@RequestBody WarehouseDTO warehouseDTO) {
        LOGGER.info("删除的记录id:{}",JSON.toJSONString(warehouseDTO.getId()));
        return warehouseService.deleteWarehouse(warehouseDTO);
    }

    @PostMapping(value = "/getAllWarehouse")
    public ResResult getAllWarehouse() {
        return ResResult.success(warehouseService.getAllWarehouse());
    }
}


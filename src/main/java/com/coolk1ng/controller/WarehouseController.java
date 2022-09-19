package com.coolk1ng.controller;

import com.coolk1ng.entity.WarehouseInfo;
import com.coolk1ng.service.WarehouseInfoService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;

/**
 * 仓库基础信息(WarehouseInfo)表控制层
 *
 * @author makejava
 * @since 2022-09-19 14:36:00
 */
@RestController
@RequestMapping("warehouseInfo")
public class WarehouseController {
    /**
     * 服务对象
     */
    @Resource
    private WarehouseInfoService warehouseInfoService;

    /**
     * 分页查询
     *
     * @param warehouseInfo 筛选条件
     * @param pageRequest      分页对象
     * @return 查询结果
     */
    @GetMapping
    public ResponseEntity<Page<WarehouseInfo>> queryByPage(WarehouseInfo warehouseInfo, PageRequest pageRequest) {
        return ResponseEntity.ok(this.warehouseInfoService.queryByPage(warehouseInfo, pageRequest));
    }

    /**
     * 通过主键查询单条数据
     *
     * @param id 主键
     * @return 单条数据
     */
    @GetMapping("{id}")
    public ResponseEntity<WarehouseInfo> queryById(@PathVariable("id") Integer id) {
        return ResponseEntity.ok(this.warehouseInfoService.queryById(id));
    }

    /**
     * 新增数据
     *
     * @param warehouseInfo 实体
     * @return 新增结果
     */
    @PostMapping
    public ResponseEntity<WarehouseInfo> add(WarehouseInfo warehouseInfo) {
        return ResponseEntity.ok(this.warehouseInfoService.insert(warehouseInfo));
    }

    /**
     * 编辑数据
     *
     * @param warehouseInfo 实体
     * @return 编辑结果
     */
    @PutMapping
    public ResponseEntity<WarehouseInfo> edit(WarehouseInfo warehouseInfo) {
        return ResponseEntity.ok(this.warehouseInfoService.update(warehouseInfo));
    }

    /**
     * 删除数据
     *
     * @param id 主键
     * @return 删除是否成功
     */
    @DeleteMapping
    public ResponseEntity<Boolean> deleteById(Integer id) {
        return ResponseEntity.ok(this.warehouseInfoService.deleteById(id));
    }

}


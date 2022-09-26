package com.coolk1ng.controller;

import com.alibaba.fastjson.JSON;
import com.coolk1ng.base.PageEntity;
import com.coolk1ng.base.ResResult;
import com.coolk1ng.pojo.dto.*;
import com.coolk1ng.service.StoreHouseService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 库存Controller
 *
 * @author coolk1ng
 * @since 2022/9/23 10:50
 */
@RestController
@RequestMapping(value = "/storeHouse")
public class StoreHouseController {

    private final static Logger LOGGER = LoggerFactory.getLogger(StoreHouseController.class);

    @Autowired
    private StoreHouseService storeHouseService;

    @PostMapping("/getProductList")
    public ResResult getProductList(@RequestBody ProductDTO productDTO) {
        LOGGER.info("商品列表查询参数:{}", JSON.toJSONString(productDTO));
        return ResResult.success(storeHouseService.getProductList(productDTO));
    }

    @PostMapping("/getOrderList")
    public ResResult getOrderList(@RequestBody PageEntity pageEntity) {
        LOGGER.info("订单列表查询参数:{}", JSON.toJSONString(pageEntity));
        return ResResult.success(storeHouseService.getOrderBaseList(pageEntity));
    }

    @PostMapping("/saveInboundInfo")
    public ResResult saveInboundInfo(@RequestBody InboundDTO inboundDTO) {
        return storeHouseService.saveInboundInfo(inboundDTO);
    }

    @PostMapping("/getInboundList")
    public ResResult getInboundList(@RequestBody PageEntity pageEntity) {
        return ResResult.success(storeHouseService.getInboundList(pageEntity));
    }

    @PostMapping("/saveDefectiveInfo")
    public ResResult saveDefectiveInfo(@RequestBody DefectiveDTO defectiveDTO) {
        return storeHouseService.saveDefectiveInfo(defectiveDTO);
    }

    @PostMapping("/saveOutboundInfo")
    public ResResult saveOutboundInfo(@RequestBody OutboundDTO outboundDTO) {
        return storeHouseService.saveOutboundInfo(outboundDTO);
    }

    @PostMapping("/getDefInfoList")
    public ResResult getDefInfoList(@RequestBody DefectiveDTO defectiveDTO) {
        LOGGER.info("次品列表查询参数:{}",JSON.toJSONString(defectiveDTO));
        return ResResult.success(storeHouseService.getDefInfoList(defectiveDTO));
    }

    @PostMapping("/saveInboundByDef")
    public ResResult saveInboundInfo(@RequestBody DefectiveDTO defectiveDTO) {
        return storeHouseService.saveInboundInfo(defectiveDTO);
    }

    @PostMapping("/saveOrderToInbound")
    public ResResult saveOrderTOInbound(@RequestBody OrderDTO orderDTO) {
        LOGGER.info("订单入库传入参数:{}",JSON.toJSONString(orderDTO));
        return storeHouseService.saveOrderToInbound(orderDTO);
    }
}

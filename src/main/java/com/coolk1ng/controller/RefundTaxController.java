package com.coolk1ng.controller;

import com.alibaba.fastjson.JSON;
import com.coolk1ng.base.ResResult;
import com.coolk1ng.pojo.dto.RefundTaxDTO;
import com.coolk1ng.pojo.entity.RefundTax;
import com.coolk1ng.service.RefundTaxService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * 退税(RefundTax)表控制层
 *
 * @author coolk1ng
 * @since 2022-09-19 16:04:23
 */
@RestController
@RequestMapping(value = "/refundTax")
public class RefundTaxController {

    private final static Logger LOGGER = LoggerFactory.getLogger(RefundTaxController.class);

    @Autowired
    private RefundTaxService refundTaxService;

    @PostMapping(value = "/getRefundTaxList")
    public ResResult getRefundTaxList(@RequestBody RefundTax refundTax) {
        LOGGER.info("查询列表参数:{}", JSON.toJSONString(refundTax));
        return ResResult.success(refundTaxService.getRefundTaxList(refundTax));
    }

    @PostMapping(value = "/saveRefundTax")
    public ResResult saveRefundTax(@RequestBody RefundTax refundTax) {
        LOGGER.info("新增数据参数:{}", JSON.toJSONString(refundTax));
        refundTaxService.saveRefundTax(refundTax);
        return ResResult.success("新增成功");
    }

    @PostMapping(value = "/getRefundTaxByIds")
    public ResResult getRefundTaxByIds(Integer[] ids) {
        return refundTaxService.getRefundTaxByIds(ids);
    }

    @PostMapping(value = "/getTheoryRefundTaxByInvoiceAmountAndTaxRate")
    public ResResult getTheoryRefundTaxByInvoiceAmountAndTaxRate(@RequestBody RefundTaxDTO refundTaxDTO) {
        return ResResult.success(refundTaxService.getTheoryRefundTaxByInvoiceAmountAndTaxRate(refundTaxDTO));
    }

    @PostMapping(value = "/updateRefundTax")
    public ResResult updateRefundTax(@RequestBody List<RefundTaxDTO> list) {
        return refundTaxService.updateRefundTax(list);
    }
}


package com.coolk1ng.service;

import com.coolk1ng.base.ResResult;
import com.coolk1ng.pojo.dto.RefundTaxDTO;
import com.coolk1ng.pojo.entity.RefundTax;
import com.github.pagehelper.PageInfo;

import java.math.BigDecimal;
import java.util.List;

/**
 * 退税(RefundTax)表服务接口
 *
 * @author makejava
 * @since 2022-09-19 16:04:28
 */
public interface RefundTaxService {

    PageInfo<RefundTax> getRefundTaxList(RefundTaxDTO refundTaxDTO);

    void saveRefundTax(RefundTaxDTO refundTaxDTO);

    /**
     * 退税记账列表
     * @param ids
     * @return ResResult
     */
    ResResult getRefundTaxByIds(Integer[] ids);

    /** 
     * 计算理论退税
     * @param refundTaxDTO 
     * @return BigDecimal
     */
    BigDecimal getTheoryRefundTaxByInvoiceAmountAndTaxRate(RefundTaxDTO refundTaxDTO);

    /** 
     * 退税
     * @param list
     * @return ResResult
     */
    ResResult updateRefundTax(List<RefundTaxDTO> list);
}

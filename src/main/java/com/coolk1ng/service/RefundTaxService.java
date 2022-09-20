package com.coolk1ng.service;

import com.coolk1ng.base.ResResult;
import com.coolk1ng.pojo.dto.RefundTaxDTO;
import com.coolk1ng.pojo.entity.RefundTax;
import com.github.pagehelper.PageInfo;

import java.math.BigDecimal;

/**
 * 退税(RefundTax)表服务接口
 *
 * @author makejava
 * @since 2022-09-19 16:04:28
 */
public interface RefundTaxService {

    PageInfo<RefundTax> getRefundTaxList(RefundTax refundTax);

    void saveRefundTax(RefundTax refundTax);

    ResResult getRefundTaxByIds(String ids);

    /** 
     * 计算理论退税
     * @param refundTaxDTO 
     * @return BigDecimal
     */
    BigDecimal getTheoryRefundTaxByInvoiceAmountAndTaxRate(RefundTaxDTO refundTaxDTO);

    ResResult updateRefundTax(String idAndActualRefundTax);
}

package com.coolk1ng.service;

import com.coolk1ng.pojo.entity.RefundTax;
import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * 退税(RefundTax)表服务接口
 *
 * @author makejava
 * @since 2022-09-19 16:04:28
 */
public interface RefundTaxService {

    PageInfo<RefundTax> getRefundTaxList(RefundTax refundTax);

    void saveRefundTax(RefundTax refundTax);

    List<RefundTax> getRefundTaxByIds(String ids);

}

package com.coolk1ng.mapper;

import com.coolk1ng.pojo.entity.RefundTax;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 退税(RefundTax)表数据库访问层
 *
 * @author coolk1ng
 * @since 2022-09-19 16:04:23
 */
@Mapper
public interface RefundTaxMapper {

    List<RefundTax> getRefundTaxList(RefundTax refundTax);

    void saveRefundTax(RefundTax refundTax);

    List<RefundTax> getRefundTaxByIds(List<Integer> ids);

    void updateRefundTax (List<RefundTax> list);
}


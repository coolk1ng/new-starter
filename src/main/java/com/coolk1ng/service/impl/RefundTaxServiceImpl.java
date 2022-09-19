package com.coolk1ng.service.impl;

import com.coolk1ng.base.ResResult;
import com.coolk1ng.mapper.RefundTaxMapper;
import com.coolk1ng.pojo.entity.RefundTax;
import com.coolk1ng.service.RefundTaxService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;

/**
 * 退税(RefundTax)表服务实现类
 *
 * @author makejava
 * @since 2022-09-19 16:04:28
 */
@Service("refundTaxService")
public class RefundTaxServiceImpl implements RefundTaxService {

    @Autowired
    private RefundTaxMapper refundTaxMapper;

    @Override
    public PageInfo<RefundTax> getRefundTaxList(RefundTax refundTax) {
        PageHelper.startPage(refundTax.getPageNum() == null ? 1 : refundTax.getPageNum()
                , refundTax.getPageSize() == null ? 5 : refundTax.getPageSize());
        List<RefundTax> refundTaxList = refundTaxMapper.getRefundTaxList(refundTax);
        refundTaxList.forEach(item -> {
            BigDecimal decimal = item.getInvoiceAmount().multiply(new BigDecimal(item.getTaxRate())).divide(new BigDecimal(100), 2, RoundingMode.UP);
            item.setTheoryRefundTax(decimal);
        });
        return new PageInfo<>(refundTaxList);
    }

    @Override
    public void saveRefundTax(RefundTax refundTax) {
        refundTax.setActualRefundTax(new BigDecimal(0).setScale(2, RoundingMode.UP));
        refundTaxMapper.saveRefundTax(refundTax);
    }

    @Override
    public ResResult getRefundTaxByIds(String ids) throws Exception {
        Boolean flag = true;
        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] split = ids.split(",");
        for (String s : split) {
            arrayList.add(Integer.parseInt(s));
        }
        List<RefundTax> list = refundTaxMapper.getRefundTaxByIds(arrayList);
        if (list != null) {
            long count = list.stream().map(RefundTax::getProjectId).distinct().count();
            if (count > 1 ) {
                return ResResult.fail("选中数据不符合");
            }
        }
            return ResResult.success(list);
    }
}
package com.coolk1ng.service.impl;

import com.coolk1ng.base.ResResult;
import com.coolk1ng.mapper.RefundTaxMapper;
import com.coolk1ng.pojo.dto.RefundTaxDTO;
import com.coolk1ng.pojo.entity.RefundTax;
import com.coolk1ng.service.RefundTaxService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicBoolean;

/**
 * 退税(RefundTax)表服务实现类
 *
 * @author coolk1ng
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
            BigDecimal decimal = item.getInvoiceAmount().multiply(new BigDecimal(item.getTaxRate()))
                    .divide(new BigDecimal(100), 2, RoundingMode.UP);
            item.setTheoryRefundTax(decimal);
        });
        return new PageInfo<>(refundTaxList);
    }

    @Override
    @Transactional
    public void saveRefundTax(RefundTax refundTax) {
        refundTax.setActualRefundTax(new BigDecimal(0).setScale(2, RoundingMode.UP));
        refundTax.setState(0);
        refundTaxMapper.saveRefundTax(refundTax);
    }

    @Override
    public ResResult getRefundTaxByIds(String ids){
        AtomicBoolean flag = new AtomicBoolean(true);
        ArrayList<Integer> arrayList = new ArrayList<>();
        String[] split = ids.split(",");
        for (String s : split) {
            arrayList.add(Integer.parseInt(s));
        }
        List<RefundTax> list = refundTaxMapper.getRefundTaxByIds(arrayList);
        if (list != null) {
            // 编号校验
            long count = list.stream().map(RefundTax::getProjectId).distinct().count();
            if (count > 1 ) {
                return ResResult.fail("选中数据不符合");
            }
            // 是否可退税校验
            list.forEach(item-> {
                if (!item.getCanRefundTax().equals(1)) {
                    flag.set(false);
                }
            });
            if (!flag.get()) {
                return ResResult.fail("选中数据不符合");
            }
        }
            return ResResult.success(list);
    }

    @Override
    public BigDecimal getTheoryRefundTaxByInvoiceAmountAndTaxRate(RefundTaxDTO refundTaxDTO) {
        return refundTaxDTO.getInvoiceAmount().multiply(new BigDecimal(refundTaxDTO.getTaxRate()))
                .divide(new BigDecimal(100),2,RoundingMode.UP);
    }

    @Override
    public ResResult updateRefundTax(String idAndActualRefundTax) {
        ArrayList<RefundTax> list = new ArrayList<>();
        String[] split = idAndActualRefundTax.split(":");
        for (String s : split) {
            String[] arr = s.split(",");
            RefundTax refundTax = new RefundTax();
            refundTax.setId(Integer.parseInt(arr[0]));
            refundTax.setActualRefundTax(new BigDecimal(arr[1]));
            //System.out.println(refundTax);
            list.add(refundTax);
        }
        refundTaxMapper.updateRefundTax(list);
        return ResResult.success("退税成功");
    }
}
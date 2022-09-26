package com.coolk1ng.service.impl;

import com.coolk1ng.base.ResResult;
import com.coolk1ng.mapper.RefundTaxMapper;
import com.coolk1ng.pojo.dto.RefundTaxDTO;
import com.coolk1ng.pojo.entity.RefundTax;
import com.coolk1ng.service.RefundTaxService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Arrays;
import java.util.List;

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
    public PageInfo<RefundTax> getRefundTaxList(RefundTaxDTO refundTaxDTO) {
        PageHelper.startPage(refundTaxDTO.getPageNum() == null ? 1 : refundTaxDTO.getPageNum()
                , refundTaxDTO.getPageSize() == null ? 5 : refundTaxDTO.getPageSize());
        List<RefundTax> refundTaxList = refundTaxMapper.getRefundTaxList(refundTaxDTO);
        refundTaxList.forEach(item -> {
            BigDecimal decimal = item.getInvoiceAmount().multiply(new BigDecimal(item.getTaxRate()))
                    .divide(new BigDecimal(100), 2, RoundingMode.UP);
            item.setTheoryRefundTax(decimal);
        });
        return new PageInfo<>(refundTaxList);
    }

    @Override
    @Transactional
    public void saveRefundTax(RefundTaxDTO refundTaxDTO) {
        RefundTax refundTax = new RefundTax();
        BeanUtils.copyProperties(refundTaxDTO, refundTax);
        refundTax.setActualRefundTax(new BigDecimal(0).setScale(2, RoundingMode.UP));
        refundTax.setState(0);
        refundTaxMapper.saveRefundTax(refundTax);
    }

    @Override
    public ResResult getRefundTaxByIds(Integer[] ids) {
        List<Integer> arrayList = Arrays.asList(ids);
        List<RefundTax> list = refundTaxMapper.getRefundTaxByIds(arrayList);
        if (list != null) {
            // 编号校验
            long count = list.stream().map(RefundTax::getProjectId).distinct().count();
            // 是否可退税校验
            boolean flag = list.stream().anyMatch(item -> !item.getCanRefundTax().equals(1));
            if (flag || count > 1) {
                return ResResult.fail("选中数据不符合");
            }
        }
        return ResResult.success(list);
    }

    @Override
    public BigDecimal getTheoryRefundTaxByInvoiceAmountAndTaxRate(RefundTaxDTO refundTaxDTO) {
        return refundTaxDTO.getInvoiceAmount().multiply(new BigDecimal(refundTaxDTO.getTaxRate()))
                .divide(new BigDecimal(100), 2, RoundingMode.UP);
    }

    @Override
    public ResResult updateRefundTax(List<RefundTaxDTO> list) {
        refundTaxMapper.updateRefundTax(list);
        return ResResult.success("退税成功");
    }
}
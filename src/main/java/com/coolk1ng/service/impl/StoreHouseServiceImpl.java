package com.coolk1ng.service.impl;

import com.coolk1ng.base.PageEntity;
import com.coolk1ng.base.ResResult;
import com.coolk1ng.mapper.StoreHouseMapper;
import com.coolk1ng.pojo.dto.*;
import com.coolk1ng.pojo.entity.Product;
import com.coolk1ng.pojo.vo.DefectiveVO;
import com.coolk1ng.pojo.vo.InboundVO;
import com.coolk1ng.pojo.vo.OrderVo;
import com.coolk1ng.pojo.vo.ProductVO;
import com.coolk1ng.service.StoreHouseService;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

/**
 * 库存StoreHouseServiceImpl
 *
 * @author coolk1ng
 * @since 2022/9/23 10:49
 */
@Service("StoreHouseService")
public class StoreHouseServiceImpl implements StoreHouseService {

    @Autowired
    private StoreHouseMapper storeHouseMapper;

    @Override
    public PageInfo<ProductVO> getProductList(ProductDTO productDTO) {
        PageHelper.startPage(productDTO.getPageNum() == null ? 1 : productDTO.getPageNum()
                , productDTO.getPageSize() == null ? 5 : productDTO.getPageSize());
        List<ProductVO> productBaseList = storeHouseMapper.getProductBaseList();
        PageInfo<ProductVO> pageInfo = new PageInfo<>(productBaseList);
        List<ProductVO> remainTotalList = storeHouseMapper.getRemainTotalList();

        for (ProductVO product : pageInfo.getList()) {
            for (ProductVO remain : remainTotalList) {
                // 设置数据
                if (product.getId().equals(remain.getId())) {
                    if (remain.getRemainTotal() != null) {
                        product.setRemainTotal(remain.getRemainTotal());
                    }
                }
            }
            // 剩余库存为空设置默认值
            if (product.getRemainTotal() == null) product.setRemainTotal(0);
        }

        // 完全出库
        if (new Integer(1).equals(productDTO.getInboundState())) {
            return new PageInfo<>(pageInfo.getList().stream()
                    .filter(item -> item.getRemainTotal() == 0)
                    .collect(Collectors.toList()));
        }
        // 未完全出库
        if (new Integer(0).equals(productDTO.getInboundState())) {
            return new PageInfo<>(pageInfo.getList().stream()
                    .filter(item -> item.getRemainTotal() != 0)
                    .collect(Collectors.toList()));
        }
        return pageInfo;
    }

    @Override
    public PageInfo<OrderVo> getOrderBaseList(PageEntity pageEntity) {
        PageHelper.startPage(pageEntity.getPageNum() == null ? 1 : pageEntity.getPageNum()
                , pageEntity.getPageSize() == null ? 5 : pageEntity.getPageSize());
        List<OrderVo> orderBaseList = storeHouseMapper.getOrderBaseList();
        List<OrderVo> defectiveList = storeHouseMapper.getDefectiveList();
        PageInfo<OrderVo> pageInfo = new PageInfo<>(orderBaseList);
        for (OrderVo order : pageInfo.getList()) {
            for (OrderVo defective : defectiveList) {
                if (order.getId() != null) {
                    Product product = storeHouseMapper.getProductById(order.getProductId());
                    if (product != null) order.setName(product.getName());
                }
                if (order.getId().equals(defective.getId())) {
                    order.setSumDefBoundQuantity(defective.getSumDefBoundQuantity());
                }
                if (order.getSumDefBoundQuantity() == null) order.setSumDefBoundQuantity(0);
                if (order.getSumInboundQuantity() == null) order.setSumInboundQuantity(0);
                if (order.getSumOutboundQuantity() == null) order.setSumOutboundQuantity(0);
            }
        }
        return pageInfo;
    }

    @Override
    public ResResult saveOrderToInbound(OrderDTO orderDTO) {
        // 计算是否超出总订单数量
        Integer sum = orderDTO.getSumDefBoundQuantity() + orderDTO.getSumInboundQuantity()
                + orderDTO.getSumOutboundQuantity() + orderDTO.getDefectiveQuantity();
        if (orderDTO.getOrderQuantity() <= sum) {
            return ResResult.fail("入库数量超出订单数量");
        }
        storeHouseMapper.saveOrderToInbound(orderDTO);
        return ResResult.success("订单入库成功");
    }

    @Override
    public ResResult saveInboundInfo(InboundDTO inboundDTO) {
        /*if (inboundDTO.getOrderQuantity() < inboundDTO.getSumDefBoundQuantity() + inboundDTO.getSumInboundQuantity()) {
            return ResResult.fail("错误的数据");
        }*/
        inboundDTO.setDefectiveId(null);
        storeHouseMapper.saveInboundInfo(inboundDTO);
        return ResResult.success("入库成功");
    }

    @Override
    public PageInfo<InboundVO> getInboundList(PageEntity pageEntity) {
        PageHelper.startPage(pageEntity.getPageNum() == null ? 1 : pageEntity.getPageNum()
                , pageEntity.getPageSize() == null ? 5 : pageEntity.getPageSize());
        List<InboundVO> inboundList = storeHouseMapper.getInboundList();
        List<ProductVO> productList = storeHouseMapper.getProductInfo();
        PageInfo<InboundVO> pageInfo = new PageInfo<>(inboundList);
        for (InboundVO inbound : pageInfo.getList()) {
            for (ProductVO product : productList) {
                if (inbound.getOrderId().equals(product.getOrderId())) {
                    inbound.setName(product.getName());
                }
            }
        }
        return pageInfo;
    }

    @Override
    @Transactional
    public ResResult saveDefectiveInfo(DefectiveDTO defectiveDTO) {
        defectiveDTO.setStatus(1);
        storeHouseMapper.saveDefectiveInfo(defectiveDTO);
        return ResResult.success("改判成功");
    }

    @Override
    public ResResult saveOutboundInfo(OutboundDTO outboundDTO) {
        if (outboundDTO.getInboundQuantity()
                <= outboundDTO.getDefectiveQuantity() + outboundDTO.getSumOutboundQuantity()) {
            return ResResult.fail("出库数量不符合");
        }
        outboundDTO.setOutQuantity(outboundDTO.getInboundQuantity()
                - outboundDTO.getSumOutboundQuantity() - outboundDTO.getDefectiveQuantity());
        storeHouseMapper.saveOutboundInfo(outboundDTO);
        return ResResult.success("出库成功");
    }

    @Override
    public PageInfo<DefectiveVO> getDefInfoList(DefectiveDTO defectiveDTO) {
        PageHelper.startPage(defectiveDTO.getPageNum() == null ? 1 : defectiveDTO.getPageNum()
                , defectiveDTO.getPageSize() == null ? 5 : defectiveDTO.getPageSize());
        List<DefectiveVO> defInfoList = storeHouseMapper.getDefInfoList(defectiveDTO);
        List<ProductVO> productInfo = storeHouseMapper.getProductInfo();
        PageInfo<DefectiveVO> pageInfo = new PageInfo<>(defInfoList);
        for (DefectiveVO defective : pageInfo.getList()) {
            for (ProductVO product : productInfo) {
                if (defective.getOrderId().equals(product.getOrderId())) {
                    defective.setName(product.getName());
                }
            }
        }
        return pageInfo;
    }

    @Override
    @Transactional
    public ResResult saveInboundInfo(DefectiveDTO defectiveDTO) {
        /*InboundVO inbound = storeHouseMapper.getOrderIdByInbound(defectiveDTO);
        defectiveDTO.setOrderId(inbound.getOrderId());*/
        if (new Integer(2).equals(defectiveDTO.getStatus())) {
            return ResResult.fail("已入库的次品");
        }
        storeHouseMapper.saveInboundByDef(defectiveDTO);
        storeHouseMapper.updateDefStatus(defectiveDTO);
        return ResResult.success("次品入库成功");
    }
}

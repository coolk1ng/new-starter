package com.coolk1ng.service;

import com.coolk1ng.base.PageEntity;
import com.coolk1ng.base.ResResult;
import com.coolk1ng.pojo.dto.*;
import com.coolk1ng.pojo.vo.DefectiveVO;
import com.coolk1ng.pojo.vo.InboundVO;
import com.coolk1ng.pojo.vo.OrderVo;
import com.coolk1ng.pojo.vo.ProductVO;
import com.github.pagehelper.PageInfo;

/**
 * 库存Service
 *
 * @author coolk1ng
 * @since 2022/9/23 10:49
 */
public interface StoreHouseService {

    /**
     * 货品列表
     * @param productDTO
     * @return List<ProductVO>
     */
    PageInfo<ProductVO> getProductList(ProductDTO productDTO);

    /**
     * 订单列表
     * @return List<OrderVo>
     */
    PageInfo<OrderVo> getOrderBaseList(PageEntity pageEntity);

    ResResult saveOrderToInbound(OrderDTO orderDTO);

    ResResult saveInboundInfo(InboundDTO inboundDTO);

    /**
     * 入库列表
     * @return PageInfo<InboundVO>
     */
    PageInfo<InboundVO> getInboundList(PageEntity pageEntity);

    ResResult saveDefectiveInfo(DefectiveDTO defectiveDTO);

    ResResult saveOutboundInfo(OutboundDTO outboundDTO);

    PageInfo<DefectiveVO> getDefInfoList(DefectiveDTO defectiveDTO);

    ResResult saveInboundInfo(DefectiveDTO defectiveDTO);
}

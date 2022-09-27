package com.coolk1ng.mapper;

import com.coolk1ng.pojo.dto.DefectiveDTO;
import com.coolk1ng.pojo.dto.InboundDTO;
import com.coolk1ng.pojo.dto.OrderDTO;
import com.coolk1ng.pojo.dto.OutboundDTO;
import com.coolk1ng.pojo.entity.Inbound;
import com.coolk1ng.pojo.entity.Product;
import com.coolk1ng.pojo.vo.DefectiveVO;
import com.coolk1ng.pojo.vo.InboundVO;
import com.coolk1ng.pojo.vo.OrderVo;
import com.coolk1ng.pojo.vo.ProductVO;
import org.apache.ibatis.annotations.Mapper;

import java.util.List;

/**
 * 库存Mapper
 *
 * @author coolk1ng
 * @since 2022/9/23 10:54
 */
@Mapper
public interface StoreHouseMapper {

    /**
     * 查询货号列表
     * @return List<ProductVO>
     */
    List<ProductVO> getProductBaseList();

    /**
     * 查询货号剩余数量
     * @return List<ProductVO>
     */
    List<ProductVO> getRemainTotalList();

    /**
     * 订单基本数据
     * @return List<OrderVo>
     */
    List<OrderVo> getOrderBaseList();

    /**
     * 次品数量
     * @return List<OrderVo>
     */
    List<OrderVo> getDefectiveList();

    Product getProductById(Integer productId);

    /**
     * 入库
     * @param orderDTO
     * @return void
     */
    void saveInboundInfo(InboundDTO orderDTO);

    /** 
     * 查询入库列表
     * @return List<InboundVO>
     */
    List<InboundVO> getInboundList();

    /**
     * 查询货品信息 ,用于映射入库列表货品名
     * @return List<ProductVO>
     */
    List<ProductVO> getProductInfo();

    /**
     * 订单列表入库
     * @param orderDTO
     * @return void
     */
    void saveOrderToInbound(OrderDTO orderDTO);

    /**
     * 改判次品
     * @param defectiveDTO
     * @return void
     */
    void saveDefectiveInfo(DefectiveDTO defectiveDTO);

    /**
     * 出库
     * @param outboundDTO
     * @return void
     */
    void saveOutboundInfo(OutboundDTO outboundDTO);

    /**
     * 次品入库
     * @param defectiveDTO
     * @return void
     */
    void saveInboundByDef(DefectiveDTO defectiveDTO);

    /**
     * 次品列表
     * @param defectiveDTO
     * @return List<DefectiveVO>
     */
    List<DefectiveVO> getDefInfoList(DefectiveDTO defectiveDTO);

    /**
     * 次品入库修改状态
     * @param defectiveDTO
     * @return void
     */
    void updateDefStatus(DefectiveDTO defectiveDTO);

    Inbound getOrderIdByInbound(DefectiveDTO defectiveDTO);
}

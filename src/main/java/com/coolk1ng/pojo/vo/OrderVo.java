package com.coolk1ng.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单VO
 *
 * @author coolk1ng
 * @since 2022/9/23 10:56
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderVo {

    private Integer id;
    /**
     * 商品名
     */
    private String name;

    private Integer productId;

    /**
     * 订单数量
     */
    private Integer orderQuantity;

    /**
     * 入库数量
     */
    private Integer sumInboundQuantity;

    /**
     * 次品数量
     */
    private Integer sumDefBoundQuantity;

    /**
     * 出库数量
     */
    private Integer sumOutboundQuantity;
}

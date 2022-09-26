package com.coolk1ng.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 入库VO
 *
 * @author coolk1ng
 * @since 2022/9/23 11:29
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InboundVO {

    private Integer id;
    private String name;
    private Integer orderId;
    /**
     * 入库数量总和
     */
    private Integer sumInboundQuantity;

    /**
     * 出库数量总和
     */
    private Integer sumOutboundQuantity;

    private Integer existDefective;

    /**
     * 入库数量
     */
    private Integer inboundQuantity;

    /**
     * 次品数量
     */
    private Integer defectiveQuantity;
}

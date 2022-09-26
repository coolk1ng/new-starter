package com.coolk1ng.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单DTO
 *
 * @author coolk1ng
 * @since 2022/9/23 17:41
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class InboundDTO {
    private Integer id;
    private Integer orderId;
    //入库数量
    private Integer inboundQuantity;
    // 出库数量
    private Integer sumOutboundQuantity;
    // 输入的次品数量
    private Integer defectiveQuantity;
    private Integer defectiveId;
    /**
     * 订单数量
     */
    private Integer orderQuantity;

    /**
     * 次品数量
     */
    private Integer sumDefBoundQuantity;

    /**
     * 入库数量
     */
    private Integer sumInboundQuantity;
}

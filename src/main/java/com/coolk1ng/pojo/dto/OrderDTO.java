package com.coolk1ng.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单DTO
 *
 * @author coolk1ng
 * @since 2022/9/26 15:03
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OrderDTO {
    private Integer id;
    private Integer orderId;
    private Integer orderQuantity;
    private Integer sumInboundQuantity;
    private Integer sumDefBoundQuantity;
    private Integer sumOutboundQuantity;
    /**
     * 传入的订单入库数量
     */
    private Integer defectiveQuantity;


}

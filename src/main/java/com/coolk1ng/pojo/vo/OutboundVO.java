package com.coolk1ng.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 出库表VO
 *
 * @author coolk1ng
 * @since 2022/9/23 11:39
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class OutboundVO {
    private Integer id;
    private Integer inboundId;
    private Integer sumOutboundQuantity;
}

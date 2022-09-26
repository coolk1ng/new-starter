package com.coolk1ng.pojo.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 出库DTO
 *
 * @author coolk1ng
 * @since 2022/9/26 11:14
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class OutboundDTO {
    private Integer id;
    private Integer inboundId;
    private Integer outQuantity;
    //入库数量
    private Integer inboundQuantity;
    // 出库数量
    private Integer sumOutboundQuantity;
    private Integer defectiveQuantity;
}

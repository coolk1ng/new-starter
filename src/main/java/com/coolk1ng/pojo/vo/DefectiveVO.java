package com.coolk1ng.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 次品表VO
 *
 * @author coolk1ng
 * @since 2022/9/26 11:49
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DefectiveVO {
    private Integer id;
    private Integer orderId;
    private String name;
    private Integer defectiveQuantity;
    private Integer inboundId;
    private Integer status;
}

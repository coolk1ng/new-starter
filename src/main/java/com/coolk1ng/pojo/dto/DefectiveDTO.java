package com.coolk1ng.pojo.dto;

import com.coolk1ng.base.PageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 次品DTO
 *
 * @author coolk1ng
 * @since 2022/9/26 10:42
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class DefectiveDTO extends PageEntity {
    private Integer id;
    private Integer orderId;
    private Integer inboundId;
    private Integer defectiveQuantity;
    private Integer status;
    private Integer defectiveId;
}

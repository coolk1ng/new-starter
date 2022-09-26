package com.coolk1ng.pojo.dto;

import com.coolk1ng.base.PageEntity;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 订单DTO
 *
 * @author coolk1ng
 * @since 2022/9/23 11:08
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductDTO extends PageEntity {
    private Integer id;
    /**
     * 是否完全出库
     */
    private Integer inboundState;
}

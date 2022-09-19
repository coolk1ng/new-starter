package com.coolk1ng.pojo.vo;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 仓库VO
 *
 * @author coolk1ng
 * @since 2022-09-19
 */
@Data
@Getter
@Setter
public class WarehouseVO {

    private Integer id;

    private String goodsName;

    private Integer warehouse;

    private Integer quantity;

    private String wareName;
}

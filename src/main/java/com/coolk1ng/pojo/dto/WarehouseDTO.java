package com.coolk1ng.pojo.dto;

import com.coolk1ng.base.PageEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 仓库DTO
 *
 * @author coolk1ng
 * @since 2022-09-19
 */
@Data
@Getter
@Setter
public class WarehouseDTO extends PageEntity {

    private Integer id;

    private String goodsName;

    private Integer warehouse;

    private Integer quantity;

    private String wareName;
}

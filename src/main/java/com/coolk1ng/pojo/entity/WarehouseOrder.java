package com.coolk1ng.pojo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * (WarehouseOrder)实体类
 *
 * @author makejava
 * @since 2022-09-19 14:37:23
 */
@Data
@Getter
@Setter
public class WarehouseOrder implements Serializable {
    private static final long serialVersionUID = 991785905186140950L;
    
    private Integer id;
    
    private String goodsName;
    
    private Integer warehouse;
    
    private Integer quantity;

}


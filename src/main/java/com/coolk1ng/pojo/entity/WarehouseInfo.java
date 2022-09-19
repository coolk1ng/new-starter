package com.coolk1ng.pojo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.io.Serializable;

/**
 * 仓库基础信息(WarehouseInfo)实体类
 *
 * @author makejava
 * @since 2022-09-19 14:37:45
 */
@Data
@Getter
@Setter
public class WarehouseInfo implements Serializable {
    private static final long serialVersionUID = -40387720125308459L;
    
    private Integer id;
    
    private String wareName;

}


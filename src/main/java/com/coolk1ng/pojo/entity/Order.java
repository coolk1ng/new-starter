package com.coolk1ng.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 订单表(Order)实体类
 *
 * @author coolk1ng
 * @since 2022-09-23 10:45:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Order implements Serializable {
    private static final long serialVersionUID = -22084480466866129L;
    
    private Integer id;
    /**
     * 货号ID
     */
    private Integer productId;
    /**
     * 订单数量
     */
    private Integer orderQuantity;

    private List<Inbound> inboundList;
}


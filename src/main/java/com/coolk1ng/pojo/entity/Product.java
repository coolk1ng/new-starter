package com.coolk1ng.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 商品表(Product)实体类
 *
 * @author coolk1ng
 * @since 2022-09-23 10:45:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Product implements Serializable {
    private static final long serialVersionUID = -80704522183717129L;
    
    private Integer id;
    /**
     * 商品名
     */
    private String name;

    private List<Order> orderList;
}


package com.coolk1ng.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * (Defective)实体类
 *
 * @author coolk1ng
 * @since 2022-09-23 10:45:32
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Defective implements Serializable {
    private static final long serialVersionUID = -22580628673351725L;
    
    private Integer id;
    /**
     * 入库ID
     */
    private Integer inboundId;
    /**
     * 入库数量
     */
    private Integer inboundQuantity;
    /**
     * 状态
     */
    private Integer status;
}


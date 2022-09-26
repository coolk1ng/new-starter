package com.coolk1ng.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

/**
 * 出库表(Outbound)实体类
 *
 * @author coolk1ng
 * @since 2022-09-23 10:45:36
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Outbound implements Serializable {
    private static final long serialVersionUID = -65415444134049130L;
    
    private Integer id;
    /**
     * 入库ID
     */
    private Integer inboundId;
    /**
     * 出库数量
     */
    private Integer outboundQuantity;

}


package com.coolk1ng.pojo.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.List;

/**
 * 入库表(Inbound)实体类
 *
 * @author coolk1ng
 * @since 2022-09-23 10:45:36
 */
@Data
@NoArgsConstructor
@AllArgsConstructor
public class Inbound implements Serializable {
    private static final long serialVersionUID = 340683169699049967L;
    
    private Integer id;
    /**
     * 订单ID
     */
    private Integer orderId;
    /**
     * 入库数量
     */
    private Integer inboundQuantity;
    /**
     * 次品ID
     */
    private Integer defectiveId;

    private List<Outbound> outboundList;
}


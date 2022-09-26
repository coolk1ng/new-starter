package com.coolk1ng.pojo.vo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * 货号VO
 *
 * @author coolk1ng
 * @since 2022/9/23 10:56
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ProductVO {

    private Integer id;
    /**
     * 商品名
     */
    private String name;

    /**
     * 总库存
     */
    private Integer storeHouseTotal;

    /**
     * 剩余数量
     */
    private Integer remainTotal;

    private Integer orderId;

    private Integer inboundId;
}

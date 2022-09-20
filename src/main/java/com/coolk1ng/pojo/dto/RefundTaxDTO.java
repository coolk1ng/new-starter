package com.coolk1ng.pojo.dto;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;

/**
 * @author coolk1ng
 * @since 2022/9/19 23:29
 */
@Data
@Getter
@Setter
public class RefundTaxDTO {

    private BigDecimal invoiceAmount;
    private Integer taxRate;
}

package com.coolk1ng.pojo.dto;

import lombok.*;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;

/**
 * @author coolk1ng
 * @since 2022/9/19 23:29
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefundTaxDTO {

    private Integer id;
    private BigDecimal invoiceAmount;
    private Integer taxRate;
    private BigDecimal actualRefundTax;
}

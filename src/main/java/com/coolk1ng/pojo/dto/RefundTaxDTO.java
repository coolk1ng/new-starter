package com.coolk1ng.pojo.dto;

import com.coolk1ng.base.PageEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.*;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotBlank;
import java.math.BigDecimal;
import java.util.Date;

/**
 * @author coolk1ng
 * @since 2022/9/19 23:29
 */
@Data
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class RefundTaxDTO extends PageEntity {

    private Integer id;
    private String projectId;
    private String supplier;
    private BigDecimal invoiceAmount;
    private Integer taxRate;
    private BigDecimal actualRefundTax;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invoiceTimeStart;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date invoiceTimeEnd;
}

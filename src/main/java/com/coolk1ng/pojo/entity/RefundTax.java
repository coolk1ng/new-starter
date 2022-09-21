package com.coolk1ng.pojo.entity;

import com.coolk1ng.base.PageEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.springframework.format.annotation.DateTimeFormat;

import javax.print.DocFlavor;
import java.math.BigDecimal;
import java.util.Date;
import java.io.Serializable;

/**
 * 退税(RefundTax)实体类
 *
 * @author coolk1ng
 * @since 2022-09-19 16:05:44
 */
@Data
@Getter
@Setter
public class RefundTax extends PageEntity implements Serializable {
    private static final long serialVersionUID = -94074313665585993L;
    
    private Integer id;
    
    private String projectId;
    
    private String brandAttribute;
    
    private String demandName;
    
    private String supplier;
    
    private String receiptName;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal invoiceAmount;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date invoiceTime;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date invoiceTimeStart;

    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date invoiceTimeEnd;

    private Integer taxRate;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal theoryRefundTax;

    @JsonFormat(shape = JsonFormat.Shape.STRING)
    private BigDecimal actualRefundTax;
    
    private Integer canRefundTax;
    
    private Integer state;

}


package com.coolk1ng.pojo.dto;

import com.coolk1ng.base.PageEntity;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

/**
 * 仓库DTO
 *
 * @author coolk1ng
 * @since 2022-09-19
 */
@Data
@Getter
@Setter
public class WarehouseDTO extends PageEntity {

    private Integer id;

    @NotNull
    @NotBlank
    @Length(max = 20, message = "20个字符以内")
    private String goodsName;

    @NotNull
    private Integer warehouse;

    @NotNull
    private Integer quantity;

    private String wareName;
}

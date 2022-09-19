package com.coolk1ng.pojo.dto;

import com.coolk1ng.base.PageEntity;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

import javax.validation.constraints.NotNull;
import java.util.Date;

/**
 * 问卷调查DTO
 *
 * @author coolk1ng
 * @since 2022-09-19
 */
@Data
@Getter
@Setter
public class QuestionnaireDTO extends PageEntity {

    private Integer id;

    @NotNull(message = "姓名不能为空")
    @Length(min = 1,max = 20,message = "不能超过20字符以内")
    private String name;

    @NotNull(message = "电话不能为空")
    @Length(min = 1,max = 11,message = "电话不能超过11位")
    private String phone;

    private String email;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    @NotNull(message = "日期不为空")
    private Date qDate;

    @Length(min = 1,max = 200,message = "200字符以内")
    private String content;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date questionnaireStartTime;

    @DateTimeFormat(pattern = "yyyy/MM/dd")
    @JsonFormat(pattern = "yyyy-MM-dd", timezone = "GMT+8")
    private Date questionnaireEndTime;
}

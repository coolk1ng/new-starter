package com.coolk1ng.pojo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;
import java.io.Serializable;

/**
 * 问卷调查表(Questionnaire)实体类
 *
 * @author coolk1ng
 * @since 2022-09-19 11:18:53
 */
@Data
@Getter
@Setter
public class Questionnaire implements Serializable {
    private static final long serialVersionUID = -83960447629251676L;
    
    private Integer id;
    
    private String name;
    
    private String phone;
    
    private String email;
    
    private Date qDate;
    
    private String content;
}


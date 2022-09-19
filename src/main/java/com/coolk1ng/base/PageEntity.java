package com.coolk1ng.base;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;

/**
 * 分页参数
 *
 * @author coolk1ng
 * @since 2022-09-19
 */
@Data
@Getter
@Setter
public class PageEntity {

    private Integer pageNum;
    private Integer pageSize;
}

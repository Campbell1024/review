package com.campbell.util;

import lombok.Data;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据展示
 *
 * @author Campbell
 * @date 2020/6/30
 */
@Data
public class Page<T> implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer startPage;

    private Integer pageSize;

    private List<T> list;

}

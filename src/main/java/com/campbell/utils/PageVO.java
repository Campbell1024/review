package com.campbell.utils;

import java.io.Serializable;
import java.util.List;

/**
 * 分页数据展示
 *
 * @author Campbell
 * @date 2020/6/30
 */
public class PageVO<T> implements Serializable {

    private static final long serialVersionUID = 2599972325331300096L;

    private Integer startPage;

    private Integer pageSize;

    private List<T> list;

    public Integer getStartPage() {
        return startPage;
    }

    public void setStartPage(Integer startPage) {
        this.startPage = startPage;
    }

    public Integer getPageSize() {
        return pageSize;
    }

    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }
}

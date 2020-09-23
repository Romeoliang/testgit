package com.qfedu.entity;

import java.util.List;

public class PageBean<T> {
    private List<T> list;

    /**
     * 当前页数（第几页） ==》前端传来
     */
    private int currentPage;

    /**
     * 页容量  一般固定
     */
    private int pageSize;

    /**
     * 一共有多少条商品
     */
    private int totalCount;

    /**
     * 总页数 ==》 总条数/页容量
     */
    private int totalPage;

    public PageBean() {
    }

    public PageBean(List<T> list, int currentPage, int pageSize, int totalCount) {
        this.list = list;
        this.currentPage = currentPage;
        this.pageSize = pageSize;
        this.totalCount = totalCount;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public int getCurrentPage() {
        return currentPage;
    }

    public void setCurrentPage(int currentPage) {
        this.currentPage = currentPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public int getTotalPage() {
        return (int) Math.ceil(totalCount * 1.0 / pageSize);
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    @Override
    public String toString() {
        return "PageBean{" +
                "list=" + list +
                ", currentPage=" + currentPage +
                ", pageSize=" + pageSize +
                ", totalCount=" + totalCount +
                ", totalPage=" + totalPage +
                '}';
    }
}

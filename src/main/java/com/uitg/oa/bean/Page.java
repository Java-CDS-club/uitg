package com.uitg.oa.bean;

import java.util.List;
import java.util.Map;

/**
 * Description Here
 *
 * @author Michael
 */
public class Page<T> {

    private int pageIndex;

    private int totalPage;

    private int pageSize;

    private int totalSize;

    private List<T> list;

    private Map<String, Object> map;

    public Page() {
    }

    public Page(int pageIndex, int totalPage, int pageSize, int totalSize, List<T> list) {
        this.pageIndex = pageIndex;
        this.totalPage = totalPage;
        this.pageSize = pageSize;
        this.totalSize = totalSize;
        this.list = list;
    }

    public int getPageIndex() {
        return pageIndex;
    }

    public void setPageIndex(int pageIndex) {
        this.pageIndex = pageIndex;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    public int getTotalSize() {
        return totalSize;
    }

    public void setTotalSize(int totalSize) {
        this.totalSize = totalSize;
    }

    public List<T> getList() {
        return list;
    }

    public void setList(List<T> list) {
        this.list = list;
    }

    public Map<String, Object> getMap() {
        return map;
    }

    public void setMap(Map<String, Object> map) {
        this.map = map;
    }
}

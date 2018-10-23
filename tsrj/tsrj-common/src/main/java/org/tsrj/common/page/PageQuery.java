package org.tsrj.common.page;

import java.io.Serializable;
import java.util.Collections;
import java.util.List;

import com.alibaba.fastjson.annotation.JSONField;
import com.github.pagehelper.PageInfo;

/**
 * Created by zqh on 2018/02/07.
 * 分页包装对象
 */
public class PageQuery<T> implements Serializable {

    private static final long serialVersionUID = -4068430693984766027L;

    private List<T> result;

    @JSONField(serialize = false)
    private PageInfo pageInfo;

    private Page page;


    public Page getPage() {
        return page;
    }

    public void setPage(Page page) {
        this.page = page;
    }

    public PageQuery(List<T> result, PageInfo pageInfo) {
        this.result = result;
        this.pageInfo = pageInfo;
    }

    public PageQuery<T> pageInfo(PageInfo value) {
        this.pageInfo = value;
        this.page=convertPageInfo2Page(value);
        return this;
    }

    private Page convertPageInfo2Page(PageInfo pageInfo){
        Page page = new Page();
        page.setCurrentPage(pageInfo.getPageNum());
        page.setPageSize(pageInfo.getPageSize());
        page.setTotalNum((int)pageInfo.getTotal());
        page.setTotalPage(pageInfo.getPages());
        page.setHasNextPage(pageInfo.isHasNextPage());
        return page;
    }

    public PageQuery() {
    }

    public PageInfo getPageInfo() {
        return pageInfo;
    }

    public void setPageInfo(PageInfo pageInfo) {
        this.pageInfo = pageInfo;
        this.page = convertPageInfo2Page(pageInfo);
    }

    public List<T> getResult() {
        return result;
    }

    public void setResult(List<T> result) {
        if (result == null) {
            this.result = Collections.emptyList();
        } else {
            this.result = result;
        }
    }

    public PageQuery<T> result(List<T> result) {
        if (result == null) {
            this.result = Collections.emptyList();
        } else {
            this.result = result;
        }
        return this;
    }
}
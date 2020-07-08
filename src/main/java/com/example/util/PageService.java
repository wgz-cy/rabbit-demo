package com.example.util;

import com.example.rabbit.page.PageResponse;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.BeanUtils;

import java.util.List;

public abstract class PageService {

    private PageInfo pageInfo;

    protected <T extends PageResponse> T getPage(List results, Class<T> clazz) {
        pageInfo = new PageInfo(results);
        T resp = BeanUtils.instantiateClass(clazz);
        long total = pageInfo.getTotal();
        int pageNum = pageInfo.getPageNum();
        int pageSize = pageInfo.getPageSize();
        resp.setTotalPages(total);
        resp.setPageNum(pageNum);
        resp.setPageSize(pageSize);
        resp.setResults(pageInfo.getList());
        return resp;
    }
}

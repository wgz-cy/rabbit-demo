package com.example.rabbit.page;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class PageResponse<T> {

    /** 当前页码 */
    private int pageNum;
    /** 每页数量 */
    private int pageSize;
    /** 记录总数 */
    private long totalSize;
    /** 页码总数 */
    private long totalPages;
    /** 数据模型 */
    private List<T> results;
}

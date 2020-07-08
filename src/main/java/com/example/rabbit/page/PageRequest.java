package com.example.rabbit.page;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PageRequest {
    /**
     * 当前页码
     */
    private int pageNum;
    /**
     * 每页数量
     */
    private int pageSize;
}

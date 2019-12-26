package com.example.inhouse.rwm.demo.model;

import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;

import java.util.List;

@AllArgsConstructor
public class PageResponse<T> {

    private Long totalCount;
    private List<T> list;

    public PageResponse(Page<T> page) {
        this(page.getTotalElements(), page.getContent());
    }
}

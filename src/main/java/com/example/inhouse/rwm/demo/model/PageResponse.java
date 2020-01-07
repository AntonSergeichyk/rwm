package com.example.inhouse.rwm.demo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.springframework.data.domain.Page;

import java.util.List;

@AllArgsConstructor
@Getter
@Setter
public class PageResponse<T> {

    private Long totalCount;
    private List<T> list;

    public PageResponse(Page<T> page) {
        this(page.getTotalElements(), page.getContent());
    }
}

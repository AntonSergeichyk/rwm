package com.example.inhouse.rwm.demo.model;


import lombok.EqualsAndHashCode;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.util.Pair;

import java.util.HashMap;
import java.util.Map;

@EqualsAndHashCode
public class PageRequest implements Pageable {

    private static Pair<String, String> ID_FIELD = Pair.of("id", "id");

    private Integer offset;
    private Integer limit;
    private Sort.Direction sortDirection;
    private String sortBy;
    private Map<String, String> mapSortBy;


    public PageRequest(Integer offset, Integer limit) {
        this.offset = offset;
        this.limit = limit;
        init();
    }

    private void init() {
        sortDirection = Sort.Direction.ASC;
        sortBy = ID_FIELD.getFirst();
        mapSortBy = new HashMap<>();
        mapSortBy.put(ID_FIELD.getFirst(), ID_FIELD.getSecond());
    }

    private Pageable previous() {
        if (hasPrevious()) {
            int newOffset = this.offset - limit;
            if (newOffset < 0) {
                newOffset = 0;
            }
//            return new PageRequest(newOffset, limit, sortDirection, sortBy, mapSortBy);
            return new PageRequest(newOffset, limit);
        }
        return first();
    }

    @Override
    public int getPageNumber() {
        return offset / limit + 1;
    }

    @Override
    public int getPageSize() {
        return limit;
    }

    @Override
    public long getOffset() {
        return Long.valueOf(offset);
    }

    @Override
    public Sort getSort() {
        if (sortBy.equals(ID_FIELD.getFirst())) {
            return Sort.by(sortDirection, ID_FIELD.getSecond());
        }
        return Sort.by(sortDirection, mapSortBy.get(sortBy), ID_FIELD.getSecond());
    }

    @Override
    public Pageable next() {
        return new PageRequest(offset + limit, limit);
    }

    @Override
    public Pageable previousOrFirst() {
        return previous();
    }

    @Override
    public Pageable first() {
        return new PageRequest(0, limit);
    }

    @Override
    public boolean hasPrevious() {
        return offset > 0;
    }
}

package com.example.inhouse.rwm.demo.service.order.cache;

import com.example.inhouse.rwm.demo.model.common.OperationSuccess;
import com.example.inhouse.rwm.demo.model.order.OrderCache;
import com.example.inhouse.rwm.demo.model.order.OrderStationsCache;
import com.example.inhouse.rwm.demo.model.order.PlaceCache;

import javax.servlet.http.HttpServletRequest;

public interface OrderCacheService {

    OperationSuccess addCacheTimeTable(HttpServletRequest request, OrderStationsCache orderStationsRequest);

    OperationSuccess addCachePlace(HttpServletRequest request, PlaceCache placeCache);

    OrderCache getOrderCache(HttpServletRequest request);

    OperationSuccess clearCache(HttpServletRequest request);
}

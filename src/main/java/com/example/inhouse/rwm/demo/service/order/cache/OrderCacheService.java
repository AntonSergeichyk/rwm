package com.example.inhouse.rwm.demo.service.order.cache;

import com.example.inhouse.rwm.demo.model.common.OperationSuccess;
import com.example.inhouse.rwm.demo.model.order.OrderStationsCache;

import javax.servlet.http.HttpServletRequest;

public interface OrderCacheService {

    OperationSuccess addCacheTimeTable(HttpServletRequest request, OrderStationsCache orderStationsRequest);

    OperationSuccess clearCache(HttpServletRequest request);

    OrderStationsCache getOrderCache(HttpServletRequest request);
}

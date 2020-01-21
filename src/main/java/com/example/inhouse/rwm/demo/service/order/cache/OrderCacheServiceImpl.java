package com.example.inhouse.rwm.demo.service.order.cache;

import com.example.inhouse.rwm.demo.common.exception.NotFoundException;
import com.example.inhouse.rwm.demo.model.common.OperationSuccess;
import com.example.inhouse.rwm.demo.model.order.OrderCache;
import com.example.inhouse.rwm.demo.model.order.OrderStationsCache;
import com.example.inhouse.rwm.demo.model.order.PlaceCache;
import com.example.inhouse.rwm.demo.service.common.DateManager;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;

@Service
public class OrderCacheServiceImpl implements OrderCacheService {


    private static final String CACHE_ORDER = "cache_order";
    private static final boolean OPERATION_SUCCESS = true;

    @Override
    public OperationSuccess addCacheTimeTable(HttpServletRequest request, OrderStationsCache orderStationsRequest) {
        clearCache(request);
        OrderCache cacheOrder = new OrderCache();
        cacheOrder.setStationArrivalId(orderStationsRequest.getArrivalStationId());
        cacheOrder.setDateOfArrival(DateManager.parseDateTime(orderStationsRequest.getArrivalTime()));
        cacheOrder.setStationLeaveId(orderStationsRequest.getDepartureStationId());
        cacheOrder.setDateOfLeave(DateManager.parseDateTime(orderStationsRequest.getDepartureTime()));

        request.getSession().setAttribute(CACHE_ORDER, cacheOrder);
        return new OperationSuccess(OPERATION_SUCCESS);
    }

    @Override
    public OperationSuccess addCachePlace(HttpServletRequest request, PlaceCache placeCache) {
        OrderCache orderCache = getOrderCache(request);
        orderCache.setPlaceId(placeCache.getPlaceId());
        orderCache.setCost(placeCache.getCost());
        return new OperationSuccess(OPERATION_SUCCESS);
    }

    @Override
    public OrderCache getOrderCache(HttpServletRequest request) {
        Object cacheOrder = request.getSession().getAttribute(CACHE_ORDER);
        if (cacheOrder == null) {
            throw new NotFoundException("The order was not found in the cache.");
        }
        return (OrderCache) cacheOrder;
    }

    @Override
    public OperationSuccess clearCache(HttpServletRequest request) {
        request.getSession().removeAttribute(CACHE_ORDER);
        return new OperationSuccess(OPERATION_SUCCESS);
    }
}

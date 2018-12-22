package com.ivy.root.dao;

import com.ivy.root.domain.Order;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderMapper {

    Long counterAllOrders(@Param("designerId") Long designerId);

    List<Order> statisticOrdersByDay(@Param("designerId")Long designerId,@Param("days") Integer days);
}
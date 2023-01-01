package com.coderman.foodie.mapper;

import com.coderman.foodie.pojo.Payment;
import java.util.List;

public interface PaymentMapper {
    int deleteByPrimaryKey(Short paymentId);

    int insert(Payment record);

    Payment selectByPrimaryKey(Short paymentId);

    List<Payment> selectAll();

    int updateByPrimaryKey(Payment record);
}
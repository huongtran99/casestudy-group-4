package com.codegym.dao.order_detail;

import com.codegym.dao.IGeneralDao;
import com.codegym.model.OrderDetail;

import java.util.List;

public interface IOrderDetailDao extends IGeneralDao<OrderDetail> {
    List<OrderDetail> findByAllId(int id);
}

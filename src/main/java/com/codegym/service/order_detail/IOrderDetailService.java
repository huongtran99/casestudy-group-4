package com.codegym.service.order_detail;
import com.codegym.model.OrderDetail;
import com.codegym.service.IGeneralService;

import java.util.List;

public interface IOrderDetailService extends IGeneralService<OrderDetail> {
    List<OrderDetail> findByAllId(int id);
}

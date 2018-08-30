package com.zsc.trade.service;

import com.zsc.trade.bean.ExchSerach;
import com.zsc.trade.bean.Exchange;

import java.util.List;

public interface ExchangeService {
    List<Exchange> getAll();

    void update(Exchange exchange);

    void delete(Integer id);

    List<Exchange> getSearch(ExchSerach exchSerach);
}

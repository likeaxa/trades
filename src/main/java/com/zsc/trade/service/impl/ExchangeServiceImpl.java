package com.zsc.trade.service.impl;

import com.zsc.trade.bean.ExchSerach;
import com.zsc.trade.bean.Exchange;
import com.zsc.trade.mapper.ExchangeMapper;
import com.zsc.trade.service.ExchangeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ExchangeServiceImpl implements ExchangeService {

    @Autowired
    ExchangeMapper exchangeMapper;

    @Override
    public List<Exchange> getAll() {
        return exchangeMapper.getAll();
    }

    @Override
    public void update(Exchange exchange) {
        exchangeMapper.update(exchange);
    }

    @Override
    public void delete(Integer id) {
        exchangeMapper.delete(id);
    }

    @Override
    public List<Exchange> getSearch(ExchSerach exchSerach) {

        if (exchSerach.getSelect().equals("买")) {
            return exchangeMapper.getBuySearch(exchSerach);
        } else {
            return exchangeMapper.getSellerSearch(exchSerach);
        }

    }
}

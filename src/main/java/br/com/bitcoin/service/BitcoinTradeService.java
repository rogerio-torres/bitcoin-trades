package br.com.bitcoin.service;

import br.com.bitcoin.service.exception.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.List;

@Service
public class BitcoinTradeService {

  public List findAll() throws ServiceException {
    try {
      return new RestTemplate().getForObject("https://www.mercadobitcoin.net/api/BTC/trades/1501871369/1501891200/", List.class);
    } catch (Exception exception) {
      throw new ServiceException("api.error.retrieve.trades");
    }
  }
}

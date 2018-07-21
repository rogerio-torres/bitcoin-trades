package br.com.bitcoin.service;

import br.com.bitcoin.model.BitcoinTrade;
import br.com.bitcoin.service.exception.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BitcoinTradeService {

  private BitcoinTrade[] fetchTrades() throws ServiceException {
    try {
      return new RestTemplate().getForObject("https://www.mercadobitcoin.net/api/BTC/trades/1501871369/1501891200/", BitcoinTrade[].class);
    } catch (Exception exception) {
      throw new ServiceException("api.error.retrieve.trades");
    }
  }

  public List findAll() throws ServiceException {
    return Arrays.asList(this.fetchTrades());
  }

  public List topSells() throws ServiceException {
    List<BitcoinTrade> trades = Arrays.asList(this.fetchTrades());
    return trades.stream()
      .filter(BitcoinTrade::isSell)
      .sorted((o1, o2) -> o2.price.compareTo(o1.price))
      .limit(5)
      .collect(Collectors.toList());
  }
}

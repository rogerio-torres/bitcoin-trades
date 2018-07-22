package br.com.bitcoin.service;

import br.com.bitcoin.model.BitcoinTrade;
import br.com.bitcoin.service.exception.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class BitcoinService {

  private BitcoinTrade[] fetchTrades() throws ServiceException {
    try {
      return new RestTemplate().getForObject("https://www.mercadobitcoin.net/api/BTC/trades/1501871369/1501891200/", BitcoinTrade[].class);
    } catch (Exception exception) {
      throw new ServiceException("api.error.retrieve.trades");
    }
  }

  public List top(String tradeType) throws ServiceException {
    List<BitcoinTrade> trades = Arrays.asList(this.fetchTrades());
    return trades.stream()
      .filter(trade -> tradeType.equals(trade.type))
      .sorted((trade1, trade2) -> trade2.price.compareTo(trade1.price))
      .limit(5)
      .collect(Collectors.toList());
  }

  public Double average(String tradeType) throws ServiceException {
    List<BitcoinTrade> trades = Arrays.asList(this.fetchTrades());
    return trades.stream()
      .filter(trade -> tradeType.equals(trade.type))
      .mapToDouble(BitcoinTrade::price)
      .average()
      .orElse(Double.NaN);
  }

  public Double median(String tradeType) throws ServiceException {
    List<BitcoinTrade> trades = Arrays.asList(this.fetchTrades());
    List<Double> sellValues = trades.stream()
      .filter(trade -> tradeType.equals(trade.type))
      .map(BitcoinTrade::price)
      .collect(Collectors.toList());
    return Calculator.median(sellValues);
  }

  public Double standardDeviation(String tradeType) throws  ServiceException {
    List<BitcoinTrade> trades = Arrays.asList(this.fetchTrades());
    List<Double> sellValues = trades.stream()
      .filter(trade -> tradeType.equals(trade.type))
      .map(BitcoinTrade::price)
      .collect(Collectors.toList());
    return Calculator.standardDeviation(sellValues);
  }
}

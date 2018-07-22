package br.com.bitcoin.service;

import br.com.bitcoin.model.BitcoinTrade;
import br.com.bitcoin.service.exception.ServiceException;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class BitcoinService {
  private List<BitcoinTrade> trades;

  public BitcoinService(String type) {
    try {
      this.trades = this.getTradesByType(type);
    } catch (ServiceException exception) {
      exception.printStackTrace();
    }
  }

  private BitcoinTrade[] fetchTrades() throws ServiceException {
    try {
      return new RestTemplate().getForObject("https://www.mercadobitcoin.net/api/BTC/trades/1501871369/1501891200/", BitcoinTrade[].class);
    } catch (Exception exception) {
      throw new ServiceException("api.error.retrieve.trades");
    }
  }

  private List<BitcoinTrade> getTradesByType(String type) throws ServiceException {
    List<BitcoinTrade> trades = Arrays.asList(this.fetchTrades());
    return trades.stream().filter(bitcoinTrade -> bitcoinTrade.type.equals(type)).collect(Collectors.toList());
  }

  public List top() {
    return this.trades.stream()
      .sorted((trade1, trade2) -> trade2.price.compareTo(trade1.price))
      .limit(5)
      .collect(Collectors.toList());
  }

  public Double average() {
    return this.trades.stream()
      .mapToDouble(BitcoinTrade::price)
      .average()
      .orElse(Double.NaN);
  }

  public Double median() {
    List<Double> values = this.trades.stream()
      .map(BitcoinTrade::price)
      .collect(Collectors.toList());
    return Calculator.median(values);
  }

  public Double standardDeviation() {
    List<Double> values = this.trades.stream()
      .map(BitcoinTrade::price)
      .collect(Collectors.toList());
    return Calculator.standardDeviation(values);
  }
}

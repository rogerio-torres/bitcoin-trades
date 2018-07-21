package br.com.bitcoin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BitcoinTrade {
  public Long date;
  public Double price;
  public Double amount;
  public Long tid;
  public String type;

  public static boolean isSell(BitcoinTrade trade) {
    return "sell".equals(trade.type);
  }
}
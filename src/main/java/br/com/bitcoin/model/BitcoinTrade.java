package br.com.bitcoin.model;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

@JsonIgnoreProperties(ignoreUnknown = true)
public class BitcoinTrade {
  public Double amount;
  public Double price;
  public String type;
  public Long date;
  public Long tid;
}

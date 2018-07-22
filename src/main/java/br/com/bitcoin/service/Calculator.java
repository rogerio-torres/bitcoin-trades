package br.com.bitcoin.service;

import java.util.List;

public class Calculator {
  public Calculator() {
  }

  public static Double calculateMedian(List<Double> values) {
    values.sort(Double::compareTo);
    if (values.size() % 2 == 0) {
      Double value1 = values.get(values.size() / 2 - 1);
      Double value2 = values.get(values.size() / 2);
      return (value1 + value2) / 2;
    }
    return values.get(values.size() / 2);
  }
}
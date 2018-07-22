package br.com.bitcoin.service;

import java.util.List;

public class Calculator {

  public static Double median(List<Double> values) {
    values.sort(Double::compareTo);
    if (values.size() % 2 == 0) {
      Double value1 = values.get(values.size() / 2 - 1);
      Double value2 = values.get(values.size() / 2);
      return (value1 + value2) / 2;
    }
    return values.get(values.size() / 2);
  }

  public static Double standardDeviation(List<Double> values) {
    Double average = values.stream().mapToDouble(value -> value).average().orElse(Double.NaN);
    Double standardDeviation = 0D;
    for (Double value : values) {
      Double difference = value - average;
      standardDeviation += difference * difference;
    }
    return Math.sqrt(standardDeviation / (values.size() - 1));
  }
}
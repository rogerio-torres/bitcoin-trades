package br.com.bitcoin.service;

import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;
import java.util.List;

public class CalculatorTest {

  @Test
  public void should_calculate_simple_median() {
    List<Double> values = Arrays.asList(1.00, 3.00, 5.00);
    Double result = Calculator.median(values);
    Assert.assertEquals(3.00, result, 0);
  }

  @Test
  public void should_calculate_unordered_median() {
    List<Double> values = Arrays.asList(3.00, 1.00, 4.00, 2.00, 0.01);
    Double result = Calculator.median(values);
    Assert.assertEquals(2.00, result, 0);
  }

  @Test
  public void should_calculate_median_from_even_sized_list() {
    List<Double> values = Arrays.asList(1.00,4.00,2.00,3.00,6.00,5.00);
    Double result = Calculator.median(values);
    Assert.assertEquals(3.5, result, 0);
  }

  @Test
  public void should_calculate_simple_standard_deviation() {
    List<Double> values = Arrays.asList(1.00, 3.00, 5.00);
    Double result = Calculator.standardDeviation(values);
    Assert.assertEquals(2, result, 0);
  }

  @Test
  public void should_calculate_complex_standard_deviation() {
    List<Double> values = Arrays.asList(1.032, 1.123, 2.001, 0.9921, 1.857);
    Double result = Calculator.standardDeviation(values);
    Assert.assertEquals(0.4869754121103035, result, 0);
  }
}

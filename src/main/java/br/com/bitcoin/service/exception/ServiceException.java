package br.com.bitcoin.service.exception;


public class ServiceException extends Exception {

  private static final long serialVersionUID = -2499659952920025569L;

  public ServiceException(String s) {
    super(s);
  }
}

package br.com.bitcoin.service.exception;


public class ServiceException extends Exception {

  private static final long serialVersionUID = -2499659952920025569L;

  public ServiceException() {
    super();
  }

  public ServiceException(String s) {
    super(s);
  }

  public ServiceException(String s, Throwable throwable) {
    super(s, throwable);
  }

  public ServiceException(Throwable throwable) {
    super(throwable);
  }

  protected ServiceException(String s, Throwable throwable, boolean b, boolean b1) {
    super(s, throwable, b, b1);
  }
}

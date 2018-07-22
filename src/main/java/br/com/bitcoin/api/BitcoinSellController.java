package br.com.bitcoin.api;

import br.com.bitcoin.model.BitcoinTrade;
import br.com.bitcoin.service.BitcoinService;
import br.com.bitcoin.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/sells")
public class BitcoinSellController {

  @Autowired
  private BitcoinService service;

  @RequestMapping(value = "/top", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> top() throws ServiceException {
    return new ResponseEntity<>(service.top(BitcoinTrade.SELL_TYPE), HttpStatus.OK);
  }

  @RequestMapping(value = "/average", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> average() throws ServiceException {
    return new ResponseEntity<>(service.average(BitcoinTrade.SELL_TYPE), HttpStatus.OK);
  }

  @RequestMapping(value = "/median", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> median() throws ServiceException {
    return new ResponseEntity<>(service.median(BitcoinTrade.SELL_TYPE), HttpStatus.OK);
  }

  @RequestMapping(value = "/offset", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> standardDeviation() throws ServiceException {
    return new ResponseEntity<>(service.standardDeviation(BitcoinTrade.SELL_TYPE), HttpStatus.OK);
  }
}
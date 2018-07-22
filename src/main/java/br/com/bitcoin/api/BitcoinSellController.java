package br.com.bitcoin.api;

import br.com.bitcoin.service.BitcoinSellService;
import br.com.bitcoin.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BitcoinSellController {

  @Autowired
  private BitcoinSellService service;

  @RequestMapping(value = "/api/v1/sells/top", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> top() throws ServiceException {
    return new ResponseEntity<>(service.top(), HttpStatus.OK);
  }

  @RequestMapping(value = "/api/v1/sells/average", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> average() throws ServiceException {
    return new ResponseEntity<>(service.average(), HttpStatus.OK);
  }

  @RequestMapping(value = "/api/v1/sells/median", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> median() throws ServiceException {
    return new ResponseEntity<>(service.median(), HttpStatus.OK);
  }

}
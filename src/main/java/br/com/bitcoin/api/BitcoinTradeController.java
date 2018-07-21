package br.com.bitcoin.api;

import br.com.bitcoin.model.BitcoinTrade;
import br.com.bitcoin.service.BitcoinTradeService;
import br.com.bitcoin.service.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BitcoinTradeController {

  @Autowired
  private BitcoinTradeService tradeService;

  @RequestMapping(value = "/api/v1/trades", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> findAll() throws ServiceException {

    List<BitcoinTrade> trades = tradeService.findAll();
    return new ResponseEntity<>(trades, HttpStatus.OK);
  }
}
package br.com.bitcoin.api;

import br.com.bitcoin.model.BitcoinTrade;
import br.com.bitcoin.service.BitcoinService;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/api/v1/purchases")
public class BitcoinPurchasesController {

  private BitcoinService service = new BitcoinService(BitcoinTrade.BUY_TYPE);

  @RequestMapping(value = "/top", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> top() {
    return new ResponseEntity<>(service.top(), HttpStatus.OK);
  }

  @RequestMapping(value = "/average", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> average() {
    return new ResponseEntity<>(service.average(), HttpStatus.OK);
  }

  @RequestMapping(value = "/median", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> median() {
    return new ResponseEntity<>(service.median(), HttpStatus.OK);
  }

  @RequestMapping(value = "/offset", method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
  public ResponseEntity<?> standardDeviation() {
    return new ResponseEntity<>(service.standardDeviation(), HttpStatus.OK);
  }
}
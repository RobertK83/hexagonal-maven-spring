package de.rob.poc;

import de.rob.poc.discardaccount.DiscardAccountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

/**
 * <p>* Maps HTTP request to ja Java objects</p>
 * <p>* Performs authorization checks</p>
 * <p>* Validates input</p>
 * <p>* Maps input to the input model of the use case</p>
 * <p>* Calls the use case</p>
 * <p>* Maps the output of the use case back to HTTP</p>
 * <p>* Returns an HTTP response</p>
 */
@RestController
public class DiscardAccountController {

  private final DiscardAccountService discardAccountService;

  public DiscardAccountController(DiscardAccountService discardAccountService) {
    this.discardAccountService = discardAccountService;
  }

  @DeleteMapping("/account/{id}")
  public ResponseEntity<String> getResponse(@PathVariable String id) {
    final boolean isAccountDiscarded = discardAccountService.byId(Long.valueOf(id));
    return new ResponseEntity<>("The Account with ID " + id + " is discarded.",
        isAccountDiscarded ? HttpStatus.OK : HttpStatus.BAD_REQUEST);
  }
}
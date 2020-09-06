package de.rob.poc.discardaccount;

import api.DiscardAccount;
import model.Account;
import org.springframework.stereotype.Service;

@Service
public class DiscardAccountService implements DiscardAccount {

  /**
   * Used by the adapter-in discard account controller
   *
   * @param id represents the id of the account that should be discarded
   * @return true if the account is successfully discarded, otherwise false
   */
  public boolean byId(Long id) {
    return discard(Account.of(id));
  }

  @Override
  public boolean discard(Account account) {
    return false;
  }
}

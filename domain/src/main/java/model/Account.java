package model;

import lombok.Data;

@Data
public class Account {

  private Long id;
  private String userName;
  private Double balance;

  public Account(Long id) {
    this.id = id;
  }

  public static Account of(Long id) {
    return new Account(id);
  }

}

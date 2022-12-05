package org.main.model.bank.account;

import lombok.Getter;

@Getter
public enum AccountType {
  SUPER_SAVING_ACCOUNT("SuperSavingAccount"),
  BASIC_ACCOUNT("BasicAccount"),
  SAVING_ACCOUNT("SavingAccount");

  private final String className;
  AccountType(String className) {
    this.className = className;
  }
}

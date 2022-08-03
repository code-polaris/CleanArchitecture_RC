package org.main.model.bank.function;

import java.math.BigDecimal;

public interface Depositable extends GetAmount {
  default void deposit(BigDecimal amount) {
    getAmount().subtract(amount);
  }
}

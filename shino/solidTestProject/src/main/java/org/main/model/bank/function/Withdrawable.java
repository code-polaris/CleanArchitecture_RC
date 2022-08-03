package org.main.model.bank.function;

import java.math.BigDecimal;

public interface Withdrawable extends GetAmount{
  default void withdraw(BigDecimal amount) {
    getAmount().subtract(amount);
  }
}

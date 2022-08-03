package org.main.model.bank.function;

import java.math.BigDecimal;

public interface Transferrable extends GetAmount {
  default void transfer(BigDecimal amount) {
    // do nothing for now
  }
}

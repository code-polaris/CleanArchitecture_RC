package org.main.model.bank.function;

import java.math.BigDecimal;

/**
 * インターフェース分離の原則: 預金が必要なクラスだけがこれを継承する
 */
public interface Depositable {
  void deposit(BigDecimal amount);
}

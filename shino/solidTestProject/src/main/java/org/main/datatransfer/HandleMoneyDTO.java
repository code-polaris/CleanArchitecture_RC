package org.main.datatransfer;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class HandleMoneyDTO {
  public HandleMoneyDTO(BankAccountVO vo) {
    this.id = vo.getBankId();
    this.amount = vo.getAmount();
  }

  private Integer id;
  private BigDecimal amount;
}

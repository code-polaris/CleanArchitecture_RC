package org.main.datatransfer;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class HandleMoneyDTO {
  public HandleMoneyDTO(BankAccountVO vo) {
    this.bankCode = vo.getBankCode();
    this.branchCode = vo.getBranchCode();
    this.accountNumber = vo.getAccountNumber();
    this.amount = vo.getAmount();
  }

  private String bankCode;
  private String branchCode;
  private String accountNumber;
  private BigDecimal amount;
}

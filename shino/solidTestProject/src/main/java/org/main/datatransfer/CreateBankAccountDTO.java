package org.main.datatransfer;

import lombok.Data;
import org.main.model.bank.account.AccountType;

@Data
public class CreateBankAccountDTO {

  public CreateBankAccountDTO(BankAccountVO vo) {
    this.bankCode = vo.getBankCode();
    this.branchCode = vo.getBranchCode();
    setAccountType(vo.getAccountType());
    this.accountNumber = vo.getAccountNumber();
  }

  private String bankCode;
  private String branchCode;
  private AccountType accountType;
  private String accountNumber;
  private String myNumber;

  private void setAccountType(String accountType) {
    try {
      this.accountType = AccountType.valueOf(accountType);
    } catch (IllegalArgumentException e) {
      throw new RuntimeException("provided bank type [" + accountType + "] not found");
    }
  }
}

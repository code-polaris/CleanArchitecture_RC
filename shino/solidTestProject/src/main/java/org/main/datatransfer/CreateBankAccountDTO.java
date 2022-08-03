package org.main.datatransfer;

import lombok.Data;

@Data
public class CreateBankAccountDTO {

  public CreateBankAccountDTO(BankAccountVO vo) {
    this.bankNumber = vo.getBankNumber();
  }

  private Long bankNumber;
}

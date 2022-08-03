package org.main.datatransfer;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class BankAccountVO {

  private Integer bankId;
  private Long bankNumber;
  private String iban;
  private BigDecimal amount;
}

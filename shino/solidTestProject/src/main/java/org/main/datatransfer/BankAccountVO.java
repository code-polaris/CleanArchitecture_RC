package org.main.datatransfer;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.io.Serial;
import java.io.Serializable;
import java.math.BigDecimal;

/**
 * Annotation を使うことで、余計なsetter, getter, constructorの変更やBuilderの付け加えなどをしなくてすむし、コードが見やすい
 */
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BankAccountVO implements Serializable {

  @Serial
  private static final long serialVersionUID = 7042748482948192461L;

  private String bankCode;
  private String branchCode;
  private String accountNumber;
  private String accountType;
  private String myNumber;

  private BigDecimal amount;
}

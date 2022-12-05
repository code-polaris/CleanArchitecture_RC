package org.main.model.bank;

import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;
import org.main.model.bank.account.AccountType;

import javax.persistence.*;
import java.math.BigDecimal;

/**
 * リスコフの置換原則
 * 全てのAccountクラスはBankAccountと置き換え可能である
 * (DB上は子クラスは全てBANK_ACCOUNTで、単にBANK_TYPEが違っているだけ)
 */
@Entity
@Data
@JsonInclude(JsonInclude.Include.NON_NULL)
@AllArgsConstructor
@NoArgsConstructor
@SuperBuilder(toBuilder = true)
@Table(name = "BANK_ACCOUNT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "BANK_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class BankAccount {

  @Id
  @GeneratedValue
  protected Integer id;

//  protected String myNumber;

  @Column(name = "BANK_CODE")
  protected String bankCode;

  @Column(name = "BRANCH_CODE")
  protected String branchCode;

  @Column(name = "ACOCUNT_NUMBER")
  protected String accountNumber;

  @Column
  protected BigDecimal amount;

  protected AccountType accountType;
}

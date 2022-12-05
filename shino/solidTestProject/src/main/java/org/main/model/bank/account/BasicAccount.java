package org.main.model.bank.account;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.main.model.bank.BankAccount;
import org.main.model.bank.function.Depositable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import java.math.BigDecimal;

@Entity
@DiscriminatorValue("BASIC_ACCOUNT")
@ToString
@NoArgsConstructor
@SuperBuilder
public class BasicAccount extends BankAccount implements Depositable {


  public BasicAccount(Integer id, /* String myNumber,*/ String bankCode, String branchCode, String accountNumber, BigDecimal amount, AccountType accountType) {
    super(id, /* myNumber,*/ bankCode, branchCode, accountNumber, amount, accountType);
  }

  @Override
  public void deposit(BigDecimal amount) {
    this.amount = this.amount.add(amount);
  }
}

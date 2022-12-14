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
@DiscriminatorValue("SAVING_ACCOUNT")
@ToString
@NoArgsConstructor
@SuperBuilder
public class SavingAccount extends BankAccount implements Depositable {
  @Override
  public void deposit(BigDecimal amount) {
    this.amount = this.amount.add(amount);
  }
}

package org.main.model.bank.account;

import lombok.experimental.SuperBuilder;
import org.main.model.bank.BankAccount;
import org.main.model.bank.function.Depositable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SAVING_ACCOUNT")
@SuperBuilder
public class SavingAccount extends BankAccount implements Depositable {
}

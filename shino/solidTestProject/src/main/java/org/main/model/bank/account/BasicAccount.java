package org.main.model.bank.account;

import lombok.experimental.SuperBuilder;
import org.main.model.bank.BankAccount;
import org.main.model.bank.function.Depositable;
import org.main.model.bank.function.Withdrawable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("BASIC_ACCOUNT")
@SuperBuilder
public class BasicAccount extends BankAccount implements Withdrawable, Depositable {
}

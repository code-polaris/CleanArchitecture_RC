package org.main.model.bank.account;

import lombok.experimental.SuperBuilder;
import org.main.model.bank.BankAccount;
import org.main.model.bank.function.Depositable;
import org.main.model.bank.function.Transferrable;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@DiscriminatorValue("INVESTMENT_ACCOUNT")
@SuperBuilder
public class InvestmentAccount extends BankAccount implements Depositable, Transferrable {

}

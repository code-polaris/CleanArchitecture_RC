package org.main.model.bank.account;

import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.main.model.bank.BankAccount;

import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("SUPER_SAVING_ACCOUNT")
@ToString
@NoArgsConstructor
@SuperBuilder
public class SuperSavingAccount extends BankAccount {

}

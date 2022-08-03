package org.main.model.bank;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.SuperBuilder;
import org.main.model.bank.account.BankType;
import org.main.model.bank.function.GetAmount;

import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@Getter
@Setter
@SuperBuilder
@Table(name = "BANK_ACCOUNT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name="BANK_TYPE", discriminatorType = DiscriminatorType.STRING)
public abstract class BankAccount implements GetAmount {

  @Id
  @GeneratedValue
  private Integer id;

  @Column(name = "BANK_NUMBER")
  private Long bankNumber;

  @Column
  private BigDecimal amount;

  public BigDecimal getAmount() {
    return getAmount();
  }

  @Override
  public String toString() {
    return "BankAccount{" +
      "id=" + id +
      ", bankNumber=" + bankNumber +
      ", amount=" + amount +
      '}';
  }
}

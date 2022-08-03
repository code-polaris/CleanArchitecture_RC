package org.main.service;

import org.main.datatransfer.CreateBankAccountDTO;
import org.main.datatransfer.HandleMoneyDTO;
import org.main.model.bank.BankAccount;
import org.main.model.bank.account.BasicAccount;
import org.main.model.bank.account.SavingAccount;
import org.main.model.bank.function.Depositable;
import org.main.model.bank.function.Transferrable;
import org.main.model.bank.function.Withdrawable;
import org.main.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@Service
public class BankManagingService {
  @Autowired
  private BankAccountRepository repository;

  public BankAccount createBasicAccount(CreateBankAccountDTO dto) {
    BasicAccount account = BasicAccount.builder().bankNumber(dto.getBankNumber()).build();
    return repository.save(account);
  }

  public BankAccount createSavingAccount(CreateBankAccountDTO dto) {
    SavingAccount account = SavingAccount.builder().bankNumber(dto.getBankNumber()).build();
    return repository.save(account);
  }

  public BigDecimal deposit(HandleMoneyDTO dto) {
    BankAccount bankAccount = repository.findById(dto.getId()).orElseThrow();
    if (bankAccount instanceof Depositable) {
      ((Depositable) bankAccount).deposit(dto.getAmount());
    } else {
      throw new IllegalArgumentException("The provided bank account is not allowed to deposit");
    }
    return bankAccount.getAmount();
  }
}

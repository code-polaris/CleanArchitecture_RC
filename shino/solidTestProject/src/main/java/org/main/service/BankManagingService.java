package org.main.service;

import org.main.datatransfer.CreateBankAccountDTO;
import org.main.datatransfer.HandleMoneyDTO;
import org.main.model.bank.BankAccount;
import org.main.model.bank.account.BankAccountFactory;
import org.main.model.bank.function.Depositable;
import org.main.repository.BankAccountRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BankManagingService {

  @Autowired
  private BankAccountFactory accountFactory;

  @Autowired
  private BankAccountRepository repository;

  public BankAccount createAccount(CreateBankAccountDTO dto) {
    // bankAccountの生成
    BankAccount account = accountFactory.createBankAccount(dto);
    // DBへの挿入
    return repository.save(account);
  }

  public BankAccount deposit(HandleMoneyDTO dto) {
    // accountの特定
    BankAccount account = repository.findByBankCodeAndBranchCodeAndAccountNumber(dto.getBankCode(), dto.getBranchCode(), dto.getAccountNumber());

    // 預金
    if (account instanceof Depositable) {
      ((Depositable) account).deposit(dto.getAmount());
      repository.save(account);
    } else {
      throw new RuntimeException("このバンクタイプは、お金を引き出すことができません。");
    }
    return account;
  }

}
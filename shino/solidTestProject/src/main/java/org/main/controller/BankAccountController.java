package org.main.controller;

import org.main.datatransfer.BankAccountVO;
import org.main.datatransfer.CreateBankAccountDTO;
import org.main.datatransfer.HandleMoneyDTO;
import org.main.model.bank.BankAccount;
import org.main.service.BankManagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {

  @Autowired
  private BankManagingService service;

  @PostMapping("/create")
  public BankAccount createAccount(@RequestBody BankAccountVO bankAccountVO) {
    CreateBankAccountDTO dto = new CreateBankAccountDTO(bankAccountVO);
    BankAccount account = service.createAccount(dto);
    return account;
  }

  @PutMapping("/deposit")
  public BankAccount deposit(@RequestBody BankAccountVO bankAccountVO) {
    HandleMoneyDTO dto = new HandleMoneyDTO(bankAccountVO);
    BankAccount account = service.deposit(dto);
    return account;
  }

  @ExceptionHandler(Exception.class)
  public String handleException(Exception ex) {
    return "Request failed. Cause: " + ex.getLocalizedMessage();
  }
}

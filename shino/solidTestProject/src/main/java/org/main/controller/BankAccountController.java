package org.main.controller;

import org.main.datatransfer.BankAccountVO;
import org.main.datatransfer.CreateBankAccountDTO;
import org.main.datatransfer.HandleMoneyDTO;
import org.main.model.bank.BankAccount;
import org.main.service.BankManagingService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/bankAccount")
public class BankAccountController {

  @Autowired
  private BankManagingService service;

  @PostMapping("/create/basicAccount")
  @ResponseBody
  public String createBasicAccount(@RequestParam BankAccountVO bankAccountVO) {
    System.out.println(bankAccountVO.toString());
    CreateBankAccountDTO dto = new CreateBankAccountDTO(bankAccountVO);
    BankAccount account = service.createBasicAccount(dto);
    return "created basic bank account id with " + account.getId();
  }

  @PostMapping("/create/savingAccount")
  public String createSavingAccount(@RequestParam BankAccountVO bankAccountVO) {
    CreateBankAccountDTO dto = new CreateBankAccountDTO(bankAccountVO);
    BankAccount account = service.createSavingAccount(dto);
    return "created basic bank account id with " + account.getId();
  }

  @PostMapping("/deposit")
  public String deposit(@RequestParam BankAccountVO bankAccountVO) {
    HandleMoneyDTO dto = new HandleMoneyDTO(bankAccountVO);
    BigDecimal amountInAccount = service.deposit(dto);
    return "You have deposited the amount of " + bankAccountVO.getAmount() + ". You have " + amountInAccount + " in your account";
  }
}

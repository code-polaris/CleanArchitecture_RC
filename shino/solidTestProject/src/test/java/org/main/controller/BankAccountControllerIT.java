package org.main.controller;

import com.google.gson.Gson;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.main.controller.BankAccountController;
import org.main.datatransfer.BankAccountVO;
import org.main.datatransfer.CreateBankAccountDTO;
import org.main.model.bank.BankAccount;
import org.main.model.bank.account.AccountType;
import org.main.model.bank.account.BasicAccount;
import org.main.service.BankManagingService;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringJUnit4ClassRunner.class)
public class BankAccountControllerIT {

  private MockMvc mockMvc;

  private final Gson gson = new Gson();

  @Mock
  private BankManagingService service;

  @InjectMocks
  private BankAccountController controller;

  @Before
  public void setUp() {
    MockitoAnnotations.openMocks(this);
    this.mockMvc = MockMvcBuilders.standaloneSetup(controller).build();
  }

  @Test
  public void test() throws Exception {
    BankAccount createdBankAccount = BasicAccount.builder().id(1).build();
    when(service.createAccount(any(CreateBankAccountDTO.class))).thenReturn(createdBankAccount);
    BankAccountVO accountVO = BankAccountVO
      .builder()
      .accountNumber("12345")
      .branchCode("ED224")
      .bankCode("123")
      .accountType(AccountType.BASIC_ACCOUNT.toString())
      .build();

    this.mockMvc.perform(
        post("/bankAccount/create")
          .contentType(MediaType.APPLICATION_JSON)
          .content(gson.toJson(accountVO)))
      .andExpect(status().isOk());
  }

}
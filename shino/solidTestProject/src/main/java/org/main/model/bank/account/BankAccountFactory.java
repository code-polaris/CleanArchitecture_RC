package org.main.model.bank.account;

import org.main.datatransfer.CreateBankAccountDTO;
import org.main.model.bank.BankAccount;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component
public class BankAccountFactory {

  public BankAccount createBankAccount(CreateBankAccountDTO dto) {
    /*
     * open-closedの法則
     * BankAccountのタイプが増えたら、ここのcaseを増やすだけで良い
     */
    BankAccount.BankAccountBuilder<?, ?> accountBuilder = switch (dto.getAccountType()) {
      case BASIC_ACCOUNT -> BasicAccount.builder(); // 子クラスのBuilderは親クラスのBankAccountBuilderを継承している
      case SAVING_ACCOUNT -> SavingAccount.builder();
      case SUPER_SAVING_ACCOUNT -> SuperSavingAccount.builder();
      default -> throw new RuntimeException("Unknown account type found during account creation");
    };

    /**
     * Builderでインスタンスの生成をする場合、要素が増えても"修正"ではなく"追加"で対応できる　(オープンクローズドの原則)
     */
    return accountBuilder
      .bankCode(dto.getBankCode())
      .branchCode(dto.getBranchCode())
      .accountNumber(dto.getAccountNumber())
      .accountType(dto.getAccountType())
//      .myNumber(dto.getMyNumber())　この部分がなくても、既存のコードには影響しない
      .amount(BigDecimal.ZERO)
      .build();
  }

  /**
   * 悪い例
   */
  public BankAccount createBankAccountByNameWithoutBuilder(CreateBankAccountDTO dto) {
    BankAccount account = switch (dto.getAccountType()) {
      // 属性が増える度にここの部分の変更が必要になる
      // new インスタンスが生成されている箇所を全部探して修正しないと、コンパイルエラーが起こる
      case BASIC_ACCOUNT -> new BasicAccount(
        0,
//        dto.getMyNumber(),
        dto.getBankCode(),
        dto.getBranchCode(),
        dto.getAccountNumber(),
        BigDecimal.ZERO,
        dto.getAccountType()
      );
      case default -> null;
    };
    return account;
  }
}

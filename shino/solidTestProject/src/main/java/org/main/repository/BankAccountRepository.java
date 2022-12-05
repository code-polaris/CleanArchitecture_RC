package org.main.repository;

import org.main.model.bank.BankAccount;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

/**
 * オープンクローズドの原則: データベースの種類は{@link org.main.SpringConfig}で変えられる。
 * もしデータベースの種類が違っていたとしても、このRepositoryクラスに変更はない
 * <p>
 * よくあるのが、テストではEmbedded databaseを使って、実際使われるMySQLやDB2と切り離すケース
 */
@Repository
public interface BankAccountRepository extends CrudRepository<BankAccount, Integer> {

  BankAccount findByBankCodeAndBranchCodeAndAccountNumber(String bankCode, String branchCode, String accountNumber);
}

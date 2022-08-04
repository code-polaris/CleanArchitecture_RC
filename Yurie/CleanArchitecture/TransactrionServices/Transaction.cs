using System;

namespace TransactrionServices
{

    /// <summary>
    /// SOLIDのSRPに極端に違反した例のクラス
    /// 一つのクラスに3つのサービスが実装されているためNG
    /// </summary>
    public class Transaction
    {
        public void TransferController()
        { }        

        public void DepositController()
        { }

        public void WithdrawalController()
        { }                
    }

    public class Validation
    {
        //入金された金額データが整数かvlidateする的なメソッド
        public bool IsInt(int money)
        {
            return true;
        }

        //預金があるかどうか
        public bool IsDepositExist() 
        {
            return true;
        }
    }


    /// <summary>
    /// Transaction関連で使うインターフェース
    /// インターフェース分離の規則の違反例
    /// </summary>
    public interface ITransactionService 
    {
        void ITransferController();

        void IDepositController();

        void IWithdrawalController();

        void IValidater();
    }
}

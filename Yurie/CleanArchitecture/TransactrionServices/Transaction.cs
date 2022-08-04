using System;

namespace TransactrionServices
{

    /// <summary>
    /// SOLIDのSRPに極端に違反した例のクラス
    /// 一つのクラスに3つのサービスが実装されているためNG
    /// </summary>
    public class Transaction
    {
        private enum TransferType
        {
            TransferToOurBank,
            TransferToOtherBank,
            TransferToRegisteredDestination,
            Default
        }

        /// <summary>
        /// これはOCPに違反。1つのcaseの処理を変えるとこのメソッド全体に影響する。
        /// </summary>
        public void TransferController()
        {            
            switch (TransferType.Default)
            {
                case TransferType.TransferToOurBank:
                    //同じ銀行の他口座への送金処理
                    break;
                case TransferType.TransferToOtherBank:
                    //違う銀行への送金処理
                    break;
                case TransferType.TransferToRegisteredDestination:
                    //登録済み口座への送金
                    break;

                default:
                    throw new ArgumentOutOfRangeException();
            }
        }

        public void DepositController()
        {
        }

        public void WithdrawalController()
        {
        }

        
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

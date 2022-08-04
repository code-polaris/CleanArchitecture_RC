using System;
using System.Collections.Generic;
using System.Text;

namespace TransactionFulfillment.Application.Services.Transfer
{
    public class TransferToOurBank :TransferBase
    {
        public int BankAccountNumber { get; set; }
        public TransferToOurBank(Transfer transfer, int bankAccountNumber) : base(transfer)
        {
            BankAccountNumber = bankAccountNumber;
        } 

    }
}

using System;
using System.Collections.Generic;
using System.Text;

namespace TransactionFulfillment.Application.Services.Transfer
{
    public abstract class TransferBase
    {
        public Transfer Transfer { get; set; }

        protected TransferBase(Transfer transfer) 
        {
            Transfer = transfer;
        }

        public void 
    }
    

    public class Transfer 
    {
        public int TransferId { get; set; }
    }
}

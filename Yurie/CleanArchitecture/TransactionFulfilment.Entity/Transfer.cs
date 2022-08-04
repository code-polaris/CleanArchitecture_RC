using System;

namespace TransactionFulfilment.Entity
{
    public class Transfer
    {        
        public enum TransferType
        {
            TransferToOurBank = 1,
            TransferToOtherBank = 2,
            TransferToRegisteredDestination = 3
        }
    }        
}

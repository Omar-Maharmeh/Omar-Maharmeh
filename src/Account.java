import java.util.Arrays;

public class Account {

    private static final int Default_Transaction_Amount = 10;

    private int Id;
    private Transaction [] transactions;
    private int LastTransactionIndex;


    {
        transactions = new Transaction[Default_Transaction_Amount];
    }

     public  Account(int id){
        this.Id=id;
}


    public void SendMonyTOAccount(Account accountTo, double MonyAmount) {

        if (accountTo == null) {
            return;
        }
        if (MonyAmount <= 0) {
            return;
        }

        Transaction transaction = new Transaction(this, accountTo, MonyAmount, StanderdAccountOperation.Money_Transaction_Send);
        addTransactio(transaction);
        accountTo.ReciveMony(accountTo,MonyAmount);

    }

    public void ReciveMony(Account accountfrom,double MonyAmount){

        if(accountfrom==null){return;}
        if(MonyAmount<=0){return;}

        Transaction transaction=new Transaction(this,accountfrom,MonyAmount,StanderdAccountOperation.Money_Transaction_Receive);
        addTransactio(transaction);

    }

    public  void Withdraw(double MonyAmont){

        Transaction transaction=new Transaction(this,null,MonyAmont,StanderdAccountOperation.WithDraw);
        addTransactio(transaction);


    }


    private void addTransactio(Transaction transaction) {

        if (transaction == null) {
            return;
        }

        if (transactions.length<=LastTransactionIndex){

            transactions=Arrays.copyOf(transactions,transactions.length<<1);

        }
        transactions[LastTransactionIndex++]=transaction;

    }

    @Override
    public String toString() {
        return "Account{" +
                "Id=" + Id +
                '}';
    }
    public Transaction[] getTransactions() {
        int nonNullTransactionsAmount = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                nonNullTransactionsAmount++;
            }
        }

        Transaction[] filteredTransactions = new Transaction[nonNullTransactionsAmount];
        int index = 0;
        for (Transaction transaction : transactions) {
            if (transaction != null) {
                filteredTransactions[index++] = transaction;
            }
        }
        return filteredTransactions;

    }



    public  static  class Transaction {


        private Account accountfrom;
        private Account accountTo;
        private double MonyAmount;
        private StanderdAccountOperation operation;

        public Account getAccountTo() {
            return accountTo;
        }

        public void setAccountTo(Account accountTo) {
            this.accountTo = accountTo;
        }

        public Account getAccountfrom() {
            return accountfrom;
        }

        public void setAccountfrom(Account accountfrom) {
            this.accountfrom = accountfrom;
        }

        public double getMonyAmount() {
            return MonyAmount;
        }

        public void setMonyAmount(double monyAmount) {
            MonyAmount = monyAmount;
        }

        public StanderdAccountOperation getOperation() {
            return operation;
        }

        public void setOperation(StanderdAccountOperation operation) {
            this.operation = operation;
        }

        public Transaction(Account accountfrom, Account accountTo, double monyAmount, StanderdAccountOperation operation) {
            this.accountfrom = accountfrom;
            this.accountTo = accountTo;
            MonyAmount = monyAmount;
            this.operation = operation;
        }

        @Override
        public String toString() {
            return "Transaction{" +
                    "accountfrom=" + accountfrom +
                    ", accountTo=" + accountTo +
                    ", MonyAmount=" + MonyAmount +
                    ", operation=" + operation +
                    '}';
        }
    }
}
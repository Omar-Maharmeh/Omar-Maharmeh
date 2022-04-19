import java.util.Arrays;

public class Demo {

    public static void main(String[] args) {


Account accountFrom=new Account(1);
Account accountTo=new Account(2);

accountFrom.SendMonyTOAccount(accountTo,100);
accountFrom.Withdraw(200);

        System.out.println(Arrays.toString(accountFrom.getTransactions()));
        System.out.println(Arrays.toString(accountTo.getTransactions()));

        System.out.println("------------------------------------");

        Account.Transaction c=new Account.Transaction(accountFrom,accountTo,100,StanderdAccountOperation.Money_Transaction_Receive);
        System.out.println(c);

    }


}

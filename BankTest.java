package exer4;

//public class BankTest {
//    public static void main(String[] args){
//        Bank bank = new Bank();
//
//        bank.addCustomer("Jane","Smith");
//
//        bank.getCustomer(0).setAccount(new Account(2000));
//
//        bank.getCustomer(0).getAccount().withdraw(500);
//
//        double balance = bank.getCustomer(0).getAccount().getBalance();
//        System.out.println("客户:" + bank.getCustomer(0).getFirstName() + "的账户余额为" +
//                bank.getCustomer(0).getAccount().getBalance());
//
//        bank.addCustomer("白","李");
//        System.out.println("银行客户数量为" + bank.getNumberOfCustomer());
//    }
//}

public class BankTest {
    public static void main(String[] args){
        Bank bank = new Bank();
        bank.addCustomer("Josh","Paul");
        Account acct = new Account(2000);
        bank.getCustomer(0).setAccount(acct);
        bank.getCustomer(0).getAccount().withdraw(500);
        double balance = bank.getCustomer(0).getAccount().getBalance();
        System.out.println("客户:" + bank.getCustomer(0).getFirstName() + "的账户余额为" +
                bank.getCustomer(0).getAccount().getBalance());
     }
}
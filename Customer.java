package exer4;

//public class Customer {
//    private String firstName;
//    private String lastName;
//    private Account account;
//
//    public Customer(String f,String l){
//        this.firstName = f;
//        this.lastName = l;
//    }
//
//    public Account getAccount() {
//        return account;
//    }
//
//    public void setAccount(Account account) {
//        this.account = account;
//    }
//
//    public String getFirstName() {
//        return firstName;
//    }
//
//    public String getLastName() {
//        return lastName;
//    }
//}
public class Customer {
    String firstname;
    String lastname;
    Account account;

    public Customer(String f,String l){
        this.firstname = f;
        this.lastname = l;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public String getFirstName() {
        return firstname;
    }

    public String getLastName() {
        return lastname;
    }
}
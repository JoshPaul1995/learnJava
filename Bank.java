package exer4;

//public class Bank {
//    private Customer[] customers;//可存放多个客户的数组
//    private int numberOfCustomer;//记录客户数量
//
//    public Bank(){
//        customers = new Customer[10];
//    }
//    public void addCustomer(String f,String l){
//        Customer cust = new Customer(f,l);
//        customers[numberOfCustomer++] = cust;
//    }
//    public int getNumberOfCustomer(){
//
//        return numberOfCustomer;
//    }
//    public Customer getCustomer(int index){
//        if(index >= 0 && index < numberOfCustomer) {
//            return customers[index];
//        }
//        return null;
//    }
//}

public class Bank {
    Customer[] customers;
    int numberOfCustomer;

    public Bank(){
        customers = new Customer[10];
    }
    public void addCustomer(String f,String l){
        Customer cust = new Customer(f,l);
        customers[numberOfCustomer++] = cust;
    }
    public int getNumberOfCustomer(){
        return numberOfCustomer;
    }
    public Customer getCustomer(int index){
        if(index >= 0 && index < numberOfCustomer) {
            return customers[index];
        }
        return null;
    }
}
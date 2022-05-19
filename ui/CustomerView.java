package ui;

import bean.Customer;
import service.CustomerList;
import util.CMUtility;

public class CustomerView {
    private CustomerList customerList = new CustomerList(10);

    public CustomerView(){
        Customer customer = new Customer("JP",'男',26,"18507699127","joshua_peng@outlook.com");
        customerList.addCustomer(customer);
    }

    public static void main(String[] args){
        CustomerView customerView = new CustomerView();
        customerView.enterMainMenu();
    }

    public void enterMainMenu(){
        boolean isFlag = true;
        while(isFlag) {
            System.out
                    .println("\n-----------------客户信息管理软件-----------------\n");
            System.out.println("                   1 添 加 客 户");
            System.out.println("                   2 修 改 客 户");
            System.out.println("                   3 删 除 客 户");
            System.out.println("                   4 客 户 列 表");
            System.out.println("                   5 退       出\n");
            System.out.print("                   请选择(1-5)：");

            char menu = CMUtility.readMenuSelection();
            switch (menu){
                case '1':
                    addNewCustomer();
                    break;
                case '2':
                    modifyCustomer();
                    break;
                case '3':
                    deleteCustomer();
                    break;
                case '4':
                    listAllCustomers();
                    break;
                case '5':
                    System.out.println("是否确认退出Y/N");
                    char isExit = CMUtility.readConfirmSelection();
                    if(isExit == 'Y'){
                        isFlag = false;
                    }
            }
        }
    }

    private void addNewCustomer(){
//        System.out.println("添加客户的操作");
        System.out.println("---------------------添加客户---------------------");
        System.out.print("姓名：");
        String name = CMUtility.readString(10);
        System.out.print("性别：");
        char gender = CMUtility.readChar();
        System.out.print("年龄：");
        int age = CMUtility.readInt();
        System.out.print("电话：");
        String phone = CMUtility.readString(13);
        System.out.print("邮箱：");
        String email = CMUtility.readString(30);

        Customer customer = new Customer(name,gender,age,phone,email);

        boolean isSuccess= customerList.addCustomer(customer);

        if(isSuccess){
            System.out.println("---------------------添加完成---------------------");
        }
        else{
            System.out.println("---------------------客户目录已满，添加失败---------------------");
        }




    }
    private void modifyCustomer(){
//        System.out.println("修改客户的操作");
        System.out.println("---------------------修改客户---------------------");
        Customer cust;
        int number;
        while(true){
            System.out.println("请选择欲修改客户编号（-1退出）");
            number = CMUtility.readInt();
            if(number == -1){
                return;
            }
            cust = customerList.getCustomer(number - 1);
            if(cust == null){                       //getCustomer方法，如果该位置无客户会返回null
                System.out.println("查无此人");
            }
            else{                                   //找到了客户
                break;                              //准备修改客户信息
            }
        }
        System.out.println("姓名(" + cust.getName() + "):");
        String name = CMUtility.readString(10,cust.getName());
        System.out.println("性别(" + cust.getGender() + "):");
        char gender = CMUtility.readChar(cust.getGender());
        System.out.println("年龄(" + cust.getAge() + "):");
        int age = CMUtility.readInt(cust.getAge());
        System.out.println("电话(" + cust.getPhone()+ "):");
        String phone = CMUtility.readString(13,cust.getPhone());
        System.out.println("邮箱(" + cust.getEmail() + "):");
        String email = CMUtility.readString(30,cust.getEmail());

        Customer newCust = new Customer(name,gender,age,phone,email);

        boolean isReplaced = customerList.replaceCustomer(number - 1,newCust);
        if(isReplaced){
            System.out.println("---------------------修改完成---------------------");
        }
        else{
            System.out.println("----------无法找到指定客户,修改失败--------------");
        }
    }

    private void deleteCustomer(){
        System.out.println("---------------------删除客户---------------------");
        int index = 0;
        Customer cust = null;
        for (;;) {
            System.out.print("请选择待删除客户编号(-1退出)：");
            index = CMUtility.readInt();
            if (index == -1) {
                return;
            }

            cust = customerList.getCustomer(index - 1);
            if (cust == null) {
                System.out.println("无法找到指定客户！");
            } else
                break;
        }

        System.out.print("确认是否删除(Y/N)：");
        char yn = CMUtility.readConfirmSelection();
        if (yn == 'N')
            return;

        boolean flag = customerList.deleteCustomer(index - 1);
        if (flag) {
            System.out
                    .println("---------------------删除完成---------------------");
        } else {
            System.out.println("----------无法找到指定客户,删除失败--------------");
        }

    }
    private void listAllCustomers(){
        System.out.println("---------------------------客户列表---------------------------");
        int total = customerList.getTotal();
        if(total == 0){
            System.out.println("没有客户记录");
        }
        else {
            System.out.println("编号\t姓名\t性别\t年龄\t电话\t\t\t邮箱");
            Customer[] custs = customerList.getAllCustomers();
            for(int i = 0;i < custs.length;i++){
//                System.out.println(i+1 + "\t" + cust[i].getName() + "\t" +  cust[i].getGender() + "\t" + cust[i].getAge() + "\t" + cust[i].getPhone() + "\t" + cust[i].getEmail());
                System.out.println((i+1) + "\t" + custs[i].getDetails());
            }
        }
        System.out.println("-------------------------客户列表完成-------------------------");
    }
}

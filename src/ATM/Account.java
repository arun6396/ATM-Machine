package ATM;

public class Account {
    private String AccountNumber;
    private String pincode;
    private double balance;

    public Account(String AccountNumber,String pincode, double balance){
        this.AccountNumber=AccountNumber;
        this.pincode=pincode;
        this.balance=balance;
    }
    public boolean Authenticate(String Inputpincode){
        return this.pincode.equals(Inputpincode);
    }

    public double getBalance(){
        return balance;
    }

    public void withdraw (double amount){
        if(amount <= balance){
            balance -=amount;
            System.out.println("Successfully withdraw amount  : " + amount);
        }
        else{
            System.out.println("Insufficient Balance");
        }
    }
    public void deposit(double amount){
        balance +=amount;
        System.out.println("Successfully Deposite : " + amount);
    }

    public void pinChange(String newPinCode){
        pincode=newPinCode;
        System.out.println("Pincode Successfully changed");
    }
}

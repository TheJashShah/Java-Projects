import java.util.Scanner;


public class Main{
    public static void main(String[] args){
        try (Scanner sc = new Scanner(System.in)) {
            account[] accounts = new account[10];
            int count = 0;

            int Loop = 1;
            int choice, AccNumber, years;
            double amt, depo, withdraw, FD_amt, rate;
            String name;
            int flag = 1;

            while(Loop == 1){
                System.out.println("\nMENU:");
                System.out.println("1. CREATE ACCOUNT.");
                System.out.println("2. DEPOSIT.");
                System.out.println("3. WITHDRAW");
                System.out.println("4. FIXED DEPOSIT");
                System.out.println("5. SEND MONEY TO ANOTHER ACCOUNT.");
                System.out.println("6. DISPLAY.");
                System.out.println("7. EXIT.");
                System.out.println("Enter your Choice: ");
                choice = sc.nextInt();

                switch(choice){
                    case 1:{
                        System.out.println("Enter an account number, preferably eight digits: ");
                        AccNumber = sc.nextInt();
                        System.out.println("Enter the Account holder's name: ");
                        name = sc.next();
                        System.out.println("Enter the initial deposit: ");
                        amt  = sc.nextDouble();

                        for(int i = 0; i < count; i++){
                            if(accounts[i].AccNumber ==  AccNumber){
                                System.out.println("THIS ACCOUNT ALREADY EXISTS.");
                                flag = 0;
                            }
                            else{
                                flag = 1;
                            }

                        }

                        if(flag == 1){
                            accounts[count++] = new account(AccNumber, name, amt);
                            System.out.println("NEW ACCOUNT CREATED.");
                        }
                                                
                        break;
                    }
                    case 2:{
                        System.out.println("Enter your account number: ");
                        AccNumber = sc.nextInt();
                        System.out.println("Enter the deposit amount: ");
                        depo = sc.nextDouble();
                        for(int i = 0; i < count; i++){
                            if(accounts[i].AccNumber == AccNumber){
                                accounts[i].deposit(depo);
                                flag = 0;
                            }
                            else{
                                flag = 1;
                            }
                        }

                        if(flag == 1){
                            System.out.println("ACCOUNT NUMBER NOT FOUND.");
                        }
                        break;
                    }
                    case 3:{
                        System.out.println("Enter your account number: ");
                        AccNumber = sc.nextInt();
                        System.out.println("Enter the amount: ");
                        withdraw = sc.nextDouble();
                        for(int i = 0; i < count; i++){
                            if(accounts[i].AccNumber == AccNumber){
                                accounts[i].withdraw(withdraw);
                                flag = 0;
                            }
                            else{
                                flag = 1;
                            }
                        }
                        if(flag == 1){
                            System.out.println("ACCOUNT NUMBER NOT FOUND.");
                        }
                        break;
                    }
                    case 4:{
                        System.out.println("Enter your account number: ");
                        AccNumber = sc.nextInt();
                        System.out.println("Enter the deposit amount: ");
                        FD_amt = sc.nextDouble();
                        System.out.println("Enter the amount of years: ");
                        years = sc.nextInt();
                        System.out.println("Enter the rate of interest you wish to recieve for this FD: ");
                        rate = sc.nextDouble();
        
                        for(int i = 0; i < count; i++){
                            if(accounts[i].AccNumber == AccNumber){
                                accounts[i].FixedDeposit(FD_amt, years, rate);
                                flag = 0;
                            }
                            else{
                                flag = 1;
                            }
                        }

                        if(flag == 1){
                            System.out.println("ACCOUNT NUMBER NOT FOUND.");
                        }
                        break;
                    }
                    case 5:{
                        System.out.println("Enter your(sender's) account number: ");
                        AccNumber = sc.nextInt();
                        System.out.println("Enter the reciever's account number: ");
                        int AccNum = sc.nextInt();
                        System.out.println("Enter the amount to be sent: ");
                        double amt_to_send = sc.nextDouble();

                        for(int i = 0; i < count; i++){
                            if(accounts[i].AccNumber == AccNumber){
                                flag = 0;
                                accounts[i].withdraw(amt_to_send);
                            }
                            else{
                                flag = 1;
                            }
                        }

                        for(int j = 0; j < count; j++){
                            if(accounts[j].AccNumber == AccNum){
                                flag = 0;
                                accounts[j].deposit(amt_to_send);
                            }
                            else{
                                flag = 1;
                            }
                        }

                        if(flag == 1){
                            System.out.println("ACCOUNT NUMBER NOT FOUND.");
                        }
                        break;
                    }
                    case 6:{
                        System.out.println("Enter your account number: ");
                        AccNumber = sc.nextInt();
                        for(int i = 0; i < count; i++){
                            if(accounts[i].AccNumber == AccNumber){
                                accounts[i].Display();
                                flag = 0;
                            }
                            else{
                                flag = 1;
                            }
                        }
                        if(flag == 1){
                            System.out.println("ACCOUNT NUMBER NOT FOUND.");
                        }
                        break;
                    }
                    case 7:{
                        System.out.println("Thank you for using our program!");
                        Loop = 0;
                        break;
                    }
                    default:{
                        System.out.println("Enter an appropriate number.");
                        break;
                    }
                }
            }
        }
    }
}
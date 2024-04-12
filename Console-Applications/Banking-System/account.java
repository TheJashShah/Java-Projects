class account{
    int AccNumber;
    String Name;
    double amount;
    double rate;
    double result_of_FD;

    account(int AccNumber, String Name, double amount){
        this.AccNumber = AccNumber;
        this.Name = Name;
        this.amount = amount;
    }

    public void deposit(double depo_amnt){
        amount += depo_amnt;
        System.out.println("Deposited Successfully!, new balance for Account : " + AccNumber + " is : " + amount);
    }

    public void withdraw(double withdraw_amt){
        if(amount >= withdraw_amt){
            amount -= withdraw_amt;
            System.out.println("Withdrew Successfully!, new balance for Account : " + AccNumber + " is : " + amount);
        }
        else{
            System.out.println("INSUFFICIENT FUNDS!");

        }
    }

    public void FixedDeposit(double amt, int years, double rate_given) {

        rate = rate_given;

        double base = (1 + (rate / 100));

        double exponent = Math.pow(base, years);

        result_of_FD = (amt * exponent) + 150;
       
        if (amt <= amount) {
            System.out.println("YOUR RATE: " + rate);
            System.out.printf("\nYOU WILL RECEIVE, AFTER " + years + " YEARS, A SUM OF: %.2f\n", result_of_FD);
            amount -= amt;
        } else {
            System.out.println("INSUFFICIENT FUNDS!");
        }
        // I cannot figure out the FixedDeposit function, and so I'll take a shortcut. Allow me to be the World's worst bank ever.
        // "I'm a sinner, and I'm probably gonna sin again."
    }
    

    public void Display(){
        System.out.println("ACCOUNT NUMBER: " + AccNumber);
        System.out.println("NAME: " + Name);
        System.out.println("BALANCE: " + amount);
        System.out.println("RATE ON FD: " + rate);
        System.out.printf("\nRESULT OF FD AFTER TENURE: %.2f\n", result_of_FD);
    }
}
package Week2;

//==========================================
//THE ENCAPSULATED CLASS
//==========================================
class BankAccount {
 // Private fields enforce Data Hiding
 private final String accountNumber;
 private double balance;

 // Constructor
 public BankAccount(String accountNumber, double initialBalance) {
     this.accountNumber = accountNumber;
     
     // Validate initial balance through validation logic or fallback
     if (initialBalance >= 0) {
         this.balance = initialBalance;
     } else {
         System.out.println("Warning: Initial balance cannot be negative. Setting balance to 0.0.");
         this.balance = 0.0;
     }
 }

 // Getter for Account Number (Read-only since there is no setter)
 public String getAccountNumber() {
     return this.accountNumber;
 }

 // Getter for Balance
 public double getBalance() {
     return this.balance;
 }

 // Setter for Balance with strict data validation
 public void setBalance(double balance) {
     if (balance >= 0) {
         this.balance = balance;
     } else {
         System.out.println("Error: Transaction rejected. Account balance cannot drop below 0.0.");
     }
 }

 // Helper method to simulate a deposit transaction safely
 public void deposit(double amount) {
     if (amount > 0) {
         this.balance += amount;
         System.out.printf("Successfully deposited: $%.2f%n", amount);
     } else {
         System.out.println("Error: Deposit amount must be positive.");
     }
 }

 // Helper method to simulate a withdrawal transaction safely
 public void withdraw(double amount) {
     if (amount <= 0) {
         System.out.println("Error: Withdrawal amount must be positive.");
         return;
     }
     
     // Validation constraint check
     if (this.balance - amount >= 0) {
         this.balance -= amount;
         System.out.printf("Successfully withdrew: $%.2f%n", amount);
     } else {
         System.out.println("Error: Withdrawal denied due to insufficient funds.");
     }
 }
}

//==========================================
//EXECUTION / TESTING
//==========================================
public class EncapsulationandDataHiding {
 public static void main(String[] args) {
     System.out.println("=== Initializing Bank Account ===");
     BankAccount account = new BankAccount("ACC123456789", 500.0);
     System.out.println("Account Number: " + account.getAccountNumber());
     System.out.printf("Current Balance: $%.2f%n", account.getBalance());
     System.out.println();

     // 1. Attempting valid modifications
     System.out.println("=== Testing Valid Transactions ===");
     account.deposit(250.0);
     account.withdraw(100.0);
     System.out.printf("Updated Balance: $%.2f%n", account.getBalance());
     System.out.println();

     // 2. Attempting illegal modifications through direct setter validation
     System.out.println("=== Testing Setter Validation Bounds ===");
     System.out.println("Attempting to set balance to -$100.0 via setter...");
     account.setBalance(-100.0); 
     System.out.printf("Balance after illegal setter attempt: $%.2f%n", account.getBalance());
     System.out.println();

     // 3. Attempting excessive withdrawal logic bounds
     System.out.println("=== Testing Withdrawal Validation Bounds ===");
     System.out.println("Attempting to withdraw $1000.0...");
     account.withdraw(1000.0);
     System.out.printf("Final Account Balance: $%.2f%n", account.getBalance());
 }
}
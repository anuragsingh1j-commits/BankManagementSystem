import java.util.Scanner;
import model.Customer;
import service.CustomerService;
import service.DepositService;
import service.TransferService;
import service.WithdrawService;
import model.Account;
import model.SavingsAccount;
import model.CurrentAccount;
import service.AccountService;
import model.Transaction;
import service.TransactionService;
//import model.Transaction;
import java.util.List;
import util.InputValidator;
import util.LoggerUtil;

public class Main {

    private static final Scanner sc = new Scanner(System.in);
private static final CustomerService customerService = new CustomerService();
private static final AccountService accountService = new AccountService();

private static final DepositService depositService = new DepositService();
private static final WithdrawService withdrawService = new WithdrawService();
private static final TransferService transferService = new TransferService();
private static final TransactionService transactionService =
        new TransactionService();

      

//private static final AccountService accountService = new AccountService();
    public static void main(String[] args) {

        int choice;

        do {

            System.out.println("\n=================================================");
            System.out.println("          BANK MANAGEMENT SYSTEM");
            System.out.println("=================================================");
            System.out.println("1. Customer Management");
            System.out.println("2. Account Management");
            System.out.println("3. Deposit Money");
            System.out.println("4. Withdraw Money");
            System.out.println("5. Transfer Money");
            System.out.println("6. Transaction History");
            System.out.println("7. View All Customers");
            System.out.println("8. View All Accounts");
            System.out.println("9. Exit");
            System.out.println("=================================================");

            System.out.print("Enter your choice: ");

            while (!sc.hasNextInt()) {
                System.out.print("Please enter a valid number: ");
                sc.next();
            }

            choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {

                case 1:
                    customerMenu();
                    break;

                case 2:
                    accountMenu();
                    break;

                case 3:
    depositMoney();
    break;

     case 4:
    withdrawMoney();
    break;

case 5:
    transferMoney();
    break;

case 6:
    transactionHistory();
    break;

case 7:
    viewAllCustomers();
    break;

case 8:
    viewAllAccounts();
    break;

case 9:
   System.out.println("\nThank you for using Bank Management System.");
                    break;

                default:
                    System.out.println("\nInvalid Choice!");
            }

        } while (choice != 9);

        sc.close();
    }

    private static void customerMenu() {

    int choice;

    do {

        System.out.println("\n========== CUSTOMER MENU ==========");
        System.out.println("1. Add Customer");
        System.out.println("2. Search Customer");
        System.out.println("3. View All Customers");
        System.out.println("4. Delete Customer");
        System.out.println("5. Back");
        System.out.print("Enter choice: ");

        choice = sc.nextInt();
        sc.nextLine();

        switch (choice) {

            case 1:
                addCustomer();
                break;

            case 2:
                searchCustomer();
                break;

            case 3:
                viewAllCustomers();
                break;

            case 4:
                deleteCustomer();
                break;

            case 5:
                break;

            default:
                System.out.println("Invalid Choice!");
        }

    } while (choice != 5);
}

   private static void accountMenu() {

    int choice;

    do {

        System.out.println("\n========== ACCOUNT MENU ==========");
        System.out.println("1. Create Savings Account");
        System.out.println("2. Create Current Account");
        System.out.println("3. Search Account");
        System.out.println("4. View All Accounts");
        System.out.println("5. Check Balance");
        System.out.println("6. Delete Account");
        System.out.println("7. Back");

        while (!sc.hasNextInt()) {
            System.out.print("Please enter a valid number: ");
            sc.next();
        }

        choice = sc.nextInt();
        sc.nextLine();

  switch (choice) {

    case 1:
        createSavingsAccount();
        break;

    case 2:
        createCurrentAccount();
        break;

    case 3:
        searchAccount();
        break;

    case 4:
        viewAllAccounts();
        break;

    case 5:
        checkBalance();
        break;

    case 6:
        deleteAccount();
        break;

    case 7:
        break;

    default:
        System.out.println("Invalid Choice!");
}

    } while (choice != 5);
}


private static void addCustomer() {

    String name = InputValidator.readString(sc, "Enter Name: ");

String email = InputValidator.readEmail(sc, "Enter Email: ");

String phone = InputValidator.readPhone(sc, "Enter Phone: ");

    Customer customer = new Customer(0, name, phone, email,"");

    if (customerService.addCustomer(customer)) {
        System.out.println("\nCustomer Added Successfully!");
        LoggerUtil.log("Customer Added : " + name);
    } else {
        System.out.println("\nFailed to Add Customer!");
        LoggerUtil.log("Failed to Add Customer : " + name);
    }
}

private static void viewAllCustomers() {

   System.out.println("\n========== CUSTOMER LIST ==========");

    for (Customer customer : customerService.getAllCustomers()) {

       System.out.println("--------------------------------");
        System.out.println("ID    : " + customer.getCustomerId());
       System.out.println("Name  : " + customer.getFullName());
       System.out.println("Email : " + customer.getEmail());
       System.out.println("Phone : " + customer.getPhone());
  }
}

private static void deleteCustomer() {

    System.out.print("Enter Customer ID: ");
    int id = sc.nextInt();

    if (customerService.deleteCustomer(id)) {
        System.out.println("Customer Deleted Successfully!");
    } else {
        System.out.println("Customer Deletion Failed!");
    }
}
private static void searchCustomer() {

    System.out.print("Enter Customer ID: ");
    int id = sc.nextInt();
    sc.nextLine();

    Customer customer = customerService.getCustomerById(id);

    if (customer == null) {
        System.out.println("Customer Not Found!");
        return;
    }

    System.out.println("\n========== CUSTOMER DETAILS ==========");
    System.out.println("ID    : " + customer.getCustomerId());
    System.out.println("Name  : " + customer.getFullName());
    System.out.println("Email : " + customer.getEmail());
    System.out.println("Phone : " + customer.getPhone());
}
private static void createSavingsAccount() {

    System.out.print("Enter Customer ID: ");
    int customerId = sc.nextInt();

    System.out.print("Enter Initial Balance: ");
    double balance = sc.nextDouble();
    sc.nextLine();

    Account account = new SavingsAccount(
            0,
            customerId,
            balance
    );

    if (accountService.createAccount(account)) {
        System.out.println("\nSavings Account Created Successfully!");
    } else {
        System.out.println("\nFailed to Create Savings Account!");
    }
}
private static void viewAllAccounts() {

    System.out.println("\n========== ACCOUNT LIST ==========");

    for (Account account : accountService.getAllAccounts()) {

        System.out.println("----------------------------------");
        System.out.println("Account No : " + account.getAccountNumber());
        System.out.println("Customer ID: " + account.getCustomerId());
        System.out.println("Type       : " + account.getAccountType());
        System.out.println("Balance    : ₹" + account.getBalance());
    }
}
private static void deleteAccount() {

    System.out.print("Enter Account Number: ");
    int accountNumber = sc.nextInt();
    sc.nextLine();

    if (accountService.deleteAccount(accountNumber)) {
        System.out.println("Account Deleted Successfully!");
    } else {
        System.out.println("Account Deletion Failed!");
    }
}
private static void createCurrentAccount() {

    System.out.print("Enter Customer ID: ");
    int customerId = sc.nextInt();

    System.out.print("Enter Initial Balance: ");
    double balance = sc.nextDouble();
    sc.nextLine();

    Account account = new CurrentAccount(
            0,
            customerId,
            balance
    );

    if (accountService.createAccount(account)) {
        System.out.println("\nCurrent Account Created Successfully!");
    } else {
        System.out.println("\nFailed to Create Current Account!");
    }
}
private static void depositMoney() {

   int accountNumber =
        InputValidator.readInt(sc, "Enter Account Number: ");

double amount =
        InputValidator.readAmount(sc, "Enter Amount: ");

    if (depositService.deposit(accountNumber, amount)) {
        System.out.println("\nDeposit Successful!");
 LoggerUtil.log("Deposit ₹" + amount + " into Account " + accountNumber);

    } else {
        System.out.println("\nDeposit Failed!");
      LoggerUtil.log("Deposit Failed for Account " + accountNumber);   
    }
}
private static void withdrawMoney() {

    System.out.print("Enter Account Number: ");
    int accountNumber = sc.nextInt();

    System.out.print("Enter Amount: ");
    double amount = sc.nextDouble();
    sc.nextLine();

    if (withdrawService.withdraw(accountNumber, amount)) {
        System.out.println("\nWithdrawal Successful!");
    } else {
        System.out.println("\nWithdrawal Failed!");
    }
}

private static void transferMoney() {

    System.out.print("From Account: ");
    int fromAccount = sc.nextInt();

    System.out.print("To Account: ");
    int toAccount = sc.nextInt();

    System.out.print("Amount: ");
    double amount = sc.nextDouble();
    sc.nextLine();

    if (transferService.transfer(fromAccount, toAccount, amount)) {
        System.out.println("\nTransfer Successful!");
    } else {
        System.out.println("\nTransfer Failed!");
    }
}

private static void transactionHistory() {

    System.out.println("\n========== TRANSACTION HISTORY ==========");

    System.out.print("Enter Account Number: ");
    int accountNumber = sc.nextInt();
    sc.nextLine();

    List<Transaction> transactions =
            transactionService.getTransactions(accountNumber);

    if (transactions == null || transactions.isEmpty()) {
        System.out.println("\nNo Transactions Found!");
        return;
    }

    System.out.println("--------------------------------------------------------------");
    System.out.printf("%-8s %-18s %-12s %-20s%n",
            "ID", "TYPE", "AMOUNT", "DATE");
    System.out.println("--------------------------------------------------------------");

    for (Transaction transaction : transactions) {

        System.out.printf("%-8d %-18s ₹%-11.2f %-20s%n",
                transaction.getTransactionId(),
                transaction.getTransactionType(),
                transaction.getAmount(),
                transaction.getTransactionDate());
    }

    System.out.println("--------------------------------------------------------------");
}
private static void searchAccount() {

    int accountNumber = InputValidator.readInt(
            sc,
            "Enter Account Number: "
    );

    Account account = accountService.getAccount(accountNumber);

    if (account == null) {
        System.out.println("\nAccount Not Found!");
        return;
    }

    System.out.println("\n========== ACCOUNT DETAILS ==========");
    System.out.println("Account Number : " + account.getAccountNumber());
    System.out.println("Customer ID    : " + account.getCustomerId());
    System.out.println("Account Type   : " + account.getAccountType());
    System.out.println("Balance        : ₹" + account.getBalance());
}

private static void checkBalance() {

    int accountNumber = InputValidator.readInt(
            sc,
            "Enter Account Number: "
    );

    Account account = accountService.getAccount(accountNumber);

    if (account == null) {
        System.out.println("\nAccount Not Found!");
        return;
    }

    System.out.println("\nCurrent Balance : ₹" + account.getBalance());
}

}
package bank;

import java.sql.SQLException;
import java.util.Scanner;

import javax.security.auth.login.LoginException;

import bank.exceptions.AmountException;

public class Menu {
  private Scanner scanner;

  public static void main(String[] args) throws SQLException, AmountException, LoginException {
    System.out.println("Welcome to Globe Bank International");

    Menu menu = new Menu();
    menu.scanner = new Scanner(System.in);

    Customer customer = menu.authenticateUser();

    if (customer != null) {
      Account account = DataSource.getAccount(customer.getAccountId());
      menu.showMenu(customer, account);
    }

    menu.scanner.close();
  }

  private Customer authenticateUser() {
    System.out.println("Please enter your username: ");
    String username = scanner.next();

    System.out.println("Please enter your password: ");
    String password = scanner.next();

    Customer customer = null;

    try {
      customer = Authenticator.login(username, password);
    } catch (LoginException e) {
      System.out.println("There was an error: " + e.getMessage());
    }
    return customer;

  }

  private void showMenu(Customer customer, Account account) throws SQLException, AmountException, LoginException {
    int selection = 0;

    while (selection != 5 && customer.isAuthenticated()) {
      System.out.println("============================================");
      System.out.println("Please select one of the following option: ");
      System.out.println("1: Deposit");
      System.out.println("2: Withdraw");
      System.out.println("3: Send Money");
      System.out.println("4: Check Balance");
      System.out.println("5: Exit");
      System.out.println("============================================");

      selection = scanner.nextInt();
      double amount = 0;
      int account_ID = 0;
      switch (selection) {
        case 1:
          System.out.println("How much would you like to deposit");
          amount = scanner.nextDouble();
          try {
            account.deposit(amount);
          } catch (AmountException e) {
            System.out.println(e.getMessage());
            System.out.print("Please try again.");
          }
          break;

        case 2:
          System.out.println("How much would you like to withdraw");
          amount = scanner.nextDouble();
          try {
            account.withdraw(amount);
          } catch (AmountException e) {
            System.out.println(e.getMessage());
            System.out.println("Please try again.");
          }
          break;

        case 3:
          System.out.println("How much would you like to send?");
          amount = scanner.nextDouble();
          System.out.println("Account ID of the person whom you will send money: ");
          account_ID = scanner.nextInt();

          try {
            account.sendMoney(amount, account_ID);
          } catch (AmountException e) {
            System.out.println(e.getMessage());
            System.out.println("Please try again.");
          }
          break;
        case 4:
          System.out.println("Current Balance: " + account.getBalance());
          break;

        case 5:
          Authenticator.logout(customer);
          System.out.println("Thanks for banking at Globe Bank International");
          break;

        default:
          System.out.println("Invalid option. Pleas try again");
          break;

      }
    }
  }
}

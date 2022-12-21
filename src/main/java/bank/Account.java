package bank;

import java.sql.SQLException;

import javax.security.auth.login.LoginException;
import javax.xml.crypto.Data;

import bank.exceptions.AmountException;

public class Account {
  private int id;
  private String type;
  private double balance;

  public Account(int id, String type, double balance) {
    setId(id);
    setType(type);
    setBalance(balance);
  }

  public int getId() {
    return this.id;
  }

  public void setId(int id) {
    this.id = id;
  }

  public String getType() {
    return this.type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public double getBalance() {
    return this.balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public void deposit(double amount) throws AmountException {
    if (amount < 1) {
      throw new AmountException("The minimum deposit is 1.00");
    } else {
      double newBalance = balance + amount;
      setBalance(newBalance);
      DataSource.updateAccountBalance(id, newBalance);
    }
  }

  public void withdraw(double amount) throws AmountException {
    if (amount < 0) {
      throw new AmountException("The withdrawal amount must be greater than 0.");
    } else if (amount > getBalance()) {
      throw new AmountException("You do not have sufficient funds for this withdrawal");
    } else {
      double newBalance = balance - amount;
      setBalance(newBalance);
      DataSource.updateAccountBalance(id, newBalance);
    }
  }

  public void sendMoney(double amount, int account_ID) throws AmountException, LoginException {
    int newAccountID = 0;

    try {
      newAccountID = searchAccount(account_ID);
    } catch (SQLException e) {
      e.printStackTrace();
    }
    do {
      if (amount < 1) {
        throw new AmountException("The amount must be greater than 0.");
      } else if (amount > getBalance()) {
        throw new AmountException("You do not have sufficient funds for this transaction");
      } else {
        double newBalance = balance - amount;
        setBalance(newBalance);
        DataSource.updateAccountBalance(id, newBalance);
        Account account = DataSource.searchAccount(newAccountID);
        int destinationAccountBalance = (int) account.getBalance();
        double newOtherAccountBalance = destinationAccountBalance + amount;
        DataSource.updateAccountBalance(newAccountID, newOtherAccountBalance);
        System.out.println("Fund Transfer Successful!");
      }

    } while (newAccountID != account_ID);

  }

  public int searchAccount(int account_ID) throws SQLException {

    try {
        DataSource.searchAccount(account_ID);
    } catch (NullPointerException e) {
        System.out.println("Please try again. ");
    }

    return account_ID;
  }
}

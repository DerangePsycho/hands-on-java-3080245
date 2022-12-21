package Employee;

import java.util.ArrayList;
import java.util.Scanner;

import bank.account;

public class main {
  public static void main(String[] args) {
    String name;
    String securityNumber;
    int birthdayMonth;
    int birthdayWeek;
    int empType;
    int hourlyPay;
    int hoursWorkedInAWeek;
    double payCheck = 0;

    ArrayList<Hourly> employees = new ArrayList<Hourly>();
    Hourly hourly = new Hourly();
    Scanner stdIn = new Scanner(System.in);

    System.out.println("Number of employees: ");
    int employeeNum = stdIn.nextInt();

    for (int i = 0; i < employeeNum; i++) {
      System.out.println("type Hourly(1), Salaried(2), Salaried plus Commission(3)");
      System.out.println("Enter 1, 2 or 3 ==> ");
      empType = stdIn.nextInt();

      switch (empType) {
        case 1:
          employees.add(new Hourly());
          System.out.println("Name ==> ");
          name = stdIn.next();

          System.out.println("Social Security Number ==> ");
          securityNumber = stdIn.next();

          System.out.println("Birthday month ==>");
          birthdayMonth = stdIn.nextInt();

          System.out.println("Birthday Bonus Week ==> ");
          birthdayWeek = stdIn.nextInt();

          System.out.println("Hourly Pay ==> ");
          hourlyPay = stdIn.nextInt();

          System.out.println("Hours worked this week ==> ");
          hoursWorkedInAWeek = stdIn.nextInt();

          hourly.load(hourlyPay, hoursWorkedInAWeek);
          payCheck = hourly.getEarnings();
          if (payCheck > 1000) {
            payCheck = 1000;
          }
          employees.get(i).load(name, securityNumber, birthdayMonth, birthdayWeek, payCheck);

          break;

        case 2:
          employees.add(new Hourly());
          System.out.println("Name ==> ");
          name = stdIn.next();
          System.out.println("Social Security Number ==> ");
          securityNumber = stdIn.next();
          System.out.println("Birthday month ==>");
          birthdayMonth = stdIn.nextInt();
          System.out.println("Birthday Bonus Week ==> ");
          birthdayWeek = stdIn.nextInt();
          // employees.get(i).load(name, securityNumber, birthdayMonth, birthdayWeek,
          // payCheck);
          break;

        case 3:
          employees.add(new Hourly());
          System.out.println("Name ==> ");
          name = stdIn.next();
          System.out.println("Social Security Number ==> ");
          securityNumber = stdIn.next();
          System.out.println("Birthday month ==>");
          birthdayMonth = stdIn.nextInt();
          System.out.println("Birthday Bonus Week ==> ");
          birthdayWeek = stdIn.nextInt();
          // employees.get(i).load(name, securityNumber, birthdayMonth, birthdayWeek,
          // payCheck);
          break;

        default:
          System.out.println("You have entered an invalid choice!");
          break;
      }

    }

    for (Employee employee : employees) {
      employee.toStringEmp(payCheck);
      Hourly hourly1 = new Hourly();
      int bonus = hourly1.getBonus();
      System.out.println(bonus);
    }

  }
}

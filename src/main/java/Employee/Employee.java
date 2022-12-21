
package Employee;

import java.util.Calendar;

public abstract class Employee {
  private String name;
  private String securityNumber;
  private int birthdayMonth;
  private int birthdayWeek;

  public int getBirthdayMonth() {
    return this.birthdayMonth;
  }

  public void setBirthdayMonth(int birthdayMonth) {
    this.birthdayMonth = birthdayMonth;
  }

  public int getBirthdayWeek() {
    return this.birthdayWeek;
  }

  public void setBirthdayWeek(int birthdayWeek) {
    this.birthdayWeek = birthdayWeek;
  }

  abstract public double getEarnings();

  public void load(String name, String securityNumber, int birthdayMonth, int birthdayWeek, double payCheck) {
    this.name = name;
    this.securityNumber = securityNumber;
    setBirthdayMonth(birthdayMonth);
    setBirthdayWeek(birthdayWeek);
    payCheck = payCheck + 0;
  }

  public void toStringEmp(Double payCheck) {
    System.out.println("employee: " + this.name);
    System.out.println("Social Security Number: " + this.securityNumber);
    String str3 = String.format("$%.2f", payCheck);
    System.out.println("paycheck: " + str3);
  }

  public int getBonus() {
    Calendar calendar = Calendar.getInstance();
    int bonus = 0;
    System.out.println(getBirthdayMonth());
    System.out.println(getBirthdayWeek());
    System.out.println((calendar.get(Calendar.MONTH) + 1));
    System.out.println(calendar.get(Calendar.WEEK_OF_MONTH));
    // if ((calendar.get(Calendar.MONTH) + 1) == this.birthdayMonth
    // && (calendar.get(Calendar.WEEK_OF_MONTH)) == this.birthdayWeek) {
    // bonus = 100;
    // }

    return bonus;
  }
}

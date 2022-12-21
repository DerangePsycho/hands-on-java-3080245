package Employee;

public class Hourly extends Employee {
  private int hourlyPay;
  private int hoursWorkedInAWeek;

  public void load(int hourlyPay, int hoursWorkedInAWeek) {
    this.hourlyPay = hourlyPay;
    this.hoursWorkedInAWeek = hoursWorkedInAWeek;
  }

  public double getEarnings() {
    double totalPay = 0;
    if (hoursWorkedInAWeek > 40) {
      int overtimehours = hoursWorkedInAWeek - 40;
      double overtimePay = overtimehours * (this.hourlyPay * 1.5);
      int normalPay = hourlyPay * (hoursWorkedInAWeek - overtimehours);
     
      totalPay = overtimePay + normalPay;
    } else {
      totalPay = hourlyPay * hoursWorkedInAWeek;
    }
    return totalPay;
  }
}

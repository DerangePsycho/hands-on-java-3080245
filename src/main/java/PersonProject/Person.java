package PersonProject;

public class Person {
  static int numOfPeople;
  private String firstName;
  private String lastName;

  public Person() {
    setFirstName("John");
    setLastName("Doe");
  }

  public Person(String firstName, String lastName) {
    setFirstName(firstName);
    setLastName(lastName);
  }

  public String getFirstName() {
    return this.firstName;
  }

  public void setFirstName(String firstName) {
    this.firstName = firstName;
  }

  public String getLastName() {
    return this.lastName;
  }

  public void setLastName(String lastName) {
    this.lastName = lastName;
  }

  public String setFirst(String firstName) {
    setFirstName(firstName);
    return firstName;
  }

  public String setLast(String lastName) {
    setLastName(lastName);
    return lastName;
  }

  public String printFullName() {
    String fullName = (getFirstName() + " " + getLastName());
    System.out.println(fullName);
    if (fullName.equals("John Doe"))
      Person.numOfPeople = numOfPeople + 0;
    else
      Person.numOfPeople++;

    return fullName;
  }

  public static int getNumOfPeople() {
    return Person.numOfPeople;
  }
}

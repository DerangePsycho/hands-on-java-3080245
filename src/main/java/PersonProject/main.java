package PersonProject;

public class main {
  public static void main(String[] args) {
    Person person1 = new Person();
    person1.printFullName();
    Person person2 = new Person("Matt", "Thebo");
    person2.printFullName();
    person1.setFirst("Paul");
    person1.setLast("John");
    person1.printFullName();
    System.out.println("Total number of people = " + Person.getNumOfPeople());
  }

}

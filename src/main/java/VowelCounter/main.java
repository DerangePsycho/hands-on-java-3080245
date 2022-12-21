package VowelCounter;

import java.util.Scanner;

public class main {
  public static void main(String[] args) {
    VowelCounter vowelCounter = new VowelCounter();
    String sampleText = "a";
    while (!sampleText.equals("")) {
      Scanner stdIn = new Scanner(System.in);
      System.out.println("Enter a line of characters(press enter by itself to quit): ");
      sampleText = stdIn.nextLine();
      vowelCounter.processLine(sampleText);
    }
    vowelCounter.printSummary();
  }
}

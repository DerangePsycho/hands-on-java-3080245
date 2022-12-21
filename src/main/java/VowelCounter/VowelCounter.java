package VowelCounter;

public class VowelCounter {
  private int[][] vowelCountArray = new int[5][2];
  private String[][] vowels = new String[][] {
      { "A", "a" },
      { "E", "e" },
      { "I", "i" },
      { "O", "o" },
      { "U", "u" },

  };

  public void processLine(String lineOfCharacters) {
    for (int i = 0; i < lineOfCharacters.length(); i++) {
      // System.out.print(lineOfCharacters.charAt(i));
      String characterHolder = String.valueOf(lineOfCharacters.charAt(i));

      for (int j = 0; j <= vowels.length - 1; j++) {
        for (int k = 0; k <= 1; k++) {
          if (characterHolder.equals(vowels[j][k])) {
            vowelCountArray[j][k] = vowelCountArray[j][k] + 1;
          }
        }
      }

    }
    System.out.println("\n");
  }

  public void printSummary() {
    int totalA = vowelCountArray[0][0] + vowelCountArray[0][1];
    int totalE = vowelCountArray[1][0] + vowelCountArray[1][1];
    int totalI = vowelCountArray[2][0] + vowelCountArray[2][1];
    int totalO = vowelCountArray[3][0] + vowelCountArray[3][1];
    int totalU = vowelCountArray[4][0] + vowelCountArray[4][1];
    System.out.println(
        "A: " + vowelCountArray[0][1] + " lowercase," + vowelCountArray[0][0] + " uppercase," + totalA + "total");
    System.out.println(
        "E: " + vowelCountArray[1][1] + " lowercase," + vowelCountArray[1][0] + " uppercase," + totalE + "total");
    System.out.println(
        "I: " + vowelCountArray[2][1] + " lowercase," + vowelCountArray[2][0] + " uppercase," + totalI + "total");
    System.out.println(
        "O: " + vowelCountArray[3][1] + " lowercase," + vowelCountArray[3][0] + " uppercase," + totalO + "total");
    System.out.println(
        "U: " + vowelCountArray[4][1] + " lowercase," + vowelCountArray[4][0] + " uppercase," + totalU + "total");
  };

}

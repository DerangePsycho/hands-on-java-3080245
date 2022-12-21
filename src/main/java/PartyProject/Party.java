package PartyProject;

public class Party {
  private final int maxGuestNum;
  private int actualGuestNum = 0;
  private String[] listOfGuest = {};
  private String hostName;

  public Party(int maxGuestNum, String hostName) {
    this.hostName = hostName;
    this.maxGuestNum = maxGuestNum;
  }

  public int getMaxGuestNum() {
    return maxGuestNum;
  }

  public int getActualGuestNum() {
    return actualGuestNum;
  }

  public void setActualGuestNum(int actualGuestNum) {
    this.actualGuestNum = actualGuestNum;
  }

  public String getHostName() {
    return hostName;
  }

  public void setHostName(String hostName) {
    this.hostName = hostName;
  }

  public void addGuest(String guestName) {
    if (listOfGuest.length <= 0) {
      listOfGuest = new String[maxGuestNum];
    }

    if (actualGuestNum != maxGuestNum) {
      if (isOnList(guestName) == true) {
        System.out.println(guestName + " is already on the guest list.");
        actualGuestNum--;
      } else
        listOfGuest[actualGuestNum] = guestName;

      actualGuestNum++;
    } else
      System.out.println(guestName + " cannot come to the party. The guest list is full");

  }

  public boolean isOnList(String guestname) {

    int i = 0;
    while (i < getActualGuestNum()) {
      if (actualGuestNum <= 0) {
        return false;
      } else {

        if (listOfGuest[i] == guestname) {
          i = actualGuestNum;
          return true;
        } else {
          i++;
          return false;
        }
      }
    }

  }

  public void printParty() {
    System.out.println("Guest list for " + hostName + "'s" + " party");
    for (int i = 0; i <= maxGuestNum - 1; i++)
      System.out.println("\u2022" + listOfGuest[i]);
  }

}

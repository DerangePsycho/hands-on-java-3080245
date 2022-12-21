package IPProject;


public class IpAddress {
  private String dottedDecimal;
  private int firstOctet;
  private int secondOctet;
  private int thirdOctet;
  private int fourthOctet;

  public IpAddress(String dottedDecimal) {
    setDottedDecimal(dottedDecimal);
  }

  public String getDottedDecimal() {
    return this.dottedDecimal;
  }

  public void setDottedDecimal(String dottedDecimal) {
    this.dottedDecimal = dottedDecimal;
  }

  public int getFirstOctet() {
    return this.firstOctet;
  }

  public void setFirstOctet(int firstOctet) {
    this.firstOctet = firstOctet;
  }

  public int getSecondOctet() {
    return this.secondOctet;
  }

  public void setSecondOctet(int secondOctet) {
    this.secondOctet = secondOctet;
  }

  public int getThirdOctet() {
    return this.thirdOctet;
  }

  public void setThirdOctet(int thirdOctet) {
    this.thirdOctet = thirdOctet;
  }

  public int getFourthOctet() {
    return this.fourthOctet;
  }

  public void setFourthOctet(int fourthOctet) {
    this.fourthOctet = fourthOctet;
  }

  public int getOctet(int position) {
    int octet[];
    octet = new int[4];

    String dotteDecimal = getDottedDecimal();
    String[] arrOfStr = dotteDecimal.split("[.]");

    for (int i = 0; i <= 4 - 1; i++)
      octet[i] = Integer.parseInt(arrOfStr[i]);

    switch (position) {
      case 1:
        setFirstOctet(octet[0]);
        break;

      case 2:
        setSecondOctet(octet[1]);
        break;

      case 3:
        setSecondOctet(octet[2]);
        break;

      case 4:
        setSecondOctet(octet[3]);
        break;

    }
    return octet[position - 1];

  }

}

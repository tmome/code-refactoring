package code.refactoring._07_divergent_change._26_extract_class;

public class TelephoneNumber {

  private String areaCode;
  private String officeNumber;


  public TelephoneNumber(String officeAreaCode, String officeNumber) {
    this.areaCode = officeAreaCode;
    this.officeNumber = officeNumber;
  }

  public String getAreaCode() {
    return areaCode;
  }

  public void setAreaCode(String areaCode) {
    this.areaCode = areaCode;
  }

  public String officeNumber() {
    return officeNumber;
  }
}
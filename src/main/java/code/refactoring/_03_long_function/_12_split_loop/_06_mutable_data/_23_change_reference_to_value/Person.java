package code.refactoring._03_long_function._12_split_loop._06_mutable_data._23_change_reference_to_value;

public class Person {

    private TelephoneNumber officeTelephoneNumber;

    public String officeAreaCode() {
        return this.officeTelephoneNumber.areaCode();
    }

    public void officeAreaCode(String areaCode) {
        this.officeTelephoneNumber.areaCode(areaCode);
    }

    public String officeNumber() {
        return this.officeTelephoneNumber.number();
    }

    public void officeNumber(String number) {
        this.officeTelephoneNumber.number(number);
    }

}

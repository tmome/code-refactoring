package code.refactoring._06_mutable_data._19_separate_query_from_modifier;

import java.util.List;
import org.apache.commons.lang3.StringUtils;

public class Criminal {

    public void alertForMiscreant(List<Person> people) {
        if(!findMiscreant(people).isBlank()){
            setOffAlarms();
        }
    }

    public String findMiscreant(List<Person> people) {
        for (Person p : people) {
            if (p.getName().equals("Don")) {
                return "Don";
            }

            if (p.getName().equals("John")) {
                return "John";
            }
        }

        return StringUtils.EMPTY;
    }

    private void setOffAlarms() {
        System.out.println("set off alarm");
    }
}

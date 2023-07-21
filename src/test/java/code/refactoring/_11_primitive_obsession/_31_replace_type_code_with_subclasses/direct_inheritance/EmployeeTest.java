package code.refactoring._11_primitive_obsession._31_replace_type_code_with_subclasses.direct_inheritance;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class EmployeeTest {

    @Test
    void employeeType() {
        assertEquals("engineer", new Employee("keesun", "engineer").getType());
        assertEquals("manager", new Employee("keesun", "manager").getType());
        assertThrows(IllegalArgumentException.class, () -> new Employee("keesun", "wrong type"));
    }

}
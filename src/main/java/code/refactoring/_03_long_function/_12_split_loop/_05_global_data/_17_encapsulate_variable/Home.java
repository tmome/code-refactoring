package code.refactoring._03_long_function._12_split_loop._05_global_data._17_encapsulate_variable;

public class Home {

    public static void main(String[] args) {
        System.out.println(Thermostats.targetTemperature);
        Thermostats.targetTemperature = 68;
        Thermostats.readInFahrenheit = false;
    }
}

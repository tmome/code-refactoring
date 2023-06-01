package code.refactoring._05_global_data._17_encapsulate_variable;

public class Thermostats {

    //TODO : 전역 데이터의 경우 한번 메모리 설정이 끝나면 불변 즉 참조만 할 수 있는 상태를 유지해야한다.
    // ex : public static final

    private static Integer targetTemperature = 70;

    private static Boolean heating = true;

    private static Boolean cooling = false;

    private static Boolean readInFahrenheit = true;

    public static Integer getTargetTemperature() {
        return targetTemperature;
    }

    public static void setTargetTemperature(Integer targetTemperature) {
        Thermostats.targetTemperature = targetTemperature;
    }

    public static Boolean getHeating() {
        return heating;
    }

    public static void setHeating(Boolean heating) {
        //TODO : validation logic ......
        Thermostats.heating = heating;
        //TODO : notify exception handler .. error
    }

    public static Boolean getCooling() {
        return cooling;
    }

    public static void setCooling(Boolean cooling) {
        Thermostats.cooling = cooling;
    }

    public static Boolean getReadInFahrenheit() {
        return readInFahrenheit;
    }

    public static void setReadInFahrenheit(Boolean readInFahrenheit) {
        Thermostats.readInFahrenheit = readInFahrenheit;
    }
}

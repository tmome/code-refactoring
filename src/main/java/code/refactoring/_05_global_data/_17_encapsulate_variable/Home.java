package code.refactoring._05_global_data._17_encapsulate_variable;

public class Home {

    //TODO : 변수 캡슐화 하기. 불변 데이터의 경우에는 이 리펙토링을 적용할 필요는 없다.

    public static void main(String[] args) {
        System.out.println(Thermostats.getTargetTemperature());
        Thermostats.setTargetTemperature(68);
        Thermostats.setReadInFahrenheit(false);
    }
}

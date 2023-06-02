package code.refactoring._06_mutable_data._21_replace_derived_variable_with_query;

import java.util.ArrayList;
import java.util.List;

public class ProductionPlan {
    //TODO : 계산식 함수를 만들어 불필요한 함수 제거

    private List<Double> adjustments = new ArrayList<>();

    public void applyAdjustment(double adjustment) {
        this.adjustments.add(adjustment);
//        this.production += adjustment;
    }

    public double getProduction() {
        return this.adjustments.stream().reduce((double) 0, Double::sum);
    }

}

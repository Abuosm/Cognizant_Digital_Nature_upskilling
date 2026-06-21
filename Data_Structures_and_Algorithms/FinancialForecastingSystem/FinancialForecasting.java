package Data_Structures_and_Algorithms.FinancialForecastingSystem;

public class FinancialForecasting {

    public static double predictFutureValue(
            double currentValue,
            double growthRate,
            int years) {

        // Base Case
        if (years == 0) {
            return currentValue;
        }

        // Recursive Call
        return predictFutureValue(
                currentValue * (1 + growthRate),
                growthRate,
                years - 1
        );
    }

    public static void main(String[] args) {

        double initialValue = 10000;
        double growthRate = 0.10;

        int years = 3;

        double future =
                predictFutureValue(
                        initialValue,
                        growthRate,
                        years
                );

        System.out.println(
                "Predicted Future Value: ₹" + future
        );
    }
}

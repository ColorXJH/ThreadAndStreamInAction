package modules.thread.part1.chapter2;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-04 9:41
 */
public class SimpleCalculatorStrategy implements CalculatorStrategy{
    private final static double SALARY_RATE=0.1;
    private final static double BONUS_RATE=0.15;
    @Override
    public double calculate(double salary, double bonus) {
        return salary*SALARY_RATE+bonus*BONUS_RATE;
    }
}

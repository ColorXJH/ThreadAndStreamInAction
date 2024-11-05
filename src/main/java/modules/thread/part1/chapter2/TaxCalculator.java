package modules.thread.part1.chapter2;

/**
 * @author ColorXJH
 * @version 1.0
 * @description: 税率计算
 * @date 2024-11-01 17:29
 */
public class TaxCalculator {
    private final double salary;
    private final double bonus;

    private CalculatorStrategy calculatorStrategy;
    public TaxCalculator(double salary, double bonus) {
        this.salary = salary;
        this.bonus = bonus;
    }

    protected double calcTax(){
        return calculatorStrategy.calculate(salary,bonus);
    }

    public double calculator(){
        return this.calcTax();
    }

    public double getSalary() {
        return salary;
    }

    public double getBonus() {
        return bonus;
    }

    public void setCalculatorStrategy(CalculatorStrategy calculatorStrategy) {
        this.calculatorStrategy = calculatorStrategy;
    }
}

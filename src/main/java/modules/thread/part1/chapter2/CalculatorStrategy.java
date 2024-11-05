package modules.thread.part1.chapter2;

/**
 * @author ColorXJH
 * @version 1.0
 * @description: 策略接口
 * @date 2024-11-04 9:38
 */
@FunctionalInterface
public interface CalculatorStrategy {
    public double calculate(double salary,double bonus);
}

package modules.thread.part1.chapter2;

/**
 * @author ColorXJH
 * @version 1.0
 * @description:
 * @date 2024-11-04 9:29
 */
public class TaxCalculatorMain {
    public static void main(String[] args) {
        /*TaxCalculator c1=new TaxCalculator(10000d,2000d){
            @Override
            protected double calcTax() {
                return getSalary()*0.1+getBonus()*0.15;
            }
        };
        double tax=c1.calculator();
        System.out.println("TaxCalculatorMain.main:"+tax);*/
        TaxCalculator calculator=new TaxCalculator(10000d,2000d);
        //SimpleCalculatorStrategy simpleCalculatorStrategy=new SimpleCalculatorStrategy();
        //calculator.setCalculatorStrategy(simpleCalculatorStrategy);
        calculator.setCalculatorStrategy((s,b)->{
            return s*0.1+b*0.15;
        });
        System.out.println("TaxCalculatorMain.main:"+calculator.calculator());
    }
}

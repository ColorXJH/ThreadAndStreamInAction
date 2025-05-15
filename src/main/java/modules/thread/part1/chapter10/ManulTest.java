package modules.thread.part1.chapter10;/**
 * @ClassName: ManulTest
 * @Package: modules.thread.part1.chapter10
 * @Description:
 * @Datetime: 2025-01-09 17:28
 * @author: ColorXJH
 */

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

/**
 * @description:
 * @author ColorXJH
 * @date 2025-01-09 17:28
 * @version 1.0
 */
public class ManulTest {
    static {int x=5; int y=6;}
    static  void say(){

    }
    public static void main(String[] args) {
        int a = 9;
        int b = a++;
        int c = ++a;
        int d = c--;
        int e = --d;
        System.out.println(a);
        System.out.println(b);
        System.out.println(c);
        System.out.println(d);
        System.out.println(e);
        List<?> list=new ArrayList<Integer>();
        PriorityQueue<Person>pq=new PriorityQueue<Person>(Comparator.comparing((X)->{
            return X.getAge();
        }));
    }
}

class TRESS extends ManulTest {
    static void say(){}

}

class General<T>{
    public  <T> T method1(){
        return null;
    }
}

class Person {
    String name;
    int age;

    Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }
}


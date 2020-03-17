package test;


import org.omg.CORBA.INTERNAL;
import org.testng.annotations.Test;

public class TestClass {
    public static void main(String[] args) {
    String A="ABCDFG";
    int b = A.indexOf("C");
        System.out.println(b);
    String C = A.substring(b);
        System.out.println(C);

    }

}

package test;


import org.testng.annotations.Test;

public class TestClass {
    @Test
    public void run(){
        System.out.printf("tpp");
    }
    public int add(int a,int b){
        int i = a + b;
        return i;

    }
    public String addString(String a,String b){
        return a+" "+b;

    }
    public int[] getArray(){
        int[] a ={1,2,3,4,5,6,7};
        return a;
    }
}

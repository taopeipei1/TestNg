package imooctest;

import org.testng.annotations.Test;

public class Test1 {

    @Test(groups = "t")
    public void setUp(){
        int i = 10/0;
        System.out.println("test1");
    }
}

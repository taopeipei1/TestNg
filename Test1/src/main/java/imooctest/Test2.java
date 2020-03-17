package imooctest;

import org.testng.annotations.Test;

public class Test2 {


    @Test(dependsOnGroups = "t")
    public void setUp(){
        System.out.println("test2");
    }
    @Test
    public void split(){

        String a = "h e l l o w ";
        String[] STR = a.split(" ");
        for (String b:STR
             ) {
            System.out.println(b);

        }
    }
}

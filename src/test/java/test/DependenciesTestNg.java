package test;

import org.testng.Assert;
import org.testng.annotations.Ignore;
import org.testng.annotations.Test;

public class DependenciesTestNg {

    @Test
    public void login(){
        System.out.println("logging in...");
    }

    @Test(dependsOnMethods = "login")
    public void makePurchase(){
        System.out.println("making the purchase");
    }
//    @Ignore

    @Test(dependsOnMethods = "makePurchase")
    public void homePage(){
        System.out.println("homePage tested");
    }

}

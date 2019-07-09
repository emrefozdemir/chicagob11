package test;

import org.testng.Assert;
import org.testng.annotations.*;
import static org.testng.Assert.*;
public class TestNGFirstTest {

    @Test
    public void firstTest(){
        System.out.println("This is the first test running");
        Assert.assertEquals("a","a", "First test a-b is failed");
    }

    @Test
    public void secondTest(){
        System.out.println("This is the second test running");
    }

    @BeforeClass
    public void setUp(){
        System.out.println("Before class running");
    }

    @AfterClass
    public void tearDown(){
        System.out.println("After running ...");
    }
    @BeforeMethod
    public void beforeMethod(){
        System.out.println("Before running ...");
    }
    @AfterMethod
    public void afterMethod(){
        System.out.println("Before method is running");
    }
    @Test
    public void titleTest(){
        String actualTitle = "Google - Apples";
        String exceptedTitle = "Apples";
       assertTrue(actualTitle.contains(exceptedTitle),"Actual title does not contain excepted value.");
    }

//    @BeforeClass
//    public void onPurposeFail(){
//        Assert.fail("This is on purpose fail");
//    }


}

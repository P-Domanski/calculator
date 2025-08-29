package com.example.calculator;

import org.testng.Assert;
import org.testng.annotations.*;

public class CalculatorLogicCoreTests {

    @DataProvider(name = "provider")
    public Object[][] dataProviderMethod() {
        return new Object[][] {
                {1.0, 1.0}, {2.0, 5.0}, {-2.0, -5.2}, {0.0, 112.0}
        };
    }

    @BeforeClass
    public void beforeClass() {
        System.out.println("==== Start of Calculator Logic Core Tests ====");
    }

    @AfterClass
    public void afterClass() {
        System.out.println("==== End of Calculator Logic Core Tests ====");
    }

    @BeforeMethod
    public void beforeMethod() {
        System.out.println("-- Start of method --");
    }

    @AfterMethod
    public void afterMethod() {
        System.out.println("-- End of method --");
    }

    @Test(priority = 1, groups = {"Function Test", "Addition"})
    public void testAddition1() {
        System.out.println("Testing addition... (1)");
        System.out.println(2.0 +" + "+ 20.0);
        Assert.assertEquals(CalculatorLogicCore.addition(2.0, 20.0), 22.0);
    }

    @Test(groups = {"Function Test", "Addition"}, dependsOnMethods = {"testAddition1"})
    public void testAddition2() {
        System.out.println("Testing addition... (2)");
        System.out.println(0.0 +" + "+ 0.0);
        Assert.assertEquals(CalculatorLogicCore.addition(0.0,0.0), 0.0);
    }

    @Test(groups = {"Function Test", "Addition"}, dependsOnMethods = {"testAddition2"})
    public void testAddition3() {
        System.out.println("Testing addition... (3)");
        System.out.println(-29.0 +" + "+ 8.0);
        Assert.assertEquals(CalculatorLogicCore.addition(-29.0,8.0), -21.0);
    }

    @Test(priority = 2, groups = {"Function Test", "Substraction"})
    public void testSubstraction() {
        System.out.println("Testing substraction... (1)");
        System.out.println(2.0 +" - "+ 20.0);
        Assert.assertEquals(CalculatorLogicCore.substraction(2.0, 20.0), -18.0);
    }

    @Test(groups = {"Function Test", "Substraction"}, dependsOnMethods = {"testSubstraction"})
    public void testSubstraction2() {
        System.out.println("Testing substraction... (2)");
        System.out.println(0.0 +" - "+ 0.0);
        Assert.assertEquals(CalculatorLogicCore.substraction(0.0,0.0), 0.0);
    }

    @Test(groups = {"Function Test", "Substraction"}, dependsOnMethods = {"testSubstraction2"})
    public void testSubstraction3() {
        System.out.println("Testing substraction... (3)");
        System.out.println(-29.0 +" - "+ 8.0);
        Assert.assertEquals(CalculatorLogicCore.substraction(-29.0,8.0), -37.0);
    }

    @Test(priority = 3, groups = {"Function Test", "Multiplication"})
    public void testMultiplication() {
        System.out.println("Testing multiplication... (1)");
        System.out.println(2.0 +" * "+ 20.0);
        Assert.assertEquals(CalculatorLogicCore.multiplication(2.0, 20.0), 40.0);
    }

    @Test(groups = {"Function Test", "Multiplication"}, dependsOnMethods = {"testMultiplication"})
    public void testMultiplication2() {
        System.out.println("Testing multiplication... (2)");
        System.out.println(0.0 +" * "+ 0.0);
        Assert.assertEquals(CalculatorLogicCore.multiplication(0.0,0.0), 0.0);
    }

    @Test(groups = {"Function Test", "Multiplication"}, dependsOnMethods = {"testMultiplication2"})
    public void testMultiplication3() {
        System.out.println("Testing multiplication... (3)");
        System.out.println(-29.0 +" * "+ 8.0);
        Assert.assertEquals(CalculatorLogicCore.multiplication(-29.0,8.0), -232.0);
    }

    @Test(priority = 4, groups = {"Function Test", "Division"})
    public void testDivision() {
        System.out.println("Testing division... (1)");
        System.out.println(2.0 +" / "+ 20.0);
        Assert.assertEquals(CalculatorLogicCore.division(2.0, 20.0), 0.1);
    }

    @Test(groups = {"Function Test", "Division"}, dependsOnMethods = {"testDivision"}, alwaysRun = true)
    public void testDivision2() {
        System.out.println("Testing division... (2)");
        System.out.println(0.0 +" / "+ 0.0);
        try {
            // Code that should throw an exception
            CalculatorLogicCore.division(0.0, 0.0);
            Assert.fail("Expected exception was not thrown");
        } catch (IllegalArgumentException e) {
            // Test passes if the exception is caught
            Assert.assertEquals(e.getMessage(), "Division by 0");
        }
    }

    @Test(groups = {"Function Test", "Division"}, dependsOnMethods = {"testDivision2"})
    public void testDivision3() {
        System.out.println("Testing division... (3)");
        System.out.println(-29.0 +" / "+ 8.0);
        Assert.assertEquals(CalculatorLogicCore.division(-29.0,8.0), -3.625);
    }

    @Test(groups = {"Addition"}, dataProvider = "provider")
    public void testAddition4(Double[] pair) {
        System.out.println("Testing addition... (4)");
        System.out.println(pair[0]+" + "+ pair[1]);
        Assert.assertEquals(CalculatorLogicCore.addition(pair[0], pair[1]), (pair[0] + pair[1]));
    }
}

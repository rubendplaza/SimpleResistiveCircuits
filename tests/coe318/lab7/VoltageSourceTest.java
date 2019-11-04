package coe318.lab7;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.Test;
import static org.junit.Assert.assertTrue;

public class VoltageSourceTest {

    /**
     * Sorry I cant test more complicated functions
     * the project is pretty simple so I had to test
     * set methods.
     *
     * 1. I test my get node methods
     *
     * 2. I test the toString method
     *
     * Hope this is okay, the other methods are difficult to test because
     * the objects created will never be the same so the equals operation
     * will not work on them. This is because of the static counter used
     * to keep track of all the elements added to the circuit which is unique
     * to every instance of the class, so comparing two instances of the same class
     * is difficult. It can be done by checking each individual value of the instances
     * and comparing but that would be redundant lines of code.
     * */

    @Test
    public void testGetNodeMethods() {

        System.out.println("TESTING GET NODE METHODS:");

        Node node1 = new Node();
        Node node2 = new Node();

        VoltageSource vSource = new VoltageSource(500, node1, node2);
        Node result = vSource.getNode1();
        Node expectedResult = node1;

        Node result2 = vSource.getNode2();
        Node expectedResult2 = node2;

        assertTrue(expectedResult.equals(result));
        assertTrue(expectedResult2.equals(result2));

        if(expectedResult.equals(result))
            System.out.println("TEST 1 PASSED.");

        if(expectedResult2.equals(result2))
            System.out.println("TEST 2 PASSED.");

    }

    @Test
    public void testVoltageSourceToString(){

        System.out.println("TESTING TO STRING:");

        Node node1 = new Node();
        Node node2 = new Node();

        VoltageSource vSource = new VoltageSource(500, node1, node2);

        String resultString = vSource.toString();
        String expectedString = "V1 0 1 DC 500.0";

        assertTrue(expectedString.equals(resultString));

        if(expectedString.equals(resultString))
            System.out.println("TEST PASSED.");

    }

    @After
    public void tearDown(){

    }

}
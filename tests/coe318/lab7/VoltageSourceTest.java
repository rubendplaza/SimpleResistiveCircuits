package coe318.lab7;

import org.junit.After;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * test class for voltage source
 */
public class VoltageSourceTest {

    @Test

    /**
     * junit test method for get node method within voltage source
     */
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
            System.out.println("TEST NODE 1 PASSED.");

        if(expectedResult2.equals(result2))
            System.out.println("TEST NODE 2 PASSED.");

    }

    @Test

    /**
     * junit test method for voltage source to string method
     */
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

    /**
     * tear down method
     */
    public void tearDown(){

    }

}
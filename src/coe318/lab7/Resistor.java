package coe318.lab7;

/**
 * resistor class used for creating resistor
 * circuit element which is then added to the
 * elements list in the circuit class
 */
public class Resistor {

    static private int resistorCounter = 1;
    private int resistorID;
    private double resistance;
    private Node node1;
    private Node node2;
    private Circuit circuit;

    /**
     * Constructor for resistor:
     * updates the static variable for the amount of resistors
     * also accesses the instance of the circuit
     * if one is not created it will create one
     * @param resistance
     * @param node1
     * @param node2
     */
    public Resistor(double resistance, Node node1, Node node2){

        circuit = Circuit.getInstance();

        if(resistance <= 0)
            throw new IllegalArgumentException("You cannot have a negative or zero resistance, zero resistance is just a short circuit not a resistor.");

        this.resistance = resistance;
        this.node1 = node1;
        this.node2 = node2;
        resistorID = resistorCounter;
        resistorCounter++;
        circuit.add(this);
    }

    /**
     * used for getting nodes that the resistor is connected to
     * returns them in an array if size 2
     * @return nodeArray
     */
    public Node[] getNodes(){

        Node[] nodeArray = new Node[2];

        nodeArray[0] = node1;
        nodeArray[1] = node2;

        return nodeArray;

    }

    /**
     * gets the resistance value
     * @return resistance
     */
    public double getResistance(){
        return resistance;
    }

    @Override

    /**
     * for printing out the resistor to the std output
     * with the desired format
     * @return String
     */
    public String toString() {
        return "R" + resistorID + " " + node1 + " " + node2 + " " + resistance;
    }

}
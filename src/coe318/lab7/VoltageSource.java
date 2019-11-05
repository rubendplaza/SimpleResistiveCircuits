package coe318.lab7;

/**
 * voltage source class for representing
 * the voltage element in the circuit
 */
public class VoltageSource {

    static private int voltageCounter = 1;
    private int voltageID;
    private double voltageValue;
    private Node node1;
    private Node node2;
    private Circuit circuit;

    /**
     * this is constructor for voltage source
     * @param voltageValue voltage value
     * @param node1 first node connection
     * @param node2 second node connection
     */
    public VoltageSource(double voltageValue, Node node1, Node node2){

        circuit = Circuit.getInstance();

        if(node1 == null || node2 == null)
            throw new IllegalArgumentException("One of your nodes is null.");

        else{
            this.voltageValue = voltageValue;
            this.node1 = node1;
            this.node2 = node2;
            voltageID = voltageCounter;
            voltageCounter++;
            circuit.add(this);
        }
    }

    /**
     * getter for voltage value
     * @return voltage value
     */
    public double getVoltageValue(){
        return voltageValue;
    }

    /**
     * setter for voltage value
     * @param voltageValue voltage value
     */
    public void setVoltageValue(double voltageValue){
        this.voltageValue = voltageValue;
    }

    /**
     * getter for the first node connection
     * @return node1
     */
    public Node getNode1(){
        return node1;
    }

    /**
     * getter for the second node connection
     * @return node2
     */
    public Node getNode2(){
        return node2;
    }

    /**
     * getter for node ID
     * @param node node object
     * @return node ID
     */
    public int getNodeID(Node node){
        return node.getNodeNum();
    }

    /**
     * reverse nodes method for when the voltage source
     * value is given as negative so it can reverse the node
     * connections and set the voltage value to positive
     */
    public void reverseNodes(){

        Node temp = node2;
        node2 = node1;
        node1 = temp;

        setVoltageValue(voltageValue*-1);

    }

    @Override

    /**
     * for printing out the voltage source to the std output
     * with the desired format
     * @return String
     */
    public String toString(){

        return "V" + voltageID + " " + node1 + " " + node2 + " DC " + voltageValue;

    }


}

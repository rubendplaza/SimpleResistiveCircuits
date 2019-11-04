package coe318.lab7;

public class VoltageSource {

    static private int voltageCounter = 1;
    private int voltageID;
    private double voltageValue;
    private Node node1;
    private Node node2;
    private Circuit circuit;

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

    public double getVoltageValue(){
        return voltageValue;
    }

    public void setVoltageValue(double voltageValue){
        this.voltageValue = voltageValue;
    }

    public Node getNode1(){
        return node1;
    }
    public Node getNode2(){
        return node2;
    }

    public int getNodeID(Node node){
        return node.getNodeNum();
    }

    public void reverseNodes(){

        Node temp = node2;
        node2 = node1;
        node1 = temp;

        setVoltageValue(voltageValue*-1);

    }

    @Override

    public String toString(){

        return "V" + voltageID + " " + node1 + " " + node2 + " DC " + voltageValue;

    }


}

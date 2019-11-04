package coe318.lab7;

import java.util.ArrayList;

/**
 * circuit class used for holding all the
 * elements and nodes of a circuit
 * and displaying the circuit to the console
 */
public class Circuit {

    private static Circuit instance = null;
    private ArrayList<Object> elements;
    private ArrayList<Node> nodeList;

    /**
     * constructor for circuit
     * sets up arraylists for both the circuit elements
     * and its nodes
     */
    private Circuit(){

        elements = new ArrayList<>();
        nodeList = new ArrayList<Node>();

    }

    /**
     * creates an single instance of the circuit class
     * if one does not already exist then it creates one
     * @return circuit instance
     */
    public static Circuit getInstance(){

        if(instance == null) {
            instance = new Circuit();
        }
        return instance;
    }

    /**
     * method to add a resistor to the circuit elements array list
     * throws exceptions based on the value of the resistance or if one
     * of its nodes are not instantiated
     * @param r
     */
    public void add(Resistor r){

        if(r.getResistance() < 0){
            throw new IllegalArgumentException("Resistance cannot be negative.");
        }
        else if(r.getNodes()[0] == null || r.getNodes()[1] == null){
            throw new IllegalArgumentException("One of your nodes is null. They cannot be.");
        }
        else{
            elements.add(r);
        }
    }

    /**
     * method to add a voltage source to the circuit elements array list
     * throws exception if one of its nodes are not instantiated
     * calls the reverseNodes method if the voltage value is negative
     * @param v
     */
    public void add(VoltageSource v){

        if(v.getVoltageValue() < 0){
            v.reverseNodes();
            elements.add(v);
        }
        else{
            elements.add(v);
        }
    }

    /**
     * possibly the most important method in the whole project
     * this method is called when the user inputs two node integers
     * this method is needed because the user may not enter nodes in sequential order
     * this method instantiates nodes up to the highest node integer that they input
     * so that when they want to add an element say from node 1 to node 9 then this method
     * instantiates nodes up to 9 so that following elements can utilize nodes up to 9
     * @param node1 integer value
     * @param node2 integer value
     */
    public void addNodes(int node1, int node2) {

        int greater = Math.max(node1, node2);

        if (greater > nodeList.size() - 1) {
            for (int i = nodeList.size(); i <= greater; i++) {
                Node nodeToAdd = new Node();
                nodeList.add(nodeToAdd);
            }
        }

    }

    /**
     * returns nodeList
     * nodelist is used to keep track of all the nodes that
     * the circuit contains
     * @return nodeList
     */
    public ArrayList<Node> getNodeList(){
        return nodeList;
    }

    /**
     * returns elementslist
     * used to keep track of the elements in the circuit
     * @return elementsList
     */
    public ArrayList getElementsList(){
        return elements;
    }

    @Override

    /**
     * for printing out the circuit to the std output
     * with the desired format
     * @return String
     */
    public String toString(){

        String returnString = "";

        for(int x = 0; x < elements.size(); x++){

            if(elements.get(x) instanceof VoltageSource){
                if(x == elements.size()-1)
                    returnString += elements.get(x); // to not have a new line character on the last output of the circuit
                else
                    returnString += elements.get(x) + "\n";
            }
            else if(elements.get(x) instanceof Resistor){
                if(x == elements.size()-1)
                    returnString += elements.get(x); // to not have a new line character on the last output of the circuit
                else
                returnString += elements.get(x) + "\n";
            }
            else{
                return "ERROR";
            }

        }

        return returnString;

    }

}
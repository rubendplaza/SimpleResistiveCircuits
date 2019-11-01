package coe318.lab7;

import java.util.ArrayList;

public class Circuit {

    private static Circuit instance = null;
    private ArrayList<Object> elements;
    private ArrayList<Node> nodeList;


    private Circuit(){

        elements = new ArrayList<>();
        nodeList = new ArrayList<Node>();

    }

    /**
     * Creating the single instance of the circuit
     * if no instance exists then it creates one
     * */
    public static Circuit getInstance(){

        if(instance == null) {
            instance = new Circuit();
        }
        return instance;
    }

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
     * Very important method
     * basically if they input a set of nodes that does not go in a sequential order
     * like r 0 1 xx
     *      v 4 7 xx
     * then we need nodes all the way up to seven
     * so this method will instantiate all the needed nodes
     * based on if the greatest node number is not already in
     * a list of instantiated nodes.
     * */

    public void addNodes(int node1, int node2) {

        int greater = Math.max(node1, node2);

        if (greater > nodeList.size() - 1) {
            for (int i = nodeList.size(); i <= greater; i++) {
                Node nodeToAdd = new Node();
                nodeList.add(nodeToAdd);
            }
        }

    }

    public ArrayList<Node> getNodeList(){
        return nodeList;
    }

    @Override

    public String toString(){

        String returnString = "";

        for(int x = 0; x < elements.size(); x++){

            if(elements.get(x) instanceof VoltageSource){
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
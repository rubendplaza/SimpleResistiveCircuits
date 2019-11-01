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

    public String toString(){//todo implement the output they want

        String returnString = "";

        for(int x = 0; x < elements.size(); x++){

            if(elements.get(x) instanceof VoltageSource){
                returnString += elements.get(x) + "\n";
            }
            else if(elements.get(x) instanceof Resistor){
                returnString += elements.get(x) + "\n";
            }
            else{
                return "ERROR";
            }

        }

        return returnString;

    }

}
package coe318.lab7;

/**
 * node class used for keeping track
 * of where circuit elements are connected
 * in the circuit
 */
public class Node {

    private int nodeNum;
    static private int nodeCounter = 0;

    /**
     * constructor for node class
     * instantiates the node ID and updates
     * the static integer nodeCounter for keeping
     * track of the nodes being created
     */
    public Node(){

        nodeNum = nodeCounter;
        nodeCounter++;

    }

    @Override

    /**
     * for printing out the node ID to the std output
     * with the desired format
     * @return String
     */
    public String toString(){

        return String.valueOf(this.nodeNum);

    }

    /**
     * for getting the node ID
     * @return nodeNum
     */
    public int getNodeNum(){
        return nodeNum;
    }

}


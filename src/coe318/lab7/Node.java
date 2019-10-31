package coe318.lab7;

public class Node {

    private int nodeNum;
    static private int nodeCounter = 0;

    public Node(){

        nodeNum = nodeCounter;
        nodeCounter++;

    }

    @Override

    public String toString(){

        return String.valueOf(this.nodeNum);

    }

    public int getNodeNum(){
        return nodeNum;
    }

    public static void main(String[] args) {

        Node node1 = new Node();
        Node node2 = new Node();

        System.out.println(node1);
        System.out.println(node2);

    }

}


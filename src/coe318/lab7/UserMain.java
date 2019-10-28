package coe318.lab7;

import java.util.Scanner;

public class UserMain {

    public static void main(String[] args) {

        int numOfNodes;
        int numOfResistors;
        double valueOfResistor;
        int node1;
        int node2;

        Scanner input = new Scanner(System.in);

        Circuit circuit = Circuit.getInstance();

        Node[] nodeArray;

        Resistor[] resistorArray;

        System.out.println("How many nodes do you have? ");
        numOfNodes = input.nextInt();

        if(numOfNodes < 1){
            throw new IllegalArgumentException("You cannot have less than 1 node.");
        }

        System.out.println("\nInitializing nodes...");

        nodeArray = new Node[numOfNodes];
        for(int x = 0; x < numOfNodes; x++){
            nodeArray[x] = new Node();
        }

        System.out.println("\nDone initializing nodes.");

        System.out.println("\nHow many resistors do you have? ");
        numOfResistors = input.nextInt();

        if(numOfResistors < 1){
            throw new IllegalArgumentException("You cannot have less than 1 resistor.");
        }

        System.out.println("\nInitializing resistors...");

        resistorArray = new Resistor[numOfResistors];
        for (int x = 0; x < numOfResistors; x++){

            System.out.println("\nWhat is the value of R" + (x+1) + ":");
            valueOfResistor = input.nextDouble();

            if(valueOfResistor <= 0){
                throw new IllegalArgumentException("Resistor value cannot be negative");
            }

            System.out.println("What is the number of the first node its connected to?");
            node1 = input.nextInt();

            if(node1 < 0 || node1 > numOfNodes-1){
                throw new IllegalArgumentException("Node cannot be less than zero or you have entered a node that does not exist");
            }

            System.out.println("What is the number of the second node its connected to?");
            node2 = input.nextInt();

            if(node2 < 0 || node2 > numOfNodes-1){
                throw new IllegalArgumentException("Node cannot be less than zero or you have entered a node that does not exist");
            }
            resistorArray[x] = new Resistor(valueOfResistor, nodeArray[node1], nodeArray[node2]); // finally initializing the resistor after given resistance and its two connected nodes
        }

        System.out.println("\nPRINTING CIRCUIT RESISTORS AND NODE CONNECTIONS:\nFORMAT: (RESISTOR ID___NODE 1___NODE 2___RESISTOR VALUE)\n\n" + circuit); // prints out all the resistors in the resistor arraylist
        input.close();

    }

}
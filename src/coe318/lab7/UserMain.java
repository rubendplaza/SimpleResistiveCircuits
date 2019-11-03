package coe318.lab7;

import java.util.ArrayList;
import java.util.Scanner;

public class UserMain {

    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);

        String newLine; //for taking user input by line
        String[] splitLine; // for splitting the data of the user input line
        double doubleValue; // for holding the double representation of the the user input value
        int node1; // for holding the integer of the node number, need to do this in order to check how many nodes need to be instantiated when user input a number.
        int node2; // same as above
        char c;

        Circuit circuit = Circuit.getInstance();

        System.out.println("ENTER YOUR CIRCUIT ELEMENTS:");
        newLine = input.nextLine();

        while (!(newLine.equals("end"))) { //sentinel controlled while loop

            c = newLine.charAt(0); // to check if we are getting a resistor or voltage else error

            if (newLine.equals("spice")) { // spice means print out circuit elements thus far
                if(circuit.getNodeList().isEmpty()){
                    System.out.println("YOU HAVEN'T ENTERED A CIRCUIT ELEMENT YET.");
                }
                else{
                    System.out.println(circuit);
                }
            }

            else if(c == 'v' || c == 'r'){
                splitLine = newLine.split("\\s+");

                if(splitLine.length < 4){
                    throw new IllegalArgumentException("You made a mistake in the input. Should be ('v'/'r')_naturalNumber_naturalNumber_value");
                }

                node1 = Integer.parseInt(splitLine[1]);
                node2 = Integer.parseInt(splitLine[2]);
                doubleValue = Double.parseDouble(splitLine[3]);

                if (node1 < 0 || node2 < 0) { // exception handling
                    throw new IllegalArgumentException("Cannot have negative node numbers, try again.");
                }

                circuit.addNodes(node1, node2); // instantiating nodes if needed

                if (splitLine[0].equals("r")) { // construct a resistor
                    new Resistor(doubleValue, circuit.getNodeList().get(node1), circuit.getNodeList().get(node2));
                } else if (splitLine[0].equals("v")) { // construct a voltage source
                    new VoltageSource(doubleValue, circuit.getNodeList().get(node1), circuit.getNodeList().get(node2));
                }
            }
            else{
                throw new IllegalArgumentException("You did not indicate 'v' or 'r' properly.");
            }
            newLine = input.nextLine(); // gathers new user input line
        }//end of input
            System.out.println("ALL DONE.");


        }
    }







//        int numOfNodes;
//        int numOfResistors;
//        double valueOfResistor;
//        int node1;
//        int node2;
//
//        Scanner input = new Scanner(System.in);
//
//        Circuit circuit = Circuit.getInstance();
//
//        Node[] nodeArray;
//
//        Resistor[] resistorArray;
//
//        System.out.println("How many nodes do you have? ");
//        numOfNodes = input.nextInt();
//
//        if(numOfNodes < 1){
//            throw new IllegalArgumentException("You cannot have less than 1 node.");
//        }
//
//        System.out.println("\nInitializing nodes...");
//
//        nodeArray = new Node[numOfNodes];
//        for(int x = 0; x < numOfNodes; x++){
//            nodeArray[x] = new Node();
//        }
//
//        System.out.println("\nDone initializing nodes.");
//
//        System.out.println("\nHow many resistors do you have? ");
//        numOfResistors = input.nextInt();
//
//        if(numOfResistors < 1){
//            throw new IllegalArgumentException("You cannot have less than 1 resistor.");
//        }
//
//        System.out.println("\nInitializing resistors...");
//
//        resistorArray = new Resistor[numOfResistors];
//        for (int x = 0; x < numOfResistors; x++){
//
//            System.out.println("\nWhat is the value of R" + (x+1) + ":");
//            valueOfResistor = input.nextDouble();
//
//            if(valueOfResistor <= 0){
//                throw new IllegalArgumentException("Resistor value cannot be negative");
//            }
//
//            System.out.println("What is the number of the first node its connected to?");
//            node1 = input.nextInt();
//
//            if(node1 < 0 || node1 > numOfNodes-1){
//                throw new IllegalArgumentException("Node cannot be less than zero or you have entered a node that does not exist");
//            }
//
//            System.out.println("What is the number of the second node its connected to?");
//            node2 = input.nextInt();
//
//            if(node2 < 0 || node2 > numOfNodes-1){
//                throw new IllegalArgumentException("Node cannot be less than zero or you have entered a node that does not exist");
//            }
//            resistorArray[x] = new Resistor(valueOfResistor, nodeArray[node1], nodeArray[node2]); // finally initializing the resistor after given resistance and its two connected nodes
//        }
//
//        System.out.println("\nPRINTING CIRCUIT RESISTORS AND NODE CONNECTIONS:\nFORMAT: (RESISTOR ID___NODE 1___NODE 2___RESISTOR VALUE)\n\n" + circuit); // prints out all the resistors in the resistor arraylist
//        input.close();

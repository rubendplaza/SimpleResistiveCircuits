package coe318.lab7;

import java.util.Scanner;

/**
 * main class for holding main method
 */
public class UserMain {

    /**
     * main method for taking in user input
     * @param args
     */
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
            input.close();

        }
    }

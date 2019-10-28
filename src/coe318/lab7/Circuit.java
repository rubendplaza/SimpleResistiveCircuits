package coe318.lab7;

import java.util.ArrayList;
import java.util.Scanner;

public class Circuit {

    private static Circuit instance = null;
    private ArrayList elements;


    private Circuit(){

        elements = new ArrayList<Resistor>();


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

    public boolean add(Resistor r){

        if(r.getResistance() < 0){
            throw new IllegalArgumentException("Resistance cannot be negative.");
        }
        else if(r.getNodes()[0] == null || r.getNodes()[1] == null){
            throw new IllegalArgumentException("One of your nodes is null. They cannot be.");
        }
        else{
            elements.add(r);
            return true;
        }
    }

    public boolean add(VoltageSource v){

        if(v.getVoltageValue() < 0){
            v.reverseNodes();
            elements.add(v);
            return true;
        }
        else{
            elements.add(v);
            return true;
        }

    }

    @Override

    public String toString(){

        String returnString = "";

        for(int x = 0; x < elements.size(); x++){

            returnString += elements.get(x) + "\n";

        }

        return returnString;

    }

}
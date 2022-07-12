package work;

import java.util.ArrayList;


import java.util.Random;

public class Car {
    static  ArrayList<Integer> usedInts = new ArrayList<>();
    private ArrayList<String> pickedOptions;
    public int VIN;

    /**
     Function that returns the selected options a car was equipped with.
     * @return ArrayList of strings
     */
    public ArrayList<String> getOptions(){
        return pickedOptions;
    }

    /**
     * Function that sets the brand of the car
     * @param name
     */
    public void setManufacturer(String name) {
    }

    /**
     * Function that sets the options picked by the user
     * @param optionsList
     */
    public void setOptions(ArrayList<String> optionsList) {
        pickedOptions = optionsList;
    }

    /**\
     * Function that generates an unique number and then assigns that number to a certain vehicle
     */
    public void setVIN(){
        int leftLimit = 100 ;
        int rightLimit = 1000 ;
        int randomInt = leftLimit + (int) (new Random().nextFloat() * (rightLimit - leftLimit));
        if(usedInts.contains(randomInt)){
            if(usedInts.size() == 100){
                System.out.println("All VINs have already been assigned.");
            }else {
                setVIN();
            }
        }else {
            usedInts.add(randomInt);
            VIN = randomInt;
        }
    }

    /**
     * Function that returns the VIN number of a specified car
     * @return VIN
     */
    public int getVIN(){
        return VIN;
    }
}


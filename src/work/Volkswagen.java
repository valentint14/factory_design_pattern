package work;

import java.util.ArrayList;

public class Volkswagen extends Car{
    /**
     *  Default constructor for the Volkswagen class
     */
    public Volkswagen(){
        setManufacturer("Volskwagen");
    }

    /**
     * Custom constructor for the Volkswagen class
     * @param optionList List of options selected by the user
     */
    public Volkswagen(ArrayList<String> optionList){
        setManufacturer("Vw");
        setVIN();
        setOptions(optionList);
    }

}


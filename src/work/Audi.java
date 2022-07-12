package work;

import java.util.ArrayList;


public class Audi extends Car{

    /**
     * Default constructor for the Audi class
     */
    public Audi(){
        setManufacturer("Audi");
        setOptions(null);
    }

    /**
     * Custom constructor for the Audi class
     * @param optionList List of options picked by the user.
     */
    public Audi(ArrayList<String> optionList){
        setManufacturer("Audi");
        setVIN();
        setOptions(optionList);

    }


}

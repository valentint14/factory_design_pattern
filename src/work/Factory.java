package work;

import java.util.ArrayList;

public class Factory {
    /**
     * This functions return a new Car object with the specified manufacturer and options
     * @param manufacturer Name of vehicle manufacturer
     * @param options ArrayList of options selected by the user
     * @return An Car object with the specified manufacturer and options.
     */
    public Car makeAuto(String manufacturer, ArrayList<String> options) {
        if (manufacturer.equals("Audi")) {
            return new Audi(options);
        } else if (manufacturer.equals("Volskwagen")) {
            return new Volkswagen(options);
        } else {
            System.out.println("Invalid Manufacturer");
            return null;
        }
    }
}


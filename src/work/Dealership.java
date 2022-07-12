package work;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Dealership {

    static ArrayList<String> options = new ArrayList<>();
    static ArrayList<ArrayList<String>> salesList = new ArrayList<>();
    static String carName = "audi";
    static ImageIcon imageSelectedWheel = new ImageIcon();
    static ImageIcon imageselectedColor = new ImageIcon();
    static JLabel configColorAudi = new JLabel();
    static JLabel configWheelAudi = new JLabel();
    static JLabel configColorVW= new JLabel();
    static JLabel configWheelVW = new JLabel();

    static String wheelOptionAudi = "17";
    static String colorlOptionAudi = "blue";
    static String pathColorBlueAudi = ".//Resources//AudiParts//audi_blue.png";
    static String pathColorWhiteAudi = ".//Resources//AudiParts//audi_white.png";
    static String pathColorRedAudi = ".//Resources//AudiParts//audi_red.png";
    static String pathColorGrayAudi = ".//Resources//AudiParts//audi_gray.png";
    static String pathWheel17Audi = ".//Resources//AudiParts//audi17.png";
    static String pathWheel18Audi = ".//Resources//AudiParts//audi18.png";
    static String pathWheel19Audi = ".//Resources//AudiParts//audi19.png";

    static String wheelOptionVw = "16";
    static String colorlOptionVw = "blue";
    static String pathColorBlueVw = ".//Resources//VWParts//vw_blue.png";
    static String pathColorWhiteVw = ".//Resources//VWParts//vw_white.png";
    static String pathColorRedVw = ".//Resources//VWParts//vw_red.png";
    static String pathColorPurpleVw = ".//Resources//VWParts//vw_purple.png";
    static String pathWheel16Vw = ".//Resources//VWParts//vw_16.png";
    static String pathWheel17Vw = ".//Resources//VWParts//vw_17.png";
   

    public static void main(String[] args) {

        Factory factory = new Factory();

        JFrame window = new JFrame();
        window.setBounds(0, 0, 1600, 900);

        ImageIcon white = new ImageIcon(".//Resources//Color//white.png");
        ImageIcon blue = new ImageIcon(".//Resources//Color//blue.png");
        ImageIcon gray = new ImageIcon(".//Resources//Color//gray.png");
        ImageIcon purple = new ImageIcon(".//Resources//Color//purple.png");
        ImageIcon red = new ImageIcon(".//Resources//Color//red.png");

        ArrayList<ImageIcon> colorPalleteAudi = new ArrayList<>();
        ArrayList<ImageIcon> colorPalleteVw = new ArrayList<>();

        colorPalleteAudi.add(blue);
        colorPalleteAudi.add(gray);
        colorPalleteAudi.add(red);
        colorPalleteAudi.add(white);

        colorPalleteVw.add(blue);
        colorPalleteVw.add(purple);
        colorPalleteVw.add(red);
        colorPalleteVw.add(white);

        ImageIcon audiRim17 = new ImageIcon(".//Resources//AudiParts//17rim.png");
        ImageIcon audiRim18 = new ImageIcon(".//Resources//AudiParts//18rim.png");
        ImageIcon audiRim19 = new ImageIcon(".//Resources//AudiParts//19rim.png");

        ArrayList<ImageIcon> audiRim = new ArrayList<>();

        audiRim.add(audiRim17);
        audiRim.add(audiRim18);
        audiRim.add(audiRim19);

        ImageIcon vwRim16 = new ImageIcon(".//Resources//VWParts//16rim.png");
        ImageIcon vwRim17 = new ImageIcon(".//Resources//VWParts//17rim.png");

        ArrayList<ImageIcon> vwRim = new ArrayList<>();

        vwRim.add(vwRim16);
        vwRim.add(vwRim17);

        ImageIcon vwlogo = new ImageIcon(".//Resources//VWParts//vw logo.png");
        ImageIcon audilogo = new ImageIcon(".//Resources//AudiParts//audi logo.png");
        ArrayList<ImageIcon> logos = new ArrayList<>();

        logos.add(audilogo);
        logos.add(vwlogo);

        JPanel haudi = new JPanel();
        haudi.setBounds(0, 0, 1600, 900);

        JPanel volscvagan = new JPanel();
        volscvagan.setBounds(0, 0, 1600, 900);

        JPanel middlePanel = new JPanel ();
        middlePanel.setBounds(20, 650, 750, 150);
        JTextArea display = new JTextArea (1,58);
        display.setEditable ( false );
        display.setText("ORDER HISTORY");
        JScrollPane orderHistory = new JScrollPane ( display );
        orderHistory.getViewport().setPreferredSize(new Dimension(710, 150));
        orderHistory.setVerticalScrollBarPolicy ( ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS );

        middlePanel.add(orderHistory);
        window.add(middlePanel);
      
        JButton run = new JButton("Order");
        run.setBounds(850, 695, 250, 50);
        run.addActionListener(e -> {

            if (carName.equals("audi")) {
                options.clear();
                options.add(wheelOptionAudi);
                options.add(colorlOptionAudi);

                Car audi = factory.makeAuto("Audi", options);
                
                ArrayList<String> order = new ArrayList<>();
                order.add(("" + audi.getVIN()));
                order.add(audi.getOptions().get(0));
                order.add(audi.getOptions().get(1));
                order.add(carName);
                salesList.add(order);

                display.setText(display.getText() + "\n" + "The order have been placed! Car name: Audi | Color: " + options.get(1) + " | RIMS: " + options.get(0) + " inch | VIN: " + audi.getVIN());

            } else if (carName.equals("vw")) {

                options.clear();
                options.add(wheelOptionVw);
                options.add(colorlOptionVw);

                Car vw = factory.makeAuto("Volskwagen", options);

                ArrayList<String> order = new ArrayList<>();
                order.add(("" + vw.getVIN()));
                order.add(vw.getOptions().get(0));
                order.add(vw.getOptions().get(1));
                order.add(carName);
                salesList.add(order);

                display.setText(display.getText() + "\n" + "The order have been placed! Car name: Volkswagen | Color: " + options.get(1) + " | RIMS: " + options.get(0) + " inch | VIN: " + vw.getVIN());
            }
        });
        window.add(run);

        JTextField orderVIN = new JTextField();
        orderVIN.setBounds(1150, 695, 80, 50);
        orderVIN.setHorizontalAlignment(SwingConstants.CENTER);
        window.add(orderVIN);

        JTextField vinTooltip = new JTextField();
        vinTooltip.setBounds(1150, 675, 80, 20);
        vinTooltip.setText("Insert VIN no.");
        vinTooltip.setHorizontalAlignment(SwingConstants.CENTER);
        vinTooltip.setEditable(false);
        vinTooltip.setEnabled(false);
        vinTooltip.setDisabledTextColor(Color.black);
        window.add(vinTooltip);

        JButton displayOrder = new JButton("Display Order");
        displayOrder.setBounds(1230, 695, 250, 50);
        window.add(displayOrder);
        displayOrder.addActionListener(e -> {
            JFrame orderShowcase = new JFrame();
            String VIN = orderVIN.getText();

            for (ArrayList<String> i : salesList) {

                if (i.get(0).equals(VIN)) {
                    String selectedCarColor = String.valueOf(i.get(2));
                    String selectedCarWheel = String.valueOf(i.get(1));


                    if(i.get(3).equals("audi")) {

                        switch (selectedCarWheel) {
                            case "17":
                                imageSelectedWheel = new ImageIcon(pathWheel17Audi);
                                break;
                            case "18":
                                imageSelectedWheel = new ImageIcon(pathWheel18Audi);
                                break;
                            case "19":
                                imageSelectedWheel = new ImageIcon(pathWheel19Audi);
                                break;
                        }

                        switch (selectedCarColor) {
                            case "blue":
                                imageselectedColor = new ImageIcon(pathColorBlueAudi);
                                break;
                            case "gray":
                                imageselectedColor = new ImageIcon(pathColorGrayAudi);
                                break;
                            case "red":
                                imageselectedColor = new ImageIcon(pathColorRedAudi);
                                break;
                            case "white":
                                imageselectedColor = new ImageIcon(pathColorWhiteAudi);
                                break;
                        }
                    }else if (i.get(3).equals("vw")){
                        switch (selectedCarWheel) {
                            case "16":
                                imageSelectedWheel = new ImageIcon(pathWheel16Vw);
                                break;
                            case "17":
                                imageSelectedWheel = new ImageIcon(pathWheel17Vw);
                                break;
                        }

                        switch (selectedCarColor) {
                            case "blue":
                                imageselectedColor = new ImageIcon(pathColorBlueVw);
                                break;
                            case "purple":
                                imageselectedColor = new ImageIcon(pathColorPurpleVw);
                                break;
                            case "red":
                                imageselectedColor = new ImageIcon(pathColorRedVw);
                                break;
                            case "white":
                                imageselectedColor = new ImageIcon(pathColorWhiteVw);
                                break;
                        }
                    }

                    JLabel selectedWheelImage = new JLabel(imageSelectedWheel);
                    selectedWheelImage.setBounds(150, 95, 584, 250);
                    orderShowcase.add(selectedWheelImage, 0);

                    JLabel selectedColorImage = new JLabel(imageselectedColor);
                    selectedColorImage.setBounds(100, 100, 584, 250);
                    orderShowcase.add(selectedColorImage, 1);

                    options.clear();
                    orderShowcase.setBounds(0, 0, 900, 480);
                    orderShowcase.setVisible(true);
                    orderShowcase.setResizable(false);
                    orderShowcase.setLayout(null);

                }
            }
        });

        for (int i = 0; i < 2; i++) {
            JButton manufacturer = new JButton("", logos.get(i));
            int finalI = i;
            manufacturer.addActionListener(e -> {
                carName = "";
                switch (finalI) {
                    case 0:
                        haudi.setVisible(true);
                        volscvagan.setVisible(false);
                        carName = "audi";
                        break;
                    case 1:
                        haudi.setVisible(false);
                        volscvagan.setVisible(true);
                        carName = "vw";
                        break;

                }
            });
            manufacturer.setBounds(20 + i * 375, 50, 375, 150);
            manufacturer.setBackground(Color.red);
            window.add(manufacturer, 0);

        }


        configColorAudi.setBounds(900, 250, 584, 250);
        configColorAudi.setIcon(new ImageIcon(pathColorBlueAudi));
        haudi.add(configColorAudi, 0);
        for (int i = 0; i < 4; i++) {
            JButton color = new JButton("", colorPalleteAudi.get(i));
            int finalI = i;
            color.addActionListener(e -> {
                switch (finalI) {
                    case 0:
                        configColorAudi.setIcon(new ImageIcon(pathColorBlueAudi));
                        colorlOptionAudi = "blue";
                        break;
                    case 1:
                        configColorAudi.setIcon(new ImageIcon(pathColorGrayAudi));
                        colorlOptionAudi = "gray";
                        break;
                    case 2:
                        configColorAudi.setIcon(new ImageIcon(pathColorRedAudi));
                        colorlOptionAudi = "red";
                        break;
                    case 3:
                        configColorAudi.setIcon(new ImageIcon(pathColorWhiteAudi));
                        colorlOptionAudi = "white";
                        break;
                }
            });
            color.setBounds(20 + i * 150, 250, 150, 150);
            haudi.add(color, 0);
        }

        configWheelAudi.setBounds(900, 250, 584, 250);
        configWheelAudi.setIcon(new ImageIcon(pathWheel17Audi));
        haudi.add(configWheelAudi, 0);
        for (int i = 0; i < 3; i++) {
            JButton wheel = new JButton("", audiRim.get(i));
            int finalI = i;
            wheel.addActionListener(e -> {
                wheelOptionAudi = "";
                switch (finalI) {
                    case 0:
                        configWheelAudi.setIcon(new ImageIcon(pathWheel17Audi));
                        wheelOptionAudi = "17";
                        break;
                    case 1:
                        configWheelAudi.setIcon(new ImageIcon(pathWheel18Audi));
                        wheelOptionAudi = "18";
                        break;
                    case 2:
                        configWheelAudi.setIcon(new ImageIcon(pathWheel19Audi));
                        wheelOptionAudi = "19";
                        break;

                }
            });
            wheel.setBounds(20 + i * 150, 450, 150, 150);
            wheel.setBackground(Color.white);
            haudi.add(wheel, 0);
        }


        configColorVW.setBounds(900, 250, 584, 250);
        configColorVW.setIcon(new ImageIcon(pathColorBlueVw));
        volscvagan.add(configColorVW, 0);
        for (int i = 0; i < 4; i++) {
            JButton color = new JButton("", colorPalleteVw.get(i));
            int finalI = i;
            color.addActionListener(e -> {
                colorlOptionVw = "";
                switch (finalI) {
                    case 0:
                        configColorVW.setIcon(new ImageIcon(pathColorBlueVw));
                        colorlOptionVw = "blue";
                        break;
                    case 1:
                        configColorVW.setIcon(new ImageIcon(pathColorPurpleVw));
                        colorlOptionVw = "purple";
                        break;
                    case 2:
                        configColorVW.setIcon(new ImageIcon(pathColorRedVw));
                        colorlOptionVw = "red";
                        break;
                    case 3:
                        configColorVW.setIcon(new ImageIcon(pathColorWhiteVw));
                        colorlOptionVw = "white";
                        break;

                }


            });
            color.setBounds(20 + i * 150, 250, 150, 150);
            color.setBackground(Color.blue);
            volscvagan.add(color, 0);
        }

        configWheelVW.setBounds(900, 250, 584, 250);
        configWheelVW.setIcon(new ImageIcon(pathWheel16Vw));
        volscvagan.add(configWheelVW, 0);
        for (int i = 0; i < 2; i++) {
            JButton wheel = new JButton("", vwRim.get(i));
            int finalI = i;
            wheel.addActionListener(e -> {
                wheelOptionVw = "";
                switch (finalI) {
                    case 0:
                        configWheelVW.setIcon(new ImageIcon(pathWheel16Vw));
                        wheelOptionVw = "16";
                        break;
                    case 1:
                        configWheelVW.setIcon(new ImageIcon(pathWheel17Vw));
                        wheelOptionVw = "17";
                        break;
                }
            });
            wheel.setBounds(20 + i * 150, 450, 150, 150);
            wheel.setBackground(Color.green);
            volscvagan.add(wheel, 0);

        }

        haudi.setVisible(true);
        haudi.setLayout(null);
        volscvagan.setLayout(null);
        window.add(haudi);
        window.add(volscvagan);
        window.setLayout(null);
        window.setResizable(false);
        window.setVisible(true);
    }
}

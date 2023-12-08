import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;



public class DrawPanel extends JPanel {

    CarWorld carW;


    /*public ArrayList<Vehicle> getCars() {
        return carC.getVehicles();
    }*/

    //ArrayList<BufferedImage> vehicleImageList = new ArrayList<>();
    ArrayList<Vehicle> vehicleList;

    public void sendToDraw(ArrayList<Vehicle> Lista){
        this.vehicleList = Lista;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);
/*
        carC.vehicles.add(new Volvo240(2, 1, Color.blue, "Volvo240"));
        carC.vehicles.add(new Saab95(2, 100, Color.red, "Saab95"));
        carC.vehicles.add(new Scania(2, 50, Color.black, "Scania"));

        for (Vehicle vehicle : getCars()) {
            try {
                String modelName = vehicle.getModelName();
                BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + modelName + ".jpg"));
                vehicleImageList.add(image);
            } catch (IOException ex) {
                ex.printStackTrace();
            }
        }*/
    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int index = 0;

        if (vehicleList != null){
            for (Vehicle vehicle : vehicleList) {
                int x = (int) Math.round(vehicle.getX());
                int y = (int) Math.round(vehicle.getY());
                g.drawImage(carW.getVehicleImageList().get(index),x,y + 100 * index, null);

                index += 1;
            }
        }
    }
}




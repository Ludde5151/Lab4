import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.imageio.ImageIO;
import javax.swing.*;


public class DrawPanel extends JPanel {

    private  CarWorld carW;


    ArrayList<Vehicle> vehicleList;

    public void sendToDraw(ArrayList<Vehicle> Lista){
        this.vehicleList = Lista;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y, CarWorld carWorld) {
        this.carW = carWorld;
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);

    }

    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int index = 0;
        List<Vehicle> vehicleList = carW.getVehicles();
        if (vehicleList != null){
            for (Vehicle vehicle : vehicleList) {
                int x = (int) Math.round(vehicle.getX());
                int y = (int) Math.round(vehicle.getY());
                //g.drawImage(carW.getVehicleImageList().get(index),x,y + 100 * index, null);
                if (carW.getVehicleBufferedImageMap().containsKey(vehicle)){
                    g.drawImage(carW.getVehicleBufferedImageMap().get(vehicle),x,y + 100 * index, null);
                }
                index += 1;

            }
        }
    }
}




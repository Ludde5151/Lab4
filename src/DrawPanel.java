import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;

import javax.imageio.ImageIO;
import javax.swing.*;



public class DrawPanel extends JPanel {

    private CarWorld carW;


    private ArrayList<Vehicle> vehicleList;

    public DrawPanel getDrawPanel(){
        return this;
    }

    public void setCarWorld(CarWorld carworld){
        carW = carworld;
    }
    public CarWorld getCarWorld(){
        return carW;
    }

    public void sendToDraw(ArrayList<Vehicle> Lista){
        this.vehicleList = Lista;
    }

    // Initializes the panel and reads the images
    public DrawPanel(int x, int y) {
        this.setDoubleBuffered(true);
        this.setPreferredSize(new Dimension(x, y));
        this.setBackground(Color.white);
    }

    @Override
    protected void paintComponent(Graphics g){
        super.paintComponent(g);
        int index = 0;
        int index2 = 0; // Index for when adding cars beyond the y-axle

        if (vehicleList != null){
            for (Vehicle vehicle : vehicleList) {
                int x = (int) Math.round(vehicle.getX());
                int y = (int) Math.round(vehicle.getY());
                if ((y + 75 * index) > 500) {
                    g.drawImage(carW.getVehicleImageList().get(index), x + 200, y + 75 * index2, null);
                    index2 += 1;
                } else {
                    g.drawImage(carW.getVehicleImageList().get(index), x, y + 75 * index, null);
                }

                index += 1;

            }
        }
    }
}

//


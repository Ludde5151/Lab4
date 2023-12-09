import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.sql.Time;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;

import javax.imageio.ImageIO;
import javax.swing.*;

public class CarWorld {
    CarView frame;

    private ArrayList<Vehicle> vehicles = new ArrayList<>();

    private final int delay = 50;

    Timer timer = new Timer(delay, new TimerListener());

    private ArrayList<BufferedImage> vehicleImageList = new ArrayList<>();
    private Map<Vehicle,BufferedImage> vehicleBufferedImageMap = new HashMap<>();
    // Check if the vehicle image list is empty

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
    public ArrayList<BufferedImage> getVehicleImageList() {return vehicleImageList;}

    public Map<Vehicle,BufferedImage> getVehicleBufferedImageMap() {return vehicleBufferedImageMap;}


    public void addVehicle(Vehicle vehicle) {
        vehicles.add(vehicle);
        try {
            String modelName = vehicle.getModelName();
            BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + modelName + ".jpg"));
            vehicleImageList.add(image);
            vehicleBufferedImageMap.put(vehicle,image);
        } catch (IOException ex) {
            ex.printStackTrace();
        }
    }



    private class TimerListener implements ActionListener {
        public void actionPerformed(ActionEvent e) {
            for (Vehicle vehicle : vehicles) {
                vehicle.move();
                int x = (int) Math.round(vehicle.getX());
                int y = (int) Math.round(vehicle.getY());
                //frame.drawPanel.moveit(x, y);
                if (vehicle.getX() > 700 || vehicle.getX() < 0) {
                    vehicle.stopEngine();
                    vehicle.turnleft();
                    vehicle.turnleft();
                    vehicle.startEngine();
                }
                if (vehicle.getX() > 700) {
                    vehicle.setX(700);
                } else if (vehicle.getX() < 0) {
                    vehicle.setX(0);
                }
            }
            // repaint() calls the paintComponent method of the panel
            frame.drawPanel.sendToDraw(vehicles);
            frame.drawPanel.repaint();
        }
    }
    // Method to update the vehicle list and repaint the panel
    public void updateAndRepaint(ArrayList<Vehicle> updatedVehicles) {
        vehicles = updatedVehicles;
        frame.drawPanel.sendToDraw(vehicles);
        frame.drawPanel.repaint();
    }
}





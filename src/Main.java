import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;


public class Main {


    public static void main(String[] args) throws IOException {
        CarWorld carW = new CarWorld();
        // Instance of this class
        CarView carView = new CarView("CarSim 1.0", carW);
        carW.frame = carView;
        CarController cc = new CarController(carView, carW);


        carW.addVehicle(new Volvo240(4, 100, Color.blue, "Volvo240"));
        carW.addVehicle(new Saab95(2, 125, Color.red, "Saab95"));
        carW.addVehicle(new Scania(2, 50, Color.black, "Scania"));

        // Start a new view and send a reference of self
        // Start the timer
        carW.timer.start();
        carView.drawPanel.paintComponent(carView.getGraphics());


    }

}

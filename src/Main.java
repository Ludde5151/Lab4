import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;


public class Main {
    private static final int delay = 50;
    private static Timer timer = new Timer(delay, new Timelistener(new CarWorld()));


    public static void main(String[] args) {
        // Instance of this class
        CarWorld carW = new CarWorld();
        CarController cc = new CarController();


        carW.addVehicle(new Volvo240(4, 100, Color.blue, "Volvo240"));
        carW.addVehicle(new Saab95(2, 125, Color.red, "Saab95"));
        carW.addVehicle(new Scania(2, 50, Color.black, "Scania"));

        // Start a new view and send a reference of self
        cc.frame = new CarView("CarSim 1.0");

        // Start the timer
        timer.start();
    }




}

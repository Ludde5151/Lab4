import javax.swing.*;
import java.awt.*;



public class Main {
    private static final int delay = 50;

    public static void main(String[] args) {
        // Instance of this class

        CarWorld carW = new CarWorld();
        CarController cc = new CarController();
        CarView frame = new CarView("Carsim 1.0");

        Timer timer = new Timer(delay, new Timelistener(carW, frame));

        carW.addVehicle(new Volvo240(4, 100, Color.blue, "Volvo240"));
        carW.addVehicle(new Saab95(2, 125, Color.red, "Saab95"));
        carW.addVehicle(new Scania(2, 50, Color.black, "Scania"));

        cc.setCarView(frame);
        cc.setCarWorld(carW);
        carW.setCarView(frame);
        frame.getDrawPanel().setCarWorld(carW);

        cc.initializeActionListener();

        timer.start();
    }




}

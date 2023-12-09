import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

/*
 * This class represents the Controller part in the MVC pattern.
 * It's responsibilities is to listen to the View and responds in a appropriate manner by
 * modifying the model state and the updating the view.
 */

public class CarController {

    CarView frame;
    CarWorld carW;
    public CarController(CarView frame, CarWorld carW){
        this.frame = frame;
        this.carW = carW;
        initializeActionListener();
    }


    // Calls the gas method for each car once
    void gas(int amount) {
        double gas = ((double) amount) / 100;
        for (Vehicle vehicle : carW.getVehicles()) {
            if (vehicle.currentSpeed >= 0.1)
                vehicle.gas(gas);
        }
    }

    void turnRight() {
        for (Vehicle vehicle : carW.getVehicles()) {
            vehicle.turnright();
        }
    }

    void turnLeft() {
        for (Vehicle vehicle : carW.getVehicles()) {
            vehicle.turnleft();
        }
    }

    void brake(int amount) {
        double brake = ((double) amount) / 100;
        for (Vehicle vehicle : carW.getVehicles()
        ) {
            vehicle.brake(brake);
        }
    }

    void turboon() {
        for (Vehicle vehicle : carW.getVehicles()) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOn();        // om det är en saab så går det att använda turboon/off
            }
        }
    }

    void turbooff() {
        for (Vehicle vehicle : carW.getVehicles()) {
            if (vehicle instanceof Saab95) {
                ((Saab95) vehicle).setTurboOff();
            }
        }
    }

    void liftBed(int amount) {
        for (Vehicle vehicle : carW.getVehicles()) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).raiseBody(amount);
            }
        }
    }

    void lowerBed(int amount) {
        for (Vehicle vehicle : carW.getVehicles()) {
            if (vehicle instanceof Scania) {
                ((Scania) vehicle).lowerBody(amount);
            }
        }
    }

    void startengine() {
        for (Vehicle vehicle : carW.getVehicles()) {
            vehicle.startEngine();

        }
    }

    void stopengine() {
        for (Vehicle vehicle : carW.getVehicles()) {
            vehicle.stopEngine();

        }
    }

    void initializeActionListener() {

        frame.gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {        // actionbutton gas
                gas(frame.gasOrBreakAmount);
            }
        });

        frame.turnRightButton.addActionListener(new ActionListener() {
            @Override                                               // actionbutton turn right
            public void actionPerformed(ActionEvent e) {
                turnRight();
            }
        });
        frame.turnLeftButton.addActionListener(new ActionListener() {
            @Override                                               // actionbutton turn left
            public void actionPerformed(ActionEvent e) {
                turnLeft();
            }
        });
        frame.brakeButton.addActionListener(new ActionListener() {
            @Override                                               // actionbutton brake
            public void actionPerformed(ActionEvent e) {
                brake(frame.gasOrBreakAmount);
            }
        });
        frame.turboOnButton.addActionListener(new ActionListener() {
            @Override                                               // actionbutton turbo on
            public void actionPerformed(ActionEvent e) {
                turboon();
            }
        });
        frame.turboOffButton.addActionListener(new ActionListener() {
            @Override                                               // actionbutton turbo off
            public void actionPerformed(ActionEvent e) {
                turbooff();
            }
        });
        frame.liftBedButton.addActionListener(new ActionListener() {
            @Override                                               // actionbutton turbo off
            public void actionPerformed(ActionEvent e) {
                liftBed(frame.bodyRaiseAmount);
            }
        });
        frame.lowerBedButton.addActionListener(new ActionListener() {
            @Override                                               // actionbutton turbo off
            public void actionPerformed(ActionEvent e) {
                lowerBed(frame.bodyRaiseAmount);
            }
        });
        frame.stopButton.addActionListener(new ActionListener() {
            @Override                                               // actionbutton turbo off
            public void actionPerformed(ActionEvent e) {
                stopengine();
            }
        });
        frame.startButton.addActionListener(new ActionListener() {
            @Override                                               // actionbutton turbo off
            public void actionPerformed(ActionEvent e) {
                startengine();
            }
        });
        frame.addCarbutton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                carW.addVehicle(new Volvo240(4,100,Color.BLUE, "Volvo240"));
            }
        });
        frame.removeCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                ArrayList<Vehicle> vehicles = carW.getVehicles();
                if (!vehicles.isEmpty()) {
                    vehicles.remove(vehicles.size() - 1);
                }
            }
        });
    }


















}

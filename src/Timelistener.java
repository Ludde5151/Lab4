import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class Timelistener implements ActionListener {
    CarWorld carW;
    public Timelistener(CarWorld carworld){
        this.carW = carworld;
    }

    public void actionPerformed(ActionEvent e) {
        carW.updatePosition();
    }
}

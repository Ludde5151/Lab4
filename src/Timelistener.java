import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Timelistener implements ActionListener {
    private CarWorld carW;
    private CarView frame;
    public Timelistener(CarWorld carworld, CarView carview){
        this.carW = carworld;
        this.frame = carview;
    }

    public void actionPerformed(ActionEvent e) {
        carW.updatePosition();
        frame.getDrawPanel().sendToDraw(carW.getVehicles());
        frame.getDrawPanel().repaint();

    }
}

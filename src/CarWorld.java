import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.ArrayList;
import javax.imageio.ImageIO;


public class CarWorld {
    private CarView frame;
    private ArrayList<Vehicle> vehicles = new ArrayList<>();
    private ArrayList<BufferedImage> vehicleImageList = new ArrayList<>();

    public ArrayList<Vehicle> getVehicles() {
        return vehicles;
    }
    public ArrayList<BufferedImage> getVehicleImageList() {return vehicleImageList;}

    public void setCarView(CarView carview){
        frame = carview;
    }
    public CarView getCarView(){
        return frame;
    }


    public void addVehicle(Vehicle vehicle){
        vehicles.add(vehicle);

        try {
            String modelName = vehicle.getModelName();
            BufferedImage image = ImageIO.read(DrawPanel.class.getResourceAsStream("pics/" + modelName + ".jpg"));
            vehicleImageList.add(image);
        } catch (IOException ex) {
            ex.printStackTrace();
            }
        }

    public void updatePosition() {
        for (Vehicle vehicle : vehicles) {
            System.out.println();
            vehicle.move();
            int x = (int) Math.round(vehicle.getX());
            int y = (int) Math.round(vehicle.getY());
            //frame.drawPanel.sendToDraw(vehicles);
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
    }







    }



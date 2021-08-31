//Ciaran Maye C00253212
//Daniel Turner C00193235
//Sharon O' Leary C00253145



public class Car {

    //Variables
    private String driverName;
    private String model;
    private char valetService;
    private Program washType;
    private double price;


    //Constructor
    public Car(String driverName, String model, Program washType) {
        setDriverName(driverName);
        setModel(model);
        setValetService('N');
        setWashType(washType);
        setPrice(washType.getCost());
    }


    //getters and setters
    public String getDriverName() {
        return driverName;
    }

    public void setDriverName(String driverName) {
        this.driverName = driverName;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    
    public char getValetService() {
        return valetService;
    }

    public void setValetService(char valetService) {
        this.valetService = valetService;
    }

    public Program getWashType() {
        return washType;
    }
    
    public void setWashType(Program washType) {
        this.washType = washType;
    }

    
    public double getPrice() {                  //
        price = Math.round(price * 100) / 100;  // Converts the price to 2 decimal places when its called.
        return price;                           //
    }

    public void setPrice (double price) {
        this.price = price;
    }

     //to String
    @Override
    public String toString() {
        return "Car : " + model + "\n" + "Driver : " + driverName + "\n" + "Wash : " + washType.getDescription() + "\n" + "Price : €" + price +"\n" + "Valet Service : " + valetService;
        }



    
   

    
    
}

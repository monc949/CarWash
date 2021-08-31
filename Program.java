//Ciaran Maye C00253212
//Daniel Turner C00193235
//Sharon O' Leary C00253145


public class Program {

    //variables
    private String description;
    private double cost;
   
    //constructor
    public Program(String description, double cost) {
        this.description = description;
        this.cost = cost;
    }
    
    //getters and setters
    public String getDescription() {
        return description;
    }
 
    public void setDescription(String description) {
        this.description = description;
    }
 
    public double getCost() {
        return cost;
    }
 
    public void setCost(double cost) {
        this.cost = cost;
    }


    //
    // No need for toString() method as the getDescription method is called in the Car class's toString method
}
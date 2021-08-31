//Ciaran Maye C00253212
//Daniel Turner C00193235
//Sharon O' Leary C00253145



import java.util.Scanner;

public class CarWashDriver {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);                       //Initialising Scanner class and creating the queue to hold the cars.
        Car[] queue = new Car[20];                                      //Also intialising the counter 'nextAvailableSlot' along with choice variable for the menu
        int nextAvailableSlot = 0;
        int choice;

        do {
            System.out.println("********* MENU *********");
            System.out.println("1. Add a car to the queue");
            System.out.println("2. Display number of cars in queue");
            System.out.println("3. Display details of all cars in queue");
            System.out.println("4. Display details of next car");
            System.out.println("5. Remove car from queue");
            System.out.println("6. Clear List");
            System.out.println("7. Apply Voucher");
            System.out.println("8. Apply Valet service");
            System.out.println("9. Wash Car");
            System.out.println("10. End Program");
            System.out.println("Please enter your choice :");
            choice = scanner.nextInt();
            switch(choice) {

    //Option 1 start : Add car along with details to the queue
                case 1:
                Program quickWash = new Program("Quick wash:" + " Soap and water, 30 sec brush, rinse." , 10.00);
                Program longWash = new Program("Long wash:" + " Soap and water, 1 min brush, rinse, wax spray" , 15.00);       //Initialises wash types with details and price
                Program rinse = new Program("Quick wash:" + " Soap and water, power rinse." , 5.0);

                Program washType = new Program("", 0.0);
                String driverName;
                String model;


                System.out.println("Please enter the drivers name : ");
                driverName = scanner.next();
                scanner.nextLine();

                System.out.println("Please enter the model of the car : ");                                     //Takes in new driver details and stores it in temp variables
                model = scanner.next(); 
                scanner.nextLine();

                System.out.println("Please enter wash type : 1,2 or 3.");
                System.out.println("1. Quick Wash.");
                System.out.println("2. Long Wash");
                System.out.println("3. Rinse");
                int washChoice = scanner.nextInt();                                                                     
                scanner.nextLine();

                    if (washChoice == 1){
                    washType = quickWash;
                    }
                    if (washChoice == 2){
                    washType = longWash;
                    }
                    if (washChoice == 3){
                        washType = rinse;
                    }
                    else if(washChoice > 3){
                        System.out.println("Please select a valid car wash choice.");
                    }
            

                
                Car tempCar = new Car(driverName, model, washType);

                if (nextAvailableSlot < queue.length){
                    queue[nextAvailableSlot] = tempCar;
                }
                else{
                    System.out.println("The queue is full. Please wash some cars.");
                }

                System.out.println("\n" + tempCar + "\n" + "This car has been added to the queue" + "\n");                    //copies inputs to temp Car and then copies tempCar to the next free slot in the array                                                                     //by way of the variable 'nextAvailableSlot'. Then increments that variable by 1

                nextAvailableSlot++;
                break;



    //Option 2 start : Display the number of cars in the queue
                case 2:
                if (nextAvailableSlot > 1){
                    System.out.println("\n" + "\n" + "There is " + nextAvailableSlot + " cars in the queue." +"\n" + "\n");                       //Returns the counter variable 'nextSlotAvailable'                                                                             // if statement is just for grammer
                }
                if (nextAvailableSlot == 1){
                    System.out.println("\n" + "\n" + "There is " + nextAvailableSlot + " car in the queue." +"\n" + "\n");                                                                                                    // if statement is just for grammer
                }
                if (nextAvailableSlot == 0){
                    System.out.println("There are no cars in the queue.");
                }
                break;


    //Option 3 start : Display all details of cars in the queue
                case 3:
                for(int i = 0; i <= queue.length -1; i++){
                    if (queue[i] != null){
                        System.out.println("Car No." + (i + 1) + "\n" + queue[i] +"\n" +"\n");                     //Invokes toString on all elements not equal to null
                    }
                   
                }
                break;

    //Option 4 start : Display details of next car
                case 4:
                System.out.println(queue[0] +"\n" +"\n");
                break;

    //Option 5 start : Remove car from queue
                case 5:
                String tempDriver;
                int removeIndex = 0;
                System.out.println("Please enter the name of the driver to remove.");
                System.out.println("Drivers in queue:");

                for(Car c : queue){
                    if(c !=null){
                        System.out.println(c.getDriverName() + "\n");
                    }
                }
                tempDriver = scanner.next();                                                        //Searches array for the driver name that was input, when matched, 
                scanner.nextLine();                                                                 //assigns the index of that person to "removeIndex"

                for(int i = 0;i <= queue.length -1;i++){
                    if(queue[i] != null){
                        if(tempDriver.equalsIgnoreCase(queue[i].getDriverName())){
                            removeIndex = i;
                        }
                    }

                }
                for(int i = 0;i <= queue.length - 1;i++){
                    if(i >= removeIndex && queue[i] != null){                                                         
                        queue[i] = queue[i + 1];
                    }
                    else{
                        queue[i] = queue[i];
                    }


                }              

                nextAvailableSlot--;
                System.out.println("\n" + tempDriver + " has been removed from the queue." +"\n");
                break;


    //Option 6 start : Clear list
                case 6:
                for(int i = 0;i <= queue.length - 1;i++){
                    queue[i] = null;
                }
                System.out.println("The Queue has been cleared." +"\n");                              //Resets all elements to null and resets counter to 0
                nextAvailableSlot = 0;
                break;


    //Option 7 start : Apply voucher
                case 7:
                String tempDriver1;
                System.out.println("Please enter the name of the driver to receive discount");
                System.out.println("Drivers in queue:");

                for(Car c : queue){
                    if(c !=null){
                        System.out.println(c.getDriverName() + "\n");
                    }
                }
                tempDriver1 = scanner.next();                                                         //Searches array for the driver name that was input, when matched,       
                scanner.nextLine();                                                                   //when matched, takes 20% of the price for that driver      
                for(int i = 0;i <= queue.length -1;i++){
                if(queue[i] != null){
                        if(tempDriver1.equalsIgnoreCase(queue[i].getDriverName())){                             
                            queue[i].setPrice(queue[i].getPrice() - (queue[i].getPrice() * 0.20));
                        }
                    }
                    
                }
                System.out.println(tempDriver1 + " will now receive a discount." +"\n");
                break;
               
                    

    //Option 8 start : Apply valet service
                case 8:
                String tempDriver2;
                System.out.println("Please enter the name of the driver to receive valet.");
                System.out.println("Drivers in queue:");

                for(Car c : queue){
                    if(c !=null){
                        System.out.println(c.getDriverName() + "\n");                   //Searches array for the driver name that was input, when matched, changes the
                    }                                                                   //valet variable to 'Y'
                }
                tempDriver2 = scanner.next();
                scanner.nextLine();
                for(int i = 0;i <= queue.length -1;i++){
                if(queue[i] != null){
                    if(tempDriver2.equalsIgnoreCase(queue[i].getDriverName())){
                        queue[i].setValetService('Y');
                    }
                }
                    
                }
                System.out.println(tempDriver2 + " will now recieve a valet service." +"\n");
                break;


    //Option 9 start : Wash next Car
                case 9:
                System.out.println("\n"+"This car will be washed :" + "\n" + queue[0] +"\n");  
                
                for(int i = 0;i <= queue.length - 1;i++){
                    if(queue[i] != null){
                        queue[i] = queue[i + 1];  
                    }
                                      
                }
                nextAvailableSlot--;
                break;


    //Option 10 start : Exit
                case 10:
                System.out.print("Goodbye");                      //Simply exits the program
                System.exit(0);
                break;

            }
        //switch statement end
        } while(choice != 10);
    //end of do while
    }
 //main end




}
// i never added a ui as there was not one in the UML diagram.but the functionalty is here and a ui could be added easily.
public class Main {
    public static void main(String[] args) {
        System.out.println("Hello world!");
        // create new house instance with all args
        House myHouse = new House("Springfield rd","south Laurel","MD",true,false,true,"red",0.00,0.00,2000,2207);
        Contractor contractor = new Contractor("location",31);
        // im not sure the relevance of these arguments as they are not required in any of the methods or functions
        // so im going to assign random possible values.
        Insurance insurance = new Insurance(1);

        System.out.println("The cost to paint the house will be: $" + contractor.CalculateRepaintCost(myHouse));
        System.out.println("The cost to insure the house will be: $" + insurance.CalculateInsuranceCost(myHouse));

    }
}
class Contractor{
    String mvaLocation;
    int numberOfVehiclesProcessed;
    Contractor(String mvaLocation,int numberOfVehiclesProcessed){
        this.mvaLocation = mvaLocation;
        this.numberOfVehiclesProcessed = numberOfVehiclesProcessed;
    }
    double CalculateRepaintCost(House house){
        final double PaintCost = 2.00;
        // paint cost is measured per sqr ft in usd
       double squareFootage =  house.getSquareFootage();
       double quote = PaintCost * squareFootage;
       house.setRepaintCost(quote);

        return quote;
    }
    double CalculateRoofRepairQuote(House house){
        final double RepairCost = 2000;
        // fixed rate also measured in usd
        return RepairCost;
    }
}
class Insurance{
    int numberOfHomesProcessed;
    Insurance(int numberOfHomesProcessed){
        this.numberOfHomesProcessed = numberOfHomesProcessed;
    }
    void IncrementHomesProcessed(){
        this.numberOfHomesProcessed ++;
    }
    double CalculateInsuranceCost(House house){
        double earthquakeProne = house.isEarthquakeProne()?.75:1;
        double floodProne = house.isFloodProne()?.50:1;
        // im probally reading somthing wrong but the way i see this it means that it is cheaper to insure in this
        // areas as you are multiplying by a less that 1 number and it doesnt say the modifier elswhere so im going to do it this way so thats
        // i implemented it as the only other way i could see it if its is the 500 + and .75 of the 500 but i dont know.
        double quote = (500*floodProne)+(500*earthquakeProne);
        return quote;
    }
}
class House{
    //region properties
    String street;
    String city;
    String state;
    boolean goodRoof;
    boolean floodProne;
    boolean earthquakeProne;
    String color;
    double insuranceCost;
    double repaintCost;
    double roofRepairCost;
    double squareFootage;
    //endregion
     House(String street,String city,String state,Boolean goodRoof,Boolean floodProne,Boolean earthquakeProne,
                 String color,double insuranceCost,double repaintCost,double roofRepairCost,double squareFootage){
         this.street = street;
         this.city = city;
         this.state = state;
         this.goodRoof = goodRoof;
         this.floodProne = floodProne;
         this.earthquakeProne = earthquakeProne;
         this.color = color;
         this.insuranceCost = insuranceCost;
         this.repaintCost = repaintCost;
         this.roofRepairCost = roofRepairCost;
         this.squareFootage = squareFootage;
    }
    void setRepaintCost(double cost){
         this.repaintCost = cost;
    }
    void setInsuranceCost(double cost){
         this.insuranceCost = cost;
    }
    boolean isFloodProne(){
         return this.floodProne;
    }
    boolean isEarthquakeProne(){
         return this.earthquakeProne;
    }
    double getSquareFootage(){
         return this.squareFootage;
    }


}

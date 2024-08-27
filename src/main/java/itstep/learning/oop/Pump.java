package itstep.learning.oop;
import java.util.Locale;


public class Pump extends Product implements Manual{
     int productivity;

     public Pump(String manufacture, int productivity) {
         super.setManufacturer(manufacture);
         this.setProductivity(productivity);
     }
    @Override
    public String getCard() {
         return String.format("Pump: '%s', Productivity: %d l/h", super.getManufacturer(), this.getProductivity());
    }
    public int getProductivity() {
        return productivity;
    }

    public void setProductivity(int productivity) {
         this.productivity = productivity;
    }
    @Works
    public void pump(){
        System.out.println("Working on:" + this.getCard());
    }
    @Warranty(2)
    public void Warrantypump(){

    }


}

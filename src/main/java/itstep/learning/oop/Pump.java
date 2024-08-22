package itstep.learning.oop;

public class Pump extends Product {
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
}

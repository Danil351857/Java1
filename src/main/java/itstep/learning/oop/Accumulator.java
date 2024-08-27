package itstep.learning.oop;

public class Accumulator extends Product {
    int capacity;
    public Accumulator(String manufacturer, int capacity) {
        this.setCapacity(capacity);
        super.setManufacturer(manufacturer);
    }

    @Override
    public String getCard() {
        return String.format("Accumulator: '%s', Capacity: %d mAh", super.getManufacturer(), this.getCapacity());
    }
    public int getCapacity() {

        return capacity;
    }
    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }
    @Works
    public void accumulator(){
        System.out.println("Working on:" + this.getCard());
    }
    @Warranty(3)
    public void Warrantyaccumulator(){

    }
}

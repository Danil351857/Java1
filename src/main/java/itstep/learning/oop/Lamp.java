package itstep.learning.oop;

public class Lamp extends Product implements Testable {

    double power;
    public Lamp(String manufacturer, double power) {
        this.setPower(power);
        super.setManufacturer(manufacturer);
    }

    @Override
    public String getCard() {
        return String.format("Lamp: '%s', Power: %.1f W", super.getManufacturer(), this.getPower());
    }
    public double getPower() {
        return power;
    }
    public void setPower(double power) {
        if(power < 0){
            throw new RuntimeException("Negative power");
        }
        this.power = power;
    }
    @Override
    public void test(){
        System.out.println("Testing: " + this.getCard());
    }
    @Works
    public void shine(){
        System.out.println("Working on:" + this.getCard());
    }
    @Warranty(0)
    public void warrantylamp(){}

}

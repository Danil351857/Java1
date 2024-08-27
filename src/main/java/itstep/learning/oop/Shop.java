package itstep.learning.oop;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;
public class Shop{
    private List<Product> products;
    public Shop() {
        products = new ArrayList<Product>();
        products.add(new Lamp("Philips", 60.0));
        products.add(new Pump("Pumper", 100));
        products.add(new Accumulator("ZXC", 1000));
    }
    public void Print(){
        for(Product product : products){
            if(product instanceof Testable){
                ((Testable) product).test();
            }
            else {
                System.out.println(product.getCard());
            }
        }
    }
    public void run(){
        Print();
        System.out.println("--------------Manual------------------");
        printManualProduct();
        System.out.println("------------NON-MANUAL----------------");
        printNonManualProduct();
        System.out.println("--------------WORKS-------------------");
        showWork();
        System.out.println("------------WARRANTY----------------");
        printWarranty();
        System.out.println("------------NON-WARRANTY----------------");
        printNonWarranty();

    }
    private void printManualProduct(){
        for(Product product : products){
            if(product instanceof Manual){
                System.out.println(product.getCard());
            }
        }
    }
    private void printNonManualProduct(){
        for(Product product : products){
            if(!(product instanceof Manual)){
                System.out.println(product.getCard());
            }
        }
    }
    private void showWork(){
        for(Product product : products){
            for(Method method : product.getClass().getDeclaredMethods()){
                if(method.isAnnotationPresent(Works.class)){
                    method.setAccessible(true);
                    try{
                        method.invoke(product);
                    }
                    catch (IllegalAccessException | InvocationTargetException ex){
                        System.err.println(ex.getMessage());
                    }
                }
            }
        }
    }
    private void printWarranty() {
        for (Product product : products) {
            for (Method method : product.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(Warranty.class)) {
                    Warranty warranty = method.getAnnotation(Warranty.class);
                    if (warranty.value() > 0) {

                        System.out.println(product.getCard() + " has a warranty of " + warranty.value() + " years.");

                    }


                }
            }
        }
    }
    private void printNonWarranty() {
        for (Product product : products) {
            for (Method method : product.getClass().getDeclaredMethods()) {
                if (method.isAnnotationPresent(Warranty.class)) {
                    if(method.getAnnotation(Warranty.class).value() == 0){

                        System.out.println(product.getCard() + " does not have a warranty.");

                    }

                }
            }
        }
    }
}

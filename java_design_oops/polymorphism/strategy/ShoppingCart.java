import java.util.ArrayList;

class Product{
    Product(int q, int p){
        quantity = q;
        price = p;
    }
    private int quantity;
    private int price;
    // setter
    public int getPrice(){
        return price * quantity;
    }
}

class Bill {
    private Product product;
    private int total_cost;
    public void setTotal(int total){
        total_cost = total;
    }

    public int getTotal(){
        return total_cost;
    }

    public void generateBill(){}
}

interface Payment{
    public void pay(int amount);
}

class UpiPayment implements Payment{
    public void pay(int amount){
        System.out.println("This is UpiPayment class. Amount = " + amount);
    }
}

class CreditPayment implements Payment{
    public void pay(int amount){
        System.out.println("This is CreditPayment class. Amount = " + amount);
    }
}

class PaypalPayment implements Payment{
    public void pay(int amount){
        System.out.println("This is PaypalPayment class. Amount = " + amount);
    }
}

public class ShoppingCart{
    ArrayList<Product> listProducts = new ArrayList<Product>();
    Bill shoppingBill = new Bill();

    public void addProduct(Product p){
        listProducts.add(p);     
    }
    // removed products

    public int calculateTotalCost(){
        int total = 0;
        for(Product prod: listProducts){
            total += prod.getPrice();
        }
        shoppingBill.setTotal(total);
        return total;
    }

    public void payBill(Payment p){
        p.pay(this.calculateTotalCost());
    }

    public static void main(String[] args){
        ShoppingCart cart = new ShoppingCart();
        Product p1 = new Product(1, 500);
        Product p2 = new Product(3, 100);
        Product p3 = new Product(1, 1500);
        cart.addProduct(p1);
        cart.addProduct(p2);
        cart.addProduct(p3);
        
        Payment payment = new PaypalPayment();
        cart.payBill(payment);
        //Payment payment = new PaypalPayment();
    }
}
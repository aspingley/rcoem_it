package rcoem;
public class Demo{
    public static void main(String args[]){
        IObserver o1 = new ConcreteObserver();
        IObserver o2 = new ConcreteObserver();
        IObserver o3 = new ConcreteObserver();

        INotifier n1 = new ConcreteNotifier();
        n1.register(o1);
        n1.register(o2);
        n1.register(o3);

        n1.process();
    } 
}
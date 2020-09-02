package rcoem;
import java.util.UUID;

public class ConcreteObserver implements IObserver{

	private UUID _identifier = UUID.randomUUID();

	public void update(String msg){
		System.out.println("Message in ConcreteObserver " + _identifier.toString() + " : " + msg);
	}
}

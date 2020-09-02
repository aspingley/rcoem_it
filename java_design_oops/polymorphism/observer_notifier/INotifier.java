package rcoem;

public interface INotifier{
	public void register(IObserver o);
	public void remove(IObserver o);
	public void process();
}

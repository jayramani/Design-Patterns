
import java.util.*;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;

public abstract class Subject
{
    private final List<IObserver> observers;
    private Map<String, Object> data;

    public Subject()
    {
        observers = new CopyOnWriteArrayList<IObserver>();
        data = new ConcurrentHashMap<>();
    }


    public void attach(IObserver observer)
    {
        observers.add(observer);
        //System.out.println("OBSERVERS:" + observers);
    }


    public void detach(IObserver observer)
    {
        observers.remove(observer);
    }

    public void notifyObservers()
    {
        //System.out.println("OBSERVERS:" + observers);
        ListIterator<IObserver> iter = observers.listIterator();
        while (iter.hasNext())
        {
            iter.next().update();
        }
    }

    public Object getValue(String key){
        return data.get(key);
    }

    public void setValue(String key, Object value){
        data.put(key,value);
    }
}
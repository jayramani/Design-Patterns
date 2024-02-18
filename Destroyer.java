public class Destroyer extends Subject{

    public void destroy(Object value){

        setValue("Board Component", value);
        notifyObservers();

    }

}

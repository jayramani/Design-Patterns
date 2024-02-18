public class SquareDecorator extends Square{

    public Square square;

    public SquareDecorator(Square square) {
        this.square = square;
    }

    @Override
    public  void Operation(){
        super.Operation();
    }
}

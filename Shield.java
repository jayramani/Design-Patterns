public class Shield extends SquareDecorator implements IObserver{

    private int shieldHealth;

    public Shield(Square square) {

        super(square);
        shieldHealth = 2;
    }

    @Override
    public  void Operation(){
        square.Operation();
    }
    @Override
    public void update() {
       // System.out.println("testing    ...  ");
        BoardComponent boardComponent = (BoardComponent) GameBoard.Instance().getDestroyer().getValue("Board Component");
        if(boardComponent == square){
            if(shieldHealth==0){
                Destroyer destroyer = GameBoard.Instance().getDestroyer();
                destroyer.detach(this);
                destroyer.attach(square);
                GameBoard.Instance().updatedBoard(this, square);
                GameBoard.Instance().getDestroyer().destroy(boardComponent);
            }else{
                shieldHealth-=1;
            }
        }
    }
}

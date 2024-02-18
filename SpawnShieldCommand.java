public class SpawnShieldCommand extends Command {

    public SpawnShieldCommand(Object receiver, String[] args)
    {
        super(receiver, args);
    }

    @Override
    public void Execute() {

        int x = Integer.parseInt(args[0]);
        int y = Integer.parseInt(args[1]);

        Square square = (Square) receiver;
        IAsteroidGameFactory factory = GameBoard.Instance().GetFactory();
        BoardComponent bc = factory.MakeShield((Square) square);
        System.out.println("Spawning shield at (" + args[0] + "," + args[1] + ")");
        GameBoard.Instance().updatedBoard(x,y,bc);
        GameBoard.Instance().getDestroyer().detach(square);
    }
}

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

// Square is a composite, making up the Composite pattern (contains components)
public class Square extends BoardComponent implements IObserver
{
	private final List<BoardComponent> children;
	private BoardComponent parent;
	
	public Square()
	{
		super();
		children = new CopyOnWriteArrayList<BoardComponent>();
	}

	@Override
	public void Operation()
	{
		ArrayList<BoardComponent> childrenCopy = new ArrayList<BoardComponent>(children);
		for (int i = 0; i < childrenCopy.size(); i++)
		{
			BoardComponent child = childrenCopy.get(i);
			child.Operation();
		}
	}

	@Override
	public void Add(BoardComponent child)
	{
		// I am now this child's parent.
		children.add(child);
		child.SetParent(this);
	}

	@Override
	public void Remove(BoardComponent child)
	{
		children.remove(child);
	}

	@Override
	public void update() {
		BoardComponent boardComponent = (BoardComponent) GameBoard.Instance().getDestroyer().getValue("Board Component");
		if(boardComponent == this){
			handleChange();
		}
 	}
	 //======================================================================
	 public void handleChange(){
		for (BoardComponent child : children){
			child.handleChange();
		}
	 }
}
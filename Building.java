// Building is the leaf node for the composite pattern, Square's can have MULTIPLE Buildings
// Buildings cannot have children.
public class Building extends BoardComponent
{
	private int buildingHealth;
	public Building()
	{
		super();
		buildingHealth = 2;
	}

	@Override
	public void Operation()
	{
		// Buildings just stand there, they don't do anything.
	}

	@Override
	public void Add(BoardComponent child)
	{
		// Do nothing, I'm a leaf.
	}

	@Override
	public void Remove(BoardComponent child)
	{
		// Do nothing, I'm a leaf.
	}

	@Override
	public void handleChange() {
		if(buildingHealth == 1){
			this.buildingHealth-=1;
			GameBoard.Instance().DecrementBuildingCount();
			parent.Remove(this);
		}else {
			this.buildingHealth-=1;
		}
		System.out.println("Building health : " + buildingHealth);
		System.out.println("Building count : " + GameBoard.Instance().GetBuildingCount());
	}
}
public abstract class Bot extends AbstractPlayer{
	
	protected double r;
	
	public Bot(String name,int maxHp){
		super(name,maxHp);
	}
	
	public abstract boolean kick(AbstractPlayer p1, int f);
	
}
public abstract class AbstractPlayer{
	
	protected int hp;
	protected String name;
	
	public AbstractPlayer(int maxHp){
		this.hp = maxHp;
	}
	
	public AbstractPlayer(String name, int maxHP) {
		this(maxHP);
		this.name = name;
	}
	
	public String toString(){
		return name + "(" + hp + ")";
	}
	
	public String getName(){
		return name;
	}
	
	public boolean alive(){
		return hp > 0;
	}
	
	public int getHp(){
		return hp;
	}
	
	public void setHp(int hp){
		this.hp = hp;
	}
	
	public abstract boolean kick(AbstractPlayer ap, int f);
}
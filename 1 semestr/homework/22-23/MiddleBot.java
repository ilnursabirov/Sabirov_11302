public class MiddleBot extends Bot{
	
	public MiddleBot(int maxHp){
		super("Elvis",maxHp);
	}
	
	public boolean kick(AbstractPlayer p1, int f){
		r = Math.random();
		if (r > 0.3 && r < 0.9){
			p1.hp -= 4;
			return true;
		} else {
			return false;
		}
	}
	
}
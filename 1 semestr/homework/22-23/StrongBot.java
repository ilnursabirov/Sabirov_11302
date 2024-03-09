public class StrongBot extends Bot{
	
	public StrongBot(int maxHp){
		super("Никита",maxHp);
	}
	
	public boolean kick (AbstractPlayer p1, int f){
		r = Math.random();
		if (r > 0.2){
			p1.hp -= 5;
			return true;
		} else {
			return false;
		}
	}
}
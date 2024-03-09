public class DummyBot extends Bot{
	
	public DummyBot(int maxHp){
		super("Maxim",maxHp);
	}
	
	public boolean kick(AbstractPlayer p1, int f){
		r = Math.random();
		if (r > 0.4 && r < 0.8){
			p1.hp -= 2;
			return true;
		} else {
			return false;
		}
	}
	
}
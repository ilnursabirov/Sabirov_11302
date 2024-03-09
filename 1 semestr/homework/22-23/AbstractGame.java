import java.util.Scanner;

public abstract class AbstractGame{
	
	protected AbstractPlayer p1, p2;
	protected Scanner in = new Scanner(System.in);
	
	public AbstractGame(int maxHP){
		System.out.println("как вас зовут?");
		String name = in.nextLine();
		System.out.println("Выберите персонажа:\n 1)обычный\n 2)хиллер");
		p1 = in.nextInt() == 1? new Player(name, maxHP): new HealerPlayer(name, maxHP);
	}
	
	public AbstractGame(int maxHP, int i){
		System.out.println("как вас зовут?");
		String name = in.nextLine();
		System.out.println("Выберите персонажа:\n 1)обычный\n 2)хиллер");
		p1 = in.nextInt() == 1? new Player(name, maxHP): new HealerPlayer(name, maxHP);
		System.out.println("Как вас зовут?");
		name = in.nextLine();
		name = in.nextLine();
		System.out.println("Выберите персонажа:\n 1)обычный\n 2)хиллер");
		p2 = in.nextInt() == 1? new Player(name, maxHP): new HealerPlayer(name, maxHP);
	}
	
	public abstract void go();
}
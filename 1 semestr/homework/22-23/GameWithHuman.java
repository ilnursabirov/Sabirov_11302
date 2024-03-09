import java.util.Scanner;

public class GameWithHuman extends AbstractGame{
	
	private Scanner scanner = new Scanner(System.in);
	
	public GameWithHuman(int maxHp) {
		super(maxHp,1);		
	}
	
	public void go() {
		System.out.println("The battle has begun.");
		AbstractPlayer kicker = p1;
		AbstractPlayer enemy = p2;
		while (kicker.alive() && enemy.alive()){
			if (kicker instanceof HealerPlayer){
				HealerPlayer temp = (HealerPlayer) kicker;
				System.out.println("What will you do?\n 1)heal\n 2)kick");
				if (scanner.nextInt() == 1){
					System.out.println("У вас есть " + kicker.getHp() + " хп. Сколько вы хотите потратить?");
					int hl = scanner.nextInt();
					while (hl > temp.getHealPoints()){
						System.out.println("мм, у тебя нет столько очков здоровья XD");
						hl = scanner.nextInt();
					}
					temp.heal(hl);
					kicker = (Player) temp;
				} else {
					System.out.println(kicker.getName() + " is going to kick " + 
								enemy.getName() + " with force: ");
					int f = in.nextInt(); // f - force
					while (!(1 <= f && f <= 10)) {
					System.out.println("Некорректный ввод");
					f = in.nextInt(); // f - force
					}
					boolean result = kicker.kick(enemy, f);
					if (result) {
						System.out.println("Success, " + enemy.getName() + "'s hp is " + enemy.getHp() + ".");
					} else {
						System.out.println("Missed");
					}
				}
			} else {
				System.out.println(kicker.getName() + " is going to kick " + 
								enemy.getName() + " with force: ");
				int f = in.nextInt(); // f - force
				while (!(1 <= f && f <= 10)) {
					System.out.println("Некорректный ввод");
					f = in.nextInt(); // f - force
				}
				boolean result = kicker.kick(enemy, f);
				if (result) {
					System.out.println("Success, " + enemy.getName() + "'s hp is " + enemy.getHp() + ".");
				} else {
					System.out.println("Missed");
				}
			}
			AbstractPlayer swap = kicker;
			kicker = enemy;
			enemy = swap;
		}
		AbstractPlayer winner = kicker.alive()? kicker: enemy;
		System.out.println(winner.getName() + " won.");
		
	}
	
	public static void main(String [] args) {
		final int MAX_HP = (args.length == 1) ? Integer.parseInt(args[0]):100;
		GameWithHuman g = new GameWithHuman(100);
		g.go();
	}
}
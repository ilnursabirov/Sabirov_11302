import java.util.Scanner;

public class Game {

	private Player p1, p2;
	private Scanner in = new Scanner(System.in);
	
	public Game(int maxHP) {
		System.out.println("Введите имя первого игрока");
		p1 = new Player(in.nextLine(), maxHP);
		System.out.println("Введите имя второго игрока");
		p2 = new Player(in.nextLine(), maxHP);
	}
	
	public void go() {
		System.out.println("The battle has begun.");
		Player kicker = p1;
		Player enemy = p2;
		while (p1.alive() && p2.alive()) {
			System.out.println(kicker + " is going to kick " + enemy + " with force: ");
			int f = in.nextInt();
			while (!(1 <= f && f <= 10)) {
				System.out.println("Некорректный ввод");
				f = in.nextInt();
			}
			boolean result = kicker.kick(enemy, f);
			if (result) {
				System.out.println("Success, " + enemy.getName() + "'s hp is " + enemy.getHp() + ".");
			} else {
				System.out.println("Missed");
			}
			Player swap = kicker;
			kicker = enemy;
			enemy = swap;
		}
		Player winner = p1.alive() ? p1: p2;
		System.out.println(winner.getName() + " won.");
		
	}
	
	public static void main(String [] args) {
		final int MAX_HP = (args.length == 1) ? Integer.parseInt(args[0]) : 100;
		Game g = new Game(MAX_HP);
		g.go();
	}
}
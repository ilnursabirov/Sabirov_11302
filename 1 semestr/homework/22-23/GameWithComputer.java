import java.util.Scanner;

public class GameWithComputer extends AbstractGame{
	
	protected Scanner scanner = new Scanner(System.in);
	protected Bot b;
	
	public GameWithComputer(int maxHP) {	
		super(maxHP);
		System.out.println("Какой уровень сложности должен быть у бота?\n 1)легкий\n 2)средний\n 3)выше среднего");
		int i = scanner.nextInt();
		if (i == 1){
			p2 = new DummyBot(maxHP);
		} else if (i == 2){
			p2 = new MiddleBot(maxHP);
		} else {
			p2 = new StrongBot(maxHP);
		}
	}
	
	public void go() {
		System.out.println("The battle has begun.");
		b = (Bot) p2;
		while (p1.alive() && b.alive()) {
			if (p1 instanceof HealerPlayer){
				HealerPlayer temp = (HealerPlayer) p1;
				System.out.println("What will you do?\n 1)heal\n 2)kick");
				if (scanner.nextInt() == 1){
					System.out.println("У вас есть " + p1.getHp() + " хп. Сколько вы хотите потратить?");
					int hl = scanner.nextInt();
					while (hl > temp.getHealPoints()){
						System.out.println("мм, у тебя нет столько очков здоровья XD");
						hl = scanner.nextInt();
					}
					temp.heal(hl);
					p1 = (Player) temp;
				} else {
					System.out.println(p1.getName() + " is going to kick " + 
								p2.getName() + " with force: ");
					int f = in.nextInt(); // f - force
					while (!(1 <= f && f <= 10)) {
						System.out.println("Некорректный ввод");
						f = in.nextInt(); // f - force
					}
					boolean result = p1.kick(p2, f);
					if (result) {
						System.out.println("Success, " + p2.getName() + "'s hp is " + p2.getHp() + ".");
					} else {
						System.out.println("Missed");
					}
				}
			} else {
				System.out.println(p1.getName() + " is going to kick " + 
								   p2.getName() + " with force: ");
				int f = in.nextInt(); // f - force
				while (!(1 <= f && f <= 10)) {
					System.out.println("Некорректный ввод");
					f = in.nextInt(); // f - force
				}
				boolean result = p1.kick(p2, f);
				if (result) {
					System.out.println("Success, " + p2.getName() + "'s hp is " + p2.getHp() + ".");
				} else {
					System.out.println("Missed");
				}
			}
			
			if (p2.alive()){
				if (p2 instanceof DummyBot){
					DummyBot tempBot = (DummyBot) p2;
					boolean result = tempBot.kick(p1, 0);
					System.out.println(tempBot.getName() + " is going to kick you...");
					if (result){
						System.out.println("Ohh, " + p1.getName() + "'s hp is " + tempBot.getHp() + ".");
					} else {
						System.out.println("Missed");
					}
					p2 = (Bot) tempBot;
				} else if (p2 instanceof MiddleBot){
					MiddleBot tempBot = (MiddleBot) p2;
					boolean result = tempBot.kick(p1, 0);
					System.out.println(p2.getName() + " is going to kick you...");
					if (result){
						System.out.println("Ohh, " + p1.getName() + "'s hp is " + b.getHp() + ".");
					} else {
						System.out.println("Missed");
					}
					p2 = (Bot) tempBot;
				} else {
					StrongBot tempBot = (StrongBot) p2;
					boolean result = tempBot.kick(p1, 0);
					System.out.println(p2.getName() + " is going to kick you...");
					if (result){
						System.out.println("Ohh, " + p1.getName() + "'s hp is " + b.getHp() + ".");
					} else {
						System.out.println("Missed");
					}
					p2 = (Bot) tempBot;
				}
			}
		}
		AbstractPlayer winner = p1.alive() ? p1: p2;
		System.out.println(winner.getName() + " won.");
		
	}
	
	public static void main(String [] args) {
		final int MAX_HP = (args.length == 1) ? Integer.parseInt(args[0]) : 100;
		GameWithComputer g = new GameWithComputer(MAX_HP);
		g.go();
	}
}
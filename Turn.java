import java.util.Scanner;

public class Turn {
    public static void main(String[] args) {
        Board bord = new Board();
        int turnCounter = 1;
        System.out.println(bord.showField());
        Scanner scanner = new Scanner(System.in);
        if (args.length == 0) {
            while (!bord.hasWon() || !bord.isFull()) {
                char symbol = 'x';
                if (bord.turnNumberIsEven(turnCounter)) {
                    symbol = 'o';
                }
                    try{
                        System.out.println(turnCounter + ". Zug: " + symbol);
                        bord.placePlayerSymbol(scanner.nextInt(), turnCounter);  // exception handling!!!!
                        System.out.println(bord.showField());
                        break;

                    }catch (Exception exception){
                        System.out.println(bord.showField());
                    }
                turnCounter += 1;
                if (bord.hasWon()) {
                    System.out.println("Sieger: " + symbol);
                    break;
                } else if (bord.isFull()) {
                    System.out.println("Kein Sieger");
                    break;
                }
            }
        } else if ((args[0].equals("ki") && args[1] == null)) {
            Bot bot = new Bot();
            while (!bord.hasWon() || !bord.isFull()) {
                char symbol = 'x';
                if (bord.turnNumberIsEven(turnCounter)) {
                    symbol = 'o';
                }
                System.out.println(turnCounter + ". Zug: " + symbol);
                if (symbol == 'x') {
                    bord.placePlayerSymbol(scanner.nextInt(), turnCounter);
                } else {
                    bord.placePlayerSymbol(bot.nextMove(bord), turnCounter);
                }
                System.out.println(bord.showField());
                turnCounter += 1;
                if (bord.hasWon()) {
                    System.out.println("Sieger: " + symbol);
                    break;
                } else if (bord.isFull()) {
                    System.out.println("Kein Sieger");
                    break;
                }
            }
        }
    }
}

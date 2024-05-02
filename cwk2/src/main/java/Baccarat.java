import java.util.Scanner;

public class Baccarat {
  // TODO: Implement your Baccarat simulation program here
  private static final int numDecks = 6;
  private static boolean inputMode = false;

  public static void inputTrue() {
    inputMode = true;
  }

  private BaccaratHand playerHand = new BaccaratHand();
  private BaccaratHand bankHand = new BaccaratHand();

  private int playerWin = 0;
  private int bankWin = 0;
  private int tie = 0;

  public Baccarat() {
    Shoe gameShoe = new Shoe(numDecks);
    gameShoe.shuffle();
    String input = "y";
    Scanner scanner = new Scanner(System.in);
    int roundCount = 0;
    while (gameShoe.size() > 6 && input == "y") {
      playRound(gameShoe);
      if (inputMode) {
        System.out.println("Another round? (y/n): ");
        input = scanner.nextLine();
        roundCount++;
      }
    }
    System.out.println(roundCount + " rounds played");
    System.out.println(playerWin + " player wins");
    System.out.println(bankWin + " bank wins");
    System.out.println(tie + " ties");
  }

  public void playRound(Shoe gameShoe) {
    for (int i = 0; i < 2; i++) {
      playerHand.add(gameShoe.deal());
      bankHand.add(gameShoe.deal());
    }

    gameState();

    if (playerHand.isNatural() || bankHand.isNatural()) {
      roundResult();
    } else {
      if (playerHand.value() < 6) {
        playerHand.add(gameShoe.deal());

        if (bankHand.value() < 3) {
          bankHand.add(gameShoe.deal());
        } else if (bankHand.value() == 3 && playerHand.cardValue(2) != 8) {
          bankHand.add(gameShoe.deal());
        } else if (bankHand.value() == 4 && playerHand.cardValue(2) > 1 && playerHand.cardValue(2) < 8) {
          bankHand.add(gameShoe.deal());
        } else if (bankHand.value() == 5 && playerHand.cardValue(2) > 3 && playerHand.cardValue(2) < 8) {
          bankHand.add(gameShoe.deal());
        } else if (bankHand.value() == 6 && playerHand.cardValue(2) > 5 && playerHand.cardValue(2) < 8) {
          bankHand.add(gameShoe.deal());
        }

      } else {
        if (bankHand.value() < 6) {
          bankHand.add(gameShoe.deal());
        }
      }
      gameState();
      roundResult();
      playerHand.discard();
      bankHand.discard();
    }

  }

  public void gameState() {
    System.out.println("Player: " + playerHand.toString() + " = " + playerHand.value());
    System.out.println("Bank: " + bankHand.toString() + " = " + bankHand.value());
    if (playerHand.isNatural()) {
      System.out.println("Player has a Natural");
    }
    if (bankHand.isNatural()) {
      System.out.println("Bank has a Natural");
    }
  }

  public void roundResult() {
    if (playerHand.value() > bankHand.value()) {
      System.out.println("Player win!");
      playerWin++;
    } else if (playerHand.value() < bankHand.value()) {
      System.out.println("Bank win!");
      bankWin++;
    } else {
      System.out.println("Tie");
      tie++;
    }
  }

  public static void main(String[] args) {

    for (String arg : args) {
      if (arg.equals("-i") || arg.equals("--interactive")) {
        inputTrue();
        break;
      }
    }
    Baccarat game = new Baccarat();
  }
}

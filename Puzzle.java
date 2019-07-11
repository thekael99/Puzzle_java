import java.util.Scanner;

public class Puzzle {
    private Chess chess;

    public Puzzle() {
        this.chess = new Chess();
        this.chess.mix();
    }

    private void show() {
        for (int i = 0; i < 9; i++) {
            if (this.chess.getBox(i) != 0)
                System.out.print(this.chess.getBox(i) + " ");
            else
                System.out.print("_" + " ");
            if (i % 3 == 2)
                System.out.println("");
        }
        System.out.println("");
        System.out.println("8: Swap empty box Up");
        System.out.println("6: Swap empty box Right");
        System.out.println("2: Swap empty box Down");
        System.out.println("4: Swap empty box Left");
        System.out.print("Press: ");
    }

    private void play() {
        Scanner scanner = new Scanner(System.in);
        int trend = -1;

        while (!this.chess.isWin()) {
            this.show();
            trend = Integer.parseInt(scanner.nextLine());
            switch (trend) {
            case 8:
                this.chess.swapUp();
                break;
            case 6:
                this.chess.swapRight();
                break;
            case 2:
                this.chess.swapDown();
                break;
            case 4:
                this.chess.swapLeft();
                break;
            }
        }
        scanner.close();
        for (int i = 0; i < 9; i++) {
            if (this.chess.getBox(i) != 0)
                System.out.print(this.chess.getBox(i) + " ");
            else
                System.out.print("_" + " ");
            if (i % 3 == 2)
                System.out.println("You win!");
        }

    }

    public static void main(String[] args) {
        Puzzle puzzle = new Puzzle();
        puzzle.play();
    }
}
import java.util.Random;

public class Chess {
    private int[] box;
    private int boxZero;
    private int[] solution;
    private final int step = 50;

    public Chess() {
        this.box = new int[9];
        for(int i=0;i<9;i++)
            box[i] = i;
        this.boxZero = 0;
        this.solution = new int[step];
    };

    private int boxUp(int box) {
        if (box > 2)
            return (box - 3);
        return (-1);
    }

    private int boxDown(int box) {
        if (box < 6)
            return (box + 3);
        return (-1);
    }

    private int boxLeft(int box) {
        if (box % 3 != 0)
            return (box - 1);
        return (-1);
    }

    private int boxRight(int box) {
        if (box % 3 != 2)
            return (box + 1);
        return (-1);
    }

    public void swapUp() {
        if (boxUp(this.boxZero) == -1)
            return;
        box[this.boxZero] = box[boxUp(this.boxZero)];
        this.boxZero = boxUp(this.boxZero);
        box[this.boxZero] = 0;
    }
    
    public void swapDown() {
        if (boxDown(this.boxZero) == -1)
            return;
        box[this.boxZero] = box[boxDown(this.boxZero)];
        this.boxZero = boxDown(this.boxZero);
        box[this.boxZero] = 0;
    }
    
    public void swapLeft() {
        if (boxLeft(this.boxZero) == -1)
            return;
        box[this.boxZero] = box[boxLeft(this.boxZero)];
        this.boxZero = boxLeft(this.boxZero);
        box[this.boxZero] = 0;
    }
    
    public void swapRight() {
        if (boxRight(this.boxZero) == -1)
            return;
        box[this.boxZero] = box[boxRight(this.boxZero)];
        this.boxZero = boxRight(this.boxZero);
        box[this.boxZero] = 0;
    }

    public void mix() {
        Random rand = new Random();
        int trend = -1;
        for (int i = 0; i < this.step; i++) {
            trend = rand.nextInt(4);
            switch (trend) {
            case 0:
                swapUp();
                break;
            case 1:
                swapRight();
                break;
            case 2:
                swapDown();
                break;
            case 3:
                swapLeft();
                break;
            }
        }
        //minimizeSolution();
    }

    private boolean sameStep(int i) {
        if ((this.solution[i] % 2) == (this.solution[i + 1] % 2))
            return (true);
        return (false);
    }

    public void minimizeSolution() {
        for (int i = 0; i < this.step - 1; i++) {
            if (sameStep(i)) {
                this.solution[i] = -1;
                this.solution[i + 1] = -1;
            }
        }
    }

    public boolean isWin() {
        for (int i = 0; i < 9; i++)
            if (this.box[i] != i)
                return (false);
        return (true);
    }

    public int getBox(int i) {
        return (this.box[i]);
    }

    public int[] getSolution() {
        return (this.solution.clone());
    }      
}
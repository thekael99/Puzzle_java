import java.util.Random;

public class Chess {
    private int[] box;
    private int boxZero;

    public Chess() {
        this.box = new int[9];
        for(int i=0;i<9;i++)
            box[i] = i;
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

    private void random() {
        boolean check = false;
        Random rand = new Random();
        int trend;
        while(!check)
        {
            trend = rand.nextInt(4);
                   
        }
    }

    public void mix() {
        
    }
    
}
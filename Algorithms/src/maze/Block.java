package maze;

public class Block extends Dot{
    private int dir;          //方向,1向上，2向右，3向下，4向左
    public Block(int x , int y) {
        super(x , y);
        dir = 1;
    }

    public int getDir(){
        return dir;
    }

    public void changeDir(){
        dir++;
    }
}

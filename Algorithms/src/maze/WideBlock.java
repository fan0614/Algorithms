package maze;

public class WideBlock extends Dot {
    private WideBlock parent;

    public WideBlock(int x , int y , WideBlock p){
        super(x , y);
        parent = p;
    }

    public WideBlock getParent(){
        return parent;
    }
}

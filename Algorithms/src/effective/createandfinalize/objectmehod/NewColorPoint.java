package effective.createandfinalize.objectmehod;

import java.awt.*;

//adds a value component without violating the equals contract
public class NewColorPoint {
    private final Point point;
    private final Color color;
    public NewColorPoint(int x,int y,Color color){
        if(color == null)
            throw new NullPointerException();
        point = new Point(x,y);
        this.color = color;
    }
    /*
    * Returns the point-view of this color point
    */
    public Point asPoint(){
        return point;
    }

    @Override
    public boolean equals(Object obj) {
        if(!(obj instanceof NewColorPoint))
            return false;
        NewColorPoint cp = (NewColorPoint) obj;
        return cp.point.equals(point) && cp.point.equals(color);
    }


}

package maze;

import java.util.Stack;

public class Test {
    static private int[][] map = {                           //迷宫地图,1代表墙壁，0代表通路
            {1,1,1,1,1,1,1,1,1,1},
            {1,0,0,1,0,0,0,1,0,1},
            {1,0,0,1,0,0,0,1,0,1},
            {1,0,0,0,0,1,1,0,0,1},
            {1,0,1,1,1,0,0,0,0,1},
            {1,0,0,0,1,0,0,0,0,1},
            {1,0,1,0,0,0,1,0,0,1},
            {1,0,1,1,1,0,1,1,0,1},
            {1,1,0,0,0,0,0,0,0,1},
            {1,1,1,1,1,1,1,1,1,1}
    };

    static private int mapX = map.length - 1;                //地图xy边界

    static private int mapY = map[0].length - 1;

    static private int startX = 1;                           //起点

    static private int startY = 1;

    static private int endX = mapX - 1;                      //终点

    static private int endY = mapY - 1;

    static Stack<Block> stack = new Stack<Block>();
    static Stack<Block> stack2 = new Stack<Block>();
    public static void main(String[] args) {
        reCall();
        while(!stack2.empty()){
            Block b = stack2.pop();
            System.out.print("("+b.getX()+","+b.getY()+"),");
        }
    }
    static public void reCall(){

        Block b = new Block(startX,startY);
        stack.push(b);
        if(startX >= 0 && startX <= mapX && startY >= 0 && startY <= mapY && map[startX][startY] == 0){
            findPath(startX , startY);
        }
    }
    public static void findPath(int x, int y){
        map[x][y] = 1;
        if(x == endX && y == endY) {
            stack.push(new Block(x, y));
            while (!stack.empty()) {
                stack2.push(stack.pop());
            }
//            return;
        }
        stack.push(new Block(x , y));
        if( x - 1 >= 0 && map[x - 1][y] == 0 ){  //可以往上走，那么往上走
            findPath(x - 1 , y);
        }
        if(x + 1 <= mapX && map[x + 1][y] == 0){ //可以往下走，那么往下走
            findPath(x + 1 , y);
        }
        if(y - 1 >= 0 && map[x][y - 1] ==0){     //往左
            findPath(x , y - 1);
        }
        if(y + 1 <= mapY && map[x][y + 1] == 0){
            findPath(x , y + 1);
        }
        if(!stack.empty()){
            stack.pop();
        }
    }
    public static void deepFirst(){

    }

}

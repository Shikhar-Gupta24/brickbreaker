import java.awt.*;

public class Brick {
    private int x,y,length;
    private double cF,m;
    private boolean flag;
    private static final double g = 0.000981;
    public Brick(int x, int y, boolean flag){//Constructors
        this.x = x;
        this.y = y;
        this.flag= flag;
    }
    public boolean getf(){
        return flag;
    }//Getter functions
    public int getx(){
        return x;
    }
    public int gety(){
        return y;
    }
    public void goneFlag(){
        flag= false;
    }
    public void draw(Graphics g){//Draws the rectangle
        if(getf()){
            g.fillRect(x, y, 20, 20);
        }
    }
    public void update(int screenWidth, int screenHeight){//Updates the bricks
        if(getf() != true){
            x=0;
            y=0;
        }
    }
}

import java.awt.*;
import java.util.*;

public class ball {
    private double vy=0.0035;//Velocity vectors
    private double vx=0.0065;
    private int x,y,length;
    private boolean f= true;
    private static final double g = 0.000981;
    public ball(int x, int y){//Constructors
        this.x = x;
        this.y = y;
    }
    public ball(int x, int y, int l, boolean f){
        this.x = x;
        this.y = y;
        length = l;
    }
    public void update(Set<Character> pressedKeys){//Updats the ball
        if(!pressedKeys.isEmpty()) {
            Iterator<Character> it = pressedKeys.iterator();
            while(it.hasNext()) {
                char key = it.next();
                if (key == 'b') {
                }
            }
        }
    }
    public boolean getf(){//getter
        return f;
    }

    public void draw(Graphics g){
        Graphics2D g2d = (Graphics2D) g;
        Font font = new Font("Serif", Font.PLAIN, 12);
        g2d.setFont(font);

        g.fillOval(x, y,length,length);

        if(f==false){
            Font fonts = new Font("Serif", Font.PLAIN, 75);
            g2d.setFont(fonts);
            g2d.drawString("You Lost!", 90, 500);//Figured this out on Java code geeks losing screen
        }
    }
    public void update(int tau,int screenWidth, int screenHeight,int playerleft, int playerright,int playerhight, int playerlow, ArrayList<Brick> m) {
        y += (int) (750 * vy);//Updates the velocity depending on if it interacts with another object
        x += (int) (750 * vx);
        double distance= x-(playerleft+45);
        distance= 0.00015* distance;
        // System.out.println("vy is:" + vy + "Y is:" + y + "Screen Height" + screenHeight);
        if (playerleft <= x && x <=playerright && y <= playerhight && y >= playerlow) {
            vx = distance;
            vy = -vy;
        }
        //if (playerleft+45 <= x && x <=playerright && y <= playerhight && y >= playerlow) {
        //   vx = 0.01;
        //   vy = -vy;
        //  }
        //  if (playerleft+25 <= x && x <=playerright-30 && y <= playerhight && y >= playerlow) {
        //  vx = 0;
        //}
        if (y >= screenHeight) {
            f=false;
            vy=0;
            vx=0;
        }
        if (y < 0) {
            vy = -vy;
        }
        if (x < 0 || x> screenWidth) {
            vx = -vx;
        }
        for (int i = 0; i < m.size() - 1; i++) {
            if(x >= m.get(i).getx() && x <= m.get(i).getx() + 20 && y <= m.get(i).gety() + 20 && y>= m.get(i).gety() +19){
                //System.out.println("X is: " + x + "Y is: " + y);
                vy=-vy;
                m.get(i).goneFlag();
                m.remove(i);
                System.out.println(m.size());
            }
            if((x>= m.get(i).getx() && x<=m.get(i).getx()+2 && y<=m.get(i).gety()+19 && y>= m.get(i).gety()+1)){
                vx=-vx;
                m.remove(i);
            }
            if((x>= m.get(i).getx()+18 && x<=m.get(i).getx()+20 && y<=m.get(i).gety()+19 && y>= m.get(i).gety()+1)){
                vx=-vx;
                m.remove(i);
            }
            if(x >= m.get(i).getx() && x <= m.get(i).getx() + 20 && y <= m.get(i).gety()+2 && y>= m.get(i).gety()){
                vy=-vy;
                m.get(i).goneFlag();
                m.remove(i);
                System.out.println(m.size());
            }
        }
    }
}


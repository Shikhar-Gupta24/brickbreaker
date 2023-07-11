import java.awt.*;
import javax.swing.*;
import javax.swing.Timer;
import java.awt.event.*;
import java.util.*;
import java.util.List;

public class GUIpanel extends JPanel implements ActionListener, MouseListener, MouseMotionListener, KeyListener{
    private static final int tau = 10;

    private Timer clock = new Timer(tau, this);
    public List<ball> circle = new ArrayList<>();
    public ArrayList<Brick> bricks = new ArrayList<>();
    private Brick br;//Creates main variables of the program
    private Player p;
    private ball b;
    private final Set<Character> pressedKeys = new HashSet<>();
    private boolean game =true;
    private int points;


    private int mouse_x, mouse_y, screenWidth, screenHeight;
    public GUIpanel(int width, int height){
        setFocusable(true);
        setPreferredSize(new Dimension(width, height));
        screenWidth = width;
        screenHeight = height;
        for(int i=15; i< screenWidth-25; i +=25) {//Generates the brick objects
            for (int j = 25; j < screenHeight- 300; j += 100) {
                bricks.add(new Brick(i, j, true));
            }
        }
        p = new Player(width / 2, height -25 );//Creates objects
        b = new ball(width/2,height -75);
        points =bricks.size();//Sets up the point variable

        clock.start();
        addMouseListener(this);
        addMouseMotionListener(this);
        addKeyListener(this);
    }

    public void paintComponent(Graphics g){
        super.paintComponent(g);
        if(circle.isEmpty()){//Paints the start screen
            Graphics2D g2d = (Graphics2D) g;
            Font font = new Font("Serif", Font.PLAIN, 75);
            g2d.setFont(font);
            g2d.drawString("Press B to Start!", (screenWidth/2)-250,(screenHeight/2)+50);//Figured this out on Java code geeks
        }
        if(bricks.isEmpty()){//Prints the winning screen
            Graphics2D g2d = (Graphics2D) g;
            Font font = new Font("Serif", Font.PLAIN, 75);
            g2d.setFont(font);
            g2d.drawString("You Won!", (screenWidth/2)-250,(screenHeight/2)+50);//Figured this out on Java code geeks
        }
        if(!bricks.isEmpty()){//Prints the score of the game
            Graphics2D g2d = (Graphics2D) g;
            Font font = new Font("Serif", Font.PLAIN, 20);
            g2d.setFont(font);
            g2d.drawString("Score: " + (points-bricks.size()), 380,675);//Figured this out on Java code geeks
        }
        for(Brick br: bricks){//Draws the bricks
            if(br.getf()){
                br.draw(g);
            }
        }
        for(ball b: circle){//Draws the circle
            b.draw(g);
        }
        p.draw(g);//Draws the player object
    }

    public void mouseClicked(MouseEvent e){
    }
    public void mouseEntered(MouseEvent e){};
    public void mouseExited(MouseEvent e){};
    public void mousePressed(MouseEvent e){};
    public void mouseReleased(MouseEvent e){};

    public void mouseDragged(MouseEvent e){
        mouse_x = e.getX();
        mouse_y = e.getY();
        repaint();
    }
    public void mouseMoved(MouseEvent e){
        mouse_x = e.getX();
        mouse_y = e.getY();
        repaint();
    }

    public void keyPressed(KeyEvent e){
        pressedKeys.add((e.getKeyChar() + "").toLowerCase().charAt(0));
        p.update(pressedKeys);
        if(!pressedKeys.isEmpty()) {
            Iterator<Character> it = pressedKeys.iterator();
            while(it.hasNext()) {
                char key = it.next();
                if (key == 'b') {//Spawns a ball if you press b
                    circle.add(new ball((getWidth()/2)-100,getHeight()-80,15,game));
                }
            }
        }
        repaint();
    }
    public void keyReleased(KeyEvent e){
        pressedKeys.remove((e.getKeyChar() + "").toLowerCase().charAt(0));
    }
    public void keyTyped(KeyEvent e){}

    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == clock) {
            for (ball b : circle) {//Updates the circle and bricks
                b.update(tau, screenWidth, screenHeight, p.getxl(), p.getxr(), p.getyh(), p.getyl(), bricks);
            }
            for (Brick br : bricks) {
                br.update(screenWidth, screenHeight);
            }
            repaint();
        }

    }
}

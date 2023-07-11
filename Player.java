import java.awt.*;
import java.util.Set;
import java.util.Iterator;

public class Player {
    private int player_x, player_y;

    public Player(int x, int y){
        player_x = x;
        player_y = y;
    }

    public void update(Set<Character> pressedKeys){
        if(!pressedKeys.isEmpty()) {
            Iterator<Character> it = pressedKeys.iterator();
            while(it.hasNext()) {
                char key = it.next();
                if (key == 'a') {//Moves the player left and right
                    player_x -= 25;
                }
                if (key == 'd') {
                    player_x += 25;
                }
                if(player_x>425){//Makes barriers for if they go too right or left
                    player_x = 425;
                }
                if(player_x<0){
                    player_x = 0;
                }
            }
        }
    }
    public int getxl(){//Getter functions for the hitbox of the bricks
        return player_x-5;
    }
    public int getxr(){
        return player_x+75;
    }
    public int getyh(){
        return player_y+5;
    }
    public int getyl(){
        return player_y-5;
    }

    public void draw(Graphics g){//Draws the rectangle player object
        g.fillRect(player_x, player_y, 75, 10);
    }

}
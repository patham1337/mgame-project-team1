import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
// latest
public class Monster {
    public int x;
    public int y;
    boolean directionX = true;
    boolean directionY = true;

    char block = '\u2588';

    public Monster(Terminal terminal, int x, int y) throws IOException {
        this.x = x;
        this.y = y;

        terminal.setCursorPosition(x,y);
        terminal.setForegroundColor(TextColor.ANSI.YELLOW);
        terminal.putCharacter('X');
        terminal.flush();
    }



    public void move(Terminal terminal, Maze maze, int playerx ,int playery) throws IOException {

        int oldMonsterPositionX;
        int oldMonsterPositionY;

        if(playerx == this.x && playery == this.y) {
            GameOver.isGameOver = true;
        }

        oldMonsterPositionX = this.x;
        oldMonsterPositionY = this.y;

        terminal.setCursorPosition(this.x, this.y);  // Remove monster
        terminal.putCharacter(' ');

        if (maze.hitMaze(this.x, this.y) == true){
            terminal.setCursorPosition(x, y);
            terminal.setForegroundColor(TextColor.ANSI.GREEN);
            terminal.putCharacter(block);
        }

        if (directionX == true) {
            this.x = x + 1;
        }
        if (directionX == false) {
            this.x = x - 1;
        }
        if (directionY == true) {
            this.y = y + 1;
        }
        if (directionY == false) {
            this.y = y - 1;
        }


        if (this.x > 79) {
            this.x -= 1;
            directionX = !directionX;
        }

        if (this.x < 0) {
            this.x += 1;
            directionX = !directionX;
        }

        if (this.y > 23) {
            this.y -= 1;
            directionY = !directionY;
        }

        if (this.y < 0) {
            this.y += 1;
            directionY = !directionY;
        }

        if (maze.hitMaze(this.x, this.y) == true) {
            if (oldMonsterPositionX > x) {
                if (maze.isVertical()) {
                    directionX = true;
                } else {
                    directionX = false;
                }
            }


            if (oldMonsterPositionX < x) {
                if (maze.isVertical()) {
                    directionX = false;
                } else {
                    directionX = true;
                }
            }

            if (oldMonsterPositionY > y) {
                if (maze.isVertical()) {
                    directionY = false;
                } else {
                    directionY = true;
                }
            }

            if (oldMonsterPositionY < y) {
                if (maze.isVertical()) {
                    directionY = true;
                } else {
                    directionY = false;
                }
            }
        }



/*
if(this.x > 79 || maze.hitMaze(this.x, this.y)) {
            this.x -= 1;
            directionX = !directionX;

        if(this.x <  0 || maze.hitMaze(this.x, this.y)) {
            this.x += 1;
            directionX = !directionX;

         if(this.y > 23 || maze.hitMaze(this.x, this.y)) {
            this.y -= 1;
            directionY = !directionY;

         if(this.y < 0 || maze.hitMaze(this.x, this.y)) {
            this.y += 1;
            directionY = !directionY;
 */

        if (maze.hitMaze(this.x, this.y) == true) {
            terminal.setCursorPosition(x, y);
            terminal.setForegroundColor(TextColor.ANSI.GREEN);
            terminal.putCharacter('X');
            terminal.flush();
        } else {

            terminal.setCursorPosition(x, y);
            terminal.setForegroundColor(TextColor.ANSI.WHITE);
            terminal.putCharacter('X');
            terminal.flush();
        }
    }


}


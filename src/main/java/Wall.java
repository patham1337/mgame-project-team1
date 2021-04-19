import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;
import java.util.ArrayList;


public class Wall {

    char block = '\u2588';

    public ArrayList<Position> wallblocks = new ArrayList();
    public boolean horizontal;
    public boolean vertical;

    public Wall(Terminal terminal, int startPosX, int startPosY, int endPosX, int endPosY) throws IOException {

        if (startPosY == endPosY)        //    Horizontal wall
        {
            this.horizontal = true;
            this.vertical = false;
            for (int i = startPosX; i <= endPosX; i++) {
                wallblocks.add(new Position(i, startPosY)) ;
            }
        }

        if (startPosX == endPosX)        //    Vertical wall
        {
            this.vertical = true;
            this.horizontal = false;
            for (int i = startPosY; i <= endPosY; i++) {
                wallblocks.add(new Position(startPosX, i));
            }
        }

        for(Position position : wallblocks) {
            terminal.setCursorPosition(position.x, position.y);
            terminal.putCharacter(block);
        }
    }

    public boolean hitWall(Wall wall, int x, int y) {

        boolean hit = false;

        for (Position position : wall.wallblocks) {
            if (position.x == x && position.y == y) {
                hit = true;
                break;
            }
        }
        return  hit;
    }

    public  boolean isHorizontal() {
        return this.horizontal;
    }

    public boolean isVertical() {
        return this.vertical;
    }
}

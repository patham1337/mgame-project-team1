import com.googlecode.lanterna.terminal.Terminal;

import java.io.IOException;


public class Wall {

    char block = '\u2588';

    public int startPosX;
    public int startPosY;
    public int endPosX;
    public int endPosY;


    public Wall(Terminal terminal, int startPosX, int startPosY, int endPosX, int endPosY) throws IOException {
        this.startPosX = startPosX;
        this.startPosY = startPosY;
        this.endPosX = endPosX;
        this.endPosY = endPosY;

        if (startPosY == endPosY)        //    Horizontal wall
        {
            for (int i = startPosX; i <= endPosX; i++) {
                terminal.setCursorPosition(i, startPosY);
                terminal.putCharacter(block);
            }
        }

        if (startPosX == endPosX)        //    Vertical wall
        {
            for (int i = startPosY; i <= endPosY; i++){
            terminal.setCursorPosition(startPosX, i);
            terminal.putCharacter(block);
            }
        }
    }

}

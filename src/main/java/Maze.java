import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.ArrayList;


public class Maze {

    static ArrayList<Wall> maze  = new ArrayList();
    static boolean vertical;
    static boolean horizontal;


    public Maze(Terminal terminal) throws IOException {
        terminal.setForegroundColor(TextColor.ANSI.GREEN);

        //Horizontal
        maze.add(new Wall(terminal, 1, 2, 25, 2));
        maze.add(new Wall(terminal, 1, 5, 5, 5));
        maze.add(new Wall(terminal, 10, 5, 20, 5));
        maze.add(new Wall(terminal, 25,12, 35, 12));
        maze.add(new Wall(terminal, 20,15, 30, 15));
        maze.add(new Wall(terminal, 35,20, 55, 20));
        maze.add(new Wall(terminal, 30,23, 60, 23));
        maze.add(new Wall(terminal, 56, 2, 75, 2));
        maze.add(new Wall(terminal, 60,4, 70, 4));
        maze.add(new Wall(terminal, 25,5, 55, 5));
        maze.add(new Wall(terminal, 25, 8, 55, 8));
        maze.add(new Wall(terminal, 10, 17, 30, 17));
        maze.add(new Wall(terminal, 5,20, 30, 20));

        //Vertical
        maze.add(new Wall(terminal, 20,6, 20, 14));
        maze.add(new Wall(terminal, 25,3, 25, 5));
        maze.add(new Wall(terminal, 25,9, 25, 11));
        maze.add(new Wall(terminal, 30,16, 30, 16));
        maze.add(new Wall(terminal, 30,21, 30, 22));
        maze.add(new Wall(terminal, 35,13, 35, 19));
        maze.add(new Wall(terminal, 70,5, 70, 20));
        maze.add(new Wall(terminal, 75,3, 75, 20));
        maze.add(new Wall(terminal, 55,2, 55, 4));
        maze.add(new Wall(terminal, 55,9, 55, 13));
        maze.add(new Wall(terminal, 55,15, 55, 19));
        maze.add(new Wall(terminal, 60,5, 60, 24));
        maze.add(new Wall(terminal, 5,6, 5, 19));
        maze.add(new Wall(terminal, 10,6, 10, 8));
        maze.add(new Wall(terminal, 10,10, 10, 16));

        terminal.flush();
    }

    public boolean isVertical() {
        return vertical;
    }

    public boolean isHorizontal() {
        return horizontal;
    }

    public boolean hitMaze(int x, int y) {

        boolean hit = false;

        for (Wall wall : maze) {
            hit = wall.hitWall(wall, x,y);
            if(hit == true) {
                if(wall.isVertical()) {vertical = true; horizontal = false;}
                if(wall.isHorizontal()) {horizontal = true; vertical = false;}
                break;
            }
        }
        return  hit;
    }
}

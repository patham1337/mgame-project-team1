import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.ArrayList;


public class Maze {

    static ArrayList<Wall> maze  = new ArrayList();

   public Maze(Terminal terminal) throws IOException {
       terminal.setForegroundColor(TextColor.ANSI.GREEN);
       maze.add(new Wall(terminal, 1, 2, 45, 2));
       maze.add(new Wall(terminal, 1,5, 40, 5));
       maze.add(new Wall(terminal, 40,5, 40, 20));
       maze.add(new Wall(terminal, 45,2, 45, 20));
       terminal.flush();

   }
   
   public boolean hitWall(int x, int y) {

       boolean hit = false;

       for (Wall wall : maze) {

           if ((wall.startPosY == wall.endPosY) && wall.startPosY == y)        //    Horizontal wall and Y is correct
           {
               for (int i = wall.startPosX; i <= wall.endPosX; i++) {
                   if(i == x) {
                       hit = true;
                   }
               }
           }

           if (wall.startPosX == wall.endPosX && wall.startPosX == x)        //    Vertical wall and X is correct
           {
               for (int i = wall.startPosY; i <= wall.endPosY; i++){
                   if(i == y) {
                       hit = true;
                   }
               }
           }
       }
       return  hit;
   }
   
}

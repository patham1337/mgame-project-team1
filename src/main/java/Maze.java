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
   
   public boolean hitMaze(int x, int y) {

       boolean hit = false;

           for (Wall wall : maze) {
               hit = wall.hitWall(wall, x,y);
               if(hit == true) {
                   break;
               }
           }
       return  hit;
       }
}

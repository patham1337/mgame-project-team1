import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.ArrayList;


public class Maze {

   static ArrayList<Wall> maze  = new ArrayList();

   public Maze(Terminal terminal) throws IOException {
       terminal.setForegroundColor(TextColor.ANSI.GREEN);
       maze.add(new Wall(terminal, 55, 2, 75, 2));
       maze.add(new Wall(terminal, 60,4, 70, 4));
       maze.add(new Wall(terminal, 70,4, 70, 20));
       maze.add(new Wall(terminal, 75,2, 75, 20));
       maze.add(new Wall(terminal, 55,2, 55, 20));
       maze.add(new Wall(terminal, 60,4, 60, 25));

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

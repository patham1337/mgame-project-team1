import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.ArrayList;


public class Maze {


   static ArrayList<Wall> maze  = new ArrayList();

   public Maze(Terminal terminal) throws IOException {
       terminal.setForegroundColor(TextColor.ANSI.GREEN);

       maze.add(new Wall(terminal, 1,5, 12, 5)); //Linje 1 nedre
       maze.add(new Wall(terminal, 14,5, 20, 5)); //Linje 1 nedre
       maze.add(new Wall(terminal, 1, 2, 25, 2)); //Linje 1 övre
       maze.add(new Wall(terminal, 20,5, 20, 10)); //Linje 2 vänster, hack 1
       maze.add(new Wall(terminal, 20,12, 20, 15)); //Linje 2 vänster, hack 1
       maze.add(new Wall(terminal, 25,4, 25, 12)); //Linje 2 höger

       maze.add(new Wall(terminal, 25,12, 30, 12)); //Linje 3 övre
       maze.add(new Wall(terminal, 33,12, 35, 12)); //Linje 3 övre, hack
       maze.add(new Wall(terminal, 20,15, 24, 15)); //Linje 3 nedre, hack
       maze.add(new Wall(terminal, 27,15, 30, 15)); //Linje 3 nedre
       maze.add(new Wall(terminal, 30,15, 30, 23)); //Linje 4 vänster
       maze.add(new Wall(terminal, 35,12, 35, 16)); //Linje 4 höger, hack
       maze.add(new Wall(terminal, 35,18, 35, 20)); //Linje 4 höger

       maze.add(new Wall(terminal, 35,20, 40, 20)); //Linje 5 övre, hack
       maze.add(new Wall(terminal, 43,20, 50, 20)); //Linje 5 övre
       maze.add(new Wall(terminal, 53,20, 55, 20)); //Linje 5 övre
       maze.add(new Wall(terminal, 30,23, 60, 23)); //Linje 5 nedre

       maze.add(new Wall(terminal, 55,2, 55, 6)); //Linje vänster, hack
       maze.add(new Wall(terminal, 55,8, 55, 14)); //Linje vänster
       maze.add(new Wall(terminal, 55,16, 55, 20)); //Linje vänster, hack
       maze.add(new Wall(terminal, 60,4, 60, 6)); //Linje höger, hack
       maze.add(new Wall(terminal, 60,8, 60, 13)); //Linje höger, hack
       maze.add(new Wall(terminal, 60,15, 60, 25)); //Linje höger
       maze.add(new Wall(terminal, 55, 2, 75, 2)); //Linje övre
       maze.add(new Wall(terminal, 60,4, 66, 4)); //Linje undre
       maze.add(new Wall(terminal, 68,4, 70, 4)); //Linje undre
       maze.add(new Wall(terminal, 70,4, 70, 11)); //Linje vänster
       maze.add(new Wall(terminal, 70,13, 70, 20)); //Linje vänster
       maze.add(new Wall(terminal, 75,2, 75, 20)); //Linje höger





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

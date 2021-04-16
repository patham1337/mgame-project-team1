import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.ArrayList;


public class Maze {


   static ArrayList<Wall> maze  = new ArrayList();

   public Maze(Terminal terminal) throws IOException {
       terminal.setForegroundColor(TextColor.ANSI.GREEN);

       maze.add(new Wall(terminal, 1, 2, 25, 2)); //Linje 1 övre
      // maze.add(new Wall(terminal, 1,5, 20, 5)); //Linje 1 nedre
       maze.add(new Wall(terminal, 1, 5, 5, 5)); //Linje 1 nedre
       maze.add(new Wall(terminal, 10, 5, 20, 5)); //Linje 1 nedre

       maze.add(new Wall(terminal, 20,5, 20, 15)); //Linje 2 vänster
       //maze.add(new Wall(terminal, 25,2, 25, 12)); //Linje 2 höger
       maze.add(new Wall(terminal, 25,2, 25, 5)); //Ny rad
       maze.add(new Wall(terminal, 25,8, 25, 12)); //Ny rad

       maze.add(new Wall(terminal, 25,12, 35, 12)); //Linje 3 övre
       maze.add(new Wall(terminal, 20,15, 30, 15)); //Linje 3 nedre
       maze.add(new Wall(terminal, 30,15, 30, 23)); //Linje 4 vänster
       maze.add(new Wall(terminal, 35,12, 35, 20)); //Linje 4 höger

       maze.add(new Wall(terminal, 35,20, 55, 20)); //Linje 5 övre
       maze.add(new Wall(terminal, 30,23, 60, 23)); //Linje 5 nedre

       maze.add(new Wall(terminal, 55, 2, 75, 2));
       maze.add(new Wall(terminal, 60,4, 70, 4));
       maze.add(new Wall(terminal, 70,4, 70, 20));
       maze.add(new Wall(terminal, 75,2, 75, 20));
       //maze.add(new Wall(terminal, 55,2, 55, 20));
       maze.add(new Wall(terminal, 55,2, 55, 5));//Ny rad
       maze.add(new Wall(terminal, 55,8, 55, 20)); //Ny rad

       maze.add(new Wall(terminal, 60,4, 60, 25));

       //Nya rader
       maze.add(new Wall(terminal, 25,5, 55, 5)); //Linje övre
       maze.add(new Wall(terminal, 25, 8, 55, 8)); //Linje nedre

       maze.add(new Wall(terminal, 5,5, 5, 20)); //Linje vänster
       maze.add(new Wall(terminal, 10,5, 10, 17)); //Linje höger

       maze.add(new Wall(terminal, 10, 17, 30, 17)); //Linje övre
       maze.add(new Wall(terminal, 5,20, 30, 20)); //Linje  nedre

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

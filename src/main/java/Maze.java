import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.terminal.Terminal;
import java.io.IOException;
import java.util.ArrayList;


public class Maze {


   static ArrayList<Wall> maze  = new ArrayList();

   public Maze(Terminal terminal) throws IOException {
       terminal.setForegroundColor(TextColor.ANSI.GREEN);

       maze.add(new Wall(terminal, 1, 2, 25, 2)); //Horisontell  1 övre okej
       maze.add(new Wall(terminal, 1, 5, 5, 5)); //Horisontell 1 nedre okej
       maze.add(new Wall(terminal, 10, 5, 20, 5)); //Linje 1 nedre

       maze.add(new Wall(terminal, 20,6, 20, 14)); //Vertikal 3 ändrad
       maze.add(new Wall(terminal, 25,3, 25, 5)); //Övre vertikal 1 ändrad
       maze.add(new Wall(terminal, 25,9, 25, 11)); //Vertikal höger

       maze.add(new Wall(terminal, 25,12, 35, 12)); //Horisontell
       maze.add(new Wall(terminal, 20,15, 30, 15)); //Linje 3 nedre
       maze.add(new Wall(terminal, 30,16, 30, 16)); //Vertikal kort
       maze.add(new Wall(terminal, 30,21, 30, 22));//Vertikal kort
       maze.add(new Wall(terminal, 35,13, 35, 19)); //Vertikal höger

       maze.add(new Wall(terminal, 35,20, 55, 20)); //Linje 5 övre
       maze.add(new Wall(terminal, 30,23, 60, 23)); //Linje 5 nedre

       maze.add(new Wall(terminal, 56, 2, 75, 2)); //Horintell 3 övre
       maze.add(new Wall(terminal, 60,4, 70, 4));
       maze.add(new Wall(terminal, 70,5, 70, 20));
       maze.add(new Wall(terminal, 75,3, 75, 20));
       //maze.add(new Wall(terminal, 55,2, 55, 20));
       maze.add(new Wall(terminal, 55,2, 55, 4));//Vertikal övre 2
       maze.add(new Wall(terminal, 55,9, 55, 19)); //Vertikal vänster

       maze.add(new Wall(terminal, 60,5, 60, 24));

       //Nya rader
       maze.add(new Wall(terminal, 25,5, 55, 5)); //Horisontell övre 2 ändrad
       maze.add(new Wall(terminal, 25, 8, 55, 8)); //Linje nedre

       maze.add(new Wall(terminal, 5,6, 5, 19)); //Vertikal 1 vänster
       maze.add(new Wall(terminal, 10,6, 10, 16)); //Vertikal 1 höger

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

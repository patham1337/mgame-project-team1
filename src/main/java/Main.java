import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;

import java.util.ArrayList;
import java.util.List;



public class Main {
//håkan
    public static void main(String[] args) throws Exception {
        char block = '\u2588';

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();

        char playerCharacter = '\u263a';
        terminal.setCursorVisible(false);
        Position player = new Position(3,3);
        terminal.setCursorPosition(player.x, player.y);
        terminal.putCharacter(playerCharacter);

        Maze maze = new Maze(terminal);

        Position goal = new Position(73, 20);
        terminal.setCursorPosition(goal.x, goal.y);
        terminal.setForegroundColor(TextColor.ANSI.RED);
        terminal.putCharacter(block);
        terminal.flush();



        List<Position> monsters = new ArrayList<>();
        //monsters.add(new Position(3, 3));
        //monsters.add(new Position(23, 23));
        //monsters.add(new Position(23, 3));
        monsters.add(new Position(40, 10));


        boolean continueReadingInput = true;
        while (continueReadingInput) {
            KeyStroke keyStroke = null;

            do {
                keyStroke = terminal.pollInput();
            }
            while (keyStroke == null);

            Character c = keyStroke.getCharacter(); // used Character instead of char because it might be null
            if (c == Character.valueOf('q')) { continueReadingInput = false;
                System.out.println("quit");
            }

            Position oldPosition = new Position(player.x, player.y);

            switch (keyStroke.getKeyType()) {
                case ArrowDown:
                    player.y += 1;
                    if(player.y > 23 || maze.hitMaze(player.x, player.y)) {
                        player.y -= 1;
                    }
                    break;
                case ArrowUp:
                    player.y -= 1;
                    if(player.y < 0 || maze.hitMaze(player.x, player.y)) {
                        player.y += 1;
                    }
                    break;
                case ArrowRight:
                    player.x += 1;
                    if(player.x > 79 || maze.hitMaze(player.x, player.y)) {
                        player.x -= 1;
                    }
                    break;
                case ArrowLeft:
                    player.x -= 1;
                    if(player.x < 0 || maze.hitMaze(player.x, player.y)) {
                        player.x += 1;
                    }
                    break;
            }

            // Draw player
            terminal.setCursorPosition(oldPosition.x, oldPosition.y);
            terminal.putCharacter(' ');
            terminal.setCursorPosition(player.x, player.y);
            terminal.setForegroundColor(TextColor.ANSI.WHITE);
            terminal.putCharacter(playerCharacter);

            // If at goal
            if(goal.x == player.x  && goal.y == player.y)
            {
                continueReadingInput = false;
                terminal.bell();
                System.out.println("GAME OVER! YOU ARE THE WINNER!");
            }





            // Handle monsters
            for (Position monster : monsters) {
                terminal.setCursorPosition(monster.x, monster.y);
                terminal.putCharacter(' ');



                if (player.x > monster.x) {
                    monster.x++;
                    if(maze.hitMaze(monster.x, monster.y)) {
                        monster.x = 40;
                        monster.y = 10;
                    }
                } else if (player.x < monster.x) {
                    monster.x--;
                    if(maze.hitMaze(monster.x, monster.y)) {
                        monster.x = 40;
                        monster.y = 10;
                    }
                }
                if (player.y > monster.y) {
                    monster.y++;
                    if(maze.hitMaze(monster.x, monster.y)) {
                        monster.x = 40;
                        monster.y = 10;
                    }
                } else if (player.y < monster.y) {
                    monster.y--;
                    if(maze.hitMaze(monster.x, monster.y)) {
                        monster.x = 40;
                        monster.y = 10;
                    }
                }

                terminal.setCursorPosition(monster.x, monster.y);
                terminal.putCharacter('X');
            }




            // Is the player alive?
            for (Position monster : monsters) {
                if (monster.x == player.x && monster.y == player.y) {
                    continueReadingInput = false;
                    terminal.bell();
                    System.out.println("GAME OVER!");
                }
            }


            terminal.flush();
        }
    }

}

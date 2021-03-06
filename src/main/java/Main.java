import com.googlecode.lanterna.TextColor;
import com.googlecode.lanterna.input.KeyStroke;
import com.googlecode.lanterna.terminal.DefaultTerminalFactory;
import com.googlecode.lanterna.terminal.Terminal;
import java.util.Random;

public class Main {

    public static void main(String[] args) throws Exception {

        char block = '\u2588';

        DefaultTerminalFactory terminalFactory = new DefaultTerminalFactory();
        Terminal terminal = terminalFactory.createTerminal();
        Random rand = new Random();

        char playerCharacter = '\u263a';
        terminal.setCursorVisible(false);
        Position player = new Position(2,3);
        terminal.setCursorPosition(player.x, player.y);
        terminal.putCharacter(playerCharacter);

        Maze maze = new Maze(terminal);

        Position goal = new Position(73, 20);
        terminal.setCursorPosition(goal.x, goal.y);
        terminal.setForegroundColor(TextColor.ANSI.RED);
        terminal.putCharacter(block);
        terminal.flush();

        Monster monster = new Monster(terminal, rand.nextInt(79),rand.nextInt(23));

        boolean continueReadingInput = true;
        while (continueReadingInput) {
            KeyStroke keyStroke = null;

            do {
                keyStroke = terminal.pollInput();
                Thread.sleep(100);
                int x = player.x;
                int y = player.y;
                monster.move(terminal, maze, x, y);
            }
            while (keyStroke == null);

            Character c = keyStroke.getCharacter();
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

            if (monster.x == player.x && monster.y == player.y) {
                continueReadingInput = false;
                terminal.bell();
                System.out.println("GAME OVER!");
            }

            terminal.flush();
        }
    }

}

import java.util.Random;

class Game {
    private Board board;
    private Player[] players;
    private int turn;

    public Game() {
        board = new Board();
        turn = new Random().nextInt(2);
        players = new Player[Color.values().length];
        for (int i = 0; i < Color.values().length; i++) {
            players[i] = new Player(Color.values()[i], board);
        }
    }

    public void play() {
        boolean isWinner = false;
        do {
            board.show();
            players[turn].move();
            isWinner = players[turn].isWinner();
            changeTurn();
        } while (!isWinner);
    }

    private void changeTurn() {
        turn = (turn + 1) % 2;
    }
}

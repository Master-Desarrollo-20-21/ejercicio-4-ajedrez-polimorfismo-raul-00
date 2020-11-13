
class Player {
    private Color color;
    private Board board;
    private boolean winner;

    public Player(Color color, Board board) {
        this.color = color;
        this.board = board;
        this.winner = false;
    }

    public void move() {
        Console console = new Console();
        console.outln(">> Mueven las " + color.toString());
        Coordinate origin = new Coordinate();
        Coordinate target = new Coordinate();
        boolean isValidMovement = false;
        do {
            origin.read("Indica la coordenada de la pieza a mover (ej.: a2): ");
            target.read("Indica la coordenada de destino (ej.: a2): ");
            isValidMovement = board.isValidMovement(origin, target, color);
            if (!isValidMovement) {
                console.outln("¡¡Movimiento no válido!!");
            }
        } while (!isValidMovement);
        checkWinner(target);
        board.move(origin, target);
    }

    private void checkWinner(Coordinate target) {
        if (board.hasKing(target)) {
            new Console().outln("¡¡¡Las " + color.toString() + " ganan!!! :))");
            this.winner = true;
        }
    }

    public boolean isWinner() {
        return winner;
    }
}

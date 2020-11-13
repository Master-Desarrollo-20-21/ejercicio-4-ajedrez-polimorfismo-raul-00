class Chess {
    private Game game;

    public Chess() {
        game = new Game();
    }

    private void play() {
        do {
            game.play();
        } while (isResumed());
    }

    private boolean isResumed() {
        Console console = new Console();
        String answer;
        do {
            console.out("¿Empezar una nueva partida? (s/n):");
            answer = console.inString();
        } while (!answer.equalsIgnoreCase("s") && !answer.equalsIgnoreCase("n"));
        return answer.equalsIgnoreCase("s");
    }

    public static void main(String[] args) throws Exception {
        new Chess().play();
    }
}

class Coordinate {
    private int row;
    private int column;

    public Coordinate(int row, int column) {
        this.row = row;
        this.column = column;
    }

    public Coordinate() {
    }

    public boolean equals(Coordinate coordinate) {
        return row == coordinate.row && column == coordinate.column;
    }

    public boolean equalRow(Coordinate coordinate) {
        return row == coordinate.row;
    }

    private boolean equalColumn(Coordinate coordinate) {
        return column == coordinate.column;
    }

    private boolean equalDiagonal(Coordinate coordinate) {
        return !equalRow(coordinate) && !equalColumn(coordinate);
    }

    public int distance(Coordinate coordinate) {
        if (equalDiagonal(coordinate)) {
            return rowDistance(coordinate);
        }
        return rowDistance(coordinate) + columDistance(coordinate);
    }

    public int columDistance(Coordinate coordinate) {
        return Math.abs(column - coordinate.column);
    }

    public int rowDistance(Coordinate coordinate) {
        return Math.abs(row - coordinate.row);
    }

    public void read(String title) {
        Console console = new Console();
        String answer;
        do {
            console.out(title);
            answer = console.inString();
        } while (!isValidAnswer(answer));
        row = Integer.parseInt(Character.toString(answer.charAt(1)));
        column = Math.abs((int) answer.charAt(0) - (int) 'a');
    }

    private boolean isValidAnswer(String answer) {
        if (answer.length() != 2) {
            return false;
        }
        if (!isValidColumn(answer.charAt(0))) {
            return false;
        }
        if (!isValidRow(answer.charAt(1))) {
            return false;
        }
        return true;
    }

    private boolean isValidRow(char row) {
        if (!Character.isDigit(row)) {
            return false;
        }
        int rowNumber = Integer.parseInt(Character.toString(row));
        if (rowNumber < 0 || rowNumber > 7) {
            return false;
        }
        return true;
    }

    private boolean isValidColumn(char column) {
        column = Character.toString(column).toLowerCase().charAt(0);
        if ((int) column < (int) 'a' || (int) column > (int) 'h') {
            return false;
        }
        return true;
    }

    public boolean behind(Coordinate coordinate) {
        return row < coordinate.row;
    }

    public int getRow() {
        return row;
    }

    public int getColumn() {
        return column;
    }
}

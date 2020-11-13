import java.util.List;

class King extends Piece {
    public King(Color color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    public char getPrintable() {
        return this.color == Color.WHITE ? '\u2654' : '\u265A';
    }

    @Override
    protected boolean isValidMovement(Coordinate origin, Coordinate target) {
        if (origin.distance(target) == 1) {
            return true;
        }
        return false;
    }

    @Override
    protected List<Coordinate> getCoordinatesBetween(Coordinate origin, Coordinate target) {
        return null;
    }

    @Override
    protected boolean isKing() {
        return true;
    }
}

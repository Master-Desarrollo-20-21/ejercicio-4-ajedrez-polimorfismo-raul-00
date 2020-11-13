import java.util.ArrayList;
import java.util.List;

class Pawn extends Piece {
    public Pawn(Color color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    public char getPrintable() {
        return this.color == Color.WHITE ? '\u2659' : '\u265F';
    }

    @Override
    protected boolean isValidMovement(Coordinate origin, Coordinate target) {
        if (origin.distance(target) > 2) {
            return false;
        }
        if (origin.distance(target) == 2 && this.moved) {
            return false;
        }
        if (color == Color.WHITE && origin.behind(target)) {
            return false;
        }
        if (color == Color.BLACK && !origin.behind(target)) {
            return false;
        }
        if (origin.equalRow(target)) {
            return false;
        }
        return true;
    }

    @Override
    protected List<Coordinate> getCoordinatesBetween(Coordinate origin, Coordinate target) {
        Coordinate start = origin;
        if (target.behind(origin)) {
            start = target;
        }
        List<Coordinate> coordinates = new ArrayList<Coordinate>();
        for (int i = 1; i < start.distance(target); i++) {
            coordinates.add(new Coordinate(start.getRow() + i, start.getColumn()));
        }
        return coordinates;
    }
}

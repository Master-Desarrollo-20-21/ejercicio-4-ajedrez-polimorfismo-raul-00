import java.util.List;

abstract class Piece {
    protected Color color;
    protected Coordinate coordinate;
    protected boolean moved;

    protected Piece(Color color, Coordinate coordinate) {
        this.moved = false;
        this.color = color;
        this.coordinate = coordinate;
    }

    protected boolean hasCoordinate(Coordinate coordinate) {
        return this.coordinate.equals(coordinate);
    }

    protected boolean equalsColor(Piece piece) {
        return hasColor(piece.color);
    }

    public boolean hasColor(Color color) {
        return this.color == color;
    }

    protected void setMoved() {
        this.moved = true;
    }

    protected void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    protected boolean isKing() {
        return false;
    }

    protected abstract boolean isValidMovement(Coordinate origin, Coordinate target);

    protected abstract char getPrintable();

    protected abstract List<Coordinate> getCoordinatesBetween(Coordinate origin, Coordinate target);
}

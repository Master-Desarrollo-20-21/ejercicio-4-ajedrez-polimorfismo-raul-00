import java.util.List;

class Knigth extends Piece {
    public Knigth(Color color, Coordinate coordinate) {
        super(color, coordinate);
    }

    @Override
    public char getPrintable() {
        return this.color == Color.WHITE ? '\u2658' : '\u265E';
    }

    @Override
    protected boolean isValidMovement(Coordinate origin, Coordinate target) {
        int columnDistance = origin.columDistance(target);
        int rowDistance = origin.rowDistance(target);
        if (columnDistance == 1 && rowDistance == 2) {
            return true;
        }
        if (columnDistance == 2 && rowDistance == 1) {
            return true;
        }
        return false;
    }

    @Override
    protected List<Coordinate> getCoordinatesBetween(Coordinate origin, Coordinate target) {
        return null;
    }
}

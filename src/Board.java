import java.util.ArrayList;
import java.util.List;

class Board {
	private final int DIMENSION = 8;

	private final int PAWNS_PER_PLAYER = 8;

	private final int WHITE_PAWN_INITIAL_ROW = 6;
	private final int WHITE_KNIGHT_INITIAL_ROW = 7;
	private final int WHITE_KING_INITIAL_ROW = 7;
	private final int BLACK_PAWN_INITIAL_ROW = 1;
	private final int BLACK_KNIGHT_INITIAL_ROW = 0;
	private final int BLACK_KING_INITIAL_ROW = 0;

	private Coordinate[][] coordinates;
	private List<Piece> pieces;

	public Board() {
		coordinates = new Coordinate[DIMENSION][DIMENSION];
		for (int i = 0; i < DIMENSION; i++) {
			for (int j = 0; j < DIMENSION; j++) {
				coordinates[i][j] = new Coordinate(i, j);
			}
		}
		createPieces();
	}

	private void createPieces() {
		pieces = new ArrayList<Piece>();
		for (int i = 0; i < PAWNS_PER_PLAYER; i++) {
			pieces.add(new Pawn(Color.BLACK, coordinates[BLACK_PAWN_INITIAL_ROW][i]));
		}
		pieces.add(new Knigth(Color.BLACK, coordinates[BLACK_KNIGHT_INITIAL_ROW][1]));
		pieces.add(new Knigth(Color.BLACK, coordinates[BLACK_KNIGHT_INITIAL_ROW][6]));
		pieces.add(new King(Color.BLACK, coordinates[BLACK_KING_INITIAL_ROW][4]));

		for (int i = 0; i < PAWNS_PER_PLAYER; i++) {
			pieces.add(new Pawn(Color.WHITE, coordinates[WHITE_PAWN_INITIAL_ROW][i]));
		}
		pieces.add(new Knigth(Color.WHITE, coordinates[WHITE_KNIGHT_INITIAL_ROW][1]));
		pieces.add(new Knigth(Color.WHITE, coordinates[WHITE_KNIGHT_INITIAL_ROW][6]));
		pieces.add(new King(Color.WHITE, coordinates[WHITE_KING_INITIAL_ROW][4]));
	}

	public void show() {
		String columnLabel = "    a    b    c    d    e    f    g   h";
		String rowSeparator = " |---------------------------------------|";
		Console console = new Console();
		console.outln(columnLabel);
		console.outln(rowSeparator);
		for (int i = 0; i < DIMENSION; i++) {
			String line = i + "";
			for (Coordinate coordinate : coordinates[i]) {
				Piece piece = getPiece(coordinate);
				line += ("|" + (piece == null ? "    " : " " + piece.getPrintable() + "  "));
			}
			console.outln(line + "|" + i);
			console.outln(rowSeparator);
		}
		console.outln(columnLabel);
	}

	private Piece getPiece(Coordinate coordinate) {
		for (Piece piece : pieces) {
			if (piece.hasCoordinate(coordinate)) {
				return piece;
			}
		}
		return null;
	}

	public boolean isValidMovement(Coordinate origin, Coordinate target, Color color) {
		Piece pieceInOrigin = getPiece(origin);
		if (pieceInOrigin == null) {
			return false;
		}
		if (!pieceInOrigin.hasColor(color)) {
			return false;
		}
		if (!pieceInOrigin.isValidMovement(origin, target)) {
			return false;
		}
		if (!hasCoordinate(target)) {
			return false;
		}
		Piece pieceInTarget = getPiece(target);
		if (pieceInTarget != null && pieceInTarget.equalsColor(pieceInOrigin)) {
			return false;
		}
		List<Coordinate> middleCoordinates = pieceInOrigin.getCoordinatesBetween(origin, target);
		if (!hasWayFree(middleCoordinates)) {
			return false;
		}
		return true;
	}

	private boolean hasCoordinate(Coordinate target) {
		for (int i = 0; i < coordinates.length; i++) {
			for (int j = 0; j < coordinates[i].length; j++) {
				if (coordinates[i][j].equals(target)) {
					return true;
				}
			}
		}
		return false;
	}

	private boolean hasWayFree(List<Coordinate> middleCoordinates) {
		if (middleCoordinates == null) {
			return true;
		}
		for (Piece piece : pieces) {
			for (Coordinate coordinate : middleCoordinates) {
				if (piece.hasCoordinate(coordinate)) {
					return false;
				}
			}
		}
		return true;
	}

	public void move(Coordinate origin, Coordinate target) {
		removePiece(target);
		Piece originPiece = getPiece(origin);
		originPiece.setCoordinate(target);
		originPiece.setMoved();
	}

	private void removePiece(Coordinate coordinate) {
		Piece piece = getPiece(coordinate);
		if (piece != null) {
			pieces.remove(piece);
		}
	}

	public boolean hasKing(Coordinate coordinate) {
		Piece piece = getPiece(coordinate);
		return piece != null && piece.isKing();
	}
}

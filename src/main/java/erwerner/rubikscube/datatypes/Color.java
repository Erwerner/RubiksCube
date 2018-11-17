package erwerner.rubikscube.datatypes;

public enum Color {
	ORANGE(-3), BLUE(-2), RED(-1), BLANK(0), WHITE(1), GREEN(2), YELLOW(3);
	private int mInt;

	private Color(int iInt) {
		mInt = iInt;
	}

	public int getInt() {
		return mInt;
	}
	public static Color getColor(int pInt) {
		switch (pInt) {
		case -3:
			return ORANGE;
		case -2:
			return BLUE;
		case -1:
			return RED;
		case 0:
			return BLANK;
		case 1:
			return WHITE;
		case 2:
			return GREEN;
		case 3:
			return YELLOW;
		default:
			throw new RuntimeException();
		}
	}
	public static Color getColor(Dim pDim) {
		return getColor(pDim.getInt());
	}
}

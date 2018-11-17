package erwerner.rubikscube.datatypes;

public enum StoneColor {
	ORANGE(-3), BLUE(-2), RED(-1), BLANK(0), WHITE(1), GREEN(2), YELLOW(3);
	private int mInt;

	private StoneColor(int iInt) {
		mInt = iInt;
	}

	public int getInt() {
		return mInt;
	}
	public static StoneColor getColor(int pInt) {
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
	public static StoneColor getColor(Dim pDim) {
		return getColor(pDim.getInt());
	}
	public int[] getRGB() {
		int[] rRGB = new int[3];
		switch (StoneColor.getColor(mInt)) {
		case ORANGE:
			rRGB[0] = 255;
			rRGB[1] = 150;
			rRGB[2] = 50;
			break;
		case BLUE:
			rRGB[0] = 0;
			rRGB[1] = 0;
			rRGB[2] = 255;
			break;
		case RED:
			rRGB[0] = 255;
			rRGB[1] = 0;
			rRGB[2] = 0;
			break; 
		case WHITE: 
			rRGB[0] = 255;
			rRGB[1] = 255;
			rRGB[2] = 255;
			break;
		case GREEN: 
			rRGB[0] = 0;
			rRGB[1] = 255;
			rRGB[2] = 0;
			break;
		case YELLOW: 
			rRGB[0] = 255;
			rRGB[1] = 255;
			rRGB[2] = 0;
			break;
		default:
			throw new RuntimeException();
		}
		return rRGB ;
	}
}

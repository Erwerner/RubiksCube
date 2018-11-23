package erwerner.rubikscube.datatypes;

import erwerner.rubikscube.cube.Slice;

/**
 * Die Dimension gibt die Richtung an, auf der eine Aktion durchzuführen ist. Jede Dimension wird durch eine Integerzahl von -3 bis 3 dargestellt. <br>
 * Beispielsweise kann die Dimension FRONT verwendet werden, um die Vorderseite des Würfels zu drehen. <br>
 * Pro räumlicher Achse gibt es zwei Dimensionen, z.B. LEFT und RIGHT für die X-Koordinate wobei der Integer-Wert 1 für RIGHT und -1 für LEFT steht.<br>
 * 
 * @version 0.1
 */
public enum Dim { 
	FRONT(-3), DOWN(-2), LEFT(-1), RIGHT(1), UP(2), BACK(3);
	private int mInt;

	private Dim(int iInt) {
		mInt = iInt;
	}

	public int getInt() {
		return mInt;
	}

	/**
	 * Übersetzt eine Integer Zahl in die dazugehörige Dimension
	 * @param iInt Integer
	 * @return FRONT(-3), DOWN(-2), LEFT(-1), RIGHT(1), UP(2), BACK(3);
	 */
	public static Dim getDim(int iInt) {
		switch (iInt) {
		case -3:
			return FRONT;
		case -2:
			return DOWN;
		case -1:
			return LEFT;
		case 1:
			return RIGHT;
		case 2:
			return UP;
		case 3:
			return BACK;
		default:
			throw new RuntimeException();
		}
	} 
//	public static Dim[] getAll() {
//		int lSkipZero = 0;
//		Dim[] rDims = new Dim[6];
//		for(int i=-3;i<=3;i++) {
//			if(i==0) {
//				lSkipZero = 1;
//				continue;
//			}
//			rDims[i-lSkipZero+3] = getDim(i);
//		}
//		return rDims;
//	}
	public Dim invert() {
		return getDim(this.getInt()*-1);
	}
}

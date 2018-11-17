package erwerner.rubikscube.mvc.present;

import erwerner.rubikscube.datatypes.Color;
import erwerner.rubikscube.datatypes.Dim;

public interface iPresentGrid {
	public Dim getLastTurn();
//	public StoneSlot[][][] getAllSlots();
	public Color[] getColorsFromDim(Dim pDim);
	boolean isSolved();
}

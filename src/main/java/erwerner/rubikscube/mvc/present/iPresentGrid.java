package erwerner.rubikscube.mvc.present;

import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.datatypes.StoneColor;
import erwerner.rubikscube.datatypes.StoneSlot;

public interface iPresentGrid {
	public Dim getLastTurn();
	public StoneSlot[][][] getAllSlots(); 
	public StoneColor[] getColorsFromDim(Dim pDim);
	boolean isSolved();
}

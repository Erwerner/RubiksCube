package erwerner.rubikscube.cube;

import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.datatypes.StoneSlot;

public interface iSlice {
	public void turn(Dim pDim);
	public StoneSlot[] getSlots();
}

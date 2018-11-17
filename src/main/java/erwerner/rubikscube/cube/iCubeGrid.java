package erwerner.rubikscube.cube;

import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.datatypes.StoneSlot;

public interface iCubeGrid {
	public Slice buildSlice(Dim pDim);

	StoneSlot getSlot(int pX, int pY, int pZ);
}

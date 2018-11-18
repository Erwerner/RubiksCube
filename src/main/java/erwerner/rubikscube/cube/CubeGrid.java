package erwerner.rubikscube.cube;

import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.datatypes.StoneSlot;

public class CubeGrid implements iCubeGrid {
	StoneSlot[][][] mSlots = new StoneSlot[3][3][3];

	public CubeGrid() {
		for (int iX = 0; iX <= 2; iX++) {
			for (int iY = 0; iY <= 2; iY++) {
				for (int iZ = 0; iZ <= 2; iZ++) {
					mSlots[iX][iY][iZ] = new StoneSlot();
				}
			}
		}
	}

	public StoneSlot getSlot(int pX, int pY, int pZ) {
		if (pX == 1 && pY == 1 && pZ == 1) {
			throw new RuntimeException("Middle Slot does not Exist");
		}
		return mSlots[pX][pY][pZ];
	}

	public Slice buildSlice(Dim pDim) {

		StoneSlot[] lSlots = new StoneSlot[9];
		int lCount = 0;
		for (int iZ = 0; iZ <= 2; iZ++) {
			for (int iY = 0; iY <= 2; iY++) {
				for (int iX = 0; iX <= 2; iX++) {
					int lX = iX;
					int lY = iY;
					int lZ = iZ;
					switch (pDim) {
					case RIGHT:
						lX = 2;
						iX = 2;
						break;
					case UP:
						lY = 2;
						iY = 2;
						break;
					case BACK:
						lZ = 2;
						iZ = 2;
						break;
					case LEFT:
						lX = 0;
						iX = 2;
						break;
					case DOWN:
						lY = 0;
						iY = 2;
						break;
					case FRONT:
						lZ = 0;
						iZ = 2;
						break;

					default:
						break;
					}
					lSlots[lCount++] = mSlots[lX][lY][lZ];
				}
			}
		}
		return new Slice(lSlots);
	}

	public StoneSlot[][][] getSlots() {
		return mSlots;
	}

}

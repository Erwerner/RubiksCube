package erwerner.rubikscube.cube;

import erwerner.rubikscube.datatypes.StoneColor;
import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.datatypes.Stone;
import erwerner.rubikscube.datatypes.StoneSlot;
import erwerner.rubikscube.mvc.Model;
import erwerner.rubikscube.mvc.controller.iContTurn;
import erwerner.rubikscube.mvc.present.iPresentGrid;

public class Cube extends Model implements iContTurn, iPresentGrid{

	protected CubeGrid mGrid;
	private Dim mLastTurn;

	public Cube()  {
		mGrid = new CubeGrid();
	}

	public void turn(Dim pDim) {
		Slice lSlice = mGrid.buildSlice(pDim);
		lSlice.turn(pDim);
		mLastTurn = pDim;
		notifyViews();
	}

	@Override
	public boolean isSolved() { 
		for (int iX = 0; iX <= 2; iX++) {
			for (int iY = 0; iY <= 2; iY++) {
				for (int iZ = 0; iZ <= 2; iZ++) { 
					if(iX==1 && iY==1 && iZ==1)continue;
					Stone lStone = mGrid.getSlot(iX, iY, iZ).getStone();
					for(Dim iDim : Dim.getAll()) {
						StoneColor lColStone = lStone.getColor(iDim);
						StoneColor lColDim = StoneColor.getColor(iDim);
						if(lColStone!=lColDim)return false;
					}
				}
			}
		} 
		return true;
	}

	@Override
	public Dim getLastTurn() throws NullPointerException { 
		if(mLastTurn == null)throw new NullPointerException();
		return mLastTurn;
	}

	@Override
	public StoneColor[] getColorsFromDim(Dim pDim) { 
		Slice lSLice = mGrid.buildSlice(pDim);
		int iCount =0;
		
		StoneColor[] rColor = new StoneColor[9];
		for(StoneSlot iSlot : lSLice.getSlots()) { 
			rColor[iCount++] = iSlot.getStone().getColor(pDim);
		}
		return rColor ;
	}

	@Override
	public StoneSlot[][][] getAllSlots() {  
		return mGrid.getSlots();
	}

}

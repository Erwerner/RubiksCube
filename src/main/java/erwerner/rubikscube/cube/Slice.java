package erwerner.rubikscube.cube;

import java.util.ArrayList;
import java.util.List;

import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.datatypes.Stone;
import erwerner.rubikscube.datatypes.StoneSlot;

public class Slice implements iSlice{
	StoneSlot mSlots[] = new StoneSlot[9];

	public Slice(StoneSlot[] pSlots) { 
		mSlots = pSlots;
	}

	public void turn(Dim pDim) {
		for(StoneSlot iSlot : mSlots) {
			iSlot.getStone().turnOnDim(pDim);
		}

		List<Stone> lStoneBeforeTurn = new ArrayList<Stone>(); 
		for(StoneSlot iSLot : mSlots) {
			lStoneBeforeTurn.add(iSLot.getStone());
		}

		for(int i=0;i<=5;i++) {
			moveStoneToSlot(lStoneBeforeTurn.get(i),mSlots[i+2]);
		}
		for(int i=0;i<=1;i++) {
			moveStoneToSlot(lStoneBeforeTurn.get(i+6),mSlots[i]);
		}
		

	}

	private void moveStoneToSlot(Stone pStone, StoneSlot pTargetSlot) {
		pTargetSlot.setStone(pStone);
	}

	public StoneSlot[] getSlots() { 
		return mSlots;
	} 

}

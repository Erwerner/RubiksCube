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
		turnStones(pDim); 
		StoneSlot[] lSlotsInLine = new StoneSlot[9];
		lSlotsInLine[0] = mSlots[0]; 
		lSlotsInLine[1] = mSlots[1];
		lSlotsInLine[2] = mSlots[2]; 
		lSlotsInLine[3] = mSlots[5]; 
		lSlotsInLine[4] = mSlots[8]; 
		lSlotsInLine[5] = mSlots[7]; 
		lSlotsInLine[6] = mSlots[6]; 
		lSlotsInLine[7] = mSlots[3]; 
		lSlotsInLine[8] = mSlots[4]; 
		switchSlots(lSlotsInLine );
		

	}

	private void switchSlots(StoneSlot[] pSlotsInLine) {
		List<Stone> lStoneBeforeTurn = new ArrayList<Stone>(); 
		for(StoneSlot iSLot : pSlotsInLine) {
			lStoneBeforeTurn.add(iSLot.getStone());
		}

		for(int i=0;i<=5;i++) {
			moveStoneToSlot(lStoneBeforeTurn.get(i),pSlotsInLine[i+2]);
		}
		for(int i=0;i<=1;i++) {
			moveStoneToSlot(lStoneBeforeTurn.get(i+6),pSlotsInLine[i]);
		}
	}

	private void turnStones(Dim pDim) {
		for(StoneSlot iSlot : mSlots) {
			iSlot.getStone().turnOnDim(pDim);
		}
	}

	private void moveStoneToSlot(Stone pStone, StoneSlot pTargetSlot) {
		pTargetSlot.setStone(pStone);
	}

	public StoneSlot[] getSlots() { 
		return mSlots;
	} 

}

package erwerner.rubikscube.cube;

import java.util.List;
import java.util.ArrayList;

import erwerner.rubikscube.datatypes.Color;
import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.datatypes.Stone;
import erwerner.rubikscube.datatypes.StoneSlot;
import junit.framework.TestCase;

public class SliceTest extends TestCase {

	List<Stone> mStoneBegin = new ArrayList<Stone>(); 
	private Slice mCut;
	
	@Override
	protected void setUp() throws Exception {
		StoneSlot[] lSlots = new StoneSlot[9];
		super.setUp();
		for(int i=0;i<=8;i++) {
			lSlots[i] = new StoneSlot();
		}
		
		for(StoneSlot iSLot : lSlots) {
			mStoneBegin.add(iSLot.getStone());
		} 
		mCut = new Slice(lSlots );
	}

	public void testTurnAffectsStone() {
		Dim lTurn = Dim.getDim(2);
		mCut.turn(lTurn);
		
		Stone lStoneAct0 = mCut.getSlots()[0].getStone();
		assertEquals( Color.getColor(1), lStoneAct0.getColor(Dim.getDim(3)) );
	}
	public void testTurnAffectsSlots() {
		Dim lTurn = Dim.getDim(2);
		mCut.turn(lTurn);

		assertStoneOnSlot(8,8); 
		assertStoneOnSlot(0,2); 
		assertStoneOnSlot(1,3); 
		assertStoneOnSlot(2,4); 
		assertStoneOnSlot(3,5);  
		assertStoneOnSlot(6,0);  
		assertStoneOnSlot(7,1);  
	}

	private void assertStoneOnSlot(int pBeginSlot, int pTargetSlot) {
		assertEquals( pBeginSlot + " not on " + pTargetSlot ,
				mStoneBegin.get(pBeginSlot) ,mCut.getSlots()[pTargetSlot].getStone() );
	}
}

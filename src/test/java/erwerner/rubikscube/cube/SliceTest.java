package erwerner.rubikscube.cube;

import java.util.List;
import java.util.ArrayList;

import erwerner.rubikscube.datatypes.StoneColor;
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
		assertEquals( StoneColor.getColor(1), lStoneAct0.getColor(Dim.getDim(3)) );
	}
	public void testTurnAffectsSlots() {
		Dim lTurn = Dim.getDim(2);
		mCut.turn(lTurn);

		assertStoneOnSlot(4,4); 
		assertStoneOnSlot(0,2); 
		assertStoneOnSlot(1,5); 
		assertStoneOnSlot(2,8); 
		assertStoneOnSlot(5,7);  
		assertStoneOnSlot(7,3);  
		assertStoneOnSlot(6,0);  
	}

	private void assertStoneOnSlot(int pBeginSlot, int pTargetSlot) {
		assertEquals( pBeginSlot + " not on " + pTargetSlot ,
				mStoneBegin.get(pBeginSlot) ,mCut.getSlots()[pTargetSlot].getStone() );
	}
}

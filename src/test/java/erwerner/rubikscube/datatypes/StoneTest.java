package erwerner.rubikscube.datatypes;

import java.util.List;

import erwerner.rubikscube.datatypes.StoneColor;
import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.datatypes.Stone;
import junit.framework.TestCase;

public class StoneTest extends TestCase {

	Stone mCut;

	protected void setUp() throws Exception {
		super.setUp();
		mCut = new Stone();
	}

	public void testInit() {
		for (Dim iDim : Dim.values()) {
			StoneColor lExp = StoneColor.getColor(iDim);
			StoneColor lAct = mCut.getColor(iDim);
			assertEquals(lExp, lAct);
		}
	}

	public void testSetColor() {
		Dim lDimAffected = Dim.getDim(1);
		Dim lDimOther = Dim.getDim(2);
		StoneColor lExpStart = StoneColor.getColor(lDimAffected);
		StoneColor lExpEnd   = StoneColor.getColor(lDimOther);
		StoneColor lAct;
		
		lAct = mCut.getColor(lDimAffected);
		assertEquals( lExpStart, lAct);
		assertNotSame(lExpEnd, lAct);
		
		mCut.setColor(lDimAffected, lExpEnd );
		lAct = mCut.getColor(lDimAffected);
		assertColorOnCUT( lExpEnd, lDimAffected);
	}

	public void testTurnOnDim2() {
		Dim lTurn = Dim.getDim(2);
		
		mCut.turnOnDim(lTurn);
		assertColorOnCUT(StoneColor.getColor(lTurn),lTurn);
		assertColorOnCUT(StoneColor.getColor(lTurn.invert()),lTurn.invert());

		assertColorOnCUT( StoneColor.getColor(1),Dim.getDim(3));
		assertColorOnCUT( StoneColor.getColor(3),Dim.getDim(-1));
		assertColorOnCUT( StoneColor.getColor(-1),Dim.getDim(-3)); 
		assertColorOnCUT( StoneColor.getColor(-3),Dim.getDim(1));
	}
	public void testTurnOnDim1() {
		Dim lTurn = Dim.getDim(1);
		
		mCut.turnOnDim(lTurn);
		assertColorOnCUT(StoneColor.getColor(lTurn),lTurn);
		assertColorOnCUT(StoneColor.getColor(lTurn.invert()),lTurn.invert());

		assertColorOnCUT( StoneColor.getColor(2),Dim.getDim(3));
		assertColorOnCUT( StoneColor.getColor(3),Dim.getDim(-2));
		assertColorOnCUT( StoneColor.getColor(-3),Dim.getDim(2)); 
		assertColorOnCUT( StoneColor.getColor(-2),Dim.getDim(-3));
	}
public void testTurn3Dims() {
	StoneColor lExp = mCut.getColor(Dim.UP);
	mCut.turnOnDim(Dim.FRONT);
	assertColorOnCUT(lExp, Dim.LEFT);
	mCut.turnOnDim(Dim.UP);
	assertColorOnCUT(lExp, Dim.FRONT);
	mCut.turnOnDim(Dim.RIGHT);
	assertColorOnCUT(lExp, Dim.UP);
	

	mCut.turnOnDim(Dim.RIGHT);
	assertColorOnCUT(lExp, Dim.BACK);
	mCut.turnOnDim(Dim.RIGHT);
	assertColorOnCUT(lExp, Dim.DOWN);
	mCut.turnOnDim(Dim.BACK);
	assertColorOnCUT(lExp, Dim.RIGHT);
	mCut.turnOnDim(Dim.DOWN);
	assertColorOnCUT(lExp, Dim.BACK);
}
	
	public void testGetAffectedOnTurn() {
		Dim lTurn = Dim.getDim(2);
		List<Dim> lAct = mCut.getAffectedOnTurn(lTurn);
		assertEquals( 4, lAct.size() );
		assertFalse(lAct.contains(lTurn));
		assertFalse(lAct.contains(lTurn.invert()));
		assertTrue(lAct.contains(Dim.getDim(1)));
		assertTrue(lAct.contains(Dim.getDim(-1)));
		assertTrue(lAct.contains(Dim.getDim(3)));
		assertTrue(lAct.contains(Dim.getDim(-3)));

		assertEquals(Dim.getDim(1), lAct.get(2));
		assertEquals(Dim.getDim(3), lAct.get(3));
		assertEquals(Dim.getDim(-1), lAct.get(1));
		assertEquals(Dim.getDim(-3), lAct.get(0));
	}
	private void assertColorOnCUT(StoneColor lExpColor,Dim lCutDim) {
		assertEquals( lExpColor , mCut.getColor(lCutDim) );
	}
}

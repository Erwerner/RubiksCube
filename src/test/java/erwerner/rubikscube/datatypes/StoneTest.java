package erwerner.rubikscube.datatypes;

import java.util.List;

import erwerner.rubikscube.datatypes.Color;
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
		for (Dim iDim : Dim.getAll()) {
			Color lExp = Color.getColor(iDim);
			Color lAct = mCut.getColor(iDim);
			assertEquals(lExp, lAct);
		}
	}

	public void testSetColor() {
		Dim lDimAffected = Dim.getDim(1);
		Dim lDimOther = Dim.getDim(2);
		Color lExpStart = Color.getColor(lDimAffected);
		Color lExpEnd   = Color.getColor(lDimOther);
		Color lAct;
		
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
		assertColorOnCUT(Color.getColor(lTurn),lTurn);
		assertColorOnCUT(Color.getColor(lTurn.invert()),lTurn.invert());

		assertColorOnCUT( Color.getColor(1),Dim.getDim(3));
		assertColorOnCUT( Color.getColor(3),Dim.getDim(-1));
		assertColorOnCUT( Color.getColor(-1),Dim.getDim(-3)); 
		assertColorOnCUT( Color.getColor(-3),Dim.getDim(1));
	}
	public void testTurnOnDim1() {
		Dim lTurn = Dim.getDim(1);
		
		mCut.turnOnDim(lTurn);
		assertColorOnCUT(Color.getColor(lTurn),lTurn);
		assertColorOnCUT(Color.getColor(lTurn.invert()),lTurn.invert());

		assertColorOnCUT( Color.getColor(2),Dim.getDim(3));
		assertColorOnCUT( Color.getColor(3),Dim.getDim(-2));
		assertColorOnCUT( Color.getColor(-3),Dim.getDim(2)); 
		assertColorOnCUT( Color.getColor(-2),Dim.getDim(-3));
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
	private void assertColorOnCUT(Color lExpColor,Dim lCutDim) {
		assertEquals( lExpColor , mCut.getColor(lCutDim) );
	}
}

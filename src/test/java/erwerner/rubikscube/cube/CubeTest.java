package erwerner.rubikscube.cube;

import erwerner.rubikscube.datatypes.Color;
import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.datatypes.Stone;
import junit.framework.TestCase;

public class CubeTest extends TestCase {

	private Cube mCut;
	protected void setUp() throws Exception {
		mCut = new Cube();
	}
	public void testTurn() {
		mCut.turn(Dim.DOWN);
		Stone lAct = mCut.mGrid.getSlot(0, 0, 0).getStone();
		Color lExpCol = Color.getColor(Dim.LEFT);
		assertEquals( lExpCol, lAct.getColor(Dim.FRONT) );
	}
	public void testIsSolved() {
		assertTrue( mCut.isSolved() );
		mCut.turn(Dim.UP);
		assertFalse( mCut.isSolved() );
		mCut.turn(Dim.UP);
		mCut.turn(Dim.UP);
		mCut.turn(Dim.UP);
		assertTrue( mCut.isSolved() );
	}
	public void testGetColorsFromDim() {
		Color[] lColors = mCut.getColorsFromDim(Dim.UP);
		for(Color iColor : lColors) {
			assertEquals( Color.getColor(Dim.UP), iColor );
		}
	}
}

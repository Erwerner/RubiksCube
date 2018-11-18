package erwerner.rubikscube.cube;

import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.datatypes.Stone;
import erwerner.rubikscube.datatypes.StoneColor;
import junit.framework.TestCase;

public class CubeTest extends TestCase {

	private Cube mCut;
	protected void setUp() throws Exception {
		mCut = new Cube();
	}
	public void testTurn() {
		
		Stone lStone020 = mCut.mGrid.getSlot(0, 2, 0).getStone();
		assertEquals( StoneColor.ORANGE, mCut.mGrid.getSlot(0, 0, 0).getStone().getColor(Dim.FRONT) );
		assertEquals( StoneColor.RED, mCut.mGrid.getSlot(0, 0, 0).getStone().getColor(Dim.LEFT) );
		assertEquals( StoneColor.BLUE, mCut.mGrid.getSlot(0, 0, 0).getStone().getColor(Dim.DOWN) );
		mCut.turn(Dim.FRONT);
		assertEquals( lStone020, mCut.mGrid.getSlot(0, 0, 0).getStone());
		assertEquals( StoneColor.ORANGE, mCut.mGrid.getSlot(0, 0, 0).getStone().getColor(Dim.FRONT) );
		assertEquals( StoneColor.GREEN, mCut.mGrid.getSlot(0, 0, 0).getStone().getColor(Dim.LEFT) );
		assertEquals( StoneColor.RED, mCut.mGrid.getSlot(0, 0, 0).getStone().getColor(Dim.DOWN) );
		mCut.turn(Dim.LEFT); 
		assertEquals( StoneColor.BLUE, mCut.mGrid.getSlot(0, 0, 0).getStone().getColor(Dim.FRONT) ); 
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
		StoneColor[] lColors = mCut.getColorsFromDim(Dim.UP);
		for(StoneColor iColor : lColors) {
			assertEquals( StoneColor.getColor(Dim.UP), iColor );
		}
	}
}

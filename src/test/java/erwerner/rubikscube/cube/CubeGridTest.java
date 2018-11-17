package erwerner.rubikscube.cube;

import java.util.Arrays;
import java.util.List;

import erwerner.rubikscube.datatypes.StoneColor;
import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.datatypes.StoneSlot;
import junit.framework.TestCase;

public class CubeGridTest extends TestCase {

	private CubeGrid mCut;

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		mCut = new CubeGrid();
	}

	public void testInit() {
		StoneSlot lStone000 = mCut.getSlot(0, 0, 0);
		StoneSlot lStone222 = mCut.getSlot(2, 2, 2);

		Dim lDim1 = Dim.getDim(1);
		Dim lDim3 = Dim.getDim(3);

		assertEquals(lStone000.getStone().getColor(lDim1), StoneColor.getColor(lDim1));
		assertEquals(lStone222.getStone().getColor(lDim3), StoneColor.getColor(lDim3));

		try {
			mCut.getSlot(1, 1, 1);
			fail();
		} catch (Exception e) {
			// Expected
		}
	}

	public void testGetSlice1() {
		Dim lDim = Dim.getDim(1);
		Slice lSlice = mCut.buildSlice(lDim);
		List<StoneSlot> lAct = Arrays.asList(lSlice.getSlots());

		assertEquals(lAct.size(), 9);
		assertTrue(lAct.contains(mCut.getSlot(2, 2, 2)));
		assertTrue(lAct.contains(mCut.getSlot(2, 0, 0)));
		assertTrue(lAct.contains(mCut.getSlot(2, 1, 1)));

	}

	public void testGetSlice3() {
		Dim lDim = Dim.getDim(3);
		Slice lSlice = mCut.buildSlice(lDim);
		List<StoneSlot> lAct = Arrays.asList(lSlice.getSlots());

		assertEquals(lAct.size(), 9);
		assertTrue(lAct.contains(mCut.getSlot(2, 2, 2)));
		assertTrue(lAct.contains(mCut.getSlot(0, 0, 2)));
		assertTrue(lAct.contains(mCut.getSlot(1, 2, 2)));
	}

	public void testGetSlice2inv() {
		Dim lDim = Dim.getDim(-2);
		Slice lSlice = mCut.buildSlice(lDim);
		List<StoneSlot> lAct = Arrays.asList(lSlice.getSlots());

		assertEquals(lAct.size(), 9);
		assertTrue(lAct.contains(mCut.getSlot(2, 0, 2)));
		assertTrue(lAct.contains(mCut.getSlot(1, 0, 0)));
		assertTrue(lAct.contains(mCut.getSlot(1, 0, 1)));
	}

	public void testGetSlice3inv() {
		Dim lDim = Dim.getDim(-3);
		Slice lSlice = mCut.buildSlice(lDim);
		List<StoneSlot> lAct = Arrays.asList(lSlice.getSlots());

		assertEquals(mCut.getSlot(0, 0, 0), lAct.get(0));
		assertEquals(mCut.getSlot(1, 0, 0), lAct.get(1));
		assertEquals(mCut.getSlot(1, 1, 0), lAct.get(4)); 
		assertEquals(mCut.getSlot(2, 2, 0), lAct.get(8));
	}
}

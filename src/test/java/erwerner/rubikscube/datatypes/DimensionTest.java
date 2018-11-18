package erwerner.rubikscube.datatypes;

import junit.framework.TestCase;

public class DimensionTest extends TestCase {
	public void testGetAll() {
		assertEquals( Dim.FRONT, Dim.values()[0] );
		assertEquals( Dim.BACK,  Dim.values()[5] );
	}
}

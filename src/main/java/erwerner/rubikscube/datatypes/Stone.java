package erwerner.rubikscube.datatypes;

import java.util.List;
import java.util.ArrayList;

public final class Stone {

	Color[] mSurfaceColor = { Color.ORANGE, Color.BLUE, Color.RED, Color.BLANK, Color.WHITE, Color.GREEN,
			Color.YELLOW };
	public Color getColor(Dim pDim) {
		int lSurface = 3 + pDim.getInt();
		return mSurfaceColor[lSurface];
	}
	public void setColor(Dim pDim, Color pColor) {
		mSurfaceColor[pDim.getInt()+3] = pColor;
	}
//	public void setColor(Dim pDimAffected, Dim pDimSource) {
//		setColor(pDimAffected,getColor(pDimSource));
//	}
	public void turnOnDim(Dim pTurn) {
		List<Dim> lAffectedDim; 
//		lAffectedDim = Arrays.asList(Dim.getAll());
//		lAffectedDim.remove(pTurn);
//		lAffectedDim.remove(pTurn.invert());
		
		lAffectedDim = getAffectedOnTurn(pTurn);

		Dim lMinDim = lAffectedDim.get(2);
		Dim lMaxDim = lAffectedDim.get(3);

		Color lColMinDim = getColor(lMinDim);
		Color lColMinDimInv = getColor(lMinDim.invert());
		Color lColMaxDim = getColor(lMaxDim);
		Color lColMaxDimInv = getColor(lMaxDim.invert());
		
		
		setColor(lMaxDim, lColMinDim );
		setColor(lMinDim.invert(), lColMaxDim);
		setColor(lMaxDim.invert(), lColMinDimInv);
		setColor(lMinDim, lColMaxDimInv);
	}
	protected List<Dim> getAffectedOnTurn(Dim pTurn) {
		List<Dim> rAffectedDim = new ArrayList<Dim>();
		for(Dim iDim : Dim.getAll()) {
			if(iDim.getInt() != pTurn.getInt() && iDim.getInt() != pTurn.invert().getInt()) {
				rAffectedDim.add(iDim);
			}
		}
		return rAffectedDim;
	}
}

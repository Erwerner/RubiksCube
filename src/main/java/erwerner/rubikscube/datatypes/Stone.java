package erwerner.rubikscube.datatypes;

import java.util.List;
import java.util.ArrayList;

public final class Stone {

	StoneColor[] mSurfaceColor = { StoneColor.ORANGE, StoneColor.BLUE, StoneColor.RED, StoneColor.BLANK, StoneColor.WHITE, StoneColor.GREEN,
			StoneColor.YELLOW };
	public StoneColor getColor(Dim pDim) {
		int lSurface = 3 + pDim.getInt();
		return mSurfaceColor[lSurface];
	}
	public void setColor(Dim pDim, StoneColor pColor) {
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

		StoneColor lColMinDim = getColor(lMinDim);
		StoneColor lColMinDimInv = getColor(lMinDim.invert());
		StoneColor lColMaxDim = getColor(lMaxDim);
		StoneColor lColMaxDimInv = getColor(lMaxDim.invert());
		
		
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

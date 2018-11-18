package erwerner.rubikscube.ui.console;

import erwerner.rubikscube.datatypes.StoneColor;
import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.mvc.Model;
import erwerner.rubikscube.mvc.View;
import erwerner.rubikscube.mvc.present.iPresentGrid;

public class ViewConsoleGrid extends View {
	iPresentGrid mGrid;
	public ViewConsoleGrid(Model pModel) {
		super(pModel); 
		iPresentGrid mGrid = (iPresentGrid) pModel; 
	}

	@Override
	public void update() {
		try {			
			System.out.println("Turn" + mGrid.getLastTurn());
		} catch (Exception e) { 
		}
		if (mGrid.isSolved()) {
			System.out.println("Solved");
		}

		int iCount =0;
		for(Dim iDim : Dim.values()) {
			for(StoneColor iColor : mGrid.getColorsFromDim(iDim)) {
				if(iCount++ % 3 == 0)System.out.println("");
				System.out.print(iColor);
				System.out.print("\t");
			}
			System.out.println("");
			System.out.println("-----------------------------------");
		}
	}

}

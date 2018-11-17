package erwerner.rubikscube.ui;

import erwerner.rubikscube.datatypes.Color;
import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.mvc.Model;
import erwerner.rubikscube.mvc.View;
import erwerner.rubikscube.mvc.present.iPresentGrid;

public class ViewConsoleGrid extends View {

	public ViewConsoleGrid(Model pModel) {
		super(pModel); 
	}

	@Override
	public void update() {
		iPresentGrid lModel = (iPresentGrid) mModel; 
		try {			
			System.out.println("Turn" + lModel.getLastTurn());
		} catch (Exception e) { 
		}
		if (lModel.isSolved()) {
			System.out.println("Solved");
		}

		int iCount =0;
		for(Dim iDim : Dim.getAll()) {
			for(Color iColor : lModel.getColorsFromDim(iDim)) {
				if(iCount++ % 3 == 0)System.out.println("");
				System.out.print(iColor);
				System.out.print("\t");
			}
			System.out.println("");
			System.out.println("-----------------------------------");
		}
	}

}

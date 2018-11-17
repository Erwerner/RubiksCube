package erwerner.rubikscube;

import erwerner.rubikscube.cube.Cube;
import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.mvc.controller.iContTurn;
import erwerner.rubikscube.ui.ViewConsoleGrid;

public class StartCube {

	public static void main(String[] args) {
		Cube lCube = new Cube();
		new ViewConsoleGrid( lCube );
		
		iContTurn lControll = lCube;
		for (int i = 1; i <= 3; i++) {
			lControll.turn(Dim.getDim(i)); 
		}
		for (int i = 3; i >= 1; i--) {
			for (int k = 0; k <= 2; k++) { 
				lControll.turn(Dim.getDim(i));
			}
		}
	}

}

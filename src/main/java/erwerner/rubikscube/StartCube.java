package erwerner.rubikscube;

import erwerner.rubikscube.cube.Cube;
import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.mvc.controller.iContTurn;
import erwerner.rubikscube.ui.swing.CubeSimpleSwingGUI;

public class StartCube {

	public static void main(String[] args) {
		Cube lCube = new Cube();
		new CubeSimpleSwingGUI( lCube );

		try {
			Thread.sleep(500);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		iContTurn lControll = lCube;
//		lControll.turn(Dim.UP);
		lControll.turn(Dim.UP);
		hold();
		lControll.turn(Dim.UP);
		hold();
		lControll.turn(Dim.DOWN);
		hold();
		lControll.turn(Dim.DOWN);
		hold();
		lControll.turn(Dim.FRONT);
		hold();
		lControll.turn(Dim.FRONT);
		hold();
		lControll.turn(Dim.BACK);
		hold();
		lControll.turn(Dim.BACK);
		hold();
		lControll.turn(Dim.RIGHT);
		hold();
		lControll.turn(Dim.RIGHT);
		hold();
		lControll.turn(Dim.LEFT);
		hold();
		lControll.turn(Dim.LEFT);
//		for (int i = 1; i <= 3; i++) { 
//			lControll.turn(Dim.getDim(i)); 
//			hold();
//		}
//		for (int i = 3; i >= 1; i--) {
//			for (int k = 0; k <= 2; k++) { 
//				lControll.turn(Dim.getDim(i));
//				hold();
//			}
//		}
	}
	public static void hold() { 
		try {
			Thread.sleep(300);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

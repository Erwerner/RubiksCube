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
		
		run(lCube); 
	}
	private static void run(Cube lCube) {
		iContTurn lControll = lCube; 

		lControll.turn(Dim.UP);
		hold();
		lControll.turn(Dim.UP);
		hold();
		lControll.turn(Dim.DOWN);
		hold();
		lControll.turn(Dim.DOWN);
		hold();
		lControll.turn(Dim.RIGHT);
		hold();
		lControll.turn(Dim.RIGHT);
		hold();
		lControll.turn(Dim.LEFT);
		hold();
		lControll.turn(Dim.LEFT); 
		hold();
		lControll.turn(Dim.FRONT);
		hold();
		lControll.turn(Dim.FRONT);
		hold();
		lControll.turn(Dim.BACK);
		hold();
		lControll.turn(Dim.BACK);
		

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
	}
	public static void hold() { 
		try {
			Thread.sleep(100);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}

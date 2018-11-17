package erwerner.rubikscube.ui.swing;

import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.mvc.Model;
import erwerner.rubikscube.mvc.View;
import erwerner.rubikscube.mvc.controller.iContTurn;
import erwerner.rubikscube.mvc.present.iPresentGrid;

public class CubeSimpleSwingGUI extends View implements ActionListener {

	private JLabel mSolved;
	private iPresentGrid mGrid;
	private iContTurn mControllerTurn;

	private JFrame mFrame;
	private SlicePanel[] mSlicePanel = new SlicePanel[7]; 

	public CubeSimpleSwingGUI(Model pModel) {
		super(pModel);
		mGrid = (iPresentGrid) pModel;
		mControllerTurn = (iContTurn) pModel;
		mFrame = new JFrame("Rubik's Cube");
		mFrame.setSize(1500, 1000);
		mFrame.setLayout(new BorderLayout());
		mFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		mSolved = new JLabel("");
		setSolved();
		JPanel lTextPanel = new JPanel();
		lTextPanel.add(mSolved);
		mFrame.add(lTextPanel, BorderLayout.NORTH);

		JPanel lCubePanel = new JPanel();
		lCubePanel.setLayout(new GridLayout(3, 4));
		for (Dim iDim : Dim.getAll()) {
			mSlicePanel[iDim.getInt() + 3] = new SlicePanel(iDim);
			mSlicePanel[iDim.getInt() + 3].fillColors(mGrid);
		}

		lCubePanel.add(new JPanel());
		lCubePanel.add(mSlicePanel[Dim.UP.getInt() + 3]);
		lCubePanel.add(new JPanel());
		lCubePanel.add(new JPanel());

		lCubePanel.add(mSlicePanel[Dim.LEFT.getInt() + 3]);
		lCubePanel.add(mSlicePanel[Dim.FRONT.getInt() + 3]);
		lCubePanel.add(mSlicePanel[Dim.RIGHT.getInt() + 3]);
		lCubePanel.add(mSlicePanel[Dim.BACK.getInt() + 3]);

		lCubePanel.add(new JPanel());
		lCubePanel.add(mSlicePanel[Dim.DOWN.getInt() + 3]);
		lCubePanel.add(new JPanel());
		lCubePanel.add(new JPanel());
		mFrame.add(lCubePanel, BorderLayout.CENTER);

		JPanel lButtonPanel = new JPanel();
		lButtonPanel.setLayout(new GridLayout(0, 6));
		for (Dim iDim : Dim.getAll()) {
			SliceButton lButton = new SliceButton(iDim);
			lButton.addActionListener(this);
			lButtonPanel.add(lButton);
		} 

		mFrame.add(lButtonPanel, BorderLayout.SOUTH);
		mFrame.setVisible(true);
	}

	public void actionPerformed(ActionEvent e) {
		SliceButton lButton = (SliceButton)e.getSource();
		mControllerTurn.turn(lButton.getDim());
	}

	private void setSolved() {
		String lText;
		lText = (mGrid.isSolved()) ? "solved" : "shuffled";
		mSolved.setText(lText);
	}

	@Override
	public void update() {
		setSolved();
		for (Dim iDim : Dim.getAll()) {
			mSlicePanel[iDim.getInt() + 3].fillColors(mGrid);
		}
		mFrame.repaint();
	}

}

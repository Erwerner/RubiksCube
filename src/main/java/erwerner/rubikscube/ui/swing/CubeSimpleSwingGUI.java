package erwerner.rubikscube.ui.swing;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.datatypes.StoneColor;
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
	private JPanel mTextPanel; 

	public CubeSimpleSwingGUI(Model pModel) {
		super(pModel);
		mGrid = (iPresentGrid) pModel;
		mControllerTurn = (iContTurn) pModel;
		mFrame = new JFrame("Rubik's Cube");
		mFrame.setSize(900, 600);
		mFrame.setLayout(new BorderLayout()); 
		mFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		mSolved = new JLabel("");
		Font lFont = mSolved.getFont();
		mSolved.setFont(new Font(lFont.getName(), lFont.getStyle(), 20));
		mTextPanel = new JPanel();
		mTextPanel.add(mSolved);
		Border border = mTextPanel.getBorder();
		Border margin = new LineBorder(Color.BLACK,2);
		mTextPanel.setBorder(new CompoundBorder(border, margin));
		setSolved();
		mFrame.add(mTextPanel, BorderLayout.NORTH);

		JPanel lCubePanel = new JPanel();
		lCubePanel.setLayout(new GridLayout(3, 4));
		for (Dim iDim : Dim.values()) {
			mSlicePanel[iDim.getInt() + 3] = new SlicePanel(iDim);
			mSlicePanel[iDim.getInt() + 3].fillColors(mGrid);
		}

		fillBlankPanel(lCubePanel);
		lCubePanel.add(mSlicePanel[Dim.UP.getInt() + 3]);
		fillBlankPanel(lCubePanel);
		fillBlankPanel(lCubePanel);

		lCubePanel.add(mSlicePanel[Dim.LEFT.getInt() + 3]);
		lCubePanel.add(mSlicePanel[Dim.FRONT.getInt() + 3]);
		lCubePanel.add(mSlicePanel[Dim.RIGHT.getInt() + 3]);
		lCubePanel.add(mSlicePanel[Dim.BACK.getInt() + 3]);

		fillBlankPanel(lCubePanel);
		lCubePanel.add(mSlicePanel[Dim.DOWN.getInt() + 3]);
		fillBlankPanel(lCubePanel);
		fillBlankPanel(lCubePanel);
		
		mFrame.add(lCubePanel, BorderLayout.CENTER);

		JPanel lButtonPanel = new JPanel();
		lButtonPanel.setLayout(new GridLayout(6, 0));
		for (Dim iDim : Dim.values()) {
			SliceButton lButton = new SliceButton(iDim);
			 int[] lRGB = StoneColor.getColor(iDim).getRGB(); 
			lButton.addActionListener(this);
			lButtonPanel.add(lButton);
		} 

		mFrame.add(lButtonPanel, BorderLayout.WEST);
		mFrame.setVisible(true);
	}

	private void fillBlankPanel(JPanel lCubePanel) {
		JPanel lPanel = new JPanel();
		lPanel.setBackground(new Color(240,240,255));
		lCubePanel.add(lPanel);
	}

	public void actionPerformed(ActionEvent e) {
		SliceButton lButton = (SliceButton)e.getSource();
		mControllerTurn.turn(lButton.getDim());
	}

	private void setSolved() {
		String lText;
		if(mGrid.isSolved()) { 
			mSolved.setText(">> SOLVED <<");
			mTextPanel.setBackground(new Color(100, 255, 100));
		}else { 
			mSolved.setText("try to solve it!");
			mTextPanel.setBackground(new Color(255, 200, 150));
		} 
	}

	@Override
	public void update() {
		setSolved();
		for (Dim iDim : Dim.values()) {
			mSlicePanel[iDim.getInt() + 3].fillColors(mGrid);
		}
		mFrame.repaint();
	}

}

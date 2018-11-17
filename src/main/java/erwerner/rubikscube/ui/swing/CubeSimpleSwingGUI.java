package erwerner.rubikscube.ui.swing;
 
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.WindowConstants;

import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.datatypes.StoneColor;
import erwerner.rubikscube.mvc.Model;
import erwerner.rubikscube.mvc.View;
import erwerner.rubikscube.mvc.present.iPresentGrid;

public class CubeSimpleSwingGUI extends View {

	private JLabel mSolved;
	private iPresentGrid mGrid;

	private JFrame mFrame;
	private SlicePanel[] mSlicePanel = new SlicePanel[7];


	public CubeSimpleSwingGUI(Model pModel) {
		super(pModel);
		mGrid = (iPresentGrid) pModel;
        mFrame = new JFrame("Rubik's Cube");       
        mFrame.setSize(1500,1000); 
        mFrame.setLayout(new BorderLayout());
        mFrame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        

        mSolved = new JLabel("");
        setSolved();
        JPanel lTextPanel = new JPanel();   
        lTextPanel.add(mSolved);  
        mFrame.add(lTextPanel,BorderLayout.NORTH);
 
        JPanel lCubePanel = new JPanel();
        lCubePanel.setLayout(new GridLayout(3, 4));
        for(Dim iDim : Dim.getAll()) {
			mSlicePanel[iDim.getInt()+3] = new SlicePanel(iDim);  
			mSlicePanel[iDim.getInt()+3].fillColors(mGrid);
        }
        
        SlicePanel lSlice; 
        lSlice = mSlicePanel[Dim.FRONT.getInt()+3];

        lSlice.addStoneToOrder(0);
        lSlice.addStoneToOrder(3);
        lSlice.addStoneToOrder(6);
        
        lSlice.addStoneToOrder(1);
        lSlice.addStoneToOrder(4);
        lSlice.addStoneToOrder(7);
        
        lSlice.addStoneToOrder(2);
        lSlice.addStoneToOrder(5);
        lSlice.addStoneToOrder(8);

        lSlice = mSlicePanel[Dim.BACK.getInt()+3];

        lSlice.addStoneToOrder(0);
        lSlice.addStoneToOrder(3);
        lSlice.addStoneToOrder(6);
        
        lSlice.addStoneToOrder(1);
        lSlice.addStoneToOrder(4);
        lSlice.addStoneToOrder(7);
        
        lSlice.addStoneToOrder(2);
        lSlice.addStoneToOrder(5);
        lSlice.addStoneToOrder(8);
        
        lSlice = mSlicePanel[Dim.DOWN.getInt()+3];

        lSlice.addStoneToOrder(0);
        lSlice.addStoneToOrder(3);
        lSlice.addStoneToOrder(6);
        
        lSlice.addStoneToOrder(1);
        lSlice.addStoneToOrder(4);
        lSlice.addStoneToOrder(7);
        
        lSlice.addStoneToOrder(2);
        lSlice.addStoneToOrder(5);
        lSlice.addStoneToOrder(8);

        lSlice = mSlicePanel[Dim.UP.getInt()+3];

        lSlice.addStoneToOrder(0);
        lSlice.addStoneToOrder(3);
        lSlice.addStoneToOrder(6);
        
        lSlice.addStoneToOrder(1);
        lSlice.addStoneToOrder(4);
        lSlice.addStoneToOrder(7);
        
        lSlice.addStoneToOrder(2);
        lSlice.addStoneToOrder(5);
        lSlice.addStoneToOrder(8);

        lSlice = mSlicePanel[Dim.RIGHT.getInt()+3];

        lSlice.addStoneToOrder(0);
        lSlice.addStoneToOrder(1);
        lSlice.addStoneToOrder(2);
        lSlice.addStoneToOrder(3);
        lSlice.addStoneToOrder(4);
        lSlice.addStoneToOrder(5);
        lSlice.addStoneToOrder(6); 
        lSlice.addStoneToOrder(7); 
        lSlice.addStoneToOrder(8);

        lSlice = mSlicePanel[Dim.LEFT.getInt()+3];

        lSlice.addStoneToOrder(0);
        lSlice.addStoneToOrder(1);
        lSlice.addStoneToOrder(2);
        lSlice.addStoneToOrder(3);
        lSlice.addStoneToOrder(4);
        lSlice.addStoneToOrder(5);
        lSlice.addStoneToOrder(6); 
        lSlice.addStoneToOrder(7); 
        lSlice.addStoneToOrder(8);
        
        
        lCubePanel.add(new JPanel());
        lCubePanel.add(mSlicePanel[Dim.UP.getInt()+3]);
        lCubePanel.add(new JPanel());
        lCubePanel.add(new JPanel());

        lCubePanel.add(mSlicePanel[Dim.LEFT.getInt()+3]);
        lCubePanel.add(mSlicePanel[Dim.FRONT.getInt()+3]);
        lCubePanel.add(mSlicePanel[Dim.RIGHT.getInt()+3]);
        lCubePanel.add(mSlicePanel[Dim.BACK.getInt()+3]);
        
        lCubePanel.add(new JPanel());
        lCubePanel.add(mSlicePanel[Dim.DOWN.getInt()+3]);
        lCubePanel.add(new JPanel());
        lCubePanel.add(new JPanel());
        mFrame.add(lCubePanel,BorderLayout.CENTER);
        
        mFrame.setVisible(true);
	}

 


	private void setSolved() {
		String lText;
		lText = (mGrid.isSolved()) ? "solved" : "shuffled";
		mSolved.setText(lText);
	}

 

	@Override
	public void update() {
        setSolved(); 
        for(Dim iDim : Dim.getAll()) {
        	mSlicePanel[iDim.getInt()+3].fillColors(mGrid);
        }
        mFrame.repaint();
	}

}

package erwerner.rubikscube.ui.swing;

import java.awt.Color;
import java.awt.Component;
import java.awt.GridLayout;

import javax.swing.JPanel;

import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.datatypes.StoneColor;
import erwerner.rubikscube.mvc.present.iPresentGrid;

public class SlicePanel extends JPanel { 
	private static final long serialVersionUID = 1L;
	private Dim mDim;
	private JPanel[] mColor = new JPanel[9];
	public SlicePanel(Dim pDim) {
		mDim = pDim;
		this.setSize(60,60);
		this.setLayout(new GridLayout(3,3));
		for(int i=0;i<=8;i++) {
			mColor[i] = new JPanel();
			mColor[i].setSize(10, 10);
		}
	}
	public void addStoneToOrder(int iIdx) { 
		this.add(mColor[iIdx]);
	}
	public void fillColors(iPresentGrid pGrid) { 
//		for(Component iComp : this.getComponents()) {
//			this.remove(iComp);
//		}
		int iCount =0;
		for(StoneColor iColor : pGrid.getColorsFromDim(mDim)) { 
			int[] lRGB = iColor.getRGB();
			mColor[iCount++].setBackground(new Color(lRGB[0], lRGB[1], lRGB[2])); 
//			this.add(lRect);
		}  
		this.revalidate(); 
	}

}

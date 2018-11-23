package erwerner.rubikscube.ui.swing;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.CompoundBorder;
import javax.swing.border.LineBorder;

import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.datatypes.StoneColor;
import erwerner.rubikscube.mvc.present.iPresentGrid;

public class SlicePanel extends JPanel {
	private static final long serialVersionUID = 1L;
	private Dim mDim;
	private JPanel[] mColor = new JPanel[9];

	public SlicePanel(Dim pDim) {
		mDim = pDim;
		this.setSize(60, 60);
		this.setLayout(new GridLayout(3, 3));
		Border lBorder = this.getBorder();
		Border lMargin = new LineBorder(Color.BLACK,2);
		this.setBorder(new CompoundBorder(lBorder, lMargin));
		for (int i = 0; i <= 8; i++) {
			mColor[i] = new JPanel();
//			mColor[i].setSize(10, 10);
			Border lColorBorder = mColor[i].getBorder();
			Border lColorMargin = new LineBorder(Color.gray,3);
			mColor[i].setBorder(new CompoundBorder(lColorBorder, lColorMargin));
		}


		JLabel lDimText = new JLabel(mDim.toString());

		switch (pDim) {
		case FRONT:
		case LEFT:
		case UP:
			lDimText.setText(lDimText.getText() + " ↺ ");
			break;

		default:
			lDimText.setText(lDimText.getText() + " ↻ ");
		}
		mColor[4].add(lDimText);

		 
		switch (mDim) {  
		case FRONT:
			this.add(mColor[6]); 
			this.add(mColor[7]);
			this.add(mColor[8]);
			this.add(mColor[3]); 
			this.add(mColor[4]);
			this.add(mColor[5]);
			this.add(mColor[0]);
			this.add(mColor[1]);
			this.add(mColor[2]);
			break;
		case BACK:
			this.add(mColor[8]);
			this.add(mColor[7]);
			this.add(mColor[6]); 
			
			this.add(mColor[5]);
			this.add(mColor[4]);
			this.add(mColor[3]); 
			
			this.add(mColor[2]);
			this.add(mColor[1]);
			this.add(mColor[0]);
			break;
		case UP:
			this.add(mColor[6]); 
			this.add(mColor[7]);
			this.add(mColor[8]);
			
			this.add(mColor[3]); 
			this.add(mColor[4]);
			this.add(mColor[5]);
			

			this.add(mColor[0]);
			this.add(mColor[1]);
			this.add(mColor[2]);

			break;

		case DOWN:
			this.add(mColor[0]);
			this.add(mColor[1]);
			this.add(mColor[2]);
			this.add(mColor[3]); 
			this.add(mColor[4]);
			this.add(mColor[5]);
			this.add(mColor[6]); 
			this.add(mColor[7]);
			this.add(mColor[8]);
			break;
		case LEFT:
			this.add(mColor[8]);
			this.add(mColor[5]);
			this.add(mColor[2]);
			this.add(mColor[7]);
			this.add(mColor[4]);
			this.add(mColor[1]);
			

			this.add(mColor[6]); 
			this.add(mColor[3]); 
			this.add(mColor[0]);
			
			break;
		case RIGHT:
			this.add(mColor[2]);
			this.add(mColor[5]);
			this.add(mColor[8]);
			
			this.add(mColor[1]);
			this.add(mColor[4]);
			this.add(mColor[7]);
			

			this.add(mColor[0]);
			this.add(mColor[3]); 
			this.add(mColor[6]); 
			break;
		}
	} 
 

	public void fillColors(iPresentGrid pGrid) {
		int iCount = 0;
		for (StoneColor iColor : pGrid.getColorsFromDim(mDim)) {
			int[] lRGB = iColor.getRGB();
			mColor[iCount++].setBackground(new Color(lRGB[0], lRGB[1], lRGB[2])); 
		}
		this.revalidate();
	}

}

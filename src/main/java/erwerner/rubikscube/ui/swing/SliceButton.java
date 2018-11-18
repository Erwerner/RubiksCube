package erwerner.rubikscube.ui.swing;

import javax.swing.JButton;

import erwerner.rubikscube.datatypes.Dim;

public class SliceButton extends JButton { 
	private static final long serialVersionUID = 1L;
	private Dim mDim;

	public SliceButton(Dim pDim) {
		super("Turn " + pDim.toString());
		mDim = pDim;
		
	}

	public Dim getDim() { 
		return mDim;
	}


}

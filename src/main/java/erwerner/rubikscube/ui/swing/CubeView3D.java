package erwerner.rubikscube.ui.swing;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.Path2D;

import javax.swing.JPanel;

import erwerner.rubikscube.datatypes.Dim;
import erwerner.rubikscube.datatypes.StoneColor;
import erwerner.rubikscube.mvc.present.iPresentGrid;

public class CubeView3D  extends JPanel{

	private iPresentGrid mGrid;

	    public CubeView3D(iPresentGrid pGrid){
	    	mGrid = pGrid;
	        setPreferredSize(new Dimension(300, 300));
	    }

	    @Override
	    public void paintComponent(Graphics g){
	        super.paintComponent(g);
	        Path2D.Double parallelogram;
	        parallelogram = new Path2D.Double();
	        parallelogram.moveTo(0,0);
	        parallelogram.lineTo(50,0);
	        parallelogram.lineTo(100,50);
	        parallelogram.lineTo(50,50);
	        Graphics2D g2d = (Graphics2D)g;
	        int[] lRGB = mGrid.getColorsFromDim(Dim.FRONT)[1].getRGB();
	        Color lColor = new Color(lRGB[0],lRGB[1],lRGB[2]);
			g2d.setColor(lColor );
	        g2d.fill(parallelogram);
	    }  
}

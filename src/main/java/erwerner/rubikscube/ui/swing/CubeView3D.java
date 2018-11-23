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

public class CubeView3D extends JPanel {

	private static final int cBlockSizeY = 20; 
	private iPresentGrid mGrid;
	

	public CubeView3D(iPresentGrid pGrid) {
		mGrid = pGrid;
		setPreferredSize(new Dimension(300, 300));
	}

	@Override
	public void paintComponent(Graphics lGraphics) { 
		super.paintComponent(lGraphics);
		for (int iY = 2; iY >= 0; iY--) {
			for (int iX = 2; iX >=0; iX--) {
				StoneColor lStoneColor = mGrid.getColorsFromDim(Dim.UP)[iX + iY * 3];
				addUpSide(lGraphics, iX * cBlockSizeY + iY * cBlockSizeY, cBlockSizeY * 2-iY * cBlockSizeY, lStoneColor);
				addUpSideBorder(lGraphics, iX * cBlockSizeY + iY * cBlockSizeY, cBlockSizeY * 2-iY * cBlockSizeY, lStoneColor);
				
			}
		}
		for (int iZ = 2; iZ >= 0; iZ--) {
			for (int iX = 2; iX >=0; iX--) {
				StoneColor lStoneColor = mGrid.getColorsFromDim(Dim.FRONT)[iX + iZ * 3];
				addFrontSide(lGraphics, iX * cBlockSizeY  ,cBlockSizeY * 3 +  cBlockSizeY * 2-iZ * cBlockSizeY, lStoneColor);
				addFrontSideBorder(lGraphics, iX * cBlockSizeY  ,cBlockSizeY * 3 +  cBlockSizeY * 2-iZ * cBlockSizeY, lStoneColor);
				}
		}
		for (int iY = 2; iY >= 0; iY--) {
			for (int iZ = 2; iZ >=0; iZ--) {
				StoneColor lStoneColor = mGrid.getColorsFromDim(Dim.RIGHT)[iZ * 3 + iY ];
				addRightSide(lGraphics, cBlockSizeY * 3 + iZ * cBlockSizeY  ,  cBlockSizeY * 3 + cBlockSizeY * 2-iY * cBlockSizeY - iZ*cBlockSizeY, lStoneColor);
				addRightSideBorder(lGraphics, cBlockSizeY * 3 + iZ * cBlockSizeY  ,  cBlockSizeY * 3 + cBlockSizeY * 2-iY * cBlockSizeY - iZ*cBlockSizeY, lStoneColor);
				}
		}
	}

	private void addUpSide(Graphics g, double pPosX, double pPosY, StoneColor pStoneColor) {
		Path2D.Double lParallelogram;
		lParallelogram = new Path2D.Double();
		lParallelogram.moveTo(pPosX, pPosY+cBlockSizeY);
		lParallelogram.lineTo(pPosX + cBlockSizeY, pPosY+cBlockSizeY);
		lParallelogram.lineTo(pPosX + cBlockSizeY*2, pPosY);
		lParallelogram.lineTo(pPosX + cBlockSizeY, pPosY);
		Graphics2D g2d = (Graphics2D) g;
		int[] lRGB = pStoneColor.getRGB();
		Color lColor = new Color(lRGB[0], lRGB[1], lRGB[2]);
		g2d.setColor(lColor);
		g2d.fill(lParallelogram);
	}
	private void addUpSideBorder(Graphics g, double pPosX, double pPosY, StoneColor pStoneColor) {
		Path2D.Double lParallelogram;
		lParallelogram = new Path2D.Double();
		lParallelogram.moveTo(pPosX, pPosY+cBlockSizeY);
		lParallelogram.lineTo(pPosX + cBlockSizeY, pPosY+cBlockSizeY);
		lParallelogram.lineTo(pPosX + cBlockSizeY*2, pPosY);
		lParallelogram.lineTo(pPosX + cBlockSizeY, pPosY);
		Graphics2D g2d = (Graphics2D) g;  
		g2d.setColor(new Color(0,0,0)); 
		g2d.draw(lParallelogram);
	}
	private void addFrontSide(Graphics g, double pPosX, double pPosY, StoneColor pStoneColor) {
		Path2D.Double lParallelogram;
		lParallelogram = new Path2D.Double();
		lParallelogram.moveTo(pPosX, pPosY+cBlockSizeY);
		lParallelogram.lineTo(pPosX + cBlockSizeY, pPosY+cBlockSizeY);
		lParallelogram.lineTo(pPosX + cBlockSizeY, pPosY);
		lParallelogram.lineTo(pPosX, pPosY);
		Graphics2D g2d = (Graphics2D) g;
		int[] lRGB = pStoneColor.getRGB();
		Color lColor = new Color(lRGB[0], lRGB[1], lRGB[2]);
		g2d.setColor(lColor);
		g2d.fill(lParallelogram);
	}
	private void addFrontSideBorder(Graphics g, double pPosX, double pPosY, StoneColor pStoneColor) {
		Path2D.Double lParallelogram;
		lParallelogram = new Path2D.Double();
		lParallelogram.moveTo(pPosX, pPosY+cBlockSizeY);
		lParallelogram.lineTo(pPosX + cBlockSizeY, pPosY+cBlockSizeY);
		lParallelogram.lineTo(pPosX + cBlockSizeY, pPosY);
		lParallelogram.lineTo(pPosX, pPosY);
		Graphics2D g2d = (Graphics2D) g;  
		g2d.setColor(new Color(0,0,0)); 
		g2d.draw(lParallelogram);
	}
	private void addRightSide(Graphics g, double pPosX, double pPosY, StoneColor pStoneColor) {
		Path2D.Double lParallelogram;
		lParallelogram = new Path2D.Double();
		lParallelogram.moveTo(pPosX, pPosY);
		lParallelogram.lineTo(pPosX , pPosY + cBlockSizeY);
		lParallelogram.lineTo(pPosX + cBlockSizeY, pPosY);
		lParallelogram.lineTo(pPosX +cBlockSizeY, pPosY - cBlockSizeY);
		Graphics2D g2d = (Graphics2D) g;
		int[] lRGB = pStoneColor.getRGB();
		Color lColor = new Color(lRGB[0], lRGB[1], lRGB[2]);
		g2d.setColor(lColor);
		g2d.fill(lParallelogram);
	}
	private void addRightSideBorder(Graphics g, double pPosX, double pPosY, StoneColor pStoneColor) {
		Path2D.Double lParallelogram;
		lParallelogram = new Path2D.Double();
		lParallelogram.moveTo(pPosX, pPosY);
		lParallelogram.lineTo(pPosX , pPosY + cBlockSizeY);
		lParallelogram.lineTo(pPosX + cBlockSizeY, pPosY);
		lParallelogram.lineTo(pPosX +cBlockSizeY, pPosY - cBlockSizeY);
		Graphics2D g2d = (Graphics2D) g;  
		g2d.setColor(new Color(0,0,0)); 
		g2d.draw(lParallelogram);
	}
}

package Testing.Visual;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.AffineTransform;
import java.awt.geom.Ellipse2D;

import javax.swing.JPanel;

import Dungeon.Utility.Constants;

@SuppressWarnings("serial")
public class Board extends JPanel {

	public Board() {}
	
	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		drawDungeon(g);
	}
	
	private void drawDungeon(Graphics g) {
		//Dungeon dungeon = Core.dungeon;
		Graphics2D g2d = (Graphics2D) g;
		RenderingHints rh = new RenderingHints(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
		rh.put(RenderingHints.KEY_RENDERING, RenderingHints.VALUE_RENDER_QUALITY);
		g2d.setRenderingHints(rh);
		Dimension size = getSize();
		double w = size.getWidth();
		double h = size.getHeight();
		Ellipse2D e = new Ellipse2D.Double(0, 0, 80, 130);
		g2d.setStroke(new BasicStroke(1));
		g2d.setColor(Color.gray);
		for(int deg = 0; deg < Constants.VISUAL_Y; deg++) {
			AffineTransform at = AffineTransform.getTranslateInstance(w / 2, h / 2);
			at.rotate(Math.toRadians(deg));
			g2d.draw(at.createTransformedShape(e));
		}
	}
}

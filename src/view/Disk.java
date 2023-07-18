package view;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.GradientPaint;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Point;
import java.awt.RenderingHints;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JPanel;
import javax.swing.JRadioButton;

import model.SampleModel;

public class Disk extends JPanel implements ActionListener{
//	Point point ;
	Integer xInteger;
	private Graphics2D g2;
	public Disk() {
		initComponents();
        setOpaque(false);
	}
	
//	public fixBackground() {
//        initComponents();
//        setOpaque(false);
//    }

    public Graphics2D getG2() {
		return g2;
	}

	public void setG2(Graphics2D g2) {
		this.g2 = g2;
	}

	// <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 142, Short.MAX_VALUE)
        );
    }// </e
	@Override
	protected void paintComponent(Graphics g) {
		super.paintComponent(g);
//        listmemory.add(50);
//        listmemory.add(150);
//        for(int i =0; i< listmemory.size();i++) {
//        	int idt = listmemory.indexOf(i);
//        	g2.setColor(Color.DARK_GRAY);
//    		g2.fillRect(idt, idt, idt, idt);
//        }
		addg(g);
        
//		g.setColor(Color.red);
//		g.drawLine(15, 15, 50, 150);
		
//		g.setColor(Color.blue);
//		g.drawOval(255, 255, 50, 50);
		
//		g.setColor(Color.green);
//		g.drawRect(45, 150, 30, 90);
		
//		g.setColor(Color.pink);
//		g.fillOval(400, 300, 50, 50);
		
		
//		g2.setColor(Color.DARK_GRAY);
//		g2.fillRect(100, 100, 150, 150);
//		addg(g);
		
//		g.setColor(Color.YELLOW);
//		g.drawString("HELLO TITV", 250, 250);	
		
	}
    private void drawEllipses(Graphics2D g2d,ArrayList<SampleModel> oj) {
//    	if(oj != null) {
    		for (int i = 0; i < oj.size(); i++) {
    			int idt = oj.get(i).getSize();
            	g2.setColor(oj.get(i).getCloColor());
            	g2.fillRect(oj.get(i).getX(), oj.get(i).getY()+(100*i), 142, idt);
            	
            	g2.setColor(Color.BLACK);
                g2.drawString(oj.get(i).getIndexID(), 40, oj.get(i).getY()+(100*i)+ (idt/2));
            }
//    	}
    }
	public void addg(Graphics g) {
		g2 = (Graphics2D) g;
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#c79081"), 0, getHeight(), Color.decode("#e4efe9"));
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
        g2.fillRect(getWidth() , 0, getWidth(), getHeight());
        g2.fillRect(0, getHeight() , getWidth(), getHeight());
//        listmemory.add(50);
//        listmemory.add(150);
//        for(int i =0; i< listmemory.size();i++) {
//        	int idt = listmemory.indexOf(i);
//        	g2.setColor(Color.DARK_GRAY);
//    		g2.fillRect(idt, idt, idt, idt);
//        }
//		g2.setColor(Color.DARK_GRAY);
//		g2.fillRect(100, 100, 150, 150);
//        
//		g2.setColor(Color.YELLOW);
//		g2.drawString("HELLO TITV", 250, 250);	
//        listmemory.add(50);
//    	listmemory.add(150);
//        for (int i = 0; i < listmemory.size(); i++) {
//        	int idt = listmemory.get(i);
//        	g2.setColor(Color.DARK_GRAY);
//        	g2.fillRect(idt, idt, idt, idt);
//        }
        ArrayList<SampleModel> oj = SampleView.Disk;
        drawEllipses(g2,oj);
		g2.dispose();
	}
	public void remake() {
//		g2.dispose();
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
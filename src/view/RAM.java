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

public class RAM extends JPanel implements ActionListener{
//	Point point ;
	Integer xInteger;
	private Graphics2D g2;
	public RAM() {
		initComponents();
        setOpaque(false);
	}
	
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
		addg(g);
	}
    private void drawEllipses(Graphics2D g2d,ArrayList<SampleModel> oj) {
//    	if(oj != null) {
    		for (int i = 0; i < oj.size(); i++) {
            	int idt = oj.get(i).getSize();
            	if(oj.get(i).getIsCheck()) {
            		continue;
            	}
            	g2.setColor(oj.get(i).getCloColor());
            	g2.fillRect(oj.get(i).getX(), oj.get(i).getY()+200, 142, idt);
            	
            	g2.setColor(Color.black);
                g2.drawString(oj.get(i).getIndexID(), oj.get(i).getX()+ (idt/4), oj.get(i).getY()+200+ (idt/2));
            }
//    	}
    }
	public void addg(Graphics g) {
		g2 = (Graphics2D) g;
        g2.setColor(getBackground());
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
        GradientPaint gp = new GradientPaint(0, 0, Color.decode("#D3D7D9"), 0, getHeight(), Color.decode("#071B26"));
        g2.setPaint(gp);
        g2.fillRoundRect(0, 0, getWidth(), getHeight(), 0, 0);
        g2.fillRect(getWidth() , 0, getWidth(), getHeight());
        g2.fillRect(0, getHeight() , getWidth(), getHeight());
        
//        int size = (int)(SampleView.Size_Ram -SampleView.Size_Ram*0.65);
//    	g2.setColor(Color.DARK_GRAY);
//    	g2.fillRect(0, 0, 142,size);
//        listmemory.add(50);
//        listmemory.add(150);
//        for(int i =0; i< listmemory.size();i++) {
//        	int idt = listmemory.indexOf(i);
//        	g2.setColor(Color.DARK_GRAY);
//    		g2.fillRect(idt, idt, idt, idt);
//        }
        Color aColor = new Color(35,100,103);
        	g2.setColor(aColor);
//    		g2.fillRect(1, 1, 142, size);
    		g2.fillRect(0, 0, 142, 200);
    		g2.setColor(Color.WHITE);
            g2.drawString("Operating System", 30,100);

        ArrayList<SampleModel> oj = SampleView.Ram;
        drawEllipses(g2,oj);
		g2.dispose();
	}
	public void remake() {
		this.repaint();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		repaint();
	}
}
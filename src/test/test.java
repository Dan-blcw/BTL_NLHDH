package test;

import java.awt.Color;

import javax.swing.UIManager;

import view.EnterSizeView;

public class test {
    public static void main(String[] args) {
        try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			new EnterSizeView();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
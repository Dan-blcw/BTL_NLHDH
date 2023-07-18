package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Point;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import controller.EnterSizeController;
import controller.SampleController;
import model.SampleModel;

public class SampleView extends JFrame{
	Boolean isFill = false;
	int cnt = 0;
	JTextField jTextFieldKeyWord;
	private JTextArea jTextAreaParagrah;
	JTextField jTextFieldReSize;
	public static int Size_Avail_Programs;
	public static int Size_Ram;
	public static int Size_Disk;
	private int maxWeight = 0;
	private int Currentlyindex_= 0;
	private int Currentlyindex_R= 0;
	private int Currentlyindex_D= 0;
	public static ArrayList<SampleModel> Avail_Programs = new ArrayList<SampleModel>();
	public static ArrayList<SampleModel> Ram = new ArrayList<SampleModel>();
	public static ArrayList<SampleModel> Disk = new ArrayList<SampleModel>();
	Color Colour0 = new Color(255,153,0);
	Color Colour1 = new Color(151,207,174);
	Color Colour2 = new Color(146,122,236);
	Color Colour3 = new Color(132,241,117);
	Color Colour4 = new Color(239,249,109);
	Color Colour5 = new Color(245,113,126);
	Color Colour6 = new Color(155,202,203);
	Color Colour7 = new Color(179,179,179);
	Color Colour8 = new Color(129,229,198);
	Color Colour9 = new Color(51,102,0);
	
	public static ArrayList<Color> Clo = new ArrayList<Color>();

	public static int index_ = 0;
	public static int index_R = 0;
	public int index_D = 0;
	private JLabel jLabel_Empty0 = new JLabel();
	private JLabel jLabel_Empty1 = new JLabel();
	private JLabel jLabel_Empty2 = new JLabel();
	private JLabel jLabel_Empty3 = new JLabel();
	private JLabel jLabel_Empty4 = new JLabel();
	private JLabel jLabel_Empty5 = new JLabel();
	public RAM ram;
	public Disk disk;
	public Avail_Programs avail_Programs;
	public int getSizeDouble() {
		return Size_Avail_Programs;
	}	
	public void setSizeDouble(int sizeDouble) {
		this.Size_Avail_Programs = sizeDouble;
	}
	public SampleView(int size,ArrayList<SampleModel> Ram) {
		this.Size_Avail_Programs = size;
		this.Avail_Programs = Avail_Programs;
		init();
	}
	
	public SampleView(int size) {
		this.Size_Avail_Programs = size;
		this.Size_Ram = size;
		init();
		
	}
	public void init() {
		addClo();
		this.setTitle("Draw Example");
		// Khong xoa dong Nay
//		this.setSize(442, Size_Avail_Programs+203);
		this.setSize(426, Size_Avail_Programs+162);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setLocationRelativeTo(null);
		setUndecorated(true);
		Font nFont = new java.awt.Font("sansserif", 3, 14);
		ram = new RAM();
		avail_Programs = new Avail_Programs();
		disk = new Disk();
		JPanel jPanel_info = new JPanel();
        jPanel_info.setLayout(new GridLayout(6,3));
        jTextAreaParagrah = new JTextArea(5,10);
        jTextAreaParagrah.setFont(nFont);
        JLabel jLabel_Position = new JLabel("Program Size");
        JLabel jLabel_1 = new JLabel("Available Program");
        JLabel jLabel_2 = new JLabel("Ram");
        JLabel jLabel_3 = new JLabel("Disk");
        JLabel jLabel_ChangeSize = new JLabel("Resize To");
        jLabel_ChangeSize.setBackground(Color.white);
        jLabel_Position.setFont(nFont);
        jLabel_ChangeSize.setFont(nFont);
        jTextFieldKeyWord = new  JTextField();
        jTextFieldKeyWord.setFont(nFont);
        jTextFieldReSize = new  JTextField();
        jTextFieldReSize.setFont(nFont);
        SampleController  sr = new SampleController(this);
        JButton jButton_Add = new JButton("Add");
        jButton_Add.addActionListener(sr);
        jButton_Add.setBackground(Color.WHITE);
        JButton jButton_ClearAll = new JButton("ClearAll");
        jButton_ClearAll.addActionListener(sr);
        jButton_ClearAll.setBackground(Color.WHITE);
        JButton jButton_ClearRAM_Disk = new JButton("ClearRunning");
        jButton_ClearRAM_Disk.addActionListener(sr);
        jButton_ClearRAM_Disk.setBackground(Color.WHITE);
        JButton jButton_ReSize = new JButton("Resize");
        jButton_ReSize.addActionListener(sr);
        jButton_ReSize.setBackground(Color.WHITE);
        JButton jButton_Running = new JButton("Running Each");
        jButton_Running.addActionListener(sr);
        jButton_Running.setBackground(Color.WHITE);
        jButton_Add.setFont(nFont);
        jButton_ClearRAM_Disk.setFont(nFont);
        jButton_ClearAll.setFont(nFont);
        jButton_ReSize.setFont(nFont);
        jButton_Running.setFont(nFont);
        jPanel_info.add(jLabel_1);
        jPanel_info.add(jLabel_2);
        jPanel_info.add(jLabel_3);
        jPanel_info.add(jLabel_Position);
        jPanel_info.add(jTextFieldKeyWord);
        jPanel_info.add(jButton_Add); 
        jPanel_info.add(jLabel_Empty0);
        jPanel_info.add(jLabel_Empty1);
        jPanel_info.add(jLabel_Empty2);
        jPanel_info.add(jLabel_ChangeSize);
        jPanel_info.add(jTextFieldReSize);
        jPanel_info.add(jButton_ReSize);
        jPanel_info.add(jLabel_Empty3);
        jPanel_info.add(jLabel_Empty4);
        jPanel_info.add(jLabel_Empty5);
        jPanel_info.add(jButton_Running);
        jPanel_info.add(jButton_ClearAll);
        jPanel_info.add(jButton_ClearRAM_Disk);
		this.setLayout(new BorderLayout());
		this.add(disk, BorderLayout.EAST);
		this.add(avail_Programs, BorderLayout.WEST);
		this.add(ram, BorderLayout.CENTER);
		this.add(jPanel_info, BorderLayout.SOUTH);
		this.setVisible(true);
	}
	

	public void addDocumentSize() {
	    int size = Integer.parseInt(jTextFieldKeyWord.getText());
		if(index_ == 0 && Avail_Programs.isEmpty()) {
			SampleModel aModel = new SampleModel(size,0,0,Random());
			Avail_Programs.add(aModel);
			index_ += size;
			Currentlyindex_ += size;
		}else {
			if(Currentlyindex_ +size <= Size_Avail_Programs) {
				SampleModel aModel0 = new SampleModel(size, 0,index_,Random());
				index_ += size;
				Currentlyindex_ += size;
				maxWeight = Math.max(maxWeight, size);
				Avail_Programs.add(aModel0);
			}else {
					ShowMesseger("Memory cell is full (Without Sort)!!!");
			}
		}
		avail_Programs.remake();
	}
	
	public void Running_Each() {
		cnt++;
		if(isFill == true) {
			int max = findMaxNear(Avail_Programs.get(cnt-1).getSize(),Ram);//0
			SampleModel aModel = Avail_Programs.get(cnt-1);
			SampleModel aSampleView = Ram.get(max);
			int m = findd(aSampleView.getSize(), Avail_Programs);
			Avail_Programs.get(m).setIsCheck(true);//0
			aModel.setY(aSampleView.getY());
			Ram = new ArrayList<SampleModel>();
			Disk.add(aSampleView);
			for(int i=0;i<Disk.size();i++) {
				Disk.get(i).setY(index_D);;
				index_D += aSampleView.getSize();
			}
			ram.remake();disk.remake();
			isFill = false;
		}
			for(int i =0;i<cnt;i++) {
				SampleModel aModel = Avail_Programs.get(i);
				aModel.setCloColor(Clo.get(i));
				aModel.setY(index_R);
				if(aModel.getIsCheck() == false) {
					Currentlyindex_R += aModel.getSize();
					index_R += aModel.getSize();
					Ram.add(aModel);
				}else {
					continue;
				}
				}
			ram.remake();
			if(Currentlyindex_R + Avail_Programs.get(cnt).getSize()+ 200> (Size_Ram) && cnt < Avail_Programs.size()) {
				isFill = true;
			}
			Currentlyindex_R = 0;
			index_R = 0;
			
//			
//			if(Size_Ram == 500) {
//				new SampleView(1000);
//				this.dispose();
//			}
//			
//			if(cnt == 0 && isFill == false) {
////				for(int i =0;i<cnt;i++) {
//					SampleModel aModel = Avail_Programs.get(0);
//					aModel.setCloColor(Clo.get(0));
//					aModel.setY(index_R);
////					if(Currentlyindex_R + aModel.getSize() <= Size_Ram) {
//						Currentlyindex_R += aModel.getSize();
//						index_R += aModel.getSize();
//						Ram.add(aModel);ram.remake();
////						Disk.add(aModel);disk.remake();
////					}
////					}
//			}
//			else if(cnt != 0 && isFill == false){
//			cnt++;
//			for(int i =0;i<cnt;i++) {
//				SampleModel aModel = Avail_Programs.get(i);
//				aModel.setCloColor(Clo.get(i));
//				aModel.setY(index_R);
////				if(Currentlyindex_R + aModel.getSize() <= Size_Ram) {
//					Currentlyindex_R += aModel.getSize();
//					index_R += aModel.getSize();
//					Ram.add(aModel);ram.remake();
////					Disk.add(aModel);disk.remake();
////				}
//				}
		
//			cnt++;
//			for(int i =0;i<cnt;i++) {
//				SampleModel aModel = Avail_Programs.get(i);
//				aModel.setCloColor(Clo.get(i));
//				aModel.setY(index_R);
////				if(Currentlyindex_R + aModel.getSize() <= Size_Ram) {
//					Currentlyindex_R += aModel.getSize();
//					index_R += aModel.getSize();
//					Ram.add(aModel);ram.remake();
////					Disk.add(aModel);disk.remake();
////				}
//				}
//		}else {
//			for(int i = 0 ;i< cnt ;i++) {
//				int max = findMaxNear(Avail_Programs.get(cnt).getSize(), Ram);
//				Ram.add(max,Avail_Programs.get(cnt));
////				Ram.remove(max-1);
//				SampleModel aSampleView = Avail_Programs.get(max);
//				Disk.add(aSampleView);
//				ram.remake();
//				disk.remake();
////				for(int i =0;i<cnt;i++) {
////					SampleModel aModel = Avail_Programs.get(i);
////					aModel.setCloColor(Clo.get(i));
////					aModel.setY(index_R);
//////					if(Currentlyindex_R + aModel.getSize() <= Size_Ram) {
////						Currentlyindex_R += aModel.getSize();
////						index_R += aModel.getSize();
////						Ram.add(aModel);ram.remake();
//////						Disk.add(aModel);disk.remake();
//////					}
////				}
////			}	}
//		}}
//		for(int i =0;i<cnt;i++) {
//				SampleModel aModel = Avail_Programs.get(i);
//				aModel.setCloColor(Clo.get(i));
//				aModel.setY(index_R);
////				if(Currentlyindex_R + aModel.getSize() <= Size_Ram) {
//					Currentlyindex_R += aModel.getSize();
//					index_R += aModel.getSize();
//					Ram.add(aModel);ram.remake();
////					Disk.add(aModel);disk.remake();
////				}
//		}
//		cnt++;
//		if(isFill == false) {
//			cnt++;
//		}else {
//			ShowMesseger("Memory cell is full (Without Sort)!!!");
//		}
//		if(Currentlyindex_R + Avail_Programs.get(cnt).getSize() < Size_Avail_Programs && isFill == false) {
//			cnt++;
//		}else {
//			isFill = true;
//			int max = findMaxNear(Avail_Programs.get(cnt+1).getSize(), Avail_Programs);
//			for(int i = 0 ;i< cnt ;i++) {
//				SampleModel aSampleView = Avail_Programs.get(max);
//				Disk.add(aSampleView);
//				Ram.add(max,Avail_Programs.get(cnt+1));
//			}
//		}
//		if(Currentlyindex_R + Avail_Programs.get(cnt+1).getSize() < Size_Avail_Programs && isFill == false) {
//			cnt++;
//		}else {
//			isFill = true;
//		}
	}
	
	public int findMaxNear(int size ,ArrayList<SampleModel> test) {
//		int adnew = Avail_Programs.get(cnt-1).getSize();
//		Queue<Integer> animal1 = new LinkedList<>();
//		for(int i =0 ;i<test.size();i++) {
//			animal1.add(test.get(i).getSize());
//		}
		int sum = size;
		int max = 0;
		int maxx = 0;
		for(int i =0 ;i<test.size();i++) {
			sum += test.get(i).getSize();
			if(sum > Size_Ram && max  < test.get(i).getSize()) {
				maxx = i;
				max = test.get(i).getSize();
			}
//			if(sizeSwap < sum) {
//				return i;
//			}
		}
		return maxx;
	}
	
	public int findd(int size ,ArrayList<SampleModel> test) {
		for(int i = 0 ;i< test.size();i++) {
			if(test.get(i).getSize() == size) {
				return i;
			}
		}
		return -1;
	}
	
	public void clearRAM_Disk() {
		Ram = new ArrayList<SampleModel>();
		ram.remake();
		Disk = new ArrayList<SampleModel>();
		disk.remake();
		for(int i=0;i<Avail_Programs.size();i++) {
			Avail_Programs.get(i).setIsCheck(false);
		}
	}
	
	public void clearAll() {
		new SampleView(Size_Avail_Programs);
		Avail_Programs.clear();
		ram.remake();
		this.dispose();
	}
	public void ShowMesseger(String decripl) {
		JOptionPane.showMessageDialog(this, decripl);
	}
	public void createMainFramework() {
    	int size = Integer.parseInt(jTextFieldReSize.getText());
		new SampleView(size,Ram);
		Currentlyindex_ = 0;
		index_ = 0;
		this.dispose();
	}
	public String Random() {
//		Math.random() * (max - min + 1) + min;
		long aLong = (long) (Math.random() * (100000 - 10 + 1) + 10);
		String s= Long.toString(aLong);
		return "Ox - "+s;
	}
	public void addClo() {
		Clo.add(Colour0);
		Clo.add(Colour1);
		Clo.add(Colour2);
		Clo.add(Colour3);
		Clo.add(Colour4);
		Clo.add(Colour6);
		Clo.add(Colour7);
		Clo.add(Colour8);
		Clo.add(Colour9);
		Clo.add(Colour5);
		Clo.add(Colour0);
		Clo.add(Colour1);
		Clo.add(Colour2);
		Clo.add(Colour3);
		Clo.add(Colour4);
		Clo.add(Colour6);
		Clo.add(Colour7);
		Clo.add(Colour8);
		Clo.add(Colour9);
		Clo.add(Colour5);
		Clo.add(Colour0);
		Clo.add(Colour1);
		Clo.add(Colour2);
		Clo.add(Colour3);
		Clo.add(Colour4);
		Clo.add(Colour6);
		Clo.add(Colour7);
		Clo.add(Colour8);
		Clo.add(Colour9);
		Clo.add(Colour5);
		Clo.add(Colour0);
		Clo.add(Colour1);
		Clo.add(Colour2);
		Clo.add(Colour3);
		Clo.add(Colour4);
		Clo.add(Colour6);
		Clo.add(Colour7);
		Clo.add(Colour8);
		Clo.add(Colour9);
		Clo.add(Colour5);
		Clo.add(Colour0);
		Clo.add(Colour1);
		Clo.add(Colour2);
		Clo.add(Colour3);
		Clo.add(Colour4);
		Clo.add(Colour6);
		Clo.add(Colour7);
		Clo.add(Colour8);
		Clo.add(Colour9);
		Clo.add(Colour5);
		Clo.add(Colour0);
		Clo.add(Colour1);
		Clo.add(Colour2);
		Clo.add(Colour3);
		Clo.add(Colour4);
		Clo.add(Colour6);
		Clo.add(Colour7);
		Clo.add(Colour8);
		Clo.add(Colour9);
		Clo.add(Colour5);
	}
	
}

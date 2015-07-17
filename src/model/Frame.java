package model;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Color;
import javax.swing.JTextArea;
import javax.swing.border.BevelBorder;
import javax.swing.text.DefaultCaret;
import javax.swing.JScrollPane;
import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

public class Frame extends JFrame {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public JTextArea textArea;
	
	private static Philosopher[] p;
	
	public static JTextField TempoComen;
	public static JTextField TempoPens;
	
	private static JLabel lblMesaFilosofo_0;
	private static JLabel lblMesaFilosofo_1;
	private static JLabel lblMesaFilosofo_2;
	private static JLabel lblMesaFilosofo_3;
	private static JLabel lblMesaFilosofo_4;
	
	private static JLabel lblFamFilos_0;
	private static JLabel lblFamFilos_1;
	private static JLabel lblFamFilos_2;
	private static JLabel lblFamFilos_3;
	private static JLabel lblFamFilos_4;
	
	private static JLabel lblPensFilos_0;
	private static JLabel lblPensFilos_1;
	private static JLabel lblPensFilos_2;
	private static JLabel lblPensFilos_3;
	private static JLabel lblPensFilos_4;

	public Frame() {
		p = new Philosopher[5];
		for(int i=0; i<5; i++){
			p[i] = new Philosopher(i,this);
		}
		
		for(int i=0; i<5; i++){
			p[i].setRIGHT(p[(i+1)%5]);
			p[i].setLEFT(p[(i+4)%5]);
		}

		getContentPane().setMaximumSize(new Dimension(1024, 768));
		getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setMaximumSize(new Dimension(1024, 768));
		panel.setBackground(Color.WHITE);
		panel.setForeground(Color.BLACK);
		panel.setBounds(0, 0, 684, 557);
		getContentPane().add(panel);
		panel.setLayout(null);
		this.setResizable(false);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		lblMesaFilosofo_0 = new JLabel("filosofo0");
		lblMesaFilosofo_0.setIcon(new ImageIcon(Frame.class.getResource("/Images/filosofo0.jpg")));
		lblMesaFilosofo_0.setBounds(176, 11, 61, 88);
		panel.add(lblMesaFilosofo_0);
		lblMesaFilosofo_0.setVisible(false);
		
		lblMesaFilosofo_1 = new JLabel("filosofo1");
		lblMesaFilosofo_1.setIcon(new ImageIcon(Frame.class.getResource("/Images/filosofo1.jpg")));
		lblMesaFilosofo_1.setBounds(46, 113, 59, 83);
		panel.add(lblMesaFilosofo_1);
		lblMesaFilosofo_1.setVisible(false);
		
		lblMesaFilosofo_2 = new JLabel("filosofo2");
		lblMesaFilosofo_2.setIcon(new ImageIcon(Frame.class.getResource("/Images/filosofo2.jpg")));
		lblMesaFilosofo_2.setBounds(90, 264, 61, 83);
		panel.add(lblMesaFilosofo_2);
		lblMesaFilosofo_2.setVisible(false);
		
		lblMesaFilosofo_3 = new JLabel("filosofo3");
		lblMesaFilosofo_3.setIcon(new ImageIcon(Frame.class.getResource("/Images/filosofo3.jpg")));
		lblMesaFilosofo_3.setBounds(264, 264, 61, 83);
		panel.add(lblMesaFilosofo_3);
		lblMesaFilosofo_3.setVisible(false);
		
		lblMesaFilosofo_4 = new JLabel("filosofo4");
		lblMesaFilosofo_4.setIcon(new ImageIcon(Frame.class.getResource("/Images/filosofo4.jpg")));
		lblMesaFilosofo_4.setBounds(301, 113, 65, 83);
		panel.add(lblMesaFilosofo_4);
		lblMesaFilosofo_4.setVisible(false);
		
		JLabel lblImage = new JLabel("");
		lblImage.setBounds(115, 103, 182, 182);
		panel.add(lblImage);
		getContentPane().setLayout(null);
		lblImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Images/Mesa.jpg")));
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(10, 375, 388, 115);
		panel.add(scrollPane);
		
		textArea = new JTextArea();
		textArea.setForeground(Color.BLACK);
		textArea.setFont(new Font("Century", Font.BOLD, 11));
		DefaultCaret caret = (DefaultCaret) textArea.getCaret();
		caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);
		textArea.setBorder(new BevelBorder(BevelBorder.LOWERED, new Color(128, 128, 128), Color.LIGHT_GRAY, null, null));
		textArea.setEnabled(false);
		scrollPane.setViewportView(textArea);
		
		JLabel lblConsole = new JLabel("Console");
		lblConsole.setFont(new Font("Calibri", Font.BOLD, 15));
		lblConsole.setBounds(10, 360, 73, 14);
		panel.add(lblConsole);
		
		JPanel panelFaminto = new JPanel();
		panelFaminto.setToolTipText("");
		panelFaminto.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.LIGHT_GRAY, Color.GRAY, null, null));
		panelFaminto.setBackground(Color.WHITE);
		panelFaminto.setBounds(408, 33, 128, 496);
		panel.add(panelFaminto);
		panelFaminto.setLayout(null);
		
		lblFamFilos_0 = new JLabel("filosofo0");
		lblFamFilos_0.setIcon(new ImageIcon(Frame.class.getResource("/Images/filosofo0.jpg")));
		lblFamFilos_0.setBounds(36, 11, 61, 89);
		panelFaminto.add(lblFamFilos_0);
		lblFamFilos_0.setVisible(false);
		
		lblFamFilos_1 = new JLabel("filosofo1");
		lblFamFilos_1.setIcon(new ImageIcon(Frame.class.getResource("/Images/filosofo1.jpg")));
		lblFamFilos_1.setBounds(36, 111, 59, 83);
		panelFaminto.add(lblFamFilos_1);
		lblFamFilos_1.setVisible(false);
		
		lblFamFilos_2 = new JLabel("filosofo2");
		lblFamFilos_2.setIcon(new ImageIcon(Frame.class.getResource("/Images/filosofo2.jpg")));
		lblFamFilos_2.setBounds(36, 205, 61, 83);
		panelFaminto.add(lblFamFilos_2);
		lblFamFilos_2.setVisible(false);
		
		lblFamFilos_3 = new JLabel("filosofo3");
		lblFamFilos_3.setIcon(new ImageIcon(Frame.class.getResource("/Images/filosofo3.jpg")));
		lblFamFilos_3.setBounds(36, 299, 61, 83);
		panelFaminto.add(lblFamFilos_3);
		lblFamFilos_3.setVisible(false);
		
		lblFamFilos_4 = new JLabel("filosofo4");
		lblFamFilos_4.setIcon(new ImageIcon(Frame.class.getResource("/Images/filosofo4.jpg")));
		lblFamFilos_4.setBounds(32, 393, 65, 83);
		panelFaminto.add(lblFamFilos_4);
		lblFamFilos_4.setVisible(false);
		
		JPanel panelPensando = new JPanel();
		panelPensando.setBorder(new BevelBorder(BevelBorder.LOWERED, Color.GRAY, Color.LIGHT_GRAY, null, null));
		panelPensando.setBackground(Color.WHITE);
		panelPensando.setBounds(546, 33, 128, 496);
		panel.add(panelPensando);
		panelPensando.setLayout(null);
		
		lblPensFilos_0 = new JLabel("filosofo0");
		lblPensFilos_0.setIcon(new ImageIcon(Frame.class.getResource("/Images/filosofo0.jpg")));
		lblPensFilos_0.setBounds(36, 11, 61, 89);
		panelPensando.add(lblPensFilos_0);
		
		lblPensFilos_1 = new JLabel("filosofo1");
		lblPensFilos_1.setIcon(new ImageIcon(Frame.class.getResource("/Images/filosofo1.jpg")));
		lblPensFilos_1.setBounds(36, 111, 59, 83);
		panelPensando.add(lblPensFilos_1);
		
		lblPensFilos_2 = new JLabel("filosofo2");
		lblPensFilos_2.setIcon(new ImageIcon(Frame.class.getResource("/Images/filosofo2.jpg")));
		lblPensFilos_2.setBounds(36, 205, 61, 83);
		panelPensando.add(lblPensFilos_2);
		
		lblPensFilos_3 = new JLabel("filosofo3");
		lblPensFilos_3.setIcon(new ImageIcon(Frame.class.getResource("/Images/filosofo3.jpg")));
		lblPensFilos_3.setBounds(36, 299, 61, 83);
		panelPensando.add(lblPensFilos_3);
		
		lblPensFilos_4 = new JLabel("filosofo4");
		lblPensFilos_4.setIcon(new ImageIcon(Frame.class.getResource("/Images/filosofo4.jpg")));
		lblPensFilos_4.setBounds(36, 393, 65, 83);
		panelPensando.add(lblPensFilos_4);
		
		JLabel lblFaminto = new JLabel("Faminto");
		lblFaminto.setFont(new Font("Calibri", Font.BOLD, 15));
		lblFaminto.setBounds(444, 11, 51, 14);
		panel.add(lblFaminto);
		
		JLabel lblPensando = new JLabel("Pensando");
		lblPensando.setFont(new Font("Calibri", Font.BOLD, 15));
		lblPensando.setBounds(577, 11, 61, 14);
		panel.add(lblPensando);
		
		JButton btnExecutar = new JButton("Executar");
		btnExecutar.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent arg0) {
				for(int i=0; i<5; i++) p[i].start();
			}
		});
		btnExecutar.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				for(int i=0; i<5; i++) p[i].start();
			}
		});
		btnExecutar.setBounds(215, 506, 94, 23);
		panel.add(btnExecutar);
		
		/*JButton btnPause = new JButton("Pause");
		btnPause.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				try{	
					for(int i=0; i<5; i++) p[i].wait();
				   }catch(Exception e1){
					   
				   }
			}
		});
		btnPause.addKeyListener(new KeyAdapter() {
			@Override
			public void keyPressed(KeyEvent e) {
			
		   try{	
				for(int i=0; i<5; i++) p[i].wait();
			   }catch(Exception e1){
				   
			   }
			}
		});
		btnPause.setBounds(320, 506, 78, 23);
		panel.add(btnPause); */
		
		JLabel lblTempoComendo = new JLabel("Tempo Comendo");
		lblTempoComendo.setFont(new Font("Calibri", Font.BOLD, 15));
		lblTempoComendo.setBounds(10, 526, 112, 14);
		panel.add(lblTempoComendo);
		
		TempoComen = new JTextField();
		TempoComen.setBounds(132, 523, 44, 20);
		panel.add(TempoComen);
		TempoComen.setColumns(10);
		
		JLabel lblMs = new JLabel("ms");
		lblMs.setBounds(186, 526, 19, 14);
		panel.add(lblMs);
		
		JLabel lblNewLabel = new JLabel("Tempo Pensando");
		lblNewLabel.setFont(new Font("Calibri", Font.BOLD, 15));
		lblNewLabel.setBounds(10, 501, 112, 14);
		panel.add(lblNewLabel);
		
		TempoPens = new JTextField();
		TempoPens.setBounds(132, 501, 44, 20);
		panel.add(TempoPens);
		TempoPens.setColumns(10);
		
		JLabel lblMs_1 = new JLabel("ms");
		lblMs_1.setBounds(186, 501, 46, 14);
		panel.add(lblMs_1);
		
		JLabel lblFilsofo = new JLabel("Fil\u00F3sofo 1");
		lblFilsofo.setBounds(23, 90, 60, 14);
		panel.add(lblFilsofo);
		
		JLabel lblFilsofo_1 = new JLabel("Fil\u00F3sofo 0");
		lblFilsofo_1.setBounds(100, 24, 61, 14);
		panel.add(lblFilsofo_1);
		
		JLabel lblFilsofo_2 = new JLabel("Fil\u00F3sofo 4");
		lblFilsofo_2.setBounds(301, 85, 65, 14);
		panel.add(lblFilsofo_2);
		
		JLabel lblFilsofo_3 = new JLabel("Fil\u00F3sofo 2");
		lblFilsofo_3.setBounds(31, 251, 61, 14);
		panel.add(lblFilsofo_3);
		
		JLabel lblFilsofo_4 = new JLabel("Fil\u00F3sofo 3");
		lblFilsofo_4.setBounds(320, 251, 61, 14);
		panel.add(lblFilsofo_4);
		
	}
	
	/** Updates philosophers state of the frame.
	 * @param key
	 * @param state
	 * @return
	 */
	public boolean setStatePhilosopher(int key, StatePhilosopher state){
		switch(key){
			case 0:
				if(state == StatePhilosopher.EATING) {
					lblMesaFilosofo_0.setVisible(true);
					lblFamFilos_0.setVisible(false);
					lblPensFilos_0.setVisible(false);
				}
				else if(state == StatePhilosopher.HUNGRY) {
					lblMesaFilosofo_0.setVisible(false);
					lblFamFilos_0.setVisible(true);
					lblPensFilos_0.setVisible(false);
				}
				else {
					lblMesaFilosofo_0.setVisible(false);
					lblFamFilos_0.setVisible(false);
					lblPensFilos_0.setVisible(true);
				}
				break;
			case 1:
				if(state == StatePhilosopher.EATING) {
					lblMesaFilosofo_1.setVisible(true);
					lblFamFilos_1.setVisible(false);
					lblPensFilos_1.setVisible(false);
				}
				else if(state == StatePhilosopher.HUNGRY) {
					lblMesaFilosofo_1.setVisible(false);
					lblFamFilos_1.setVisible(true);
					lblPensFilos_1.setVisible(false);
				}
				else {
					lblMesaFilosofo_1.setVisible(false);
					lblFamFilos_1.setVisible(false);
					lblPensFilos_1.setVisible(true);
				}
				break;
			case 2:
				if(state == StatePhilosopher.EATING) {
					lblMesaFilosofo_2.setVisible(true);
					lblFamFilos_2.setVisible(false);
					lblPensFilos_2.setVisible(false);
				}
				else if(state == StatePhilosopher.HUNGRY) {
					lblMesaFilosofo_2.setVisible(false);
					lblFamFilos_2.setVisible(true);
					lblPensFilos_2.setVisible(false);
				}
				else {
					lblMesaFilosofo_2.setVisible(false);
					lblFamFilos_2.setVisible(false);
					lblPensFilos_2.setVisible(true);
				}
				break;
			case 3:
				if(state == StatePhilosopher.EATING) {
					lblMesaFilosofo_3.setVisible(true);
					lblFamFilos_3.setVisible(false);
					lblPensFilos_3.setVisible(false);
				}
				else if(state == StatePhilosopher.HUNGRY) {
					lblMesaFilosofo_3.setVisible(false);
					lblFamFilos_3.setVisible(true);
					lblPensFilos_3.setVisible(false);
				}
				else {
					lblMesaFilosofo_3.setVisible(false);
					lblFamFilos_3.setVisible(false);
					lblPensFilos_3.setVisible(true);
				}
				break;
			case 4:
				if(state == StatePhilosopher.EATING) {
					lblMesaFilosofo_4.setVisible(true);
					lblFamFilos_4.setVisible(false);
					lblPensFilos_4.setVisible(false);
				}
				else if(state == StatePhilosopher.HUNGRY) {
					lblMesaFilosofo_4.setVisible(false);
					lblFamFilos_4.setVisible(true);
					lblPensFilos_4.setVisible(false);
				}
				else {
					lblMesaFilosofo_4.setVisible(false);
					lblFamFilos_4.setVisible(false);
					lblPensFilos_4.setVisible(true);
				}
				break;
		}
		this.repaint();
		return true;
	}
}

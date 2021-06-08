package listeners;

import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import exceptions.WikipediaNoArcticleException;
import totravel.City;
import totravel.ElderTraveller;
import totravel.MiddleTraveller;
import totravel.Traveller;
import totravel.YoungTraveller;
import static totravel.Traveller.*;
import static totravel.City.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class TextVectorsListener {
	
	private static ArrayList<City> cities;
	private static ArrayList<Traveller> travellers;

	
	public TextVectorsListener(ArrayList<City> cities,ArrayList<Traveller> travellers){
		this.cities=cities;
		this.travellers=travellers;
	}
	
	//paradoteo 3 
	   private JFrame mainFrame;
	   private JLabel label00;
	   private JLabel label0;
	   private JLabel label1;
	   private JLabel label2;
	   private JLabel label3;
	   private JLabel label4;
	   private JLabel label5;
	   private JLabel label6;
	   private JLabel label7;
	   private JLabel label8;
	   private JLabel label9;
	   private JLabel label10;
	   private JLabel label11;
	   private JLabel label12;
	   private JLabel label13;
	   private JLabel label14;

	   private JLabel statusLabel;
	   private JLabel statusLabel2;
	   private JPanel controlPanel;
	   private JTextField textField;
	   private JTextField textField2;
	   private JTextField textField3;
	   private JComboBox comboBox;
	   private JComboBox comboBox2;
	   private JComboBox comboBox3;
	   private JComboBox comboBox4;
	   private JComboBox comboBox5;
	   private JComboBox comboBox6;
	   private JComboBox comboBox7;
	   private JComboBox comboBox8;
	   private JComboBox comboBox9;
	   private JComboBox comboBox10;
	   private JComboBox comboBox11;


	

	public void showKeyListenerDemo(){
		
		mainFrame = new JFrame("Welcome to our Travel Agency");
	    mainFrame.setSize(700,800);
	    mainFrame.setLayout(new FlowLayout());
	    
	    mainFrame.addWindowListener(new WindowAdapter() {
		       public void windowClosing(WindowEvent windowEvent){
		          System.exit(0);
		       }        
		    });  
	    mainFrame.setVisible(true);  
	    label00 = new JLabel("",JLabel.CENTER );
	    label0 = new JLabel("Thank you for choosing us! Please answer the following questions!!");
		label1 = new JLabel("",JLabel.CENTER );
		label2 = new JLabel("",JLabel.CENTER );
		label3 = new JLabel("",JLabel.CENTER );
		label4 = new JLabel("",JLabel.CENTER );
		label5 = new JLabel("",JLabel.CENTER );
		label6 = new JLabel("",JLabel.CENTER );
		label7 = new JLabel("",JLabel.CENTER );
		label8 = new JLabel("",JLabel.CENTER );
		label9 = new JLabel("",JLabel.CENTER );
		label10 = new JLabel("",JLabel.CENTER );
		label11 = new JLabel("",JLabel.CENTER );
		label12 = new JLabel("",JLabel.CENTER );
		label13 = new JLabel("",JLabel.CENTER );
		label14 = new JLabel("",JLabel.CENTER );

		    statusLabel = new JLabel("",JLabel.CENTER);        
		    statusLabel.setSize(350,100);
		    statusLabel2 = new JLabel("",JLabel.CENTER);        
		    statusLabel2.setSize(350,100);
		    
		    
	  // label0.setText("Please answer the following questions from 1 to 10"); 
	   label1.setText("How much do you like going to the sea?");
	   String [] items = { "0","1","2","3","4","5","6","7","8","9","10"};
	   comboBox = new JComboBox(items);
	   label2.setText("How much do you like to see walls?");
	   comboBox2 = new JComboBox(items);
	   label3.setText("How much do you like going to the ancient areas?");
	   comboBox3 = new JComboBox(items);
	   label4.setText("How much do you like going to the mountain?");
	   comboBox4 = new JComboBox(items);
	   label5.setText("How much do you like going for a coffee?");
	   comboBox5 = new JComboBox(items);
	   label6.setText("How much do you like museums?");
	   comboBox6 = new JComboBox(items);
	   label7.setText("How much do you like squeares?");
	   comboBox7 = new JComboBox(items);
	   label8.setText("How much do you like restaurants?");
	   comboBox8 = new JComboBox(items);
	   label9.setText("How much do you like nice views?");
	   comboBox9 = new JComboBox(items);
	   label10.setText("How much do you like forests?");
	   comboBox10 = new JComboBox(items);
	   label11.setText("How old are you?");
	   
	   String [] items2 = { "16-25","26-60","61-115"};
	   comboBox11 = new JComboBox(items2);
	   label12.setText("Please write the name of your City");
	   textField  = new JTextField(10);	  
	   label00.setText("Please write your name"); 
	   textField3  = new JTextField(10);	 
	   
	   
	   
	   label13.setText("Write the 2 top letters of your country and press enter");
	   textField2  = new JTextField(10);	  
	   textField2.addKeyListener(new CustomKeyListener());//wste otan patithei enter na mou dwsei tin kaliteri poli	
	   
	   label14.setText("Press the button to see if you won a freeticket");
	   
	    JButton okButton = new JButton("CLICK ME ");
	   
	   okButton.addActionListener(new ActionListener() {				//2nd Listener activated with Button click.
	      public void actionPerformed(ActionEvent e) {
	    	  try {
				String winner=freeticket(travellers).getName();
				if(winner.equals(textField3.getText())) {
					statusLabel2.setText("Congratulations "+" "+ textField3.getText()+" "+"you are the winner");
				}else {
					statusLabel2.setText("We are Sorry "+" "+ textField3.getText()+" "+"the winner is:"+" "+winner);
				}
			} catch (IOException | WikipediaNoArcticleException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}

	      }
	   });
       
	   controlPanel = new JPanel();
	   controlPanel.setLayout(new GridLayout(17,2,2,1));

	  
	   controlPanel.add(label1);
	   controlPanel.add(comboBox);
	   controlPanel.add(label2);
	   controlPanel.add(comboBox2);
	   controlPanel.add(label3);
	   controlPanel.add(comboBox3);
	   controlPanel.add(label4);
	   controlPanel.add(comboBox4);
	   controlPanel.add(label5);
	   controlPanel.add(comboBox5);
	   controlPanel.add(label6);
	   controlPanel.add(comboBox6);
	   controlPanel.add(label7);
	   controlPanel.add(comboBox7);
	   controlPanel.add(label8);
	   controlPanel.add(comboBox8);
	   controlPanel.add(label9);
	   controlPanel.add(comboBox9);
	   controlPanel.add(label10);
	   controlPanel.add(comboBox10);
	   controlPanel.add(label11);
	   controlPanel.add(comboBox11);
	   controlPanel.add(label12);
	   controlPanel.add(textField);
	   controlPanel.add(label00);
	   controlPanel.add(textField3);
	    controlPanel.add(label13);
	   controlPanel.add(textField2);
	   controlPanel.add(label14);
	   controlPanel.add(okButton);


	   	   
	    mainFrame.add(label0);
	    mainFrame.add(controlPanel);
	   
	    
	    mainFrame.add(statusLabel);
	    mainFrame.add(statusLabel2);
	    
	    
	    mainFrame.setVisible(true); 
	    
	}
	



	class CustomKeyListener implements KeyListener{				//2nd Listener activated with Button click.
	   public void keyTyped(KeyEvent e) {
	   }
	   public void keyPressed(KeyEvent e) {
		    
	      if(e.getKeyCode() == KeyEvent.VK_ENTER){
	    	  
	    	   City bestCity = null;
	    	  
	    	 if("16-25".equals(comboBox11.getSelectedItem())) {
	    		 YoungTraveller young1=new YoungTraveller("Athens","gr");
	    		 young1.setRating_vector(new int[] {Integer.valueOf((String)comboBox.getSelectedItem()),Integer.valueOf((String)comboBox2.getSelectedItem()),Integer.valueOf((String)comboBox3.getSelectedItem()),Integer.valueOf((String)comboBox4.getSelectedItem()),Integer.valueOf((String)comboBox5.getSelectedItem()),Integer.valueOf((String)comboBox6.getSelectedItem()),Integer.valueOf((String)comboBox7.getSelectedItem()),Integer.valueOf((String)comboBox8.getSelectedItem()),Integer.valueOf((String)comboBox9.getSelectedItem()),Integer.valueOf((String)comboBox10.getSelectedItem())});
	    		 young1.setCity(textField.getText());
	    		 young1.setCountry(textField2.getText());
	    		 
	    		 
	    		try {
					bestCity=young1.CompareCities(cities);
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
	    	 
	    	 }else if("26-60".equals(comboBox11.getSelectedItem())){
	    		 MiddleTraveller middle1=new MiddleTraveller("Athens","gr");
                 middle1.setRating_vector(new int[] {Integer.valueOf((String)comboBox.getSelectedItem()),Integer.valueOf((String)comboBox2.getSelectedItem()),Integer.valueOf((String)comboBox3.getSelectedItem()),Integer.valueOf((String)comboBox4.getSelectedItem()),Integer.valueOf((String)comboBox5.getSelectedItem()),Integer.valueOf((String)comboBox6.getSelectedItem()),Integer.valueOf((String)comboBox7.getSelectedItem()),Integer.valueOf((String)comboBox8.getSelectedItem()),Integer.valueOf((String)comboBox9.getSelectedItem()),Integer.valueOf((String)comboBox10.getSelectedItem())});	    	     middle1.setCity(textField.getText());
	    	     middle1.setCountry(textField2.getText());
	    	     try {
						bestCity=middle1.CompareCities(cities);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    	 }else {
	    		 ElderTraveller elder1=new ElderTraveller("Athens","gr");
                 elder1.setRating_vector(new int[] {Integer.valueOf((String)comboBox.getSelectedItem()),Integer.valueOf((String)comboBox2.getSelectedItem()),Integer.valueOf((String)comboBox3.getSelectedItem()),Integer.valueOf((String)comboBox4.getSelectedItem()),Integer.valueOf((String)comboBox5.getSelectedItem()),Integer.valueOf((String)comboBox6.getSelectedItem()),Integer.valueOf((String)comboBox7.getSelectedItem()),Integer.valueOf((String)comboBox8.getSelectedItem()),Integer.valueOf((String)comboBox9.getSelectedItem()),Integer.valueOf((String)comboBox10.getSelectedItem())});	    		 elder1.setCity(textField.getText());
	    		 elder1.setCountry(textField2.getText());
	    		 try {
						bestCity=elder1.CompareCities(cities);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
	    	 }
	    	  
	    	  statusLabel.setText("The best City for you is:"+" "+bestCity.getCity());	
	         	
	      }
	   }
	   public void keyReleased(KeyEvent e) {
	   }   
	}

	
	
	 public static void main(String[] args){
		 
		 
		 TextVectorsListener  textVectorsListener = new TextVectorsListener(cities,travellers);  
		 textVectorsListener.showKeyListenerDemo();
	   }
	
	
	
	
	
	
	public JComboBox getComboBox() {
		return comboBox;
	}


	public void setComboBox(JComboBox comboBox) {
		this.comboBox = comboBox;
	}


	public JComboBox getComboBox2() {
		return comboBox2;
	}


	public void setComboBox2(JComboBox comboBox2) {
		this.comboBox2 = comboBox2;
	}


	public JComboBox getComboBox3() {
		return comboBox3;
	}


	public void setComboBox3(JComboBox comboBox3) {
		this.comboBox3 = comboBox3;
	}


	public JComboBox getComboBox4() {
		return comboBox4;
	}


	public void setComboBox4(JComboBox comboBox4) {
		this.comboBox4 = comboBox4;
	}


	public JComboBox getComboBox5() {
		return comboBox5;
	}


	public void setComboBox5(JComboBox comboBox5) {
		this.comboBox5 = comboBox5;
	}


	public JComboBox getComboBox6() {
		return comboBox6;
	}


	public void setComboBox6(JComboBox comboBox6) {
		this.comboBox6 = comboBox6;
	}


	public JComboBox getComboBox7() {
		return comboBox7;
	}


	public void setComboBox7(JComboBox comboBox7) {
		this.comboBox7 = comboBox7;
	}


	public JComboBox getComboBox8() {
		return comboBox8;
	}


	public void setComboBox8(JComboBox comboBox8) {
		this.comboBox8 = comboBox8;
	}


	public JComboBox getComboBox9() {
		return comboBox9;
	}


	public void setComboBox9(JComboBox comboBox9) {
		this.comboBox9 = comboBox9;
	}


	public JComboBox getComboBox10() {
		return comboBox10;
	}


	public void setComboBox10(JComboBox comboBox10) {
		this.comboBox10 = comboBox10;
	}


	public JComboBox getComboBox11() {
		return comboBox11;
	}


	public void setComboBox11(JComboBox comboBox11) {
		this.comboBox11 = comboBox11;
	}
}

package com.jcjcjp.cs131mp2;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class GUI{

  GUI(int x){    
  
    JFrame f = new JFrame("Inputs"); //submit button
    JButton b = new JButton("Run!");    
    b.setBounds(80,240,140, 30);    
          //enter name label
    JLabel label_1 = new JLabel();    
    label_1.setText("Input Initial Conditions:");
    label_1.setBounds(20, 10, 150, 15);
    JLabel label_2 = new JLabel(); 
    label_2.setText("Initial Value of t:");
    label_2.setBounds(25, 10, 200, 80);
    JLabel label_3 = new JLabel(); 
    label_3.setText("No. of Iterations (n):");
    label_3.setBounds(25, 10, 120, 160);
    JLabel label_4 = new JLabel(); 
    label_4.setText("Step Size (h):");
    label_4.setBounds(25, 10, 100, 245);
    JLabel label_5 = new JLabel(); 
    label_5.setText("Initial Y vector:");
    label_5.setBounds(25, 10, 200, 330);
    
    //empty label which will show event after button clicked
    JLabel label1 = new JLabel();
    label1.setBounds(20, 190, 200, 50);
    
    //textfields
    JTextField textfield = new JTextField();
    textfield.setBounds(150, 35, 50, 30);
    JTextField textfield2 = new JTextField();
    textfield2.setBounds(150, 80, 50, 30);
    JTextField textfield3 = new JTextField();
    textfield3.setBounds(115, 120, 50, 30);
    JTextField textfield4 = new JTextField();
    textfield4.setBounds(130, 160, 50, 30);
    
    //add to frame
    f.add(label_1);
    f.add(label_2);
    f.add(textfield);
    f.add(label1);
    f.add(label_3);
    f.add(textfield2);
    f.add(label_4);
    f.add(textfield3);
    f.add(label_5);
    f.add(textfield4);
    f.add(b);    

    if(x == 1){
      label1.setText("<html><font color='red'>Please Input All Initial Conditions!</font></html>");
      f.add(label1);

    }
    else if(x == 2){
      label1.setText("<html><font color='green'>Results generated! <br>Try again?</font></html>");
      f.add(label1);
    }

    f.setSize(300,330);    
    f.setLayout(null);    
    f.setVisible(true);    
    f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   
    
    //action listener
    b.addActionListener(new ActionListener() {
    
      @Override
      public void actionPerformed(ActionEvent arg0) {
        
        String getX = textfield.getText();
        String getN = textfield2.getText();
        String getH = textfield3.getText();
        String getY = textfield4.getText();
          
        if ((getX.equals(""))||(getN.equals(""))||(getH.equals(""))||(getY.equals(""))){
          f.setVisible(false); //you can't see me!
          f.dispose(); //Destroy the JFrame object

          new GUI(1);
        }//End If
          
        else {
          System.out.println(getX);
          System.out.println(getN);
          System.out.println(getH);
          System.out.println(getY);
          f.setVisible(false); //you can't see me!
          f.dispose(); //Destroy the JFrame object

          new GUI(2);
          
          parseInput( getX, getY, getN, getH );

        }//End Else
     
      }//End Override actionPerformed Function          
    });//End Listener

  }//End Function EulerGUI         
  
  public void parseInput( String t, String y, String n, String h )
  {
	  double t0 = Double.parseDouble(t);
	  int n0 = Integer.parseInt(n);
	  double h0 = Double.parseDouble(h);
	  String[] y_values = y.split(",");
	  double[] y0 = new double[ y_values.length ];
	  
	  for( int i = 0; i < y_values.length; i++ )
		  y0[i] = Double.parseDouble( y_values[i] );
	  
	  Main.run( t0, y0, n0, h0 );
  }
  
 }//End Class EulerGUI

package Զ��ͨѶ¼ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Amends extends JFrame implements ActionListener
{

	Statement s1;
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JTextArea ta=new JTextArea();
	JTextField nametext = new JTextField(10);
	JTextField sextext = new JTextField(10);
	JTextField agetext = new JTextField(10);
	JTextField phonetext = new JTextField(10);
	JTextField mailtext = new JTextField(10);
	JTextField hometext = new JTextField(10);
	
	JButton amend=new JButton("�޸�");
	JButton reset=new JButton("����");
	JButton cancel=new JButton("ȡ��");
	
	
	Amends(Statement s2)
	{
		 super("�޸�ͨѶ¼��Ϣ");
		 s1=s2;
		 setLayout(new BorderLayout());
		 p1.setLayout(new FlowLayout());
		 p1 = new JPanel(new GridLayout(2,3));
		 p2.setLayout(new FlowLayout());
		 
		 p1.add(new JLabel("����"));
		 p1.add(nametext);
		 p1.add(new JLabel("�Ա�"));
		 p1.add(sextext);
		 p1.add(new JLabel("����"));
		 p1.add(agetext);
		 p1.add(new JLabel("�绰"));
		 p1.add(phonetext);
		 p1.add(new JLabel("����"));
		 p1.add(mailtext);
		 p1.add(new JLabel("סַ"));
		 p1.add(hometext);
		 p2.add(amend);
		 p2.add(reset);
	     p2.add(cancel);
	     
	     add(p1,BorderLayout.NORTH);
		 add(ta,BorderLayout.CENTER);
		 add(p2,BorderLayout.SOUTH);
		 add("Center",new JScrollPane(ta));
		 
		 
		 amend.addActionListener(this);
		 reset.addActionListener(this);
	     cancel.addActionListener(this);
	   
	     setSize(600,400);
		 setLocation(400,100);
		 setDefaultCloseOperation(EXIT_ON_CLOSE); 
	}
	
	 public void actionPerformed(ActionEvent e) 
	 {
		 if(e.getSource()==amend)
			{ 
			 try
			 {
				 String aa=nametext.getText();
				 String bb=sextext.getText();
				 String cc=agetext.getText();
				 String dd=phonetext.getText();
				 String mm=mailtext.getText();
				 String ff=hometext.getText();
				 
				 String x="update tongxunlu set ���� =  '"+aa+"', �Ա�= '"+bb+"', ����= '"+cc+"', �绰= '"+dd+"', ����= '"+mm+"', סַ= '"+ff+"' where ���� ='"+aa+"' ";
				 s1.executeUpdate(x);
			 }
			    catch(SQLException ee){System.out.println(ee.getMessage());}
			 try
			 {
				 ResultSet rs=s1.executeQuery("select*from tongxunlu");
				 while(rs.next())
				 {
					 ta.append(rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5)+"   "+rs.getString(6)+"   "+"\n");
			     }
			 }
		 		catch(SQLException ee){System.out.println(ee.getMessage());}
			}
		 if(e.getSource()==reset)
			{
			 nametext.setText(null);
			 sextext.setText(null);
		     agetext.setText(null);
		     phonetext.setText(null);
		     mailtext.setText(null);
		     hometext.setText(null);
			}
		 if(e.getSource()==cancel)
			{
				dispose();
			}
			
	 }



}

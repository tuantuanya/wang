package Զ��ͨѶ¼ϵͳ;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Adds extends JFrame implements ActionListener
{
	Statement s1;
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JTextArea ta=new JTextArea(200,100);
	JTextField nametext = new JTextField(10);
	JTextField sextext = new JTextField(10);
	JTextField agetext = new JTextField(10);
	JTextField phonetext = new JTextField(10);
	JTextField mailtext = new JTextField(10);
	JTextField hometext = new JTextField(10);
	
	JButton addd=new JButton("ȷ��");
	JButton reset=new JButton("����");
	JButton cancel=new JButton("ȡ��");
	
	 Adds(Statement s2)
	{
		 super("���ͨѶ¼��Ϣ");
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
		 p2.add(addd);
		 p2.add(reset);
	     p2.add(cancel);
	     
	     add(p1,BorderLayout.NORTH);
		 add(ta,BorderLayout.CENTER);
		 add(p2,BorderLayout.SOUTH);
		 add("Center",new JScrollPane(ta));
		 
		 
		 addd.addActionListener(this);
		 reset.addActionListener(this);
	     cancel.addActionListener(this);
	   
	     setSize(600,400);
		 setLocation(400,100);
		
	}
	 
	 public void actionPerformed(ActionEvent e) 
	 {
		 if(e.getSource()==addd)
		{ 
		 try
		 {
			 String a=nametext.getText();
			 String b=sextext.getText();
			 String c=agetext.getText();
			 String d=phonetext.getText();
			 String m=mailtext.getText();
			 String f=hometext.getText();
			 
			 String g="insert into tongxunlu (����,�Ա�,����,�绰,���� ,סַ)values('"+a+"','"+b+"','"+c+"','"+d+"','"+m+"','"+f+"')";
			 s1.executeUpdate(g); //ִ��ָ��sql���
		 }
		 catch(SQLException ee){System.out.println(ee.getMessage());}
		 try
		 {
			 ResultSet rs=s1.executeQuery("select*from tongxunlu ");  //���ص���ResultSet����
			 while(rs.next()) //�������м�¼
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

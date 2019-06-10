package 远程通讯录系统;
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
	
	JButton addd=new JButton("确定");
	JButton reset=new JButton("重置");
	JButton cancel=new JButton("取消");
	
	 Adds(Statement s2)
	{
		 super("添加通讯录信息");
		 s1=s2;
		 setLayout(new BorderLayout());
		 p1.setLayout(new FlowLayout());
		 p1 = new JPanel(new GridLayout(2,3));
		 p2.setLayout(new FlowLayout());
		 
		 p1.add(new JLabel("姓名"));
		 p1.add(nametext);
		 p1.add(new JLabel("性别"));
		 p1.add(sextext);
		 p1.add(new JLabel("年龄"));
		 p1.add(agetext);
		 p1.add(new JLabel("电话"));
		 p1.add(phonetext);
		 p1.add(new JLabel("邮箱"));
		 p1.add(mailtext);
		 p1.add(new JLabel("住址"));
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
			 
			 String g="insert into tongxunlu (姓名,性别,年龄,电话,邮箱 ,住址)values('"+a+"','"+b+"','"+c+"','"+d+"','"+m+"','"+f+"')";
			 s1.executeUpdate(g); //执行指定sql语句
		 }
		 catch(SQLException ee){System.out.println(ee.getMessage());}
		 try
		 {
			 ResultSet rs=s1.executeQuery("select*from tongxunlu ");  //返回单个ResultSet对象
			 while(rs.next()) //遍历所有记录
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

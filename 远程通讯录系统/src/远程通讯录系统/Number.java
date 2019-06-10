package 远程通讯录系统;
import java.awt.BorderLayout;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.*;

public class Number extends JFrame implements ActionListener
{
	Statement s1;
	JTextField lookk=new JTextField(15);
	JTextArea ta=new JTextArea(200,100); 
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	JButton look=new JButton("查看");
	
	Number(Statement s2)
	{
		super("按电话查找学生信息");
		s1=s2;
		setLayout(new BorderLayout());
		p1.setLayout(new FlowLayout());
		
		p1.add(new JLabel("电话"));
		p1.add(lookk);
		p2.add(look);
		add(p1,BorderLayout.NORTH);
	    add(ta,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);
	    add("Center",new JScrollPane(ta));

	    look.addActionListener(this);
	    
		
		setSize(600,400);
		setLocation(400,100);
		
	}
	 public void actionPerformed(ActionEvent e) 
	 {
		 
		 if(e.getSource()==look)
			{
			 try
			 {
				 String num=lookk.getText();
		    	 ResultSet rs=s1.executeQuery("select*from tongxunlu where 电话  ='"+num+"'");
				 while(rs.next())
				 {
					 ta.append(rs.getString(1)+"   "+rs.getString(2)+"   "+rs.getString(3)+"   "+rs.getString(4)+"   "+rs.getString(5)+"   "+rs.getString(6)+"   "+"\n");
			     }
			 }
		 		catch(SQLException ee){System.out.println(ee.getMessage());}
			}
	 }

	

}

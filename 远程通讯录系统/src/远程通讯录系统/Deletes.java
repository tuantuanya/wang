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

public class Deletes extends JFrame implements ActionListener
{
	Statement s1;
	
	JPanel p1=new JPanel();
	JPanel p2=new JPanel();
	
	JTextField nametext=new JTextField(10);
	JTextArea ta=new JTextArea(200,100); 
	
	JButton delete=new JButton("删除");
	JButton reset=new JButton("重置");
	JButton cancel=new JButton("取消");

	 Deletes(Statement s2)
	{
		super("删除通讯录信息");
		s1=s2;
		setLayout(new BorderLayout());
		p1.setLayout(new FlowLayout());
		p2.setLayout(new FlowLayout());
		
		p1.add(new JLabel("姓名"));
		p1.add(nametext);
		p2.add(delete);
		p2.add(reset);
		p2.add(cancel);
		add(p1,BorderLayout.NORTH);
	    add(ta,BorderLayout.CENTER);
		add(p2,BorderLayout.SOUTH);
	    add("Center",new JScrollPane(ta));
	    
	    delete.addActionListener(this);
		reset.addActionListener(this);
		cancel.addActionListener(this);
	
		setSize(500,300);
		setLocation(400,100);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	 public void actionPerformed(ActionEvent e) 
	 {
		 if(e.getSource()==delete)
			{ 
			 try
			 {
				 String x=nametext.getText();
				 String d="delete from tongxunlu where 姓名='"+x+"'";
				 s1.executeUpdate(d);
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
			 
			}
		 if(e.getSource()==cancel)
			{
				dispose(); //关闭GUI页面
			}
	 }


}

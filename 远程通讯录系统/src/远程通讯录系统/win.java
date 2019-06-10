package 远程通讯录系统;
import java.awt.event.ActionEvent;

import java.awt.event.ActionListener;
import java.sql.Statement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
public class win extends JFrame implements ActionListener
{
	JMenuItem adds=new JMenuItem("添加通讯录记录");
	JMenuItem deletes=new JMenuItem("删除通讯录记录");
	JMenuItem amends=new JMenuItem("修改学生记录");
	JMenuItem finds=new JMenuItem("查找全部记录 ");
	JMenuItem number=new JMenuItem("电话查找");
	JMenuItem name=new JMenuItem("姓名查找");
	
	JMenu addition=new JMenu("添加通讯录信息");
	JMenu delete=new JMenu("删除通讯录 信息");
	JMenu amend=new JMenu("修改通讯录信息");
	JMenu find=new JMenu("查找通讯录信息");
	
	JMenuBar bar=new JMenuBar();
	
	String JDriver = "com.hxtt.sql.access.AccessDriver"; //声明JDBC驱动程序对象
	String conURL="jdbc:access:///E:\\大三下学期\\网络技术应用开发实践\\system.accdb"; //定义URL对象
	Connection con;
	Statement s;
	
	Adds a;
	Deletes d;
	Amends am;
	Finds f;
	Number nu;
	Name na;
	
	public win()
	{
		super("通讯录系统");
		
		ImageIcon icon= new ImageIcon("E:\\大三\\面向对象程序设计实践\\王睿 20161856127\\学生系统\\通讯录系统.jpg");
		JLabel label1=new JLabel(icon);
		add(label1);

		try 
		   { 
		       Class.forName(JDriver);  //加载和注册驱动程序
		   }
		    catch(ClassNotFoundException e)
		   {  System.out.println(e);}
		    
		try 
			{
			   con=DriverManager.getConnection(conURL,"","");  //连接数据库
			   s=con.createStatement();  //创建statement类对象
		   }
		   catch(SQLException e1) 
		     { System.out.println("错误");}   
		   
		   a=new Adds(s);
		   d=new Deletes(s);
		   am=new Amends(s);
		   f=new Finds(s);
		   nu=new Number(s);
		   na=new Name(s);
		  
		   addition.add(adds);
		   delete.add(deletes);
		   amend.add(amends);
		   find.add(finds);
		   find.add(number);
		   find.add(name);
		   bar.add(addition);
		   bar.add(delete);
		   bar.add(amend);
		   bar.add(find);
		   setJMenuBar(bar);
		
		   adds.addActionListener(this);
		   deletes.addActionListener(this);
		   amends.addActionListener(this);
		   finds.addActionListener(this);
		   number.addActionListener(this);
		   name.addActionListener(this);
		   
		    setSize(800,600);
			setLocation(400,100);
			setVisible(true);
			setDefaultCloseOperation(EXIT_ON_CLOSE);
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==adds)
        {
			a.setVisible(true);
		}
		
		if(e.getSource()==deletes)
		{
			d.setVisible(true);
		} 
		
	    if(e.getSource()==amends)
	    {
	    	am.setVisible(true);
	    }
	    
	    if(e.getSource()==finds)
        {
	    	f.setVisible(true);
		}
	    
		if(e.getSource()==number)
		{
			nu.setVisible(true);
		} 
	    if(e.getSource()==name)
	    {
	    	na.setVisible(true);
	    } 
	    
	}

	public static void main(String[] args)
	{
		// TODO Auto-generated method stub
		new win();
	}

}

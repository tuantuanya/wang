package Զ��ͨѶ¼ϵͳ;
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
	JMenuItem adds=new JMenuItem("���ͨѶ¼��¼");
	JMenuItem deletes=new JMenuItem("ɾ��ͨѶ¼��¼");
	JMenuItem amends=new JMenuItem("�޸�ѧ����¼");
	JMenuItem finds=new JMenuItem("����ȫ����¼ ");
	JMenuItem number=new JMenuItem("�绰����");
	JMenuItem name=new JMenuItem("��������");
	
	JMenu addition=new JMenu("���ͨѶ¼��Ϣ");
	JMenu delete=new JMenu("ɾ��ͨѶ¼ ��Ϣ");
	JMenu amend=new JMenu("�޸�ͨѶ¼��Ϣ");
	JMenu find=new JMenu("����ͨѶ¼��Ϣ");
	
	JMenuBar bar=new JMenuBar();
	
	String JDriver = "com.hxtt.sql.access.AccessDriver"; //����JDBC�����������
	String conURL="jdbc:access:///E:\\������ѧ��\\���缼��Ӧ�ÿ���ʵ��\\system.accdb"; //����URL����
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
		super("ͨѶ¼ϵͳ");
		
		ImageIcon icon= new ImageIcon("E:\\����\\�������������ʵ��\\��� 20161856127\\ѧ��ϵͳ\\ͨѶ¼ϵͳ.jpg");
		JLabel label1=new JLabel(icon);
		add(label1);

		try 
		   { 
		       Class.forName(JDriver);  //���غ�ע����������
		   }
		    catch(ClassNotFoundException e)
		   {  System.out.println(e);}
		    
		try 
			{
			   con=DriverManager.getConnection(conURL,"","");  //�������ݿ�
			   s=con.createStatement();  //����statement�����
		   }
		   catch(SQLException e1) 
		     { System.out.println("����");}   
		   
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

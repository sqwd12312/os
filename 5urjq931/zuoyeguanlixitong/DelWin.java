package 实训;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;
public class DelWin extends JFrame implements ActionListener 
{
	JPanel jpan1;
	JLabel label;
	JButton but,but1;
	JTextField jtf1,jtf2;
	public DelWin()
	{
		super("删除单词");
		this.setBounds(250,250,250,200);
		this.setVisible(true);
        jpan1=new JPanel();
     	jpan1.add(new Label("输入要删除的单词:"));
     	jtf1=new JTextField(20);   	
     	jpan1.add(jtf1);   	   	
     	but = new JButton("删除");  	
     	but1 = new JButton("取消");  	
     	jpan1.add(but); jpan1.add(but1);   	
     	getContentPane().add(jpan1);
     	but.addActionListener(this);
     	but1.addActionListener(this);
		this.validate();
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==but)
     	{
     		if(jtf1.getText().equals(""))
     		{
     			 JOptionPane.showMessageDialog(this,"删除的单词不能为空！","警告",     
                     JOptionPane.WARNING_MESSAGE);
     		}     		     		
     		else
     		{     		     		
     			try{
     				删除();		     			
     				}
     			catch(SQLException ee){}
     		}     		
     	}
     	
     	else if(e.getSource()==but1)
     	{
     		dispose();
     	}
	}
	public void 删除() throws SQLException 
	{

    	String eng_info,chi_info;
    	boolean boo=false;
    	try
		{
			String url = "jdbc:sqlserver://127.0.0.1:1433;databasename=dictionary";
			Connection cn = DriverManager.getConnection(url,"sa","123456");
			Statement stmt = cn.createStatement();
			ResultSet rs = stmt.executeQuery("select * from dic_tra ");
			while((boo=rs.next())==true)
			{
				eng_info=rs.getString("English");
				chi_info=rs.getString("Chinese");
				if(jtf1.getText().trim().equals(eng_info.trim()))
				{
					String s1="'"+jtf1.getText().trim()+"'";
					stmt.executeUpdate("delete from dic_tra where English="+s1 );
					JOptionPane.showMessageDialog(this,"成功删除记录！","恭喜",	
							JOptionPane.WARNING_MESSAGE);
							dispose();	
							break;
				}
				
			}
			if(boo=false)
			{
				JOptionPane.showMessageDialog(this,"不存在此单词！","警告",
						
						JOptionPane.WARNING_MESSAGE);
			}
			rs.close();
			stmt.close();
			cn.close();
		}catch(SQLException e1)
		{
			e1.printStackTrace();
		}
	}
}
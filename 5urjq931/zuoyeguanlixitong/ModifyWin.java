package 实训;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

import java.sql.*;
public class ModifyWin extends JFrame implements ActionListener 
{
	JPanel jpan1;
	JLabel label,label1;
	JButton but,but1;
	JTextField jtf1,jtf2;
	public ModifyWin()
	{
		super("修改单词");
		this.setBounds(250,250,250,200);
		this.setVisible(true);
        jpan1=new JPanel();
     	jpan1.add(new Label("输入英语单词:"));
     	jtf1=new JTextField(20);   	
     	jpan1.add(jtf1);   	
     	jpan1.add(new Label("输入该单词修改汉语的解释:"));   	
    	jtf2=new JTextField(20);   	
    	jpan1.add(jtf2);   	
     	but = new JButton("提交");  	
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
			
			if(jtf1.getText().equals("")||
			   
			   jtf2.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"修改的单词或解释不能为空！","警告",
                    JOptionPane.WARNING_MESSAGE);
			}
		else
		{				
			try{
				修改();
									
			   }
			catch(SQLException ee){}
		}
		
	  }
	  else if(e.getSource()==but1)
	  {
	  	dispose();
	  }
	}
	public void 修改() throws SQLException 
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
					String s1="'"+jtf1.getText().trim()+"'",
					s2="'"+jtf2.getText().trim()+"'";				
					stmt.executeUpdate("UPDATE dic_tra SET Chinese="+s2+" WHERE English = "+s1);	
					JOptionPane.showMessageDialog(this,"记录修改成功！","恭喜",
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
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}

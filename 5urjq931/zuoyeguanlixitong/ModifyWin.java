package ʵѵ;
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
		super("�޸ĵ���");
		this.setBounds(250,250,250,200);
		this.setVisible(true);
        jpan1=new JPanel();
     	jpan1.add(new Label("����Ӣ�ﵥ��:"));
     	jtf1=new JTextField(20);   	
     	jpan1.add(jtf1);   	
     	jpan1.add(new Label("����õ����޸ĺ���Ľ���:"));   	
    	jtf2=new JTextField(20);   	
    	jpan1.add(jtf2);   	
     	but = new JButton("�ύ");  	
     	but1 = new JButton("ȡ��");  	
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
				JOptionPane.showMessageDialog(this,"�޸ĵĵ��ʻ���Ͳ���Ϊ�գ�","����",
                    JOptionPane.WARNING_MESSAGE);
			}
		else
		{				
			try{
				�޸�();
									
			   }
			catch(SQLException ee){}
		}
		
	  }
	  else if(e.getSource()==but1)
	  {
	  	dispose();
	  }
	}
	public void �޸�() throws SQLException 
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
					JOptionPane.showMessageDialog(this,"��¼�޸ĳɹ���","��ϲ",
					JOptionPane.WARNING_MESSAGE);
					dispose();
					break;
				}	
			}
			if(boo=false)
			{

				JOptionPane.showMessageDialog(this,"�����ڴ˵��ʣ�","����",
				
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

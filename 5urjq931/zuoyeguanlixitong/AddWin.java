package 实训;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
public class AddWin extends JFrame implements ActionListener 
{
	JPanel jpan1;
	JLabel label,label1;
	JButton but,but1;
	JTextField jtf1,jtf2;
	public AddWin()
	{
		super("添加单词");
		this.setBounds(250,250,250,200);
		this.setVisible(true);
        jpan1=new JPanel();
     	jpan1.add(new Label("输入要添加的单词:"));
     	jtf1=new JTextField(20);   	
     	jpan1.add(jtf1);   	
     	jpan1.add(new Label("输入添加的单词的解释:"));   	
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
			if(jtf1.getText().equals("")||jtf2.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"添加的单词或解释不能为空！",
						"警告",JOptionPane.WARNING_MESSAGE);
			}
			else{	
 		        try{
 			           添加();    			      
 		            }   
 		         catch(SQLException ee){}  
 		      }   		
		}
		else if(e.getSource()==but1)
		{
			dispose();
		}
	}
    public void 添加() throws SQLException
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
					JOptionPane.showMessageDialog(this,"此词汇已存在！","警告",	
					JOptionPane.WARNING_MESSAGE);		
					break;
				}		
			}
			rs.close();
			if(boo=true)
			{
				String s1="'"+jtf1.getText().trim()+"'",s2="'"+jtf2.getText().trim()+"'";	
	     	    stmt.executeUpdate("INSERT INTO dic_tra VALUES ("+s1+","+s2+")");						
				JOptionPane.showMessageDialog(this,"添加成功！","恭喜",
				JOptionPane.WARNING_MESSAGE);	
				dispose();
			}
			stmt.close();
			cn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
	}
}


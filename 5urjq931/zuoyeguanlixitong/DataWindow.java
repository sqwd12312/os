package 实训;
import java.awt.*;
import java.awt.datatransfer.*;
import java.awt.event.*;
import javax.swing.*;
import java.sql.*;
import java.io.*;
public class DataWindow extends JFrame implements ActionListener 
{
	JMenuBar bar=new JMenuBar();
	JMenu fileMenu,editMenu,helpMenu;
	JPopupMenu menu;
	JMenuItem c_h,h_c,save,exit,addwords,delwords,editwords,help,about,paste,cut,copy;
	JPanel jp0,jp1,jp2,jp3;
	JLabel jla1;
	JTextField jtf;
	JTextArea jtext;
	JButton jbt1,jbt2,jbt3,jbt4,jbt5;
	JScrollPane jsp;
	Clipboard clipboard=null;
	public DataWindow()
	{
		super("英汉小词典");
		this.setSize(500,400);
		menu=new JPopupMenu();
		clipboard=getToolkit().getSystemClipboard();//获取系统剪贴板。
		fileMenu=new JMenu("文件");
		editMenu=new JMenu("编辑");
		helpMenu=new JMenu("帮助");
		//menu=new JMenu("剪切板");
		c_h=new JMenuItem("英汉词典");
		c_h.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				    jla1.setText("输入要查询的英语单词");
				    jbt1.setVisible(true);
			}
		});
		h_c=new JMenuItem("汉英词典");
		h_c.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				    jla1.setText("输入要查询的汉语意思");
				    jbt1.setVisible(true);
			}
		});
		save=new JMenuItem("备份词库");
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				File fromfile = new File("english\\english.mdb");
				FileInputStream fis = null;	
				FileDialog filedialog_save=new FileDialog(new JFrame(),"保存文件对话框",FileDialog.SAVE );
				filedialog_save.setVisible(true);
				try{
					fis = new FileInputStream(fromfile);
					int bytesRead;  //定义变量来存储输入流中读取出来的文件
					byte[] buf = new byte[4*1024];  //4K buffer
					File tofile = new File(filedialog_save.getDirectory(),filedialog_save.getFile());
					FileOutputStream fos = new FileOutputStream(tofile);
					while((bytesRead = fis.read(buf))!=-1)
						{
						fos.write(buf,0,bytesRead);
						}
					fos.flush();
					fos.close();
					fis.close();
					}
					catch(IOException e2){  }
				}

			}
		);
		exit=new JMenuItem("退出");
		exit.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				System.exit(0);
			}
		});
		fileMenu.add(c_h);
		fileMenu.add(h_c);
		fileMenu.add(save);
		fileMenu.add(exit);
		addwords=new JMenuItem("添加词汇");
		editwords=new JMenuItem("修改词汇");
		delwords=new JMenuItem("删除词汇");
		editMenu.add(addwords);
		editMenu.add(editwords);
		editMenu.add(delwords);
		help=new JMenuItem("帮助");
		about=new JMenuItem("关于...");
		copy=new JMenuItem("复制");
	    cut=new JMenuItem ("剪切");  
	    paste=new JMenuItem ("粘贴");
	    menu.add(cut);
	    menu.add(copy);
	    menu.add(paste);
		addwords.addActionListener(this);
		editwords.addActionListener(this);
		delwords.addActionListener(this);
		help.addActionListener(this);
		about.addActionListener(this);
		helpMenu.add(help);
		helpMenu.add(about);
		bar.add(fileMenu);
		bar.add(editMenu);
		bar.add(helpMenu);
		bar.add(menu);
		setJMenuBar(bar);
		jp0=new JPanel();
		jp1=new JPanel();
		jp2=new JPanel();
		jp3=new JPanel();
		jla1=new JLabel("输入要查询的英语单词");
		jtf=new JTextField(15);
		jtext=new JTextArea();
		jsp=new JScrollPane(jtext);
		jbt1=new JButton("查询");
		jbt2=new JButton("发音");
		jbt3=new JButton("添加");
		jbt4=new JButton("修改");
		jbt5=new JButton("删除");
		copy.addActionListener(this); 
		cut.addActionListener(this);
	    paste.addActionListener(this);
		jbt1.addActionListener(this);
		jbt2.addActionListener(this);
		jbt3.addActionListener(this);
		jbt4.addActionListener(this);
		jbt5.addActionListener(this);
		jp0.setLayout(new FlowLayout());
		jp1.setLayout(new FlowLayout());
		jp0.add(jla1,FlowLayout.LEFT);
		jp0.add(jtf,FlowLayout.CENTER);
		jp0.add(jbt1,FlowLayout.RIGHT);
		jp1.add(jp0,FlowLayout.LEFT);
		jp1.add(jbt2,FlowLayout.CENTER);
		jp2.setLayout(new FlowLayout());
		jp2.add(jbt3,FlowLayout.LEFT);
		jp2.add(jbt4,FlowLayout.CENTER);
		jp2.add(jbt5,FlowLayout.RIGHT);
		jp3.setLayout(new BorderLayout());
		jp3.add(jp1,BorderLayout.NORTH);
		jp3.add(jp2,BorderLayout.SOUTH);
		jp3.add(jsp,BorderLayout.CENTER);
		jtext.addMouseListener(new MouseAdapter(){
			public void mousePressed( MouseEvent event ) { 
					triggerEvent(event); 
				} 
			public void mouseReleased( MouseEvent event ) {
					triggerEvent(event); 
				} 
			private void triggerEvent(MouseEvent event) {
					if (event.isPopupTrigger()) 
						menu.show(event.getComponent(),event.getX(),event.getY()); 
				} 
		}); 
		this.add(jp3);
		this.setVisible(true);
		
	}
	public void actionPerformed(ActionEvent e)
	{
		if(e.getSource()==jbt1)
		{
			try{Listwords();}
			catch(SQLException ee){}
		}
		else if(e.getSource()==jbt3||e.getSource()==addwords)
		{
			new AddWin();

		}
		else if(e.getSource()==jbt4||e.getSource()==editwords)
		{
			 new ModifyWin();
		}
		else if(e.getSource()==jbt5||e.getSource()==delwords)
		{
			new DelWin();
		}
		else if(e.getSource()==help)
		{
			HelpFrame help = new HelpFrame();
			help.setVisible(true);
		}else if(e.getSource()==about)
		{
			final String AboutMsg = "A Electrical Dictionary 1.0 \n \n"
				+"An application written to show off the function of dictionary.\n \n"
				+"Written By Edith.\n \n"
				+"Copyright (c) 2005 by Edith.All rights Reserved.";
				JOptionPane.showMessageDialog(this,AboutMsg);
		}else if(e.getSource()==copy)                  
	       {  String temp=jtext.getSelectedText();  
	          StringSelection text=new StringSelection(temp);
	          clipboard.setContents(text,null);
	       }
	     else if(e.getSource()==cut)              
	      {  String temp=jtext.getSelectedText();   
	         StringSelection text=new StringSelection(temp);
	         clipboard.setContents(text,null);
	         int start=jtext.getSelectionStart();
	         int end  =jtext.getSelectionEnd(); 
	         jtext.replaceRange("",start,end) ; 
	      }
	     else if(e.getSource()==paste)       
	     {  Transferable contents=clipboard.getContents(this);
	        DataFlavor  flavor= DataFlavor.stringFlavor;
	        if( contents.isDataFlavorSupported(flavor))
	          try{  String str;
	                str=(String)contents.getTransferData(flavor);
	                jtext.append(str);
	             }
	          catch(Exception ee){}
	      }
	}
	public void Listwords()throws SQLException
	{
		if(query())
		{
		}
	}
	public boolean query()throws SQLException
	{
		String eng_info,chi_info;
		boolean boo=false;
		//1.加载驱动
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		//查询学生信息
		try
		{
			String url = "jdbc:sqlserver://127.0.0.1:1433;databasename=dictionary";
			//2.创建连接
			Connection cn = DriverManager.getConnection(url,"sa","123456");
			//3.创建命令对象
			Statement stmt = cn.createStatement();
			//4.执行查询语句
			//jla1.setText("输入要查询的英语单词");
			jtext.setText("");
			if(jla1.getText().trim().equals("输入要查询的英语单词"))
			{
				ResultSet rs = stmt.executeQuery("select * from dic_tra ");
				while(rs.next())
				{
					eng_info=rs.getString("English");
					chi_info=rs.getString("Chinese");
					//jtext.append(jtf.getText().trim());
					//jtext.append("单词："+eng_info+"\t解释："+chi_info+"\n");
					if(jtf.getText().trim().equals(eng_info.trim()))
					{
						jtext.append("单词："+eng_info+"解释："+chi_info+"\n");
						boo=true;
					}
				}
				rs.close();
			}
			else if(jla1.getText().equals("输入要查询的汉语意思"))
			{
				ResultSet rs = stmt.executeQuery("select * from dic_tra where Chinese like'%"+jtf.getText()+"%'");
				while(rs.next())
				{
					eng_info=rs.getString("English");
					chi_info=rs.getString("Chinese");
					jtext.append(eng_info+'\n');
				}
				rs.close();  //关闭数据库
			}
			if(jtf.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "查询对象不能为空", "警告",JOptionPane.WARNING_MESSAGE);
			}
			else if(jtext.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"查无此单词！","警告",
				JOptionPane.WARNING_MESSAGE);
			}
			stmt.close();
			cn.close();
		}catch(SQLException e)
		{
			e.printStackTrace();
		}
		return boo;
	}

}




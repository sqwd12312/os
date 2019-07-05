package ʵѵ;
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
		super("Ӣ��С�ʵ�");
		this.setSize(500,400);
		menu=new JPopupMenu();
		clipboard=getToolkit().getSystemClipboard();//��ȡϵͳ�����塣
		fileMenu=new JMenu("�ļ�");
		editMenu=new JMenu("�༭");
		helpMenu=new JMenu("����");
		//menu=new JMenu("���а�");
		c_h=new JMenuItem("Ӣ���ʵ�");
		c_h.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				    jla1.setText("����Ҫ��ѯ��Ӣ�ﵥ��");
				    jbt1.setVisible(true);
			}
		});
		h_c=new JMenuItem("��Ӣ�ʵ�");
		h_c.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				    jla1.setText("����Ҫ��ѯ�ĺ�����˼");
				    jbt1.setVisible(true);
			}
		});
		save=new JMenuItem("���ݴʿ�");
		save.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e)
			{
				File fromfile = new File("english\\english.mdb");
				FileInputStream fis = null;	
				FileDialog filedialog_save=new FileDialog(new JFrame(),"�����ļ��Ի���",FileDialog.SAVE );
				filedialog_save.setVisible(true);
				try{
					fis = new FileInputStream(fromfile);
					int bytesRead;  //����������洢�������ж�ȡ�������ļ�
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
		exit=new JMenuItem("�˳�");
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
		addwords=new JMenuItem("��Ӵʻ�");
		editwords=new JMenuItem("�޸Ĵʻ�");
		delwords=new JMenuItem("ɾ���ʻ�");
		editMenu.add(addwords);
		editMenu.add(editwords);
		editMenu.add(delwords);
		help=new JMenuItem("����");
		about=new JMenuItem("����...");
		copy=new JMenuItem("����");
	    cut=new JMenuItem ("����");  
	    paste=new JMenuItem ("ճ��");
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
		jla1=new JLabel("����Ҫ��ѯ��Ӣ�ﵥ��");
		jtf=new JTextField(15);
		jtext=new JTextArea();
		jsp=new JScrollPane(jtext);
		jbt1=new JButton("��ѯ");
		jbt2=new JButton("����");
		jbt3=new JButton("���");
		jbt4=new JButton("�޸�");
		jbt5=new JButton("ɾ��");
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
		//1.��������
		try
		{
			Class.forName("com.microsoft.sqlserver.jdbc.SQLServerDriver");
		}
		catch(ClassNotFoundException ex)
		{
			ex.printStackTrace();
		}
		//��ѯѧ����Ϣ
		try
		{
			String url = "jdbc:sqlserver://127.0.0.1:1433;databasename=dictionary";
			//2.��������
			Connection cn = DriverManager.getConnection(url,"sa","123456");
			//3.�����������
			Statement stmt = cn.createStatement();
			//4.ִ�в�ѯ���
			//jla1.setText("����Ҫ��ѯ��Ӣ�ﵥ��");
			jtext.setText("");
			if(jla1.getText().trim().equals("����Ҫ��ѯ��Ӣ�ﵥ��"))
			{
				ResultSet rs = stmt.executeQuery("select * from dic_tra ");
				while(rs.next())
				{
					eng_info=rs.getString("English");
					chi_info=rs.getString("Chinese");
					//jtext.append(jtf.getText().trim());
					//jtext.append("���ʣ�"+eng_info+"\t���ͣ�"+chi_info+"\n");
					if(jtf.getText().trim().equals(eng_info.trim()))
					{
						jtext.append("���ʣ�"+eng_info+"���ͣ�"+chi_info+"\n");
						boo=true;
					}
				}
				rs.close();
			}
			else if(jla1.getText().equals("����Ҫ��ѯ�ĺ�����˼"))
			{
				ResultSet rs = stmt.executeQuery("select * from dic_tra where Chinese like'%"+jtf.getText()+"%'");
				while(rs.next())
				{
					eng_info=rs.getString("English");
					chi_info=rs.getString("Chinese");
					jtext.append(eng_info+'\n');
				}
				rs.close();  //�ر����ݿ�
			}
			if(jtf.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this, "��ѯ������Ϊ��", "����",JOptionPane.WARNING_MESSAGE);
			}
			else if(jtext.getText().equals(""))
			{
				JOptionPane.showMessageDialog(this,"���޴˵��ʣ�","����",
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




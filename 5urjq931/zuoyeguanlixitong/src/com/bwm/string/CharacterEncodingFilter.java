package com.bwm.string;

import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.util.Map;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletRequestWrapper;


 
/**
 * ˵����ȫվ�ַ����������
 * ע�⣺��������д�ú�,��Ҫȥweb.xml�ļ������ò���ʹ��,��Ĭ�������,����������ʱ��������������
 * �ص㣺���Խ��HTTP����GET & POST���ύ�������������ݳ������������
 * ˼·��
 *       �ٶ�̬����
 *       ��ʹ��HttpServletRequestWrapper�ࣨ���������õ�������
 */
public class CharacterEncodingFilter implements Filter 
{
	private String charset;
	
    public void destroy(){}
    
	public void init(FilterConfig filterConfig) throws ServletException
	{
		charset = filterConfig.getInitParameter("charset"); //��web.xml�ļ��ڵĵ�ǰ�����������л�ȡ���õ��ַ��������
		charset = (charset==null? "UTF-8" : charset); //��û����web.xml�ļ�������,��charsetֵ����ΪUTF-8
	}
	
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException 
	{
		request.setCharacterEncoding(charset); //Ϊrequest�����������
		PowerRequest powerRequest = new PowerRequest((HttpServletRequest)request); //����request����İ�װ����һ����request���������ǿ�Ķ���
		chain.doFilter(powerRequest, response); //��������з���
	}
}
 
 
//---------------------------------------------------------------------------------------------------------------------------------------------------
 
 
/**
 * ˵����
 *      ����JavaEE�淶��ר���ṩ��һ������װ�����ģʽ����HttpServletRequestWrapper
 *      ����HttpServletRequestWrapper����ڲ�,��ʵ�Ѿ�������һ������ΪHttpServletRequest�ĳ�Ա����
 *      ����HttpServletRequestWrapper���е����з���,��ʵ����ʹ�����ڲ���HttpServletRequest���͵ĳ�Ա����ȥ���õ�
 *      �ܸ�HttpServletRequestWrapper������þ���ר���ṩ������ʹ�õ�,����Ա������д��ĳЩ����,�Ӷ��ﵽ"��ǿ�������"��Ŀ��
 *
 * ˼·��ͨ���Լ���дһ�������̳�HttpServletRequestWrapper,Ȼ����д�����ĳЩ����,�Ӷ��ﵽ���������������
 */
class PowerRequest extends HttpServletRequestWrapper
{
	private String charset;
	
	//���캯��
	public PowerRequest(HttpServletRequest request)
	{
		super(request);
		charset = super.getCharacterEncoding(); //��֮ǰ����Ϊ�����ù�request����ı���,���ȡ�ɹ�,�����ȡΪnull
		charset = (charset == null? "ISO-8859-1" : charset);
	}
 
	
	@Override
	public String getParameter(String name)
	{
		if("GET".equalsIgnoreCase(super.getMethod()))
		{
			String data = super.getParameter(name); //��ȡ�����������
			if(data != null)
			{
				try
				{
					data = new String(data.getBytes("ISO-8859-1"), charset);
				}
				catch(UnsupportedEncodingException e)
				{
					throw new RuntimeException(e);
				}
			}
			return data;
		}
		return super.getParameter(name);
	}
 
 
	@Override
	public String[] getParameterValues(String name)
	{
		if("GET".equalsIgnoreCase(super.getMethod()))
		{
			String[] values = super.getParameterValues(name);
			for(int i=0; values!=null && i<values.length; i++)
			{
				try
				{
					values[i] = new String(values[i].getBytes("ISO-8859-1"), charset);
				}
				catch(UnsupportedEncodingException e)
				{
					throw new RuntimeException(e);
				}
			}
			return values;
		}
		return super.getParameterValues(name);
	}
 
 
	@Override
	public Map getParameterMap()
	{
		if("GET".equalsIgnoreCase(super.getMethod()))
		{
			Map<String,String[]> map = super.getParameterMap();
			if(map != null)
			{
				for(Map.Entry<String,String[]> me : map.entrySet())
				{
					String[] values = me.getValue();
					for(int i=0; values!=null && i<values.length; i++)
					{
						try
						{
							values[i] = new String(values[i].getBytes("ISO-8859-1"), charset);
						}
						catch(UnsupportedEncodingException e)
						{
							throw new RuntimeException(e);
						}
					}
				}
			}
			return map;
		}
		return super.getParameterMap();
	}
	
}
 

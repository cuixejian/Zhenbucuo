package com.webtest.utils;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.StringWriter;
import java.io.UnsupportedEncodingException;
import java.io.Writer;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import com.webtest.demo.Test1;

import freemarker.template.Configuration;
import freemarker.template.ObjectWrapper;
import freemarker.template.Template;
import freemarker.template.TemplateException;

public class createDayReportFiles {
	/**
	    * 通过JSON生成Html，Excel，Word
	    * @param data 数据源
	    * @param fileName 文件名
	    * @param templateFilePath 文件路径
	    * @param templateFile 模板
	 * @throws TemplateException 
	    */
	    public static void createDayReportFile(Map data,String fileName,String templateFilePath,String templateFile) throws TemplateException {
	        BufferedInputStream in = null;
	        Writer out = null;  
	        Template template = null;
	        try {
	  
	            //构造Configuration
	            Configuration configuration = new Configuration();
	            configuration.setDefaultEncoding("utf-8");  
	            configuration.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
	            configuration.setDirectoryForTemplateLoading(new File(templateFilePath));
	            
	            
	            try {  
	                //test.ftl为要装载的模板  
	            	template = configuration.getTemplate(templateFile);  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	          
	           
	            //输出文档路径及名称  
	            File outFile = new File(fileName);  
	           
	            FileOutputStream fos = null;
	            OutputStreamWriter oWriter=null;
	            try {  
	                fos = new FileOutputStream(outFile);  
	                 oWriter = new OutputStreamWriter(fos,"UTF-8");  
	                //这个地方对流的编码不可或缺，使用main（）单独调用时，应该可以，但是如果是web请求导出时导出后word文档就会打不开，并且包XML文件错误。主要是编码格式不正确，无法解析。  
	                 out = new StringWriter();   
	                 
	            } catch (FileNotFoundException e1) {  
	                e1.printStackTrace();  
	            }  
	            
	        
	            //生成HTML
//	            System.out.println("测试结果"+tests);
	            template.process(data, out);
	            System.out.println(out.toString());
	            oWriter.write(out.toString());
	            oWriter.flush();
	            
	            
	            
	            
//	            System.out.println("测试"+data);
//	            template.process(data, out);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }  finally {
	            if(null != in) {
	                try {
	                    in.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            if(null != out) {
	                try {
	                    out.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        
	    }
	/**
	    * 通过JSON生成Html，Excel，Word
	    * @param data 数据源
	    * @param fileName 文件名
	    * @param templateFilePath 文件路径
	    * @param templateFile 模板
	 * @throws TemplateException 
	    */
	    public static void createDayReportFile1(Map<String,Object> data,ArrayList<Test1> tests,String fileName,String templateFilePath,String templateFile) throws TemplateException {
	        BufferedInputStream in = null;
	        Writer out = null;  
	        Template template = null;
	        try {
	  
	            //构造Configuration
	            Configuration configuration = new Configuration();
	            configuration.setDefaultEncoding("utf-8");  
	            configuration.setObjectWrapper(ObjectWrapper.BEANS_WRAPPER);
	            configuration.setDirectoryForTemplateLoading(new File(templateFilePath));
	            
	            
	            try {  
	                //test.ftl为要装载的模板  
	            	template = configuration.getTemplate(templateFile);  
	            } catch (IOException e) {  
	                e.printStackTrace();  
	            }  
	          
	           
	            //输出文档路径及名称  
	            File outFile = new File(fileName);  
	           
	            FileOutputStream fos = null;  
	            try {  
	                fos = new FileOutputStream(outFile);  
	                OutputStreamWriter oWriter = new OutputStreamWriter(fos,"UTF-8");  
	                //这个地方对流的编码不可或缺，使用main（）单独调用时，应该可以，但是如果是web请求导出时导出后word文档就会打不开，并且包XML文件错误。主要是编码格式不正确，无法解析。  
	                 out = new BufferedWriter(oWriter);   
	                 
	            } catch (FileNotFoundException e1) {  
	                e1.printStackTrace();  
	            }  
	            
	        	for (Test1 test1:tests) {
	    			System.out.println("验证："+test1.name);
	    			
	    		}
	            //生成HTML
	            template.process(tests, out);
	        } catch (FileNotFoundException e) {
	            e.printStackTrace();
	        } catch (UnsupportedEncodingException e) {
	            e.printStackTrace();
	        } catch (IOException e) {
	            e.printStackTrace();
	        }  finally {
	            if(null != in) {
	                try {
	                    in.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	            if(null != out) {
	                try {
	                    out.close();
	                } catch (IOException e) {
	                    e.printStackTrace();
	                }
	            }
	        }
	        
	    }
}





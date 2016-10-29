package com.newsat.platform.web.parse;

import java.io.File;  
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.jsoup.Jsoup;  
import org.jsoup.nodes.Document;  
import org.jsoup.select.Elements; 
import org.jsoup.Connection.*; 

public class WebParse {

	public static List<File> listFile = new ArrayList<File>();
	
	public static void ListSubFiles(File file)
	{
		File files[] = file.listFiles();
		if(files == null)
		{
			return;
		}
		for (File f : files)
		{		
			if (f.isDirectory())
			{
				ListSubFiles(f);
			}
			else
			{
				listFile.add(f);
			}
		}
	}
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try 
		{  
			//Document doc = Jsoup.connect("http://www.sciencemag.org/news/2016/10/nations-sign-major-deal-curb-warming-chemicals-used-air-conditioning").userAgent("Mozilla/5.0 (Windows; U; Windows NT 5.1; zh-CN; rv:1.9.2.15)").timeout(5000).get(); 
			File files[] = new File("D:\\news\\").listFiles();
			for (int i = 0; i < files.length; ++i)
			{
				if (files[i].isDirectory())
				{
					ListSubFiles(files[i]);
				}
			}
			
			for (File file: listFile)
			{
				String filename = file.getName();
				String filepath = file.getPath();
				Document doc = Jsoup.parse(file,"UTF-8","");
				System.out.println(filepath);
				Elements body = doc.select("div.article__body"); 
				File newfile = new File(filepath+".txt");
				FileOutputStream fop = new FileOutputStream(newfile);
				fop.write(body.text().getBytes());
				fop.close();
			}
	    }
		catch (IOException e) 
		{  
			e.printStackTrace();  
	    }
	}

}

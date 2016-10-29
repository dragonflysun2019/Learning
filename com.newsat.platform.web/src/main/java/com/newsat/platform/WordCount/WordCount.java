package com.newsat.platform.WordCount;

import java.io.BufferedReader;
import java.io.File;  
import java.io.FileOutputStream;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Vector;
import java.util.Map;
import java.util.HashMap;
import java.util.Iterator;

import jxl.Cell;   
import jxl.CellType;   
import jxl.Sheet;   
import jxl.Workbook;   
import jxl.write.Label;   

public class WordCount {
	
	public static Vector<String> vecWords  = new Vector<String>();
	public static Map<String, Vector<String>> mapWordSentence = new HashMap<String, Vector<String>>();

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		try {
			//Read Word
			File fileword = new File("D:\\Hinge\\FoundingFathers.txt");
			if (fileword.isFile() && fileword.exists())
			{
				InputStreamReader read = new InputStreamReader(new  FileInputStream(fileword), "UTF-8");
				BufferedReader bufferedReader = new BufferedReader(read);
				
				String strWord = null;
				while((strWord = bufferedReader.readLine()) != null)
				{
					String word = strWord.trim();
					if (word.length() <= 2)
					{
						continue;
					}
					//System.out.println(word + ":  " + word.length());
					vecWords.add(word);
				}
				System.out.println("单词表个数：" + vecWords.size());
				read.close();
			}
			
			File file = new File("D:\\Hinge\\汇总.txt");
			if (file.isFile() && file.exists())
			{
				InputStreamReader read = new InputStreamReader(new  FileInputStream(file), "UTF-8");
				BufferedReader bufferedReader = new BufferedReader(read);
				String strTotalContent = new String();
				String strContent = null;
				
				int nCount = 0;
				int nTotalCount = 0;
				while((strContent = bufferedReader.readLine() )!= null){
					strTotalContent += strContent;
					++nCount;
					if (nTotalCount >= 100)
					{
						break;
					}
					
					if (10000 == nCount)
					{
						String[] strSentences = strTotalContent.split("\\.");
						for (String sentence: strSentences)
						{
							Iterator<String> itr = vecWords.iterator();
							while (itr.hasNext())
							{
								String word = itr.next();
								if (sentence.toLowerCase().indexOf(word.toLowerCase()) != -1)
								{
									Vector<String> vecSentences = mapWordSentence.get(word);
									if (vecSentences == null)
									{
										vecSentences = new Vector<String>();
									}
									if (vecSentences.size() >= 10)
									{
										itr.remove();
									}
									else
									{
										vecSentences.add(sentence);
										mapWordSentence.put(word, vecSentences);
									}
								}
							}
						}
						strTotalContent = null;
						nCount = 0;
						++nTotalCount;
					}
				}
			read.close();
			}
			
			System.out.println("统计单词数：" + mapWordSentence.size());
			File newfile = new File("D:\\Hinge\\result.txt");
			FileOutputStream fop = new FileOutputStream(newfile);
			for (String key: mapWordSentence.keySet() )
			{
				fop.write(key.getBytes());
				fop.write(": \r\n".getBytes());
				Vector<String> vecSentences = mapWordSentence.get(key);
				for (int j = 0; j < vecSentences.size(); ++j)
				{
					String num = String.valueOf(j+1);
					fop.write(num.getBytes());
					fop.write(". ".getBytes());
					fop.write(vecSentences.get(j).getBytes());
					fop.write("\r\n".getBytes());
				}
			}
			fop.close();
		}catch(Exception e){
			e.printStackTrace();
		}
	}

}

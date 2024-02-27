package com.tmb.utils;

import java.lang.reflect.Method;
import java.lang.reflect.Parameter;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.annotations.DataProvider;

/*
 * This single data Provider will be common to 
 */
public final class DataProviderUtil {
	
	private static List<Map<String,String>> list = new ArrayList<>();
	
	@DataProvider
	public static Object[] getData(Method m)
	{
		String testname = m.getName();
		Parameter[] p = m.getParameters();
		for(Parameter ps : p)
		{
			ps.getName();
		}
		
		if(list.isEmpty())
		{
			list = ExcelUtils.getTestDetails("Data");
		}
		
		List<Map<String,String>> iterationList = new ArrayList<>();
		
		for(int i=0;i<list.size();i++)
		{
			if(list.get(i).get("testname").equalsIgnoreCase(testname))
			{
				if(list.get(i).get("execute").equalsIgnoreCase("yes"))
				{
					iterationList.add(list.get(i));
				}
			}
		}
		
		return iterationList.toArray();
	}

}

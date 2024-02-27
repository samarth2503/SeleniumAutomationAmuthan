package com.tmb.Listners;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.apache.commons.collections4.bag.SynchronizedSortedBag;
import org.testng.IMethodInstance;
import org.testng.IMethodInterceptor;
import org.testng.ITestContext;

import com.tmb.utils.ExcelUtils;

public class MethodInterceptor implements IMethodInterceptor{

	/*
	 * It contains all the test that testNg going to execute
	 * It is used when we want to makes changes in testNg method at run time
	 * It will run once per suite
	 */
	@Override
	public List<IMethodInstance> intercept(List<IMethodInstance> methods, ITestContext context) {
		
		List<Map<String,String>> list = ExcelUtils.getTestDetails("RunManager");
		List<IMethodInstance> result = new ArrayList<>();
		
		for(int i=0;i<methods.size();i++)
		{
			for(int j=0;j<list.size();j++)
			{
				if(methods.get(i).getMethod().getMethodName().equalsIgnoreCase(list.get(j).get("Testname")))
				{
					if(list.get(j).get("Execute").equalsIgnoreCase("yes")) {
						methods.get(i).getMethod().setDescription(list.get(j).get("TestDescription"));
						methods.get(i).getMethod().setInvocationCount(Integer.parseInt(list.get(j).get("Count")));
						methods.get(i).getMethod().setPriority(Integer.parseInt(list.get(j).get("Priority")));
						result.add(methods.get(i));
						System.out.println(methods.get(i).getMethod().getInstance());
					}
				}
			}
		}
		
		return result;
	}

}

package com.tmb.Listners;

import java.lang.reflect.Constructor;
import java.lang.reflect.Method;

import org.testng.IAnnotationTransformer;
import org.testng.annotations.ITestAnnotation;

import com.tmb.utils.DataProviderUtil;


public class AnnotationTransformer implements IAnnotationTransformer{
	
	/*
	 * It will be called each time when test methods is ran.
	 */
	
	@Override
	public void transform(ITestAnnotation annotation, Class testClass, Constructor testConstructor,Method testMethod)
	{
		annotation.setDataProvider("getData");
		annotation.setDataProviderClass(DataProviderUtil.class);
		annotation.setRetryAnalyzer(RetryFailedTest.class);
	}

}

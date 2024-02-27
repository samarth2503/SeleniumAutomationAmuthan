package com.tmb.utils;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Objects;
import java.util.Properties;

import com.tmb.FrameworkException.PropertyFileUsageException;
import com.tmb.constants.FrameworkConstants;
import com.tmb.enums.ConfigProperties;

public class ReadPropertyFile {
	
	private ReadPropertyFile() {}
	
	private static Properties property = new Properties();
	private static Map<String,String> CONFIGMAP = new HashMap<String,String>();
	
	static {
		try {
			FileInputStream file = new FileInputStream(FrameworkConstants.getConfigpath());
			property.load(file);
			for(Entry<Object, Object> key : property.entrySet())
			{
				CONFIGMAP.put(String.valueOf(key.getKey()).toLowerCase().trim(), String.valueOf(key.getValue()).trim());
			}
		}
		catch(FileNotFoundException e)
		{
			e.printStackTrace();
		}
		catch(IOException e)
		{
			e.printStackTrace();
		}
	}
	
	public static String getValue(ConfigProperties key)
	{
		if(Objects.isNull(property.getProperty(key.name().toLowerCase())) || Objects.isNull(key.name().toLowerCase()))
		{
			throw new PropertyFileUsageException("Property name "+key+" is not found. Please check config.properties");
		}
		
		return CONFIGMAP.get(key.name().toLowerCase()).trim();
	}

}

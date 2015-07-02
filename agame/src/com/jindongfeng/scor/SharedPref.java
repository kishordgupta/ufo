package com.jindongfeng.scor;

import org.cocos2d.nodes.CCDirector;

import android.content.SharedPreferences;


/**
 * program`s setting model
 */
public class SharedPref{
	public static final String PREFS_NAME = "SharedPreferences";
	public static SharedPreferences	m_settings;

	public static boolean isContain( String strKey ){
		return m_settings.contains(strKey);
	}
	
	public static int getIntValue( String strKey, int nDefValue ){
		if(isContain(strKey)){
			return (Integer) m_settings.getInt(strKey, nDefValue);
		}
		return nDefValue;
	}
	
	public static boolean getBooleanValue( String strKey, boolean bDefValue ){
		if(isContain(strKey)){
			return m_settings.getBoolean(strKey, bDefValue);
		}
		return bDefValue;
	}
	
	public static float getFloatValue( String strKey, float ftDefValue ){
		if(isContain(strKey)){
			return m_settings.getFloat(strKey, ftDefValue);
		}
		return ftDefValue;
	}
	
	public static long getLongValue( String strKey, long lDefValue ){
		if(isContain(strKey)){
			return m_settings.getLong(strKey, lDefValue);
		}
		return lDefValue;
	}
	
	public static String getStringValue( String strKey, String strDefValue ){
		if(isContain(strKey)){
			return m_settings.getString(strKey, strDefValue);
		}
		return strDefValue;
	}
	
	public static void putValue( String strKey, Object value ){
		SharedPreferences.Editor edit = m_settings.edit();
		
		if(value instanceof Integer){
			edit.putInt(strKey, ((Number)value).intValue());
		}else if(value instanceof Boolean){
			edit.putBoolean(strKey, ((Boolean)value).booleanValue());
		}else if(value instanceof Float){
			edit.putFloat(strKey, ((Number)value).floatValue());
		}else if(value instanceof Long){
			edit.putLong(strKey, ((Number)value).longValue());
		}else if(value instanceof String){
			edit.putString(strKey, (String)value);
		}else if(value instanceof Double){
			edit.putFloat(strKey, ((Number)value).floatValue());
		}
		
		edit.commit();
	}
	
	public static void putValue( String strKey, int nValue ){
		SharedPreferences.Editor edit = m_settings.edit();
		edit.putInt(strKey, nValue);
		edit.commit();
	}
	
	public static void putValue( String strKey, boolean bValue ){
		SharedPreferences.Editor edit = m_settings.edit();
		edit.putBoolean(strKey, bValue);
		edit.commit();
	}
	
	public static void putValue( String strKey, float ftValue ){
		SharedPreferences.Editor edit = m_settings.edit();
		edit.putFloat(strKey, ftValue);
		edit.commit();
	}
	
	public static void putValue( String strKey, long lValue ){
		SharedPreferences.Editor edit = m_settings.edit();
		edit.putLong(strKey, lValue);
		edit.commit();
	}
	
	public static void putValue( String strKey, String strValue ){
		SharedPreferences.Editor edit = m_settings.edit();
		edit.putString(strKey, strValue);
		edit.commit();
	}
	
	public static void remove( String strKey ){
		SharedPreferences.Editor edit = m_settings.edit();
		edit.remove(strKey);
		edit.commit();
	}

	/*
	public static void removeAll(){
		SharedPreferences.Editor edit = m_settings.edit();
		edit.clear();
		edit.commit();
	}
	*/
	/** initialize setting */
    public static void initialize(){
    	m_settings = CCDirector.sharedDirector().getActivity().getSharedPreferences(PREFS_NAME, 0);
 
//    	removeAll();
    	if( getBooleanValue("FIRST_INSTALL_FLAG", true) ){
        	putValue("FIRST_INSTALL_FLAG", false);
			
        	// Game Info
			putValue("LevelInfo", 1);
    	}
    }
}

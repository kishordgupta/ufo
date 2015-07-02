package com.siliconorchard.jumpingufo;



import android.app.Application;

public class ParseApplication extends Application {

	@Override
	public void onCreate() {
		super.onCreate();

		// Add your initialization code here
	/*	Parse.initialize(this, "UEn2n5S8Lv9DSZcfDLgse2zpXwO8rYL1WNRpF96L", "LskSbzo7ZoOLDTE8gN8zlczUj5tqNb1vtx9QamsL");
		PushService.setDefaultPushCallback(this, WoodyDaPeckerActivity.class);
		//ParseUser.enableAutomaticUser();
		ParseACL defaultACL = new ParseACL();
	    
		// If you would like all objects to be private by default, remove this line.
		defaultACL.setPublicReadAccess(true);
		defaultACL.setPublicWriteAccess(true);
		
		ParseACL.setDefaultACL(defaultACL, true);*/
		//Pushinotification
		//PushService.setDefaultPushCallback(this, TrampolineCocos2dv.class);
	}

}

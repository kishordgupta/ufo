package com.jindongfeng.scor;

import java.util.ArrayList;
import java.util.List;

import android.app.Dialog;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.pm.ResolveInfo;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.text.format.Time;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.View.OnClickListener;
import android.view.inputmethod.InputMethodManager;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;


import com.facebook.Session;
import com.facebook.UiLifecycleHelper;
import com.facebook.widget.FacebookDialog;
import com.facebook.widget.WebDialog;
import com.siliconorchard.jumpingufo.Common;
import com.siliconorchard.jumpingufo.R;
import com.siliconorchard.jumpingufo.WoodyDaPeckerActivity;

public class ScoreViewManager {

	public static String g_dbname = "topplayer";
	
	public static ArrayList<ScoreItem> g_GlobalScore = new ArrayList<ScoreItem>();
	
	public static boolean bIsLodedScores = false;
	
	/////////////setUserNameView///////////////////////
	public static  void showUserNameDialog(){
		if(SharedPref.getStringValue("username", "").length() != 0)
		{
			Common.g_username = SharedPref.getStringValue("username", "");
			return;
		}
		//hadler.postDelayed(runnable, 3000);
		//WoodyDaPeckerActivity.instance.runOnUiThread(runnable);
	}
    
	/*public static Runnable runnable = new Runnable(){
    	
		@Override
		public void run() {
			
			final Dialog dialog = new Dialog(WoodyDaPeckerActivity.instance);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setContentView(R.layout.username);
			final EditText username = (EditText)  dialog.findViewById(R.id.username);
			
			Button sendButton = (Button) dialog.findViewById(R.id.btnSend);
			sendButton.setOnClickListener(new OnClickListener() {
				@Override
				public void onClick(View v) {
					
					Common.g_username = username.getText().toString();
					if(Common.g_username.trim().length() == 0)
						return;
					
					((InputMethodManager) WoodyDaPeckerActivity.instance.getSystemService(Context.INPUT_METHOD_SERVICE)).hideSoftInputFromWindow(
							username.getWindowToken(), 0);
				
					SharedPref.putValue("username", Common.g_username);
					
					ParseQuery<ParseObject> query = ParseQuery.getQuery(g_dbname);
					query.whereEqualTo("player", Common.g_username );
					query.findInBackground(new FindCallback<ParseObject>() {
					    public void done(List<ParseObject> scoreList, ParseException e) {
					        if (e == null) {
					        	ParseObject gameScore = null;
					        	if(scoreList.size() == 0)
					        	{
					        		gameScore = new ParseObject(g_dbname);
					        		gameScore.put("player", Common.g_username );
					        		int oldScore = SharedPref.getIntValue("topScore", 0);
					        		gameScore.put("score", oldScore);
						        	Time today = new Time(Time.getCurrentTimezone());
									today.setToNow();
									gameScore.put("date", today.year+"/"+(today.month+1)+"/"+today.monthDay);
						        	gameScore.saveInBackground(new SaveCallback(){

										@Override
										public void done(ParseException arg0) {
											
										}
						        		
						        	});
					        	}
					        } 
					    }
					});
				
					dialog.dismiss();
					
				}
			});
			dialog.show();
		}
    };
    */
	/////////////////////showScoreView////////////////////////
    
	public static void setScore(){
		
		if(Common.g_username.equals(""))
		{
			showUserNameDialog();
			return;
		}
		
		/*ParseQuery<ParseObject> query = ParseQuery.getQuery(g_dbname);
		query.whereEqualTo("player", Common.g_username );
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> scoreList, ParseException e) {
		        if (e == null) {
		        	ParseObject gameScore = null;
		        	if(scoreList.size() == 0)
		        	{
		        		gameScore = new ParseObject(g_dbname);
		        		gameScore.put("player", Common.g_username );
		        		
		        	}else{
		        		gameScore = scoreList.get(0);
		        		
		        	}
		        	
		        	int oldScore = SharedPref.getIntValue("topScore", 0);
		        	
		        	gameScore.put("score", oldScore);
		        	Time today = new Time(Time.getCurrentTimezone());
					today.setToNow();
					gameScore.put("date", today.year+"/"+(today.month+1)+"/"+today.monthDay);
		        	gameScore.saveInBackground(new SaveCallback(){

						@Override
						public void done(ParseException arg0) {
							// TODO Auto-generated method stub
							//if(arg0 == null){
								//showScoreView();
							//}
						}
		        		
		        	});
		        } else {
		        	// if Exception is not null. it do not require the resisting of socores.
		        }
		    }
		});*/
		
	}
	
	
	public static void setDBName(String dbName){
		g_dbname = dbName;
	}
	
	
/////////////////////show score view////////////////////////	
	public static void showScoreView(){
		if (FacebookDialog.canPresentShareDialog(WoodyDaPeckerActivity.instance.getApplicationContext(),
				FacebookDialog.ShareDialogFeature.SHARE_DIALOG)) {UiLifecycleHelper uiHelper=new UiLifecycleHelper(WoodyDaPeckerActivity.instance, null);;
		FacebookDialog shareDialog = new FacebookDialog.ShareDialogBuilder(WoodyDaPeckerActivity.instance)
	     .setLink("https://play.google.com/store/apps/details?id=com.siliconorchard.jumpingufo")
	     .setApplicationName("Save the UFO")
	     .setPicture("http://imgur.com/WfO6Dxp")
	     .build();
	uiHelper.trackPendingDialogCall(shareDialog.present());}
		else{
		 Bundle params = new Bundle();
		    params.putString("name", "Save the UFO");
		    params.putString("caption", "Build great social apps and get more installs.");
		    params.putString("description", "I am Enjoying Save the UFO game in android");
		    params.putString("link", "https://play.google.com/store/apps/details?id=com.siliconorchard.jumpingufo");
		    params.putString("picture", "http://imgur.com/WfO6Dxp");

		    WebDialog feedDialog = (
		            new WebDialog.FeedDialogBuilder(WoodyDaPeckerActivity.instance,
		                    Session.getActiveSession(),
		                    params)).build();
		    feedDialog.show();
		}
/*		Intent shareIntent = new Intent(android.content.Intent.ACTION_SEND);
		   shareIntent.setType("text/plain");
		   shareIntent.putExtra(android.content.Intent.EXTRA_TITLE, "Save the UFO");
		   shareIntent.putExtra(android.content.Intent.EXTRA_TEXT, "I am Enjoying Save the UFO game in android");
		   shareIntent.putExtra(android.content.Intent.EXTRA_SUBJECT, "https://play.google.com/store/apps/details?id=com.siliconorchard.jumpingufo");
		   shareIntent.putExtra(android.content.Intent.EXTRA_STREAM, R.drawable.ic_launcher);
		    WoodyDaPeckerActivity.instance.startActivity(shareIntent);*/
		 /*  PackageManager pm = WoodyDaPeckerActivity.instance.getPackageManager();
		   List<ResolveInfo> activityList = pm.queryIntentActivities(shareIntent, 0);
		     for (final ResolveInfo app : activityList) 
		     {
		         if ((app.activityInfo.name).contains("facebook")) 
		         {
		           final ActivityInfo activity = app.activityInfo;
		           final ComponentName name = new ComponentName(activity.applicationInfo.packageName, activity.name);
		          shareIntent.addCategory(Intent.CATEGORY_LAUNCHER);
		          shareIntent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK | Intent.FLAG_ACTIVITY_RESET_TASK_IF_NEEDED);
		          shareIntent.setComponent(name);
		          WoodyDaPeckerActivity.instance.startActivity(shareIntent);
		          break;
		        }
		      }*/
		/*ParseQuery<ParseObject> query = ParseQuery.getQuery(g_dbname);
		query.orderByDescending("score");
		
		query.findInBackground(new FindCallback<ParseObject>() {
		    public void done(List<ParseObject> scoreList, ParseException e) {
		        if (e == null) {
		        	g_GlobalScore.clear();
		        	if(scoreList.size()>0)
		        	{
		        		for(int i=0; i<scoreList.size(); i++ )
		        		{
		        			ScoreItem score = new ScoreItem();
		        			score.nRanking = i;
		        			score.sUserName = scoreList.get(i).getString("player");
		        			score.nScor = scoreList.get(i).getInt("score");
		        			score.date = scoreList.get(i).getString("date");
		        			g_GlobalScore.add(score);
		        		}
		        		Handler hadler = new Handler();
				        hadler.postDelayed(runableShowScorView, 500);
				        bIsLodedScores = true;
		        	}
		        	
		        } else {
		        	
		        }
		        
		    }
		});*/
	}
    
	
	public static Runnable runableShowScorView = new Runnable(){
    	
		@Override
		public void run() {
			if(WoodyDaPeckerActivity.instance == null)
				return;
			
			final Dialog dialog = new Dialog(WoodyDaPeckerActivity.instance);
			dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
			dialog.setContentView(R.layout.scoreview);
			
			ListView score = (ListView)dialog.findViewById(R.id.listView);
			score.setCacheColorHint(Color.TRANSPARENT);
			score.setAdapter(new ScoreListAdapter(WoodyDaPeckerActivity.instance,g_GlobalScore));
			//score.set
			
			dialog.show();
			bIsLodedScores = false;
		}
	};
	/////////////////////adapter/////////////////////////
	
	public static class ScoreListAdapter extends BaseAdapter
    {
        private LayoutInflater mInflater;
        private ArrayList<ScoreItem> data;
        
        public ScoreListAdapter(Context context, ArrayList data)
        {
            this.mInflater = LayoutInflater.from(context);
            this.data = data;
        }
        @Override
        public int getCount() {
        	return data.size();
        }
        @Override
        public Object getItem(int arg0) {
            // TODO Auto-generated method stub
            return null;
        }
        @Override
        public long getItemId(int arg0) {
            // TODO Auto-generated method stub
            return 0;
        }
        @Override
        public View getView(int position, View convertView, ViewGroup parent) 
        {
    		convertView = mInflater.inflate(R.layout.score_item_list, null);
    		final TextView ranking = (TextView)  convertView.findViewById(R.id.ranking);
    		final TextView user = (TextView)  convertView.findViewById(R.id.user);
    		final TextView score = (TextView)  convertView.findViewById(R.id.score);
    		final TextView winnum = (TextView)  convertView.findViewById(R.id.winnumber);
   
    		
    		if(Common.g_username.equals(data.get(position).sUserName)){
    			ranking.setTextColor(Color.RED);
    			user.setTextColor(Color.RED);
    			score.setTextColor(Color.RED);
    			winnum.setTextColor(Color.RED);
    		}
    		
    		ranking.setText(""+(position+1));
    		user.setText(data.get(position).sUserName);
    		score.setText(""+data.get(position).nScor);
    		winnum.setText(data.get(position).date);
    		
			return convertView;
        }
    }
	
}

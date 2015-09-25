package org.annet.criminalintent;

import java.util.Date;
import java.util.UUID;

import org.json.JSONException;
import org.json.JSONObject;

import android.util.Log;

class Crime {
	private static final String JSON_ID = "id";
	private static final String JSON_TITLE = "title";
	private static final String JSON_SOLVED = "solved";
	private static final String JSON_DATE = "date";
	
	private static final String JSON_SUSPECT = "suspect"; 

	private UUID mID;
	private String mTitle;
	private boolean mSolved;
	private Date mDate;
	private String mSuspect;

	public Crime() {
		mID = UUID.randomUUID();
		mDate = new Date();
	}

	public Crime(JSONObject json) throws JSONException {
		
		mID = UUID.fromString(json.getString(JSON_ID));
		
		if (json.has(JSON_TITLE)) 
			mTitle = json.getString(JSON_TITLE);
		
		mSolved = json.getBoolean(JSON_SOLVED);
		Log.d("From Crime", "blah");
		
		mDate = new Date();
		
		if(json.has(JSON_SUSPECT))
			mSuspect = json.getString(JSON_SUSPECT);
		
	}

	public JSONObject toJSON() throws JSONException {
		JSONObject json = new JSONObject();
		json.put(JSON_ID, mID.toString());
		json.put(JSON_TITLE, mTitle);
		json.put(JSON_SOLVED, mSolved);
		json.put(JSON_DATE, mDate);
		json.put(JSON_SUSPECT, mSuspect);
		return json;
	}

	public String getTitle() {
		return mTitle;
	}

	public void setTitle(String title) {
		mTitle = title;
	}

	public UUID getID() {
		return mID;
	}

	public boolean isSolved() {
		return mSolved;
	}

	public void setSolved(boolean solved) {
		mSolved = solved;
	}

	public Date getDate() {
		return mDate;
	}

	public void setDate(Date date) {
		this.mDate = date;
	}

	public String getSuspect() {
		return mSuspect;
	}

	public void setSuspect(String suspect) {
		mSuspect = suspect;
	}

	public String toString() {
		return mTitle;
	}

}

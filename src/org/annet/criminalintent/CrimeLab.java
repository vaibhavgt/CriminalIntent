package org.annet.criminalintent;

import java.util.ArrayList;
import java.util.UUID;

import android.content.Context;
import android.util.Log;

class CrimeLab {

	private static final String TAG = "CrimeLab";
	private static final String FILENAME = "crimes.json";
	private CriminalIntentJSONSerializer mSerializer;

	private static CrimeLab sCrimeLab;
	private ArrayList<Crime> mCrimes;
	private Context mAppContext;

	private CrimeLab(Context appContext) {
		mAppContext = appContext;
		mSerializer = new CriminalIntentJSONSerializer(mAppContext, FILENAME);
		try {
			mCrimes = new CriminalIntentJSONSerializer(mAppContext, FILENAME)
					.loadCrimes();
		} catch (Exception e) {
			mCrimes = new ArrayList<Crime>();
			Log.d(TAG, "FILE NOT FOUND");
		}
	}

	public boolean saveCrimes() {
		try {
			mSerializer.saveCrimes(mCrimes);
			Log.d("Nothing", "Saved Successfully");
			return true;

		} catch (Exception e) {
			Log.d("Nothing", "UNsuccessful");
			return false;
		}
	}

	public static CrimeLab getCrimeLab(Context context) {
		if (sCrimeLab == null) {
			sCrimeLab = new CrimeLab(context.getApplicationContext());
			return sCrimeLab;
		}
		return sCrimeLab;
	}

	public void addCrime(Crime c) {
		mCrimes.add(c);
	}

	public Crime getCrime(UUID id) {
		for (Crime crime : mCrimes) {
			if (crime.getID().equals(id))
				return crime;
		}
		return null;
	}

	public ArrayList<Crime> getCrimes() {
		return mCrimes;
	}
}

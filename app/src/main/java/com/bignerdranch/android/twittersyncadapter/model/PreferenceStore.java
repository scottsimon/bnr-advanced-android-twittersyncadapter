/*
  COPYRIGHT 1995-2015  ESRI

  TRADE SECRETS: ESRI PROPRIETARY AND CONFIDENTIAL
  Unpublished material - all rights reserved under the
  Copyright Laws of the United States.

  For additional information, contact:
  Environmental Systems Research Institute, Inc.
  Attn: Contracts Dept
  380 New York Street
  Redlands, California, USA 92373

  email: contracts@esri.com
*/
package com.bignerdranch.android.twittersyncadapter.model;

import android.content.Context;
import android.preference.PreferenceManager;

/**
 * Created by scotts on 10/22/15.
 */
public class PreferenceStore {

  private static final String GCM_TOKEN_KEY = "com.bignerdranch.android.twittersyncadapter.GCM_TOKEN";

  private static PreferenceStore sPreferenceStore;

  private Context mContext;

  public static PreferenceStore get(Context context) {
    if (sPreferenceStore == null) {
      sPreferenceStore = new PreferenceStore(context.getApplicationContext());
    }
    return sPreferenceStore;
  }

  private PreferenceStore(Context context) {
    mContext = context;
  }

  public String getGcmToken() {
    return PreferenceManager.getDefaultSharedPreferences(mContext)
        .getString(GCM_TOKEN_KEY, null);
  }

  public void setGcmToken(String token) {
    PreferenceManager.getDefaultSharedPreferences(mContext)
        .edit()
        .putString(GCM_TOKEN_KEY, token)
        .apply();
  }


}

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

import android.content.ContentValues;
import com.bignerdranch.android.twittersyncadapter.contentprovider.DatabaseContract;

/**
 * Created by scotts on 10/22/15.
 */
public class User {
  private int mId;
  private String mServerId;
  private String mScreenName;
  private String mPhotoUrl;

  public User(String serverId, String screenName, String photoUrl) {
    mServerId = serverId;
    mScreenName = screenName;
    mPhotoUrl = photoUrl;
  }

  public ContentValues getContentValues() {
    ContentValues cv = new ContentValues();
    cv.put(DatabaseContract.User.SERVER_ID, mServerId);
    cv.put(DatabaseContract.User.SCREEN_NAME, mScreenName);
    cv.put(DatabaseContract.User.PHOTO_URL, mPhotoUrl);
    return cv;
  }

  public String getServerId() {
    return mServerId;
  }

}
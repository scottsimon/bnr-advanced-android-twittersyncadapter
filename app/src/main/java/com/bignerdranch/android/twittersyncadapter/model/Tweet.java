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
public class Tweet {
  private String mServerId;
  private int mId;
  private String mText;
  private int mFavoriteCount;
  private int mRetweetCount;
  private User mUser;

  public Tweet(String serverId, String text, int favoriteCount, int retweetCount,
      User user) {
    mServerId = serverId;
    mText = text;
    mFavoriteCount = favoriteCount;
    mRetweetCount = retweetCount;
    mUser = user;
  }

  public ContentValues getContentValues() {
    ContentValues cv = new ContentValues();
    cv.put(DatabaseContract.Tweet.SERVER_ID, mServerId);
    cv.put(DatabaseContract.Tweet.TEXT, mText);
    cv.put(DatabaseContract.Tweet.FAVORITE_COUNT, mFavoriteCount);
    cv.put(DatabaseContract.Tweet.RETWEET_COUNT, mRetweetCount);
    cv.put(DatabaseContract.Tweet.USER_ID, mUser.getServerId());
    return cv;
  }


}

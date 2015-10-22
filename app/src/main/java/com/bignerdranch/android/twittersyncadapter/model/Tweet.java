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
import com.google.gson.annotations.SerializedName;

/**
 * Created by scotts on 10/22/15.
 */
public class Tweet {
  private int mId;

  @SerializedName("id_str")
  private String mServerId;

  @SerializedName("text")
  private String mText;

  @SerializedName("favorite_count")
  private int mFavoriteCount;

  @SerializedName("retweet_count")
  private int mRetweetCount;

  @SerializedName("user")
  private User mUser;

  private String mUserId;

  public Tweet(String serverId, String text, int favoriteCount, int retweetCount,
      User user) {
    mServerId = serverId;
    mText = text;
    mFavoriteCount = favoriteCount;
    mRetweetCount = retweetCount;
    mUser = user;
  }

  public Tweet(String serverId, String text, int favoriteCount, int retweetCount, String userId) {
    mServerId = serverId;
    mText = text;
    mFavoriteCount = favoriteCount;
    mRetweetCount = retweetCount;
    mUserId = userId;
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

  public String getText() {
    return mText;
  }

  public User getUser() {
    return mUser;
  }

  public void setUser(User user) {
    mUser = user;
  }

  public String getUserId() {
    return mUserId;
  }
}

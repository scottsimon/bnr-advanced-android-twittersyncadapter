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
package com.bignerdranch.android.twittersyncadapter.contentprovider;

import android.content.ContentResolver;
import android.net.Uri;

/**
 * Created by scotts on 10/22/15.
 */
public class DatabaseContract {
  public static final String AUTHORITY = "com.bignerdranch.android.twittersyncadapter.provider";
  public static final Uri CONTENT_URI = Uri.parse("content://" + AUTHORITY);

  public static final String LIST_CONTENT_TYPE = ContentResolver.CURSOR_DIR_BASE_TYPE + "vnd." + AUTHORITY;
  public static final String SINGLE_CONTENT_TYPE = ContentResolver.CURSOR_ITEM_BASE_TYPE + "vnd." + AUTHORITY;

  public static final class Tweet {
    public static final String TABLE_NAME = "tweet";
    public static final Uri CONTENT_URI = Uri.withAppendedPath(DatabaseContract.CONTENT_URI, TABLE_NAME);

    public static final String TWEET_ID = "_id";
    public static final String SERVER_ID = "_server_id";
    public static final String TEXT = "text";
    public static final String RETWEET_COUNT = "retweet_count";
    public static final String FAVORITE_COUNT = "favorite_count";
    public static final String USER_ID = "user_id";
  }

  public static final class User {
    public static final String TABLE_NAME = "user";
    public static final Uri CONTENT_URI = Uri.withAppendedPath(DatabaseContract.CONTENT_URI, TABLE_NAME);

    public static final String USER_ID = "user_id";
    public static final String SERVER_ID = "server_id";
    public static final String SCREEN_NAME = "screen_name";
    public static final String PHOTO_URL = "photo_url";
  }

}

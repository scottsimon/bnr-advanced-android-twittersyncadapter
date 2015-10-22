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

import android.database.Cursor;
import android.database.CursorWrapper;
import com.bignerdranch.android.twittersyncadapter.model.Tweet;

/**
 * Created by scotts on 10/22/15.
 */
public class TweetCursorWrapper extends CursorWrapper {

  public TweetCursorWrapper(Cursor cursor) {
    super(cursor);
  }

  public Tweet getTweet() {
    String serverId = getString(getColumnIndex(DatabaseContract.Tweet.SERVER_ID));
    String text = getString(getColumnIndex(DatabaseContract.Tweet.TEXT));
    int favCount = getInt(getColumnIndex(DatabaseContract.Tweet.FAVORITE_COUNT));
    int retweetCount = getInt(getColumnIndex(DatabaseContract.Tweet.RETWEET_COUNT));
    String userId = getString(getColumnIndex(DatabaseContract.Tweet.USER_ID));

    return new Tweet(serverId, text, favCount, retweetCount, userId);
  }

}

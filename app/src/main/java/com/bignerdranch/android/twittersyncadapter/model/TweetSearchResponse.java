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

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * Created by scotts on 10/22/15.
 */
public class TweetSearchResponse {

  @SerializedName("statuses")
  private List<Tweet> mTweetList;

  public List<Tweet> getTweetList() {
    return mTweetList;
  }
}

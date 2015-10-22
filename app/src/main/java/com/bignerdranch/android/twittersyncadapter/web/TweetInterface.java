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
package com.bignerdranch.android.twittersyncadapter.web;

import com.bignerdranch.android.twittersyncadapter.model.TweetSearchResponse;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by scotts on 10/22/15.
 */
public interface TweetInterface {

  @GET("/search/tweets.json")
  TweetSearchResponse searchTweets(@Query("q") String query);

}

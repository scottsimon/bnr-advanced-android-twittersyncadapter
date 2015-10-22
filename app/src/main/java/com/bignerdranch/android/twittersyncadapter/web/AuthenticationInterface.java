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

import retrofit.Callback;
import retrofit.client.Response;
import retrofit.http.Body;
import retrofit.http.Field;
import retrofit.http.FormUrlEncoded;
import retrofit.http.POST;

/**
 * Created by scotts on 10/22/15.
 */
public interface AuthenticationInterface {

  @POST("/oauth/request_token")
  void fetchRequestToken(@Body String body, Callback<Response> callback);

  @FormUrlEncoded
  @POST("/oauth/access_token")
  void fetchAccessToken(@Field("oauth_verifier") String verifier, Callback<Response> callback);

}

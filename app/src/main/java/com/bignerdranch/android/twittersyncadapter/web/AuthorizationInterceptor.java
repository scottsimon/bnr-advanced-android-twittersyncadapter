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

import android.util.Log;
import com.squareup.okhttp.Interceptor;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;

/**
 * Created by scotts on 10/22/15.
 */
public class AuthorizationInterceptor implements Interceptor {

  private static final String TAG = AuthorizationInterceptor.class.getSimpleName();
  private static final String AUTH_HEADER = "Authorization";

  @Override
  public Response intercept(Chain chain) throws IOException {
    Request request = chain.request();
    TwitterOauthHelper oauthHelper = TwitterOauthHelper.get();

    try {
      String authHeaderString = oauthHelper.getAuthorizationHeaderString(request);
      request = request.newBuilder()
          .addHeader(AUTH_HEADER, authHeaderString)
          .build();
    } catch (InvalidKeyException | NoSuchAlgorithmException e) {
      Log.e(TAG, "Failed to get auth header string", e);
    }

    return chain.proceed(request);
  }

}

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
package com.bignerdranch.android.twittersyncadapter.account;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by scotts on 10/22/15.
 */
public class AuthenticatorService extends Service {

  private Authenticator mAuthenticator;

  public AuthenticatorService() {
    mAuthenticator = new Authenticator(this);
  }

  @Nullable
  @Override
  public IBinder onBind(Intent intent) {
    return mAuthenticator.getIBinder();
  }

}

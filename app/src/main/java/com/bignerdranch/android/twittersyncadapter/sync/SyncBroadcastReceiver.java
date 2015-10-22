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
package com.bignerdranch.android.twittersyncadapter.sync;

import android.accounts.Account;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import com.bignerdranch.android.twittersyncadapter.account.Authenticator;
import com.bignerdranch.android.twittersyncadapter.contentprovider.DatabaseContract;
import com.google.android.gms.gcm.GcmReceiver;

/**
 * Created by scotts on 10/22/15.
 */
public class SyncBroadcastReceiver extends GcmReceiver {

  private static final String TAG = SyncBroadcastReceiver.class.getSimpleName();

  @Override
  public void onReceive(Context context, Intent intent) {
    Log.d(TAG, "Received GCM notification, request sync");

    // Kick off a sync
    Account account = new Account(Authenticator.ACCOUNT_NAME, Authenticator.ACCOUNT_TYPE);
    ContentResolver.setIsSyncable(account, DatabaseContract.AUTHORITY, 1);
    ContentResolver.setSyncAutomatically(account, DatabaseContract.AUTHORITY, true);
    ContentResolver.requestSync(account, DatabaseContract.AUTHORITY, Bundle.EMPTY);
  }
}

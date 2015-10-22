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

import android.accounts.*;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import com.bignerdranch.android.twittersyncadapter.controller.AuthenticationActivity;

/**
 * Created by scotts on 10/22/15.
 */
public class Authenticator extends AbstractAccountAuthenticator {

  public static final String ACCOUNT_NAME = "TwitterSyncAdapter";
  public static final String ACCOUNT_TYPE = "com.bignerdranch.android.twittersyncadapter.USER_ACCOUNT";
  public static final String AUTH_TOKEN_TYPE = "com.bignerdranch.android.twittersyncadapter.FULL_ACCESS";

  private Context mContext;

  public Authenticator(Context context) {
    super(context);
    mContext = context;
  }

  @Override
  public Bundle getAuthToken(AccountAuthenticatorResponse response, Account account, String authTokenType,
      Bundle options) throws NetworkErrorException {

    AccountManager accountManager = AccountManager.get(mContext);

    String authToken = accountManager.peekAuthToken(account, authTokenType);

    Bundle result = new Bundle();
    if (TextUtils.isEmpty(authToken)) {
      // show user activity to authenticate with Twitter
      Intent intent = AuthenticationActivity.newIntent(mContext, account.type, authTokenType);
      result.putParcelable(accountManager.KEY_INTENT, intent);
    } else {
      result.putString(accountManager.KEY_ACCOUNT_NAME, account.name);
      result.putString(accountManager.KEY_ACCOUNT_TYPE, account.type);
      result.putString(accountManager.KEY_AUTHTOKEN, authToken);
    }

    return result;
  }

  @Override
  public Bundle addAccount(AccountAuthenticatorResponse response, String accountType, String authTokenType,
      String[] requiredFeatures, Bundle options) throws NetworkErrorException {
    Intent intent = AuthenticationActivity.newIntent(mContext, accountType, authTokenType);
    Bundle bundle = new Bundle();
    bundle.putParcelable(AccountManager.KEY_INTENT, intent);
    return bundle;
  }

  @Override
  public Bundle editProperties(AccountAuthenticatorResponse response, String accountType) {
    return null;
  }

  @Override
  public Bundle confirmCredentials(AccountAuthenticatorResponse response, Account account, Bundle options)
      throws NetworkErrorException {
    return null;
  }

  @Override
  public String getAuthTokenLabel(String authTokenType) {
    return null;
  }

  @Override
  public Bundle updateCredentials(AccountAuthenticatorResponse response, Account account, String authTokenType,
      Bundle options) throws NetworkErrorException {
    return null;
  }

  @Override
  public Bundle hasFeatures(AccountAuthenticatorResponse response, Account account, String[] features)
      throws NetworkErrorException {
    return null;
  }
}

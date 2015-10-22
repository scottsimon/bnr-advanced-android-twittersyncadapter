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
import android.accounts.AccountManager;
import android.content.AbstractThreadedSyncAdapter;
import android.content.ContentProviderClient;
import android.content.Context;
import android.content.SyncResult;
import android.os.Bundle;
import android.util.Log;
import com.bignerdranch.android.twittersyncadapter.account.Authenticator;
import com.bignerdranch.android.twittersyncadapter.contentprovider.DatabaseContract;
import com.bignerdranch.android.twittersyncadapter.controller.AuthenticationActivity;
import com.bignerdranch.android.twittersyncadapter.model.Tweet;
import com.bignerdranch.android.twittersyncadapter.model.TweetSearchResponse;
import com.bignerdranch.android.twittersyncadapter.model.User;
import com.bignerdranch.android.twittersyncadapter.web.AuthorizationInterceptor;
import com.bignerdranch.android.twittersyncadapter.web.TweetInterface;
import com.squareup.okhttp.OkHttpClient;
import retrofit.RestAdapter;
import retrofit.client.OkClient;

import java.util.List;

/**
 * Created by scotts on 10/22/15.
 */
public class SyncAdapter extends AbstractThreadedSyncAdapter {

  private static final String TAG = SyncAdapter.class.getSimpleName();
  private static final String TWITTER_ENDPOINT = "https://api.twitter.com/1.1";
  private static final String QUERY = "android";

  private String mAccessToken;
  private String mAccessTokenSecret;

  public SyncAdapter(Context context, boolean autoInitialize) {
    super(context, autoInitialize);

    AccountManager accountManager = AccountManager.get(context);
    Account account = new Account(Authenticator.ACCOUNT_NAME, Authenticator.ACCOUNT_TYPE);
    mAccessTokenSecret = accountManager.getUserData(account, AuthenticationActivity.OAUTH_TOKEN_SECRET_KEY);
    mAccessToken = accountManager.peekAuthToken(account, Authenticator.AUTH_TOKEN_TYPE);
  }

  @Override
  public void onPerformSync(Account account, Bundle extras, String authority, ContentProviderClient provider,
      SyncResult syncResult) {
    Log.d(TAG, "onPerformSync()");
    List<Tweet> tweets = fetchTweets();
    insertTweetData(tweets);
  }

  //region Private methods

  private List<Tweet> fetchTweets() {
    OkHttpClient client = new OkHttpClient();
    client.interceptors().add(new AuthorizationInterceptor());

    RestAdapter restAdapter = new RestAdapter.Builder()
        .setEndpoint(TWITTER_ENDPOINT)
        .setClient(new OkClient(client))
        .setLogLevel(RestAdapter.LogLevel.FULL)
        .build();

    TweetInterface tweetInterface = restAdapter.create(TweetInterface.class);
    TweetSearchResponse response = tweetInterface.searchTweets(QUERY);
    return response.getTweetList();
  }

  private void insertTweetData(List<Tweet> tweets) {
    User user;
    for (Tweet tweet : tweets) {
      user = tweet.getUser();
      getContext().getContentResolver().insert(DatabaseContract.User.CONTENT_URI, user.getContentValues());
      getContext().getContentResolver().insert(DatabaseContract.Tweet.CONTENT_URI, tweet.getContentValues());
    }
  }

  //endregion Private methods
}

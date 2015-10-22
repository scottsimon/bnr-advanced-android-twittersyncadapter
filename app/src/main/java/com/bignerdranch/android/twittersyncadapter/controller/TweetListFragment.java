package com.bignerdranch.android.twittersyncadapter.controller;

import android.accounts.*;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import com.bignerdranch.android.twittersyncadapter.R;
import com.bignerdranch.android.twittersyncadapter.account.Authenticator;

import java.io.IOException;

/**
 * A placeholder fragment containing a simple view.
 */
public class TweetListFragment extends Fragment {

  private static final String TAG = TweetListFragment.class.getSimpleName();

  private String mAccessToken;
  private Account mAccount;
  private TextView mAuthTokenTextView;

  public TweetListFragment() {
  }

  @Override
  public void onStart() {
    super.onStart();
    fetchAccessToken();
  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View view = inflater.inflate(R.layout.fragment_tweet_list, container, false);
    mAuthTokenTextView = (TextView) view.findViewById(R.id.fragment_tweet_list_auth_token_text_view);
    return view;
  }

  private void fetchAccessToken() {
    final AccountManager accountManager = AccountManager.get(getActivity());
    mAccount = new Account(Authenticator.ACCOUNT_NAME, Authenticator.ACCOUNT_TYPE);
    accountManager.getAuthToken(mAccount, Authenticator.AUTH_TOKEN_TYPE, null, getActivity(),
        new AccountManagerCallback<Bundle>() {
          @Override
          public void run(AccountManagerFuture<Bundle> future) {
            try {
              Bundle bundle = future.getResult();
              mAccessToken = bundle.getString(AccountManager.KEY_AUTHTOKEN);
              mAuthTokenTextView.setText("Have access token: " + mAccessToken);
            } catch (AuthenticatorException |
                OperationCanceledException |
                IOException e) {
              Log.e(TAG, "Got an exception", e);
            }
          }
        }, null);
  }


}

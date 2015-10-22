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
import com.bignerdranch.android.twittersyncadapter.model.User;

/**
 * Created by scotts on 10/22/15.
 */
public class UserCursorWrapper extends CursorWrapper {

  public UserCursorWrapper(Cursor cursor) {
    super(cursor);
  }

  public User getUser() {
    String serverId = getString(getColumnIndex(DatabaseContract.User.SERVER_ID));
    String screenName = getString(getColumnIndex(DatabaseContract.User.SCREEN_NAME));
    String photoUrl = getString(getColumnIndex(DatabaseContract.User.PHOTO_URL));

    return new User(serverId, screenName, photoUrl);
  }

}

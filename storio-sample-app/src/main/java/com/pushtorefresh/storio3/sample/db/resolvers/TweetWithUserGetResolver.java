package com.pushtorefresh.storio3.sample.db.resolvers;


import android.database.Cursor;
import android.support.annotation.NonNull;

import com.pushtorefresh.storio3.sample.db.entities.Tweet;
import com.pushtorefresh.storio3.sample.db.entities.TweetWithUser;
import com.pushtorefresh.storio3.sample.db.entities.User;
import com.pushtorefresh.storio3.sample.sample_code.Relations;
import com.pushtorefresh.storio3.sqlite.StorIOSQLite;
import com.pushtorefresh.storio3.sqlite.operations.get.DefaultGetResolver;

public class TweetWithUserGetResolver extends DefaultGetResolver<TweetWithUser> {

    // We expect that cursor will contain both Tweet and User: SQL JOIN
    @NonNull
    @Override
    public TweetWithUser mapFromCursor(@NonNull StorIOSQLite storIOSQLite, @NonNull Cursor cursor) {
        final Tweet tweet = Tweet.newTweet(
                cursor.getLong(cursor.getColumnIndexOrThrow(Relations.QUERY_COLUMN_TWEET_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Relations.QUERY_COLUMN_TWEET_AUTHOR)),
                cursor.getString(cursor.getColumnIndexOrThrow(Relations.QUERY_COLUMN_TWEET_CONTENT))
        );

        final User user = User.newUser(
                cursor.getLong(cursor.getColumnIndexOrThrow(Relations.QUERY_COLUMN_USER_ID)),
                cursor.getString(cursor.getColumnIndexOrThrow(Relations.QUERY_COLUMN_USER_NICK))
        );

        return new TweetWithUser(tweet, user);
    }
}

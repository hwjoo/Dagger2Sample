package com.hwjoo.dagger2sample.data;

import android.content.Context;
import android.content.res.Resources;

import com.hwjoo.dagger2sample.data.model.User;
import com.hwjoo.dagger2sample.di.ApplicationContext;

import javax.inject.Inject;
import javax.inject.Singleton;

/**
 * Created by hwjoo on 2017-02-02.
 */

@Singleton
public class DataManager {
    private Context mContext;
    private DbHelper mDbHelper;
    private SharedPrefsHelper mSharedPrefsHelper;

    @Inject
    public DataManager(@ApplicationContext Context context,
                       DbHelper dbHelper,
                       SharedPrefsHelper sharedPrefsHelper) {
        this.mContext = context;
        this.mDbHelper = dbHelper;
        this.mSharedPrefsHelper = sharedPrefsHelper;
    }
    public String getAccessToken(){
        return null;
    }
    public Long createUser(User user) throws Exception {
        return null;
    }
    public User getUser(Long userId) throws Resources.NotFoundException, NullPointerException {
        return null;
    }
}

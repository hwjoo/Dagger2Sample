package com.hwjoo.dagger2sample;

import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.hwjoo.dagger2sample.data.DataManager;
import com.hwjoo.dagger2sample.data.model.User;
import com.hwjoo.dagger2sample.di.component.ActivityComponent;
import com.hwjoo.dagger2sample.di.component.DaggerActivityComponent;
import com.hwjoo.dagger2sample.di.module.ActivityModule;

import javax.inject.Inject;

import butterknife.BindView;

public class MainActivity extends AppCompatActivity {
    private ActivityComponent activityComponent;

    @Inject DataManager mDataManager;
    @BindView(R.id.tv_user_info) TextView mTvUserInfo;
    @BindView(R.id.tv_access_token) TextView mTvAccessToken;
    public ActivityComponent getActivityComponent(){
        if(activityComponent == null){
            activityComponent = DaggerActivityComponent.builder()
                    .activityModule(new ActivityModule(this))
                    .applicationComponent(DemoApplication.get(this).getComponent())
                    .build();
        }
        return activityComponent;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        getActivityComponent().inject(this);
    }
    @Override
    protected void onPostCreate(@Nullable Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        createUser();
        getUser();
        mDataManager.saveAccessToken("ASDR12443JFDJF43543J543H3K543");

        String token = mDataManager.getAccessToken();
        if(token != null){
            mTvAccessToken.setText(token);
        }
    }
    private void createUser(){
        try {
            mDataManager.createUser(new User("Ali", "1367, Gurgaon, Haryana, India"));
        }catch (Exception e){e.printStackTrace();}
    }

    private void getUser(){
        try {
            User user = mDataManager.getUser(1L);
            mTvUserInfo.setText(user.toString());
        }catch (Exception e){e.printStackTrace();}
    }
}

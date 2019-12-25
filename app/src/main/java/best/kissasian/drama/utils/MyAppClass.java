package best.kissasian.drama.utils;

import android.app.Application;
import android.content.Context;
import android.content.SharedPreferences;

import com.facebook.ads.AudienceNetworkAds;
import com.google.android.gms.ads.AdRequest;
import com.onesignal.OneSignal;

public class MyAppClass extends Application {

    private static Context mContext;

    @Override
    public void onCreate() {
        super.onCreate();
        AudienceNetworkAds.initialize(this);


        mContext=this;


        // OneSignal Initialization
        OneSignal.startInit(this)
                .inFocusDisplaying(OneSignal.OSInFocusDisplayOption.Notification)
                .unsubscribeWhenNotificationsAreDisabled(true)
                .init();


        SharedPreferences preferences=getSharedPreferences("push",MODE_PRIVATE);
        if (preferences.getBoolean("status",true)){
            OneSignal.setSubscription(true);
        }else {
            OneSignal.setSubscription(false);
        }


    }

    public static Context getContext(){
        return mContext;
    }
}

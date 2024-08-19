package com.ortto.demoapp;

import android.app.Application;

import com.ortto.messaging.Ortto;
import com.ortto.messaging.OrttoConfig;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        OrttoConfig config = new OrttoConfig(
                getString(R.string.ortto_datasource_id),
                getString(R.string.ortto_api_endpoint),
                false,
                true
        );
        Ortto.instance().init(config, this);

        Ortto.instance().dispatchPushRequest();
    }
}

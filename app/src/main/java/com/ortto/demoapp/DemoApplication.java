package com.ortto.demoapp;

import android.app.Application;

import com.ortto.messaging.Ortto;
import com.ortto.messaging.OrttoConfig;
import com.ortto.messaging.identity.UserID;

public class DemoApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();

        // Initialize Ortto
        OrttoConfig config = new OrttoConfig(
            getString(R.string.ortto_datasource_id),
            getString(R.string.ortto_api_endpoint),
            false,
            true
        );
        Ortto.instance().init(config, this);


        // Identify the user
        UserID userID = UserID.make()
            .setName("John", "Doe")
            .setEmail("john@example.com")
            .setExternalId("abc123");
        Ortto.instance().identify(userID);

        // Dispatch push permission request
        Ortto.instance().dispatchPushRequest();
    }
}

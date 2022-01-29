package com.home.simplesysinfoapp.view;

import com.home.simplesysinfoapp.R;
import com.home.simplesysinfoapp.types.CustomActivity;

public class SettingsActivity extends CustomActivity {
    @Override
    public void onBackPressed() {
        moveToMainScene();
    }

    @Override
    protected void initHandlers() {
        findViewById(R.id.settingsTopBackButton).setOnClickListener(v -> {
            showDebugToast("Settings back click");
            moveToMainScene();
        });
    }
}
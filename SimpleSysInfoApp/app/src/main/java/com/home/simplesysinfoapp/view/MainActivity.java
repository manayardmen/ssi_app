package com.home.simplesysinfoapp.view;

import android.view.View;

import com.home.simplesysinfoapp.R;
import com.home.simplesysinfoapp.enums.EScenes;
import com.home.simplesysinfoapp.interfaces.ICustomRunnable;
import com.home.simplesysinfoapp.types.CustomActivity;
import com.home.simplesysinfoapp.utils.DefaultConstants;

public class MainActivity extends CustomActivity {
    @Override
    protected void initHandlers() {
        findViewById(R.id.getInfoButton).setOnClickListener(this::getInfoClickHandler);
        findViewById(R.id.settingsGearLayout).setOnClickListener(this::settingsClickHandler);
        findViewById(R.id.settingsGearButton).setOnClickListener(this::settingsClickHandler);
    }

    @Override
    protected void afterInit() {
        if (DefaultConstants.IS_DEBUG && data.getIsFirstStart()) {
            showToast("Debug flag is active");
        }

        if (data.getIsFirstStart()) {
            // TODO: Do first start job
            threading.runInBackground(() -> runOnUiThread(() -> showDebugToast("First start job is running")));
        }
    }

    private void getInfoClickHandler(View v) {
        showDebugToast("Get info click");
        moveToScene(EScenes.GENERAL_INFO);
    }

    private void settingsClickHandler(View v) {
        showDebugToast("Settings click");
        moveToScene(EScenes.SETTINGS);
    }

    @Override
    public void onBackPressed() {
        this.finishAffinity();
    }
}
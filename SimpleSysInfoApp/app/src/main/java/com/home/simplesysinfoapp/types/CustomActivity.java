package com.home.simplesysinfoapp.types;

import android.os.Bundle;

import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;

import com.home.simplesysinfoapp.data.InstanceData;
import com.home.simplesysinfoapp.enums.EScenes;
import com.home.simplesysinfoapp.interfaces.ICustomRunnable;
import com.home.simplesysinfoapp.utils.CustomLogger;
import com.home.simplesysinfoapp.utils.SceneManager;
import com.home.simplesysinfoapp.utils.Threading;
import com.home.simplesysinfoapp.utils.Toasts;

public class CustomActivity extends AppCompatActivity {
    protected final SceneManager sceneManager = SceneManager.getInstance();
    protected final Toasts toasts = Toasts.getInstance();
    protected final InstanceData data = InstanceData.getInstance();
    protected final CustomLogger logger = CustomLogger.getInstance();
    protected final Threading threading = Threading.getInstance();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        beforeInit();

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null)
            actionBar.hide();
        else
            showErrorToast( "No action bar found!");

        setContentView(data.getSceneId());
        initHandlers();
        afterInit();

        data.resetIsFirstStart();
    }

    protected void beforeInit() {
        /* Before full activity init some actions */
    }

    protected void afterInit() {
        /* After full activity init some actions */
    }

    protected void initHandlers() {
        /* Initialization for controls handlers on screen */
    }

    @Override
    public void onBackPressed() {
        /* Empty back press handler by default */
    }

    protected void moveToMainScene() {
        moveToScene(EScenes.MAIN);
    }

    protected void showDebugToast(String message) {
        toasts.debugMessage(this, message);
    }

    protected void showToast(String message) {
        toasts.makeText(this, message);
    }

    protected void showErrorToast(String message) {
        toasts.errorMessage(this, message);
    }

    protected void moveToScene(EScenes target) {
        sceneManager.moveToScene(this, target);
    }
}

package com.home.simplesysinfoapp.utils;

import android.content.Context;
import android.content.Intent;

import com.home.simplesysinfoapp.R;
import com.home.simplesysinfoapp.data.InstanceData;
import com.home.simplesysinfoapp.enums.EScenes;
import com.home.simplesysinfoapp.view.GeneralInfoActivity;
import com.home.simplesysinfoapp.view.MainActivity;
import com.home.simplesysinfoapp.view.SettingsActivity;

public class SceneManager {
    private static SceneManager instance;

    private final CustomLogger logger = CustomLogger.getInstance();
    private final InstanceData data = InstanceData.getInstance();

    private SceneManager() {
        data.setSceneIndex(EScenes.MAIN);
        data.setSceneId(R.layout.activity_main);
    }

    public static SceneManager getInstance() {
        if (instance == null)
            instance = new SceneManager();

        return instance;
    }

    public void moveToScene(Context c, EScenes sceneIndex) {
        if (c == null) {
            logger.printError("Current context is NULL");
            return;
        }

        switch (sceneIndex) {
            case MAIN: {
                setIndexAndStartScene(c,
                        R.layout.activity_main,
                        EScenes.MAIN,
                        MainActivity.class);
                break;
            }

            case GENERAL_INFO: {
                setIndexAndStartScene(c,
                        R.layout.activity_general_info,
                        EScenes.GENERAL_INFO,
                        GeneralInfoActivity.class);
                break;
            }

            case SETTINGS: {
                setIndexAndStartScene(c,
                        R.layout.activity_settings,
                        EScenes.SETTINGS,
                        SettingsActivity.class);
                break;
            }

            default: {
                logger.printError("Unknown target activity");
            }
        }
    }

    private void setIndexAndStartScene(
            Context c,
            int sceneId,
            EScenes sceneIndex,
            Class<?> activityClass) {
        data.setSceneId(sceneId);
        data.setSceneIndex(sceneIndex);

        Intent target = new Intent(c, activityClass);
        c.startActivity(target);
    }
}

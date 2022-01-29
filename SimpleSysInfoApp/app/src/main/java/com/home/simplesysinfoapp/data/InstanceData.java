package com.home.simplesysinfoapp.data;

import com.home.simplesysinfoapp.enums.EScenes;

public class InstanceData {
    private boolean isFirstStart = true;

    private static InstanceData instance;

    private EScenes currentSceneIndex;
    private int currentSceneId = 0;

    private InstanceData() { }

    public static InstanceData getInstance() {
        if (instance == null)
            instance = new InstanceData();

        return instance;
    }

    public boolean getIsFirstStart() {
        return isFirstStart;
    }

    public void resetIsFirstStart() {
        isFirstStart = false;
    }

    public void setSceneIndex(EScenes index) {
        currentSceneIndex = index;
    }

    public EScenes getSceneIndex() {
        return currentSceneIndex;
    }

    public void setSceneId(int id) {
        currentSceneId = id;
    }

    public int getSceneId() {
        return currentSceneId;
    }
}

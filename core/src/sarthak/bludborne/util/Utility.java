package sarthak.bludborne.util;

import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.TextureLoader;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.maps.tiled.TiledMap;
import com.badlogic.gdx.maps.tiled.TmxMapLoader;

public class Utility {
    public static final AssetManager assetManager = new AssetManager();
    private static final String TAG = Utility.class.getSimpleName();

    private static InternalFileHandleResolver filePathResolver = new InternalFileHandleResolver();

    public static void unloadAsset(String assetPath) {
        if(assetManager.isLoaded(assetPath)) {
            assetManager.unload(assetPath);
        } else {
            Gdx.app.debug(TAG, "Asset not loaded! " + assetPath);
        }
    }

    public static float loadCompleted() {
        return assetManager.getProgress();
    }

    public static boolean isAssetLoaded(String filePath) {
        return assetManager.isLoaded(filePath);
    }

    public static void loadMap(String mapFilePath) {
        if(mapFilePath == null || mapFilePath.isEmpty()) {
            return;
        }

        if(filePathResolver.resolve(mapFilePath).exists()) {
            assetManager.setLoader(TiledMap.class, new TmxMapLoader(filePathResolver));

            assetManager.load(mapFilePath, TiledMap.class);
            assetManager.finishLoadingAsset(mapFilePath);

            Gdx.app.debug(TAG, "MAP LOADED! " + mapFilePath);
        }
        else {
            Gdx.app.debug(TAG,"MAP DOES NOT EXIST! " + mapFilePath);
        }
    }
    public static TiledMap getMap(String mapFilePath) {
        TiledMap map = null;

        if(assetManager.isLoaded(mapFilePath)) {
            map = assetManager.get(mapFilePath,TiledMap.class);
        }
        else{
            Gdx.app.debug(TAG,"MAP IS NOT LOADED! " + mapFilePath);
        }
        return map;
    }

    public static void loadTexture(String textureFilePath) {
        if(textureFilePath == null || textureFilePath.isEmpty()) {
            return;
        }

        if(filePathResolver.resolve(textureFilePath).exists()) {
            assetManager.setLoader(Texture.class, new TextureLoader(filePathResolver));
            assetManager.load(textureFilePath, Texture.class);
            assetManager.finishLoadingAsset(textureFilePath);

            Gdx.app.debug(TAG, "TEXTURE LOADED! " + textureFilePath);
        }
        else{
            Gdx.app.debug(TAG, "TEXTURE DOES NOT EXISTS! " + textureFilePath);
        }
    }

    public static Texture getTexture(String textureFilePath) {
        Texture texture = null;

        if(assetManager.isLoaded(textureFilePath)) {
            texture = assetManager.get(textureFilePath, Texture.class);
        }
        else{
            Gdx.app.debug(TAG,"TEXTURE IS NOT LOADED! " + textureFilePath);
        }
        return texture;
    }
}

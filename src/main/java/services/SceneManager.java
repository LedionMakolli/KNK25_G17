package services;

import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import utils.SceneLocator;

public class SceneManager {
    private static SceneManager sceneManager;
    private Scene scene;
    private LanguageManager languageManager;
    private String currentPath;

    private SceneManager(){
        this.languageManager = LanguageManager.getInstance();
        this.currentPath = SceneLocator.FIRST_PAGE;
        this.scene = this.initScene();
    }

    public static SceneManager getInstance(){
        if(sceneManager == null)
            sceneManager = new SceneManager();
        return sceneManager;
    }

    private Scene initScene(){  //
        try{
            return new Scene(this.getParent(currentPath));
        }catch (Exception e){
            return null;
        }
    }

    public static void load(String path) throws Exception{
        if(sceneManager == null) {
            throw new Exception("Scene manager is not initialized yet!"); //
        }
        sceneManager.loadParent(path); //
    }

    public static void load(String path, Pane pane) throws Exception{
        if(sceneManager == null){
            throw new Exception("Scene manager is not initialized yet!");
        }
        sceneManager.loadParent(path, pane); //
    }


    public static <T> T loadWithController(String path) throws Exception {
        if (sceneManager == null) {
            throw new IllegalStateException("SceneManager is not initialized yet!");
        }

        FXMLLoader loader = new FXMLLoader(
                SceneManager.class.getResource(path),
                sceneManager.languageManager.getResourceBundle()
        );

        try {
            Parent root = loader.load();
            sceneManager.currentPath = path;
            sceneManager.scene.setRoot(root);

            T controller = loader.getController();
            if (controller == null) {
                throw new IllegalStateException("FXML file " + path + " has no controller specified");
            }
            return controller;
        } catch (Exception e) {
            throw new Exception("Failed to load FXML from " + path, e);
        }
    }

    private void loadParent(String path) throws Exception{  // nashta me fshi
        Parent parent = getParent(path);
        this.currentPath = path;
        scene.setRoot(parent);
    }

    private void loadParent(String path, Pane pane) throws Exception { // nashta me fshi
        pane.getChildren().clear();

        Parent parent = getParent(path);
        pane.getChildren().add(parent);
    }

    private Parent getParent(String path) throws Exception{ // me ndrru ne loadParentNode?
        FXMLLoader loader = new FXMLLoader(
                this.getClass().getResource(path)
        );
        loader.setResources(this.languageManager.getResourceBundle());
        return loader.load();
    }

    public static void reload() throws Exception{
        load(sceneManager.currentPath);
    }

    public Scene getScene() {
        return scene;
    }
}
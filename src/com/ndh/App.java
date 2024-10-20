package com.ndh;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

public class App extends Application {

    private static Scene scene;
    private static final String PATH_RESOURCE = "/com/ndh/design/";

    private static ClientHandler clientHandler;

    @Override
    public void start(Stage stage) throws IOException {
        scene = new Scene(loadFXML("Login"));
        stage.setScene(scene);
        stage.show();

        clientHandler = new ClientHandler();
        clientHandler.startClient();

        stage.setOnCloseRequest(event -> {
            clientHandler.closeClient();
            System.exit(0);
        });
    }

    public static void setRoot(String fxml) throws IOException {
        scene.setRoot(loadFXML(fxml));
    }

    private static Parent loadFXML(String fxml) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(App.class.getResource(PATH_RESOURCE + fxml + ".fxml"));
        return fxmlLoader.load();
    }

    public static void main(String[] args) {
        launch(args);
    }
    
    public static ClientHandler getClientHandler() {
        return clientHandler;
    }


}

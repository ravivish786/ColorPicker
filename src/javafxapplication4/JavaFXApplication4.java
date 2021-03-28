/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package javafxapplication4;

import java.io.IOException;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

/**
 *
 * @author VICKY
 */
public class JavaFXApplication4 extends Application {
    
    @Override
    public void start(Stage primaryStage) throws IOException {
      Parent home=FXMLLoader.load(getClass().getResource("/demo/FXML.fxml"));
       // Parent home=FXMLLoader.load(getClass().getResource("/demo/test.fxml"));
      Scene home_scene= new Scene(home);
        
        home_scene.setFill(Color.TRANSPARENT);
         primaryStage.initStyle(StageStyle.TRANSPARENT);
        primaryStage.setScene(home_scene);
          home_scene.setOnMouseClicked((MouseEvent event) -> {
             if (event.getClickCount()==2) {
                 primaryStage.setFullScreen(true);
                 
             }
        });
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

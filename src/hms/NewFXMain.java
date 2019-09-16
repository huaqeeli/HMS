/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hms;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.stage.StageStyle;
import org.pdfsam.ui.RingProgressIndicator;

/**
 *
 * @author Administrator
 */
public class NewFXMain extends Application {
    
    @Override
    public void start(Stage primaryStage) {
        
        RingProgressIndicator ring = new RingProgressIndicator();
        ring.setRingWidth(200);
        ring.makeIndeterminate();
                
        
        StackPane root = new StackPane();
        root.getChildren().add(ring);
        
        Scene scene = new Scene(root, 300, 250);
        
        primaryStage.setTitle("Hello World!");
        primaryStage.setScene(scene);
        primaryStage.initStyle(StageStyle.UNDECORATED);
        primaryStage.show();
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }
    
}

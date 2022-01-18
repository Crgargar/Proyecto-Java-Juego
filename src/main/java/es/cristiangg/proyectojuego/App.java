package es.cristiangg.proyectojuego;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class App extends Application {
    
    double posX=100;
    double posY =100;

    @Override
    public void start(Stage stage) {
        
        Pane root = new Pane();
        var scene = new Scene(root, 460, 689);
        stage.setScene(scene);
        stage.show();
        
        Rectangle r = new Rectangle();
        r.setWidth(20.5);
        
        Polyline cabeza = new Polyline();
        cabeza.getPoints().addAll(new Double[]{
            50.0, 0.0,
            100.0, 60.0,
            0.0, 60.0 });
        cabeza.setFill(Color.BLACK);
               
        Rectangle cuerpo = new Rectangle ();
        cuerpo.setWidth(30);
        cuerpo.setHeight(40);
        cuerpo.setX(0);
        cuerpo.setY(20);
        
        Group groupPersonaje = new Group();
        groupPersonaje.getChildren().add(cabeza);
        groupPersonaje.getChildren().add(cuerpo);
        root.getChildren().add(groupPersonaje);
        
        groupPersonaje.setLayoutX(posX);
        groupPersonaje.setLayoutY(posY);
    }

    public static void main(String[] args) {
        launch();
    }

}
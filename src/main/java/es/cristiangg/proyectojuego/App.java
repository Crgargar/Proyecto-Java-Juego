package es.cristiangg.proyectojuego;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;


public class App extends Application {
    
    //posiciones de la nave
    double posX=230;
    double posY =500;

    @Override
    public void start(Stage stage) {
        
        //dimensiones de la pantalla
        Pane root = new Pane();
        var scene = new Scene(root, 460, 689);
        stage.setScene(scene);
        stage.show();
        
        //introduccion de la imagen de fondo
        Image img = new Image(getClass().getResourceAsStream("/imagenes/estrellas.jpeg"));
        ImageView imgView = new ImageView(img);
        root.getChildren().add(imgView);

        //pico de la nave
        Polyline cabeza = new Polyline();
        cabeza.getPoints().addAll(new Double[]{
            20.0, 20.0,
            -20.0, 20.0,
            0.0, 0.0 });
        cabeza.setFill(Color.YELLOW);
        
        //ala derecha de la nave
        Polyline derecha = new Polyline();
        derecha.getPoints().addAll(new Double[]{
            20.0, 30.0,
            50.0, 70.0,
            20.0, 70.0 });
        derecha.setFill(Color.BLUE);
        
        //ala izquierda de la nave
        Polyline izquierda = new Polyline();
        izquierda.getPoints().addAll(new Double[]{
            -20.0, 30.0,
            -50.0, 70.0,
            -20.0, 70.0 });
        izquierda.setFill(Color.BLUE);
        
        //cuerpo de la nave
        Rectangle cuerpo = new Rectangle ();
        cuerpo.setWidth(40);
        cuerpo.setHeight(40);
        cuerpo.setX(-20);
        cuerpo.setY(20);
        cuerpo.setFill(Color.GREEN);

        
        //circulo de la ventana de la nave
        Circle circleBall = new Circle (0,40,7);
        circleBall.setFill(Color.BLUE);
        root.getChildren().add(circleBall);
        
        //fuego derecho
        Polyline fuegod = new Polyline();
        fuegod.getPoints().addAll(new Double[]{
            0.0, 60.0,
            20.0, 60.0,
            10.0, 100.0 });
        fuegod.setFill(Color.RED);
        
        //fuego izquierdo
        Polyline fuegoi = new Polyline();
        fuegoi.getPoints().addAll(new Double[]{
            0.0, 60.0,
            -20.0, 60.0,
            -10.0, 100.0 });
        fuegoi.setFill(Color.RED);
        
        //agrupar las partes de la nave
        Group groupPersonaje = new Group();
        groupPersonaje.getChildren().add(cabeza);
        groupPersonaje.getChildren().add(cuerpo);
        groupPersonaje.getChildren().add(derecha);
        groupPersonaje.getChildren().add(izquierda);
        groupPersonaje.getChildren().add(circleBall);
        groupPersonaje.getChildren().add(fuegod);
        groupPersonaje.getChildren().add(fuegoi);
        root.getChildren().add(groupPersonaje);
        
        //desplazar figuras
        groupPersonaje.setLayoutX(posX);
        groupPersonaje.setLayoutY(posY);
    }

    public static void main(String[] args) {
        launch();
    }

}
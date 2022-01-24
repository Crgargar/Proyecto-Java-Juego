package es.cristiangg.proyectojuego;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Polyline;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;
import javafx.util.Duration;


public class App extends Application {
    
    //posiciones de la nave
    double posX=230;
    double posY =500;
    
    //movimiento nave
    int velocidad = 0;
    
    int imagenY= 0;
    int imagen2Y =689;
    
    //dimensiones de pantalla
    final int SCENE_TAM_X = 600;
    final int SCENE_TAM_Y = 400;
    final int STICK_WIDTH = 7;
    final int STICK_HEIGHT = 50;
    
    
    //posicion de las imagenes de fondo
     
    Image img = new Image(getClass().getResourceAsStream("/imagenes/estrellas.jpeg"));
    Image img2 = new Image(getClass().getResourceAsStream("/imagenes/estrellas2.jpeg"));

    @Override
    public void start(Stage stage) {
        
        //dimensiones de la pantalla
        Pane root = new Pane();
        var scene = new Scene(root, 460, 689);
        stage.setScene(scene);
        stage.show();
        
        //introduccion de la imagen de fondo
        ImageView imgView = new ImageView(img);
        root.getChildren().add(imgView);
        
        ImageView imgView2 = new ImageView(img2);
        root.getChildren().add(imgView2);
        
        ///movimiento de la imagen de fondo
          
        Timeline animationespacio = new Timeline(
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
                //System.out.println(desiertoX);
                imgView.setY(imagenY);
                imagenY -= 5;
               
                //System.out.println(desiertoX2);
                imgView2.setY(imagen2Y);
                imagen2Y -= 5;
               
                if (imagenY < -685) {
                imagenY = 680;
                }
               
                if (imagen2Y < -685) {
                imagen2Y = 680;
                }
               
            })
        );
        animationespacio.setCycleCount(Timeline.INDEFINITE);
        animationespacio.play();
        
        
        //////creacion de la nave///////
        
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
        
        //movimiento de la nave///
        //suma de la posicion X y velocidad
        
        posY += velocidad;
            if(posY < 0) {
                posY = 0;
            } else {
                if(posY > SCENE_TAM_Y - STICK_HEIGHT) {
                    posY = SCENE_TAM_Y - STICK_HEIGHT;
                }
            }
        
        
        
        ///
        scene.setOnKeyPressed((KeyEvent event) -> {
        switch(event.getCode()) {    
            case LEFT:
                posX -= velocidad;
                groupPersonaje.setLayoutX(posX);
                break;
            case RIGHT:
                posX += velocidad;
                groupPersonaje.setLayoutX(posX);
                break;
        }
        });
 
        //
        
    }

    public static void main(String[] args) {
        launch();
    }

}
package es.cristiangg.proyectojuego;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
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
    double posX=210;
    double posY =500;
    
    //posicion disparo
    double posXdisparo= posX;
    double posYdisparo=490;
    
    //movimiento nave
    int velocidad = 0;
    
    //movimiento marciano
    int marciano1X = 50;
    int marciano2X = 100;   
    int marciano3X = 150;
    int marciano4X = 200;
    
    // rebotes marciano
    int movimientoMarciano1X = 3;
    
    //imagenes de fondo
    int imagenY= 0;
    int imagen2Y = -689;
    
    //dimensiones de pantalla
    final int SCENE_TAM_X = 460;
    final int SCENE_TAM_Y = 689;
    final int STICK_WIDTH = 7;
    final int STICK_HEIGHT = 50;
    
    //velocidad disparo
    int velocidadisparo= 0;
    Rectangle disparo = new Rectangle ();


    
    //posicion de las imagenes de fondo
    Image img = new Image(getClass().getResourceAsStream("/imagenes/estrellas.jpeg"));
    Image img2 = new Image(getClass().getResourceAsStream("/imagenes/estrellas2.jpeg"));
    
    //imagenes de marciano 1
    Image marciano = new Image(getClass().getResourceAsStream("/imagenes/verde.png"));
    ImageView imageView1 = new ImageView(marciano);
    
    //imagen de marciano 2
    Image marciano1 = new Image(getClass().getResourceAsStream("/imagenes/verde.png"));
    ImageView imageView2 = new ImageView(marciano1);
    
    //imagen marciano 3
    Image marciano2 = new Image(getClass().getResourceAsStream("/imagenes/verde.png"));
    ImageView imageView3 = new ImageView(marciano2);
    
    //imagen marciano 4
    Image marciano3 = new Image(getClass().getResourceAsStream("/imagenes/verde.png"));
    ImageView imageView4 = new ImageView(marciano3);
    
    //meteorito
//    Image meteorito1 = new Image(getClass().getResourceAsStream("/imagenes/meteorito.jpg"));
//    ImageView imageView5 = new ImageView(meteorito1);

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
        
        //marciano 1
        Rectangle zona1 = new Rectangle(20, 20);
        Group grupo1 = new Group();
        grupo1.getChildren().addAll(imageView1, zona1);
        root.getChildren().add(grupo1);
        zona1.setVisible(false);
        grupo1.setLayoutY(50);
        imageView1.setScaleY(0.15);
        imageView1.setScaleX(0.15);
        
        //marciano 2
        Rectangle zona2 = new Rectangle(20, 20);
        Group grupo2 = new Group();
        grupo2.getChildren().addAll(imageView2, zona2);
        root.getChildren().add(grupo2);
        zona2.setVisible(false);
        grupo2.setLayoutY(50);
        imageView2.setScaleY(0.15);
        imageView2.setScaleX(0.15);
        
       // marciano 3
        Rectangle zona3 = new Rectangle(20, 20);
        Group grupo3 = new Group();
        grupo3.getChildren().addAll(imageView3, zona3);
        root.getChildren().add(grupo3);
        zona3.setVisible(false);
        grupo3.setLayoutY(50);
        imageView3.setScaleY(0.15);
        imageView3.setScaleX(0.15);
        
        //marciano 4
        Rectangle zona4 = new Rectangle(20, 20);
        Group grupo4 = new Group();
        grupo4.getChildren().addAll(imageView4, zona4);
        root.getChildren().add(grupo4);
        zona4.setVisible(false);
        grupo4.setLayoutY(50);
        imageView4.setScaleY(0.15);
        imageView4.setScaleX(0.15);
    
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
        
        //disparo nave
        disparo.setWidth(5);
        disparo.setHeight(10);
        disparo.setFill(Color.BLUE);
        root.getChildren().add(disparo);

        
//        //meteorito
//        Circle meteorito = new Circle (0,40,7);
//        Group meteorito1 = new Group();
//        meteorito1.getChildren().addAll(imageView4, meteorito);
//        root.getChildren().add(meteorito1);
//        meteorito.setVisible(false);
//        meteorito1.setLayoutY(50);
//        imageView4.setScaleY(0.15);
//        imageView4.setScaleX(0.15);
             
        
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
             
        /// movimiento del teclado
        scene.setOnKeyPressed((KeyEvent event) -> {
        switch(event.getCode()) {    
            case LEFT:
                velocidad = -5;
                break;
            case RIGHT:
                velocidad = 5;
                break;
            case SPACE:
                velocidadisparo -= 5;
        }
        });

        //movimiento de la imagen de fondo
                  
        Timeline animationespacio = new Timeline(
                
            new KeyFrame(Duration.seconds(0.017), (ActionEvent ae) -> {
//                System.out.println("primera imagen " + imagenY);
                imgView.setY(imagenY);
                imagenY += 5;
               
//                System.out.println("segunda imagen " + imagenY);
                imgView2.setY(imagen2Y);
                imagen2Y += 5;
               
                if (imagenY > 680) {
                imagenY = -675;
                }
               
                if (imagen2Y > 680) {
                imagen2Y = -675;
                }
                
                //desplazar figuras
                groupPersonaje.setLayoutX(posX);
                groupPersonaje.setLayoutY(posY);
                
                //diparo nave
                disparo.setX(posX);
                disparo.setY(posYdisparo);

        
                //suma de la posicion X y velocidad de la nave
                posX += velocidad;
                    if(posX < 50) {        
                        posX = 50;
                    } else {
                        if(posX > SCENE_TAM_X - STICK_HEIGHT) {
                            posX = SCENE_TAM_X - STICK_HEIGHT;
                        }
                        
                //velocidad disparo de la nave
                posYdisparo -= velocidadisparo;
                    if(velocidadisparo < 0) {
                        velocidadisparo = 10;
                        disparo.setLayoutY(velocidadisparo);
//                    } else {
//                        if(posYdisparo > SCENE_TAM_Y - STICK_HEIGHT) {
//                            posYdisparo = SCENE_TAM_Y - STICK_HEIGHT;
//                        } 
                    }
                    }
                   
            //movimiento marciano1
            grupo1.setLayoutX(marciano1X);
            marciano1X += movimientoMarciano1X;
            if(marciano4X >= 300) {
                movimientoMarciano1X = -3;
            }
            if(marciano1X <= -120) {
                movimientoMarciano1X = 3;
            }
            
//            marciano 2
            grupo2.setLayoutX(marciano2X);
            marciano2X += movimientoMarciano1X;
        
//            marciano 3
            grupo3.setLayoutX(marciano3X);
            marciano3X += movimientoMarciano1X;
                System.out.println(velocidadisparo);

//            marciano 4
            grupo4.setLayoutX(marciano4X);
            marciano4X += movimientoMarciano1X;
            
            //volver disparo de la nave
            if (posYdisparo < 5){
                disparo.setLayoutY(490);
                velocidadisparo = 0;
            }
            })
       
        );

        animationespacio.setCycleCount(Timeline.INDEFINITE);
        animationespacio.play();
    }
    
    public static void main(String[] args) {
        launch();
    }

}
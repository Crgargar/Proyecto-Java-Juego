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
import javafx.scene.shape.Shape;
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
    final int SCENE_TAM_X = 460;
    final int SCENE_TAM_Y = 689;
    final int STICK_WIDTH = 7;
    final int STICK_HEIGHT = 50;
    
    
    //posicion de las imagenes de fondo
    Image img = new Image(getClass().getResourceAsStream("/imagenes/estrellas.jpeg"));
    Image img2 = new Image(getClass().getResourceAsStream("/imagenes/estrellas2.jpeg"));
    
    //imagenes de marciano lila
    Image marciano = new Image(getClass().getResourceAsStream("/imagenes/marcianolila.jpg"));
    ImageView imageView1 = new ImageView();
    
    // imagen de marciano rojo
    Image marciano1 = new Image(getClass().getResourceAsStream("/imagenes/marcianorojo.jpg"));
    ImageView imageView2 = new ImageView();
    
    // imagen marciano verde
    Image marciano2 = new Image(getClass().getResourceAsStream("/imagenes/marcianoverde.jpg"));
    ImageView imageView3 = new ImageView();
    
//    // imagen marciano verde claro
    Image marciano3 = new Image(getClass().getResourceAsStream("/imagenes/marcianoverdeclaro.png"));
    ImageView imageView4 = new ImageView();

    @Override  
    public void start(Stage stage) {
                               
        //dimensiones de la pantalla
        Pane root = new Pane();
        var scene = new Scene(root, 460, 689);
        stage.setScene(scene);
        stage.show();
      
       
//        // Ejemplo de asignar una posición aleatoria 1
//        Random random = new Random();
//        int posX = random.nextInt(640);
//        zona1.setLayoutX(posX);
//        int posY = random.nextInt(480);
//        zona1.setLayoutY(posY);
 
        // Parte del código para detectar la colisión de los rectángulos
        //Shape zonaColision = Shape.intersect(zona1, zona2, zona3, zona4);
        
        
        //introduccion de la imagen de fondo
        ImageView imgView = new ImageView(img);
        //root.getChildren().add(imgView);
        
        ImageView imgView2 = new ImageView(img2);
        //root.getChildren().add(imgView2);
        
         //marciano lila
        Rectangle zona1 = new Rectangle(20, 20);
        Group grupo1 = new Group();
        grupo1.getChildren().addAll(imageView1, zona1);
        root.getChildren().add(imgView);
        zona1.setVisible(false);
        grupo1.setLayoutX(100);
        grupo1.setLayoutY(100);


        // marciano rojo
        Rectangle zona2 = new Rectangle(20, 20);
        Group grupo2 = new Group();
        grupo2.getChildren().addAll(imageView2, zona2);
        root.getChildren().add(imageView2);
        zona2.setVisible(false);
        grupo2.setLayoutX(130);
        grupo2.setLayoutY(130);
        
        // marciano verde
        Rectangle zona3 = new Rectangle(20, 20);
        Group grupo3 = new Group();
        grupo3.getChildren().addAll(imageView3, zona3);
        root.getChildren().add(imageView3);
        zona3.setVisible(false);
        grupo3.setLayoutX(170);
        grupo3.setLayoutY(170);
        
//        //marciano verde claro
        Rectangle zona4 = new Rectangle(20, 20);
        Group grupo4 = new Group();
        grupo4.getChildren().addAll(imageView4, zona4);
        root.getChildren().add(grupo4);
        //zona4.setVisible(false);
        grupo4.setLayoutX(200);
        grupo4.setLayoutY(200);
//        

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
             
        /// movimiento del teclado
        scene.setOnKeyPressed((KeyEvent event) -> {
        switch(event.getCode()) {    
            case LEFT:
                velocidad = -5;
                break;
            case RIGHT:
                velocidad = 5;
                break;
        }
        });

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
                //desplazar figuras
                groupPersonaje.setLayoutX(posX);
                groupPersonaje.setLayoutY(posY);
        
                //suma de la posicion X y velocidad de la nave
        
                posX += velocidad;
                    if(posX < 0) {
                        posX = 0;
                    } else {
                        if(posX > SCENE_TAM_X - STICK_HEIGHT) {
                            posX = SCENE_TAM_X - STICK_HEIGHT;
                        }
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
import javafx.application.Application;


import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import javafx.application.Platform;

import javafx.scene.input.KeyEvent;
import javafx.scene.input.KeyCode;
import javafx.event.EventHandler;
import javafx.event.ActionEvent;

import javafx.scene.image.*;

import javafx.scene.text.*;

import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;

import javafx.collections.ObservableList;
import javafx.collections.FXCollections;
import javafx.scene.control.ComboBox;

public class Presentor extends Application {

    public Slide currentSlide;
    public Pane pane;

    public static void main(String[] args) { launch(args); }

    @Override
    public void start(Stage primaryStage) {
        
        primaryStage.setTitle("Lecture Quest Alpha");
        primaryStage.getIcons().add(new Image("file:../resources/4learning_icon_32.png"));

        pane = new Pane();
        // Slide s1 = new Slide("1");
        // Slide s2 = new Slide("2");

        // currentSlide = s1;
        
        Scene scene = new Scene(pane, 300, 200);

        // scene.setOnKeyPressed((keyEvent) -> {
        //     switch(keyEvent.getCode()) {
        //         case ESCAPE:
        //             System.out.println("Esc pressed");
        //             stop();
        //         break;
        //         case RIGHT:
        //             System.out.println("Right pressed");
        //             setSlide(s2);
        //         break;
        //         case LEFT:
        //             System.out.println("Left pressed");
        //             setSlide(s1);
        //         break;
        //     }
        // });

        // pane.getChildren().add(s1.text);


        // // Create a simple combo box to display the available slides
        // ObservableList<String> options = FXCollections.observableArrayList(s1.ID, s2.ID);

        // ComboBox comboBox = new ComboBox<String>(options);
        // comboBox.setLayoutX(100);
        // comboBox.setOnAction((event) -> {
        //     String selectedStiring = comboBox.getSelectionModel().getSelectedItem().toString();
        //     if(selectedStiring == "1") {
        //         setSlide(s1);
        //     }
        //     else if(selectedStiring == "2") {
        //         setSlide(s2);
        //     }
        //     System.out.println(selectedStiring);
        // });

        // pane.getChildren().add(comboBox);





        /*
        // Display text
        Text t = new Text("Test");
        t.setFont(new Font(20));

        // Display an image
        Image image = new Image("file:../resources/sampleImg.jpg");
        ImageView imageView = new ImageView(image);
        // Play some audio
        // This approach also doesnt work with mp3
        Media sound = new Media(new File("../resources/sampleAudio.wav").toURI().toString());
        MediaPlayer player = new MediaPlayer(sound);
        player.play();

        Button btn1 = new Button();
        btn1.setText("This is Slide 1");
        
        slide.getChildren().add(imageView);
        slide.getChildren().add(btn1);
        slide.getChildren().add(t);
        */

        // stackPane.getChildren().add(s1.text);
        // stackPane.getChildren().add(s2.text);

        primaryStage.setScene(scene);
        //scene1.getStylesheets().add("ButtonTest.css");        
        primaryStage.show();
        
        // Display the current slide
        // In this simple case that just means displaying the text
        
    }

    @Override
    public void stop() {
        System.out.println("Stopping");
        Platform.exit();
    }

    // public void setSlide(Slide nextSlide) {
    //     if(currentSlide != null) {
    //         pane.getChildren().remove(currentSlide.text);
    //     }

    //     currentSlide = nextSlide;
    //     pane.getChildren().add(currentSlide.text);
    // }

}
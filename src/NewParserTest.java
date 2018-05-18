// import static org.junit.Assert.*;

// import java.util.List;
// import org.junit.Before;
// import org.junit.Test;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.stage.Stage;

public class NewParserTest extends Application{

    public Colors programDefaultColor;// = new Colors("#000000", "#000000");
    public TextStyle programDefaultStyle;// = new TextStyle("Arial", 20, false, false, false);
    public Defaults programDefault;// = new Defaults(programDefaultStyle, programDefaultColor);

//    XMLParserNew xmlReader;
    Presentation presentation;

    //@Before
    public void newParserTest(){
        System.out.println("Starting to build XML Parser.");

        programDefaultColor = new Colors("#000000", "#000000");
        programDefaultStyle = new TextStyle("Arial", 20, false, false, false);
        programDefault = new Defaults(programDefaultStyle, programDefaultColor);

        // NOTE (chris): Not loading the resource in the correct way currently
			XMLParserNew xmlReader = new XMLParserNew("../resources/NewXML.xml", programDefault);
			presentation = xmlReader.getPresentation();
        System.out.println("Finished building XML Parser.");
    }

    public static void main(String[] args){	launch(args); }

    @Override
    public void start(Stage PrimaryStage) {

    newParserTest();






        System.out.println("--------------------");

        stop();

    }

    @Override
    public void stop() {
        Platform.exit();
    }


}
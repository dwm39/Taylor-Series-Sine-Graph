
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class FinalGraph extends Application {

    
    static public StringBuilder myData = new StringBuilder();
    // Starting up program and creating new scene
    // Calls upon the Controller for most of the underlying program
    
    @Override
    public void start(Stage stage) throws Exception {
        Parent root = FXMLLoader.load(getClass().getResource("FinalGraph.fxml"));
        Scene scene = new Scene(root);
        stage.setTitle("Hello World");
        stage.setScene(scene);
        stage.show();
    }

    public static void main(String[] args) {
        launch(args);
        

    }
}
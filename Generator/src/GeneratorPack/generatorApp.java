package GeneratorPack;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * Created by Michał Nowak
 */
public class generatorApp extends Application {
    @Override
    public void start(Stage primaryStage) throws Exception {
        FXMLLoader fxmlLoader = new FXMLLoader(generatorApp.class.getResource("generator.fxml"));
        Parent layout = fxmlLoader.load();
        Scene scene = new Scene(layout);
        primaryStage.setScene(scene);
        primaryStage.setTitle("Generator");
        primaryStage.show();
    }
}

package ba.unsa.etf.rs.zadaca3;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import java.util.ArrayList;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        LibraryDAO model = LibraryDAO.getInstance();

        FXMLLoader loader = new FXMLLoader(getClass().getResource("/fxml/mainform.fxml"));
        loader.setController(new MainController(model));
        Parent root = loader.load();
        primaryStage.setTitle("Library");
        primaryStage.setScene(new Scene(root, 600, 500));
        primaryStage.show();
    }


    public static void main(String[] args) {
//        launch(args);
        LibraryDAO dao = LibraryDAO.getInstance().getInstance();
        dao.adduserToDatabase(new User("Test", "Testovic"));
        dao.adduserToDatabase(new User("Test2", "Testovic"));
        dao.adduserToDatabase(new User("Test3", "Testovic"));
        ArrayList<User> users = dao.getUsersFromDatabase();
        for (User user : users) {
            System.out.println(user);
        }
    }
}
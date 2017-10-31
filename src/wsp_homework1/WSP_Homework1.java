package wsp_homework1;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.*;
import javafx.stage.Stage;
import javafx.scene.layout.Priority;

public class WSP_Homework1 extends Application {
    String output;
    @Override
    public void start(Stage primaryStage) {
        output = "- START -\n";
        primaryStage.setTitle("Window");
        
        GridPane root = new GridPane();
        // Column 1
        ColumnBuild cb1 = new ColumnBuild("Column 1", "1-1", "1-2", "1-3");
        root.add(cb1, 0, 0);
        ColumnBuild cb2 = new ColumnBuild("Column 2", "2-1", "2-2", "2-3");
        root.add(cb2, 1, 0);
        region(root);
        Button submitB = new Button("Submit");
        Button printB = new Button("Print");
        root.add(submitB, 3, 0);
        root.add(printB, 3, 1);
        
        submitB.setOnAction( 
            (event) -> {
                if (cb1.getStatus() || cb2.getStatus()) {
                    if (cb1.getStatus()) {
                        output += cb1.getString();
                    }
                    if (cb2.getStatus()) {
                        output += cb2.getString();
                    }
                    output += "\n";
                }
            }
        );
        
        printB.setOnAction(
            (event) -> System.out.println(output+"- END -   ")
        );
        
        primaryStage.setScene(new Scene(root, 400, 400));
        primaryStage.show();
    }    
    public static void region(GridPane input) {
        Region r = new Region();
        input.add(r, 2, 0);
        input.setHgrow(r, Priority.ALWAYS);
    }
    public static void main(String[] args) {
        launch(args);
    }
}
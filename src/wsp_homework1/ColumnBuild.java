package wsp_homework1;

import javafx.beans.binding.Bindings;
import javafx.scene.control.CheckBox;
import javafx.scene.control.RadioButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.GridPane;

public class ColumnBuild extends GridPane {
    CheckBox cb;
    ToggleGroup tga;
    public ColumnBuild(String one, String two, String three, String four) {
        cb = new CheckBox(one);
        add(cb, 0, 0);
        tga = new ToggleGroup();
        RadioButton rb1 = new RadioButton(two);
        add(rb1, 0, 1);
        rb1.setUserData(two);
        rb1.setToggleGroup(tga);
        RadioButton rb2 = new RadioButton(three);
        add(rb2, 0, 2);
        rb2.setUserData(three);
        rb2.setToggleGroup(tga);
        RadioButton rb3 = new RadioButton(four);
        add(rb3, 0, 3);
        rb3.setUserData(four);
        rb3.setToggleGroup(tga);
        
        cb.setOnAction(
            (event) -> {
                if (tga.getSelectedToggle() == null) {
                    tga.selectToggle(rb1);
                }
            }
        );

        rb1.disableProperty().bind(Bindings.not(cb.selectedProperty()));
        rb2.disableProperty().bind(Bindings.not(cb.selectedProperty()));
        rb3.disableProperty().bind(Bindings.not(cb.selectedProperty()));
    }
    
    public boolean getStatus() {
        return cb.isSelected();
    }
    
    public String getString() {
        return tga.getSelectedToggle().getUserData().toString();
    }
}
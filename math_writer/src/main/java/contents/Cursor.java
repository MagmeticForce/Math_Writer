package contents;

import javafx.scene.image.Image;

public class Cursor {
    //create image object
    Image sprite = new Image(getClass().getResource("sprites/_bigmode_cursor.png").toExternalForm());
    /* Image bigmode_cursor_sprite = new Image ("file:/home/deck/Documents/Scripts/CSI-2300/MATH_WRITER/math_writer/src/main/java/contents/sprites/_bigmode_cursor.png"); */


    /*
    //unused code - aded this code to GUI script instead since it's easier that way
    void move_cursor_based_on_user_input(Scene scene_input, ImageView imageview_input) {
        scene_input.setOnKeyPressed(event -> {
            double modified_x = imageview_input.getLayoutX();
            double modified_y  = imageview_input.getLayoutY(); //must define new variables or else compiler will complain
            if (event.getCode() == KeyCode.RIGHT) {modified_x += 50; imageview_input.setLayoutX(modified_x);}
            else if (event.getCode() == KeyCode.LEFT) {modified_x -= 50;imageview_input.setLayoutX(modified_x);}
            else if (event.getCode() == KeyCode.UP) {modified_y -= 50; imageview_input.setLayoutY(modified_y);}
            else if (event.getCode() == KeyCode.DOWN) {modified_y += 50; imageview_input.setLayoutY(modified_y);}
        });

    }
    */
    
}

package contents;
import java.util.List;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.stage.Stage;
import javafx.scene.input.KeyCode;

public class GUI extends Application {

    private List <Image> symbol_images = new ArrayList<>();
    private List<ImageView> symbol_imageviews = new ArrayList<>();

    @Override 
    public void start(Stage primaryStage) {

        /********************
        OVERVIEW OF CODE SETUP:
         * initialization (creating objects and variables that will be used throughout the script)
         * set onKeyPressed
            * if smallmode is on
                * if regular keyboard mode is on
                    * if shift is being held down
                        * place uppercase letters and symbols
                    * if shift is NOT being held down
                        * place lowercase letters and numbers
                * if regular keyboard mode is off
                    * act based on keyboad inputs (Shift does not matter in this case)
            * if bigmode is on
                * if regular keyboard mode is on
                    * if shift is being held down
                        * place uppercase letters and symbols
                    * if shift is NOT being held down
                        * place lowercase letters and numbers
                * if regular keyboard mode is off
                    * act based on keyboad inputs (Shift does not matter in this case)
         * set the background color and display the scene
        ********************/
        
        /*
        Tip: at the start of each if staement, hover over
        the line number on the left and press the little
        arrow to collapse/hide all of that if statement's
        code. Since some of these if statements are incedibly
        lengthy, doing this will make it much easier to
        navigate around this script.
        This also works for events, so you can do this with the
        setOnKeyPressed event in this script, which can be very
        useful.
        */

        /******************** INITIALIZATION ********************/

        //create necessary object
        Cursor cursor_object = new Cursor();

        //create images and imageviews for cursor and keyboard images
        ImageView cursor_displayer = new ImageView(cursor_object.sprite);
        cursor_displayer.setLayoutX(25);
        cursor_displayer.setLayoutY(225);
        Image keyboard_sprite = new Image (getClass().getResource("sprites/_keyboard.png").toExternalForm());
        ImageView keyboard_displayer = new ImageView (keyboard_sprite);
        keyboard_displayer.setLayoutX(470);
        keyboard_displayer.setLayoutY(20);
        //Make a Pane to hold ImageViews
        Pane pane_object = new Pane(); //must use Pane instead of StackPane or else setLayoutX and setLayoutY will not work
        pane_object.getChildren().add(cursor_displayer); 
        pane_object.getChildren().add(keyboard_displayer);

        Scene scene_object = new Scene(pane_object, 1710, 870); 
        scene_object.setFill(Color.WHITE);

        Label tab_label = new Label ("Tab: switch between Small Mode and Big Mode");
        tab_label.setLayoutX(30); tab_label.setLayoutY(10);
        pane_object.getChildren().add(tab_label);
        Label alt_label = new Label ("Alt: toggle Regular Keyboard  Mode" + "\n" + "(switch between math keyboard and normal keyboard)");
        alt_label.setLayoutX(30); alt_label.setLayoutY(30);
        pane_object.getChildren().add(alt_label);
        Label regular_keyboard_mode_status = new Label ("Regular Keyboard Mode is OFF");
        regular_keyboard_mode_status.setLayoutX(30); regular_keyboard_mode_status.setLayoutY(70);
        pane_object.getChildren().add(regular_keyboard_mode_status);

        pane_object.setStyle("-fx-background-color: WHITE");

        Label debug_label = new Label("j");
        pane_object.getChildren().add(debug_label);
        //Label debug_label2 = new Label ("j");
        //debug_label2.setTranslateX(50);
        //pane_object.getChildren().add(debug_label2);
        //Label debug_label3 = new Label ("j");
        //debug_label3.setTranslateX(100);
        //pane_object.getChildren().add(debug_label3);


        /* 
        instead of creating primitive type variables,
        i created arrays with only one value since
        arrays are reference types, allowing me
        to get and set values regardless of whether i
        am in an event/function or not
        */
        boolean[] regular_keyboard_mode_is_on = {false};
        boolean[] small_mode_is_on = {false};
        int[] small_mode_tile_number = {0};

        /******************** SET ONKEYPRESSED ********************/

        //this entire event runs every time a key is pressed
        scene_object.setOnKeyPressed(event -> {

            if (small_mode_is_on[0]) {  
                if (regular_keyboard_mode_is_on[0]) {
                    if (event.getCode() == KeyCode.ALT) {
                        regular_keyboard_mode_status.setText("Regular Keyboard Mode is OFF");
                        regular_keyboard_mode_is_on[0] = false;
                    }
                    if (event.isShiftDown()) {
                        //debug_label.setText("SHIFT");
                        if (event.getCode() == KeyCode.DIGIT1) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_exclamation.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT2) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_at.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT3) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_hashtag.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT4) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_dollar.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT5) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_percent.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT6) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_carrot.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT7) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_and.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT8) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_asterisk.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT9) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_parenthesis_open.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT0) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_parenthesis_closed.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.MINUS) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_line_horizontal_bottom.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.EQUALS) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_plus.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.Q) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_Q.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.W) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_W.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.E) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_E.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.R) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_R.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.T) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_T.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.Y) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_Y.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.U) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_U.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.I) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_I.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.O) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_O.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.P) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_P.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.OPEN_BRACKET) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_bracket_curly_open.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.CLOSE_BRACKET) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_bracket_curly_closed.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.BACK_SLASH) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_line_vertical_middle.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.QUOTE) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_quote_double.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.SLASH) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_question_mark.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.A) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_A.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.S) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_S.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.D) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_D.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.F) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_F.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.G) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_G.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.H) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_H.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.J) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_J.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.K) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_K.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.L) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_L.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.SEMICOLON) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_colon.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.Z) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_Z.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.X) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_X.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.C) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_C.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.V) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_V.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.B) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_B.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.N) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_N.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.M) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_uppercase_M.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.COMMA) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_less_than.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.PERIOD) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_greater_than.png", cursor_displayer, small_mode_tile_number);
                        }
                    }
                    else { //Shift is NOT being held down
                        //debug_label.setText("None");
                        if (event.getCode() == KeyCode.DIGIT1) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_1.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT2) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_2.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT3) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_3.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT4) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_4.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT5) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_5.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT6) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_6.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT7) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_7.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT8) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_8.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT9) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_9.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.DIGIT0) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_0.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.MINUS) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_minus.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.EQUALS) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_equals.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.Q) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_q.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.W) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_w.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.E) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_e.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.R) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_r.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.T) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_t.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.Y) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_y.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.U) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_u.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.I) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_i.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.O) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_o.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.P) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_p.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.QUOTE) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_quote_single.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.SLASH) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_slash_forward.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.OPEN_BRACKET) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_bracket_square_open.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.CLOSE_BRACKET) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_bracket_square_closed.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.BACK_SLASH) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_slash_backward.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.A) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_a.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.S) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_s.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.D) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_d.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.F) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_f.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.G) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_g.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.H) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_h.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.J) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_j.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.K) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_k.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.L) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_l.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.SEMICOLON) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_semicolon.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.Z) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_z.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.X) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_x.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.C) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_c.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.V) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_v.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.B) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_b.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.N) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_n.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.M) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_m.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.COMMA) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_comma.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.PERIOD) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_decimal.png", cursor_displayer, small_mode_tile_number);
                        }
                        else if (event.getCode() == KeyCode.SPACE) {
                            cursor_displayer.setLayoutX(cursor_displayer.getLayoutX() + 25);
                            if (small_mode_tile_number[0] == 1) {small_mode_tile_number[0] = 2;}
                            else if (small_mode_tile_number[0] == 2) {small_mode_tile_number[0] = 1;}
                            else if (small_mode_tile_number[0] == 3) {small_mode_tile_number[0] = 4;}
                            else if (small_mode_tile_number[0] == 4) {small_mode_tile_number[0] = 3;}
                        }
                        else if (event.getCode() == KeyCode.BACK_SPACE) {
                            create_symbol_smallmode (pane_object, "sprites/smallmode_empty.png", cursor_displayer, small_mode_tile_number); 
                            cursor_displayer.setLayoutX(cursor_displayer.getLayoutX() - 50);
                        }
                    }
                }
                else { //regular keyboard mode is OFF (so math mode basically)
                    if (event.getCode() == KeyCode.ALT) {
                        regular_keyboard_mode_status.setText("Regular Keyboard Mode is ON");
                        regular_keyboard_mode_is_on[0] = true;
                    }
                    if (event.getCode() == KeyCode.DIGIT1) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_1.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.DIGIT2) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_2.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.DIGIT3) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_3.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.DIGIT4) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_4.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.DIGIT5) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_5.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.DIGIT6) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_6.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.DIGIT7) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_7.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.DIGIT8) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_8.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.DIGIT9) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_9.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.DIGIT0) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_0.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.Q) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_plus.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.W) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_minus.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.E) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_asterisk.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.R) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_slash_forward.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.T) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_equals.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.Y) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_y.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.U) {
                        Image smallmode_square_root_corner_sprite = new Image (getClass().getResource("sprites/smallmode_square_root_corner.png").toExternalForm());
                        ImageView smallmode_square_root_corner_displayer = new ImageView (smallmode_square_root_corner_sprite);
                        smallmode_square_root_corner_displayer.setLayoutX(cursor_displayer.getLayoutX() + 12.5);
                        smallmode_square_root_corner_displayer.setLayoutY(cursor_displayer.getLayoutY() - 12.5);
                        pane_object.getChildren().add(smallmode_square_root_corner_displayer);
                        symbol_images.add(smallmode_square_root_corner_sprite);
                        symbol_imageviews.add(smallmode_square_root_corner_displayer);
                        Image smallmode_line_horizontal_bottom_sprite = new Image (getClass().getResource("sprites/smallmode_line_horizontal_bottom.png").toExternalForm());
                        ImageView smallmode_line_horizontal_bottom_displayer = new ImageView (smallmode_line_horizontal_bottom_sprite);
                        smallmode_line_horizontal_bottom_displayer.setLayoutX(cursor_displayer.getLayoutX() + 37);
                        smallmode_line_horizontal_bottom_displayer.setLayoutY(cursor_displayer.getLayoutY() - 12.5);
                        pane_object.getChildren().add(smallmode_line_horizontal_bottom_displayer);
                        symbol_images.add(smallmode_line_horizontal_bottom_sprite);
                        symbol_imageviews.add(smallmode_line_horizontal_bottom_displayer);
                        create_symbol_smallmode (pane_object, "sprites/smallmode_square_root.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.O) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_square_root_corner.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.I) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_square_root.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.P) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_pi.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.OPEN_BRACKET) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_parenthesis_open.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.CLOSE_BRACKET) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_parenthesis_closed.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.A) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_line_horizontal_bottom.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.S) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_line_horizontal_middle.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.D) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_line_horizontal_top.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.F) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_arrow.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.G) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_equals_not.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.H) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_greater_than.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.J) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_greater_than_or_equals.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.K) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_less_than.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.L) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_less_than_or_equals.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.X) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_lowercase_x.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.C) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_line_vertical_left.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.V) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_line_vertical_middle.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.B) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_line_vertical_right.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.N) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_infinity.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.M) {
                        cursor_displayer.setLayoutY(cursor_displayer.getLayoutY() - 25);
                        create_symbol_smallmode (pane_object, "sprites/smallmode_integral.png", cursor_displayer, small_mode_tile_number);
                        cursor_displayer.setLayoutY(cursor_displayer.getLayoutY() + 25);
                    }
                    else if (event.getCode() == KeyCode.COMMA) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_comma.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.PERIOD) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_decimal.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.Z) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_percent.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.SEMICOLON) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_summation.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.BACK_QUOTE) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_theta.png", cursor_displayer, small_mode_tile_number);
                    }
                    else if (event.getCode() == KeyCode.BACK_SPACE) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_empty.png", cursor_displayer, small_mode_tile_number);  
                        cursor_displayer.setLayoutX(cursor_displayer.getLayoutX() - 50);
                    }
                    else if (event.getCode() == KeyCode.SLASH) {
                        create_symbol_smallmode (pane_object, "sprites/smallmode_cancel.png", cursor_displayer, small_mode_tile_number);
                        cursor_displayer.setLayoutY(cursor_displayer.getLayoutY() - 25);
                        if (small_mode_tile_number[0] == 1) {small_mode_tile_number[0] = 3;}
                        else if (small_mode_tile_number[0] == 2) {small_mode_tile_number[0] = 4;}
                        else if (small_mode_tile_number[0] == 3) {small_mode_tile_number[0] = 1;}
                        else if (small_mode_tile_number[0] == 4) {small_mode_tile_number[0] = 2;}
                    }
                }

                if (event.getCode() == KeyCode.TAB) {
                    switch (small_mode_tile_number[0]) {
                        case 1:
                            cursor_displayer.setLayoutX(cursor_displayer.getLayoutX() + 62.5);
                            cursor_displayer.setLayoutY(cursor_displayer.getLayoutY() + 12.5);
                            break;
                        case 2:
                            cursor_displayer.setLayoutX(cursor_displayer.getLayoutX() + 37.5);
                            cursor_displayer.setLayoutY(cursor_displayer.getLayoutY() + 12.5);
                            break;
                        case 3:
                            cursor_displayer.setLayoutX(cursor_displayer.getLayoutX() + 62.5);
                            cursor_displayer.setLayoutY(cursor_displayer.getLayoutY() - 12.5);
                            break;
                        case 4:
                            cursor_displayer.setLayoutX(cursor_displayer.getLayoutX() + 37.5);
                            cursor_displayer.setLayoutY(cursor_displayer.getLayoutY() - 12.5);
                            break;
                    }
                    small_mode_is_on[0] = false;
                }
                
                if (event.isShiftDown()) { //scroll
                    if (event.getCode() == KeyCode.RIGHT) {
                        move_symbols(symbol_imageviews, "right");
                    }
                    else if (event.getCode() == KeyCode.LEFT) {
                        move_symbols(symbol_imageviews, "left");
                    }
                    else if (event.getCode() == KeyCode.UP) {
                        move_symbols(symbol_imageviews, "up");
                    }
                    else if (event.getCode() == KeyCode.DOWN) {
                        move_symbols(symbol_imageviews, "down");
                    }
                }
                else { //shift is NOT held down - move the cursor
                    if (event.getCode() == KeyCode.RIGHT) {
                        cursor_displayer.setLayoutX(cursor_displayer.getLayoutX() + 25);
                        //update tile number
                        if (small_mode_tile_number[0] == 1) {small_mode_tile_number[0] = 2;}
                        else if (small_mode_tile_number[0] == 2) {small_mode_tile_number[0] = 1;}
                        else if (small_mode_tile_number[0] == 3) {small_mode_tile_number[0] = 4;}
                        else if (small_mode_tile_number[0] == 4) {small_mode_tile_number[0] = 3;}
                    }
                    else if (event.getCode() == KeyCode.LEFT) {
                        cursor_displayer.setLayoutX(cursor_displayer.getLayoutX() - 25);
                        //update tile number
                        if (small_mode_tile_number[0] == 1) {small_mode_tile_number[0] = 2;}
                        else if (small_mode_tile_number[0] == 2) {small_mode_tile_number[0] = 1;}
                        else if (small_mode_tile_number[0] == 3) {small_mode_tile_number[0] = 4;}
                        else if (small_mode_tile_number[0] == 4) {small_mode_tile_number[0] = 3;}
                    }
                    else if (event.getCode() == KeyCode.UP) {
                        cursor_displayer.setLayoutY(cursor_displayer.getLayoutY() - 25);
                        //update tile number
                        if (small_mode_tile_number[0] == 1) {small_mode_tile_number[0] = 3;}
                        else if (small_mode_tile_number[0] == 2) {small_mode_tile_number[0] = 4;}
                        else if (small_mode_tile_number[0] == 3) {small_mode_tile_number[0] = 1;}
                        else if (small_mode_tile_number[0] == 4) {small_mode_tile_number[0] = 2;}
                    }
                    else if (event.getCode() == KeyCode.DOWN) {
                        cursor_displayer.setLayoutY(cursor_displayer.getLayoutY() + 25);
                        //update tile number:
                        if (small_mode_tile_number[0] == 1) {small_mode_tile_number[0] = 3;}
                        else if (small_mode_tile_number[0] == 2) {small_mode_tile_number[0] = 4;}
                        else if (small_mode_tile_number[0] == 3) {small_mode_tile_number[0] = 1;}
                        else if (small_mode_tile_number[0] == 4) {small_mode_tile_number[0] = 2;}
                    }
                }

                debug_label.setText(small_mode_tile_number[0] + "");

            } //close bracket for "small mode is ON"
            else { //small mode is OFF
              if (regular_keyboard_mode_is_on[0]) {
                    if (event.getCode() == KeyCode.ALT) {
                        regular_keyboard_mode_status.setText("Regular Keyboard Mode is OFF");
                        regular_keyboard_mode_is_on[0] = false;
                    }
                    if (event.isShiftDown()) {
                        //debug_label.setText("SHIFT");
                        if (event.getCode() == KeyCode.DIGIT1) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_exclamation.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT2) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_at.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT3) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_hashtag.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT4) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_dollar.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT5) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_percent.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT6) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_carrot.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT7) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_and.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT8) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_asterisk.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT9) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_parenthesis_open.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT0) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_parenthesis_closed.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.MINUS) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_line_horizontal_bottom.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.EQUALS) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_plus.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.Q) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_Q.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.W) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_W.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.E) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_E.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.R) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_R.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.T) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_T.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.Y) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_Y.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.U) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_U.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.I) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_I.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.O) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_O.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.P) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_P.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.OPEN_BRACKET) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_bracket_curly_open.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.CLOSE_BRACKET) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_bracket_curly_closed.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.BACK_SLASH) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_line_vertical_middle.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.QUOTE) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_quote_double.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.SLASH) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_question_mark.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.A) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_A.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.S) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_S.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.D) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_D.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.F) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_F.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.G) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_G.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.H) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_H.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.J) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_J.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.K) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_K.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.L) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_L.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.SEMICOLON) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_colon.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.Z) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_Z.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.X) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_X.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.C) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_C.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.V) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_V.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.B) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_B.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.N) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_N.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.M) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_uppercase_M.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.COMMA) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_less_than.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.PERIOD) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_greater_than.png", cursor_displayer);
                        }
                    }
                    else { //Shift is NOT being held down
                        //debug_label.setText("None");
                        if (event.getCode() == KeyCode.DIGIT1) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_1.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT2) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_2.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT3) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_3.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT4) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_4.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT5) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_5.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT6) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_6.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT7) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_7.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT8) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_8.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT9) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_9.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.DIGIT0) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_0.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.MINUS) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_minus.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.EQUALS) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_equals.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.Q) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_q.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.W) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_w.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.E) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_e.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.R) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_r.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.T) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_t.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.Y) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_y.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.U) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_u.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.I) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_i.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.O) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_o.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.P) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_p.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.QUOTE) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_quote_single.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.SLASH) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_slash_forward.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.OPEN_BRACKET) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_bracket_square_open.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.CLOSE_BRACKET) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_bracket_square_closed.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.BACK_SLASH) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_slash_backward.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.A) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_a.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.S) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_s.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.D) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_d.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.F) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_f.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.G) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_g.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.H) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_h.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.J) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_j.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.K) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_k.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.L) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_l.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.SEMICOLON) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_semicolon.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.Z) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_z.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.X) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_x.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.C) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_c.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.V) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_v.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.B) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_b.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.N) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_n.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.M) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_m.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.COMMA) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_comma.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.PERIOD) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_decimal.png", cursor_displayer);
                        }
                        else if (event.getCode() == KeyCode.SPACE) {
                            cursor_displayer.setLayoutX(cursor_displayer.getLayoutX() + 50);
                        }
                        else if (event.getCode() == KeyCode.BACK_SPACE) {
                            create_symbol_bigmode (pane_object, "sprites/bigmode_empty.png", cursor_displayer); 
                            cursor_displayer.setLayoutX(cursor_displayer.getLayoutX() - 100);
                        }
                        else if (event.getCode() == KeyCode.TAB) {
                            small_mode_is_on[0] = true;
                            cursor_displayer.setLayoutX(cursor_displayer.getLayoutX() - 12.5);
                            cursor_displayer.setLayoutY(cursor_displayer.getLayoutY() - 12.5);
                            small_mode_tile_number[0] = 1;
                        }
                    }

                }
                else { //regular keyboard mode is OFF (so math mode basically)
                    if (event.getCode() == KeyCode.ALT) {
                        regular_keyboard_mode_status.setText("Regular Keyboard Mode is ON");
                        regular_keyboard_mode_is_on[0] = true;
                    }
                    if (event.getCode() == KeyCode.DIGIT1) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_1.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.DIGIT2) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_2.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.DIGIT3) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_3.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.DIGIT4) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_4.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.DIGIT5) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_5.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.DIGIT6) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_6.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.DIGIT7) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_7.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.DIGIT8) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_8.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.DIGIT9) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_9.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.DIGIT0) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_0.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.Q) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_plus.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.W) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_minus.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.E) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_asterisk.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.R) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_slash_forward.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.T) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_equals.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.Y) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_y.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.U) {
                        Image bigmode_square_root_corner_sprite = new Image (getClass().getResource("sprites/bigmode_square_root_corner.png").toExternalForm());
                        ImageView bigmode_square_root_corner_displayer = new ImageView (bigmode_square_root_corner_sprite);
                        bigmode_square_root_corner_displayer.setLayoutX(cursor_displayer.getLayoutX());
                        bigmode_square_root_corner_displayer.setLayoutY(cursor_displayer.getLayoutY() - 50);
                        pane_object.getChildren().add(bigmode_square_root_corner_displayer);
                        symbol_images.add(bigmode_square_root_corner_sprite);
                        symbol_imageviews.add(bigmode_square_root_corner_displayer);
                        Image bigmode_line_horizontal_bottom_sprite = new Image (getClass().getResource("sprites/bigmode_line_horizontal_bottom.png").toExternalForm());
                        ImageView bigmode_line_horizontal_bottom_displayer = new ImageView (bigmode_line_horizontal_bottom_sprite);
                        bigmode_line_horizontal_bottom_displayer.setLayoutX(cursor_displayer.getLayoutX() + 50);
                        bigmode_line_horizontal_bottom_displayer.setLayoutY(cursor_displayer.getLayoutY() - 50);
                        pane_object.getChildren().add(bigmode_line_horizontal_bottom_displayer);
                        symbol_images.add(bigmode_line_horizontal_bottom_sprite);
                        symbol_imageviews.add(bigmode_line_horizontal_bottom_displayer);
                        create_symbol_bigmode (pane_object, "sprites/bigmode_square_root.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.O) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_square_root_corner.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.I) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_square_root.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.P) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_pi.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.OPEN_BRACKET) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_parenthesis_open.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.CLOSE_BRACKET) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_parenthesis_closed.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.A) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_line_horizontal_bottom.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.S) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_line_horizontal_middle.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.D) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_line_horizontal_top.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.F) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_arrow.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.G) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_equals_not.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.H) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_greater_than.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.J) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_greater_than_or_equals.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.K) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_less_than.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.L) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_less_than_or_equals.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.X) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_lowercase_x.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.C) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_line_vertical_left.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.V) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_line_vertical_middle.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.B) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_line_vertical_right.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.N) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_infinity.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.M) {
                        cursor_displayer.setLayoutY(cursor_displayer.getLayoutY() - 50);
                        create_symbol_bigmode (pane_object, "sprites/bigmode_integral.png", cursor_displayer);
                        cursor_displayer.setLayoutY(cursor_displayer.getLayoutY() + 50);
                    }
                    else if (event.getCode() == KeyCode.COMMA) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_comma.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.PERIOD) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_decimal.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.Z) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_percent.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.SEMICOLON) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_summation.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.BACK_QUOTE) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_theta.png", cursor_displayer);
                    }
                    else if (event.getCode() == KeyCode.BACK_SPACE) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_empty.png", cursor_displayer);  
                        cursor_displayer.setLayoutX(cursor_displayer.getLayoutX() - 100);
                    }
                    else if (event.getCode() == KeyCode.SLASH) {
                        create_symbol_bigmode (pane_object, "sprites/bigmode_cancel.png", cursor_displayer);
                        cursor_displayer.setLayoutY(cursor_displayer.getLayoutY() - 50);
                    }
                    else if (event.getCode() == KeyCode.TAB) {
                        small_mode_is_on[0] = true;
                        cursor_displayer.setLayoutX(cursor_displayer.getLayoutX() - 12.5);
                        cursor_displayer.setLayoutY(cursor_displayer.getLayoutY() - 12.5);
                        small_mode_tile_number[0] = 1;
                    }
                }

                //bigmode_theta_displayer.setLayoutX(50);

                //arrow keys functionality: scrolling and cursor movement
                if (event.isShiftDown()) { //scroll
                    if (event.getCode() == KeyCode.RIGHT) {
                        move_symbols(symbol_imageviews, "right");
                    }
                    else if (event.getCode() == KeyCode.LEFT) {
                        move_symbols(symbol_imageviews, "left");
                    }
                    else if (event.getCode() == KeyCode.UP) {
                        move_symbols(symbol_imageviews, "up");
                    }
                    else if (event.getCode() == KeyCode.DOWN) {
                        move_symbols(symbol_imageviews, "down");
                    }
                    
                }
                else { //shift is NOT held down - move the cursor
                    if (event.getCode() == KeyCode.RIGHT) {cursor_displayer.setLayoutX(cursor_displayer.getLayoutX() + 50);}
                    else if (event.getCode() == KeyCode.LEFT) {cursor_displayer.setLayoutX(cursor_displayer.getLayoutX() - 50);}
                    else if (event.getCode() == KeyCode.UP) {cursor_displayer.setLayoutY(cursor_displayer.getLayoutY() - 50);}
                    else if (event.getCode() == KeyCode.DOWN) {cursor_displayer.setLayoutY(cursor_displayer.getLayoutY() + 50);}
                }
            } //close bracket for "small mode is OFF"

            cursor_displayer.toFront();
            keyboard_displayer.toFront();
        });
        
        /******************** DISPLAY THE SCENE ********************/
        alt_label.setStyle("-fx-background-color: white;");
        tab_label.setStyle("-fx-background-color: white;");
        regular_keyboard_mode_status.setStyle("-fx-background-color: white;");

        primaryStage.setScene(scene_object);
        primaryStage.setTitle("Math Writer");
        primaryStage.show();

    }

    private void create_symbol_bigmode (Pane pane_input, String image_path_input, ImageView cursor_imageview_input) {
        Image image_object = new Image (getClass().getResource(image_path_input).toExternalForm());
        ImageView imageview_object = new ImageView (image_object);
        imageview_object.setLayoutX(cursor_imageview_input.getLayoutX());
        imageview_object.setLayoutY(cursor_imageview_input.getLayoutY());
        pane_input.getChildren().add(imageview_object);
        cursor_imageview_input.setLayoutX(cursor_imageview_input.getLayoutX() + 50); 
        symbol_images.add (image_object);
        symbol_imageviews.add (imageview_object);
    }

    private void create_symbol_smallmode (Pane pane_input, String image_path_input, ImageView cursor_imageview_input, int[] tile_number_input) {
        Image image_object = new Image (getClass().getResource(image_path_input).toExternalForm());
        ImageView imageview_object = new ImageView (image_object);
        imageview_object.setLayoutX(cursor_imageview_input.getLayoutX() + 12);
        imageview_object.setLayoutY(cursor_imageview_input.getLayoutY() + 12.5);
        pane_input.getChildren().add(imageview_object);
        cursor_imageview_input.setLayoutX(cursor_imageview_input.getLayoutX() + 25); 
        symbol_images.add (image_object);
        symbol_imageviews.add (imageview_object);
        //update tile number
        if (tile_number_input[0] == 1) {tile_number_input[0] = 2;}
        else if (tile_number_input[0] == 2) {tile_number_input[0] = 1;}
        else if (tile_number_input[0] == 3) {tile_number_input[0] = 4;}
        else if (tile_number_input[0] == 4) {tile_number_input[0] = 3;}
    }

    private void move_symbols(List<ImageView> imageview_array_input, String direction_input) {
        switch (direction_input) {
            case "left":
                for (int i = 0; i < imageview_array_input.size(); i++) {
                    imageview_array_input.get(i).setLayoutX(imageview_array_input.get(i).getLayoutX() - 50);
                }
                break;
            case "right":
                for (int i = 0; i < imageview_array_input.size(); i++) {
                    imageview_array_input.get(i).setLayoutX(imageview_array_input.get(i).getLayoutX() + 50);
                }
                break;
            case "up":
                for (int i = 0; i < imageview_array_input.size(); i++) {
                    imageview_array_input.get(i).setLayoutY(imageview_array_input.get(i).getLayoutY() - 50);
                }
                break;
            case "down":
                for (int i = 0; i < imageview_array_input.size(); i++) {
                    imageview_array_input.get(i).setLayoutY(imageview_array_input.get(i).getLayoutY() + 50);
                }
                break;
        }
    }
}



package com.hrquiz;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;

public class Controller
{
    @FXML
    private Button buttonNO;
    @FXML
    private Label salary;

    /* Set limiters for button NO position */
    public static final int X_LEFT_LIMITER = 10;
    public static final int X_MOVING_AREA = 410;
    public static final int Y_TOP_LIMITER = 60;
    public static final int Y_MOVING_AREA = 260;
    /* Set margins for new position of button NO */
    public static final int X_BUTTON_NO_LIMITER = 100;
    public static final int Y_BUTTON_NO_LIMITER = 50;
    /* Set initial button NO position */
    public static final int X_BUTTON_NO_INITIAL = 380;
    public static final int Y_BUTTON_NO_INITIAL = 350;

    public void mouseDrag() {
        salary.setText("Are you satisfied by your salary?");

        /* Set button NO random position if mouse come under this button */
        double x  = X_LEFT_LIMITER + Math.random()*X_MOVING_AREA;
        double y = Y_TOP_LIMITER + Math.random()*Y_MOVING_AREA;

        /* to avoid interference with button NO in case if Math.random put it to close to the latest position */
        if (x > (buttonNO.getLayoutX()-X_BUTTON_NO_LIMITER) && x < (buttonNO.getLayoutX() + X_BUTTON_NO_LIMITER) ) {
            if (y > (buttonNO.getLayoutY() - Y_BUTTON_NO_LIMITER) && y < (buttonNO.getLayoutY() + Y_BUTTON_NO_LIMITER)) {
                x = X_BUTTON_NO_INITIAL;
                y = Y_BUTTON_NO_INITIAL;
            }
        }

        buttonNO.setLayoutX(x);
        buttonNO.setLayoutY(y);
   }

    public void clickButtonYES() {
        salary.setText("Thank you! We had no doubts!");
        buttonNO.setLayoutX(X_BUTTON_NO_INITIAL);
        buttonNO.setLayoutY(Y_BUTTON_NO_INITIAL);
    }
}
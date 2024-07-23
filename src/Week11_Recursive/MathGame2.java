/**
 * Student Name: Bo Qu
 * Lab Professor: Travis Lothar Czech
 * Due Date: 2024-07-23
 * Modified: 2024-07-23
 * Description: Lab assignment
 */

package Week11_Recursive;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import java.util.Scanner;

public class MathGame2 extends Application {

    private static int iterations;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Welcome to the Math Game!");

        // Display game modes
        System.out.println("Choose a game mode: ");
        System.out.println("4. Generate Koch Curve Fractal\n");

        int choice = scanner.nextInt();

        if (choice == 4) {
            System.out.println("Koch Curve Fractal: Generate fractal drawing!");
            System.out.println("Please enter the number of iterations: ");
            iterations = scanner.nextInt();

            launch(args);
        } else {
            System.out.println("Invalid choice. Exiting game.");
        }

        scanner.close();
    }

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("Koch Curve Fractal");

        Canvas canvas = new Canvas(800, 600);
        GraphicsContext gc = canvas.getGraphicsContext2D();

        drawKochCurve(gc, iterations, 50, 300, 750, 300);

        StackPane root = new StackPane(canvas);
        primaryStage.setScene(new Scene(root));
        primaryStage.show();
    }

    // Drawing Koch Curve Fractal using GraphicsContext
    private void drawKochCurve(GraphicsContext gc, int iterations, double x1, double y1, double x2, double y2) {
        if (iterations == 0) {
            gc.strokeLine(x1, y1, x2, y2);
        } else {
            double deltaX = (x2 - x1) / 3;
            double deltaY = (y2 - y1) / 3;

            double x3 = x1 + deltaX;
            double y3 = y1 + deltaY;

            double x4 = x1 + 2 * deltaX;
            double y4 = y1 + 2 * deltaY;

            double xMid = (x2 + x1) / 2 + Math.sqrt(3) * (y1 - y2) / 6;
            double yMid = (y2 + y1) / 2 + Math.sqrt(3) * (x2 - x1) / 6;

            drawKochCurve(gc, iterations - 1, x1, y1, x3, y3);
            drawKochCurve(gc, iterations - 1, x3, y3, xMid, yMid);
            drawKochCurve(gc, iterations - 1, xMid, yMid, x4, y4);
            drawKochCurve(gc, iterations - 1, x4, y4, x2, y2);
        }
    }
}

//        --module-path
//        "C:\Users\czecht\IdeaProjects\Week11_Recursion\javafx-sdk-22.0.2\lib"
//        --add-modules=javafx.controls,javafx.fxml

//        edit -> modify options -> add VM options

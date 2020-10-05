package dad.javafx.cambiodivisa;

import javafx.application.Application;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class CambioDivisa extends Application {
	private TextField text1;
	private TextField text2;
	private ComboBox combo1;
	private ComboBox combo2;
	private Button cambiarButton;
	
	@Override
	public void start(Stage primaryStage) throws Exception {

		text1 = new TextField("0");
		text1.setPrefColumnCount(4);

		combo1 = new ComboBox();
		
		HBox hbox1 = new HBox();
		hbox1.setAlignment(Pos.BASELINE_CENTER);
		hbox1.setSpacing(5);
		hbox1.getChildren().addAll(text1, combo1);
		
		text2 = new TextField("0");
		text2.setPrefColumnCount(4);
		
		combo2 = new ComboBox();

		HBox hbox2 = new HBox();
		hbox2.setAlignment(Pos.BASELINE_CENTER);
		hbox2.setSpacing(5);
		hbox2.getChildren().addAll(text2, combo2);
		
		cambiarButton = new Button("Cambiar");
		
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(hbox1, hbox2, cambiarButton);
		
		Scene scene = new Scene(root, 320, 200);
		
		primaryStage.setTitle("CambioDivisa");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

		   public static void main(String args[]){ 
		      launch(args); 
		   } 
}


package dad.cambiodivisa;
import javafx.application.Application;
import javafx.event.ActionEvent;
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
	private ComboBox<Divisa> combo1;
	private ComboBox<Divisa> combo2;
	private Button cambiarButton;
	private Divisa euro = new Divisa("Euro", 1.0);
	private Divisa libra = new Divisa("Libra", 0.8873);
	private Divisa dolar = new Divisa("Dolar", 1.2007);
	private Divisa yen = new Divisa("Yen", 133.59);
	private Divisa [] divisas = {euro, libra, dolar, yen};
	   
	public void start(Stage primaryStage) throws Exception {

		text1 = new TextField("0");
		text1.setPrefColumnCount(4);

		combo1 = new ComboBox<>();
		combo1.getItems().addAll(divisas);
		combo1.getSelectionModel().select(euro);
		
		HBox hbox1 = new HBox();
		hbox1.setAlignment(Pos.BASELINE_CENTER);
		hbox1.setSpacing(5);
		hbox1.getChildren().addAll(text1, combo1);
		
		text2 = new TextField("0");
		text2.setPrefColumnCount(4);
		text2.setEditable(false);
		
		combo2 = new ComboBox<>();
		combo2.getItems().addAll(divisas);
		combo2.getSelectionModel().select(libra);
		
		HBox hbox2 = new HBox();
		hbox2.setAlignment(Pos.BASELINE_CENTER);
		hbox2.setSpacing(5);
		hbox2.getChildren().addAll(text2, combo2);
		
		cambiarButton = new Button("Cambiar");
		cambiarButton.setOnAction(e-> onCambiarAction(e));
		VBox root = new VBox();
		root.setSpacing(5);
		root.setAlignment(Pos.CENTER);
		root.getChildren().addAll(hbox1, hbox2, cambiarButton);
		
		Scene scene = new Scene(root, 420, 200);
		
		primaryStage.setTitle("CambioDivisa");
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

		   private Object onCambiarAction(ActionEvent e) {
	       double cantidad1 = Double.parseDouble(text1.getText());
	       Divisa divisa1 = combo1.getSelectionModel().getSelectedItem();
	       Divisa divisa2 =combo2.getSelectionModel().getSelectedItem();
	       double cantidad2 = divisa2.fromEuro(divisa1.toEuro(cantidad1));
	       text2.setText(""+ cantidad2);
		return null;
	}
	public static void main(String[] args) {
		
		launch(args); 
	}

}

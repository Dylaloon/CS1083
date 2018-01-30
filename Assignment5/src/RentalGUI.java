/**
*Create a basic JavaFX application
*/

import java.text.NumberFormat;

import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.stage.Stage;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.FlowPane;
import javafx.geometry.Pos;	
import javafx.scene.text.Text;
import javafx.scene.text.Font;
 
/**
 * this class represents a GUI for the RentalDriver
 * and its resepected classes.
 * @author Dylan Lohnes
 *
 */
public class RentalGUI extends Application{
	TextField input = null;
	Label output = null;
	Button eco = null;
	Button buis = null;
	public void start(Stage primaryStage){
		
		FlowPane gridPane = new FlowPane();
		
		//asdasdasd
		Scene scene1 = new Scene(gridPane,350,200);
		gridPane.setAlignment(Pos.CENTER);
		gridPane.setVgap(10);
		gridPane.setHgap(10);
		Text opening = new Text (10,10,"Enter the capacity of the vehichle required.");
		gridPane.getChildren().add(opening);
		input = new TextField();
		input.setPrefWidth(50);
		gridPane.getChildren().add(input);
		 eco = new Button ("Economy Rental");
		gridPane.getChildren().add(eco);
		eco.setOnAction(this::eventHandler);
		 buis = new Button ("Buisness Rental");
		gridPane.getChildren().add(buis);	
		buis.setOnAction(this::eventHandler);
		output = new Label ();
		gridPane.getChildren().add(output);
		
		primaryStage.setTitle("Greetings");
		primaryStage.setScene(scene1);
		primaryStage.show();

}

	private void eventHandler(ActionEvent event) {
		String i = input.getText();
			int in = Integer.parseInt(i);
			StringBuffer stringBuf = new StringBuffer();
			NumberFormat form = NumberFormat.getCurrencyInstance();
			if (in <= 0)
				stringBuf.append("Please enter a number above 0");
			else if (event.getSource() == eco)
			{
				EconomyClassRental r3 = new EconomyClassRental(in); 
				stringBuf.append("Economy Rate: " + form.format(r3.getDailyRentalCost()) + "\n");
				stringBuf.append("Insurance Cost: " + form.format(r3.getInsuranceCost()) + "\n");
				stringBuf.append("Total Cost: " + form.format(r3.getDailyRentalCost() + r3.getInsuranceCost()));
			}
			else if (event.getSource() == buis)
			{
				BuisnessClassRental r2 = new BuisnessClassRental(in);
				stringBuf.append("Business Rate: " + form.format(r2.getDailyRentalCost()) +"\n");
				stringBuf.append("Reward Points: " + r2.getPoints());
			}
				output.setText(stringBuf.toString());
		}
}
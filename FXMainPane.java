


import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

/**
 * This panel is the basic panel, inside which other panels are placed.  
 * Before beginning to implement, design the structure of your GUI in order to 
 * understand what panels go inside which ones, and what buttons or other components
 * go in which panels.  
 * @author ralexander
 *
 */
//make the main panel's layout be a VBox
public class FXMainPane extends VBox {

	//student Task #2:
	//  declare five buttons, a label, and a textfield
	private Button hello, howdy, chinese, clear, exit;
	private TextField textField;
	private Label label;
	//  declare two HBoxes
	private HBox box1, box2;
	
	//student Task #4:
	//  declare an instance of DataManager
	private DataManager dataManager;
	/**
	 * The MainPanel constructor sets up the entire GUI in this approach.  Remember to
	 * wait to add a component to its containing component until the container has
	 * been created.  This is the only constraint on the order in which the following 
	 * statements appear.
	 */
	FXMainPane() {
		//student Task #2:
		//  instantiate the buttons, label, and textfield
		hello = new Button("Hello");
		hello.setOnAction(new ButtonHandler());

		howdy = new Button("Howdy");
		howdy.setOnAction(new ButtonHandler());

		chinese = new Button("Chinese");
		chinese.setOnAction(new ButtonHandler());

		clear = new Button("Clear");
		clear.setOnAction(new ButtonHandler());

		exit = new Button("Exit");
		exit.setOnAction(new ButtonHandler());

		label = new Label("Feedback");
		textField = new TextField();
		//  instantiate the HBoxes
		box1 = new HBox();
		box2 = new HBox();
		
		//student Task #4:
		//  instantiate the DataManager instance
		dataManager = new DataManager();
		//  set margins and set alignment of the components
		Insets inset = new Insets(10);
		box1.setMargin(hello, inset);
		box1.setMargin(howdy, inset);
		box1.setMargin(chinese, inset);
		box1.setMargin(clear, inset);
		box1.setMargin(exit, inset);
		box1.setAlignment(Pos.CENTER);

		box2.setMargin(textField, inset);
		box2.setMargin(label, inset);
		box2.setAlignment(Pos.CENTER);
		
		//student Task #3:
		//  add the label and textfield to one of the HBoxes
		box1.getChildren().addAll(hello, howdy, chinese, clear, exit);
		//  add the buttons to the other HBox
		box2.getChildren().addAll(label, textField);
		//  add the HBoxes to this FXMainPanel (a VBox)
		getChildren().addAll(box1, box2);
		
	}
	
	//Task #4:
	//  create a private inner class to handle the button clicks
	class ButtonHandler implements EventHandler<ActionEvent> {

		public void handle(ActionEvent event) {
			if (event.getTarget() == hello) {
				textField.setText(dataManager.getHello());
			} else if (event.getTarget() == howdy) {
				textField.setText(dataManager.getHowdy());
			} else if (event.getTarget() == chinese) {
				textField.setText(dataManager.getChinese());
			} else if (event.getTarget() == clear) {
				textField.setText("");
			} else if (event.getTarget() == exit) {
				System.exit(0);
			}
		}

	}
}
	

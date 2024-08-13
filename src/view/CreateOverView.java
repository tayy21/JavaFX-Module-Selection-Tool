package view;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

public class CreateOverView extends VBox {
	private TextArea t1,t2,t3;
       private Button review_Btn;
	
	public CreateOverView() {
		 t1 = new TextArea();
		t1.setEditable(false);
		t1.setMinSize(163, 108);
		t1.setPrefSize(1081, 360);
		 
                t2 = new TextArea();
		t2.setEditable(false);
		t2.setMinSize(163, 108);
		t2.setPrefSize(1081, 360);
		 
                 t3 = new TextArea();
		t3.setEditable(false);
		t3.setMinSize(162, 108);
		t3.setPrefSize(1080, 360); 
                VBox vb_view_Var= new VBox();
                HBox hb_Var= new HBox();
                 hb_Var.setSpacing(100);
                hb_Var.getChildren().addAll(t2,t3);
                hb_Var.setPadding(new Insets(20,20,20,20));
                vb_view_Var.getChildren().addAll(t1,hb_Var);
                vb_view_Var.setPadding(new Insets(10,10,10,10));
		review_Btn = new Button("Save Overview");
                review_Btn.setMinWidth(Region.USE_PREF_SIZE);
		review_Btn.setMaxWidth(Region.USE_PREF_SIZE);
		review_Btn.setAlignment(Pos.CENTER);
		review_Btn.setPrefWidth(200);
		this.setAlignment(Pos.CENTER);
		this.setPadding(new Insets(5,5,5,5));
		this.getChildren().add(vb_view_Var);
                this.setAlignment(Pos.CENTER);
		this.getChildren().add(review_Btn);
		}
	
	public String getT1() {
		return t1.getText();
	}
	public void setT1(String s) {
		t1.setText(s);
	}
	 public String getT2() {
        return t2.getText();
        }

        public void setT2(String s) {
            t2.setText(s);
        }

        public String getT3() {
            return t3.getText();
        }

        public void setT3(String s) {
           t3.setText(s);
        }
	public void add_Overview_event_Handler_M(EventHandler<ActionEvent> handler) {
		review_Btn.setOnAction(handler);			
	}
        
}

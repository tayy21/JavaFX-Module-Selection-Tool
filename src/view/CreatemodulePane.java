package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.Border;
import javafx.scene.layout.BorderStroke;
import javafx.scene.layout.BorderStrokeStyle;
import javafx.scene.layout.BorderWidths;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Region;
import javafx.scene.layout.RowConstraints;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import model.Course;
import model.Module;

public class CreatemodulePane extends VBox {
	private Label Labeltxt_var1 = new Label("Unselected Term 1 Modules: ");
	private ListView<Module> unSelected_var1, selected_var2, unSelect_var3, selected_var4;
	private Label Labeltext_2 = new Label("Selected Term 1 Modules: ");
	private Label Labeltxt_3 = new Label("Unselected Term 2 Modules: ");
	private Label Labeltxt4 = new Label("Selected Term 2 Modules: ");
	private Label Labeltxt5 = new Label("Year Long Modules: ");
	private Label Labeltxt6 = new Label("Term 1 Credits: ");
	private Label Labeltxt7 = new Label("Term 2 Credits: ");
	private ListView<Module> year_Var;
	private Button add1Btn_Var, remove1Btn_Var, add2Btn_Var, remove2Btn_Var, resetButton_Var, submitBtn_Var;
	private ObservableList<Module> allM_var = FXCollections.observableArrayList ();	
	private ObservableList<Module> unsTel_var = FXCollections.observableArrayList ();	
	private ObservableList<Module> selTerm_Var = FXCollections.observableArrayList ();		
	private ObservableList<Module> unTerm2_Var = FXCollections.observableArrayList ();	
	private ObservableList<Module> selT2_VAR = FXCollections.observableArrayList ();
	private ObservableList<Module> project_Var = FXCollections.observableArrayList ();	
	TextField text_1 = new TextField();
	TextField text2 = new TextField();
	

	public CreatemodulePane() {
		 Labeltxt_var1.setMinWidth(Region.USE_PREF_SIZE);
                 Labeltext_2.setMinWidth(Region.USE_PREF_SIZE);
                   Labeltxt_3.setMinWidth(Region.USE_PREF_SIZE);
                 Labeltxt4.setMinWidth(Region.USE_PREF_SIZE);
                 Labeltxt5.setMinWidth(Region.USE_PREF_SIZE);
                 Labeltxt6.setMinWidth(Region.USE_PREF_SIZE);
		Labeltxt6.setAlignment(Pos.CENTER);
		 Labeltxt7.setMinWidth(Region.USE_PREF_SIZE);
		Labeltxt7.setAlignment(Pos.CENTER);
		 unSelected_var1 = new ListView<Module>(unsTel_var);
		unSelected_var1.setMinSize(163, 109);
		unSelected_var1.setPrefSize(1081, 361);
		 selected_var2 = new ListView<Module>(selTerm_Var);
		selected_var2.setMinSize(163, 109);
		selected_var2.setPrefSize(1081, 361);
		 unSelect_var3 = new ListView<Module>(unTerm2_Var);
		unSelect_var3.setMinSize(163, 109);
		unSelect_var3.setPrefSize(1081, 361);
               selected_var4 = new ListView<Module>(selT2_VAR);
		selected_var4.setMinSize(163, 109);
		selected_var4.setPrefSize(1081, 361);
		 year_Var = new ListView<Module>(project_Var);
		year_Var.setPrefSize(2201, 41);
		 add1Btn_Var = new Button("Add");
		add1Btn_Var.setMinWidth(Region.USE_PREF_SIZE);
		add1Btn_Var.setMaxWidth(Region.USE_PREF_SIZE);
                remove1Btn_Var = new Button("Remove");
		remove1Btn_Var.setMinWidth(Region.USE_PREF_SIZE);
		remove1Btn_Var.setMaxWidth(Region.USE_PREF_SIZE);
               add2Btn_Var = new Button("Add");
		add2Btn_Var.setMinWidth(Region.USE_PREF_SIZE);
		add2Btn_Var.setMaxWidth(Region.USE_PREF_SIZE);
                remove2Btn_Var = new Button("Remove");
		remove2Btn_Var.setMinWidth(Region.USE_PREF_SIZE);
		remove2Btn_Var.setMaxWidth(Region.USE_PREF_SIZE);

		
		submitBtn_Var = new Button("Submit");
		submitBtn_Var.setMinWidth(Region.USE_PREF_SIZE);

		resetButton_Var = new Button("Reset");
		resetButton_Var.setMinWidth(Region.USE_PREF_SIZE);
 
		HBox menubar_Var = new HBox();
		menubar_Var.setSpacing(10);
		menubar_Var.getChildren().add(add1Btn_Var);
		menubar_Var.getChildren().add(remove1Btn_Var);
		menubar_Var.setAlignment(Pos.CENTER);
		
		HBox menubar_Var2 = new HBox();
		menubar_Var2.setSpacing(10);
		menubar_Var2.getChildren().add(add2Btn_Var);
		menubar_Var2.getChildren().add(remove2Btn_Var);
		menubar_Var2.setAlignment(Pos.CENTER);
		
		VBox year_Bar_Var = new VBox();
		year_Bar_Var.setSpacing(1);
                year_Bar_Var.setAlignment(Pos.BOTTOM_LEFT);
		year_Bar_Var.getChildren().add(Labeltxt5);
		year_Bar_Var.getChildren().add(year_Var);
		year_Bar_Var.setAlignment(Pos.CENTER);
		year_Bar_Var.setMinSize(324, 40);
		year_Bar_Var.setPrefSize(324 , 40);
		
		HBox hbox_var1 = new HBox();
		hbox_var1.setSpacing(10);
		hbox_var1.getChildren().add(submitBtn_Var);
		hbox_var1.getChildren().add(resetButton_Var);
		hbox_var1.setAlignment(Pos.CENTER);
		hbox_var1.setMinSize(324, 40);
		hbox_var1.setPrefSize(324, 40);
		 GridPane grid2_Pane_var =  new GridPane();
		grid2_Pane_var.setVgap(4);
		grid2_Pane_var.setPadding(new Insets(10,10, 10, 10));
		grid2_Pane_var.setHgap(10);
		grid2_Pane_var.setAlignment(Pos.CENTER);
		
		ColumnConstraints co_Var = new ColumnConstraints();
		RowConstraints row_Var = new RowConstraints();
		co_Var.setPercentWidth(50);
		row_Var.setPercentHeight(10);
		grid2_Pane_var.getRowConstraints().add(row_Var);
		grid2_Pane_var.getColumnConstraints().add(co_Var);
		
		
		grid2_Pane_var.add(year_Bar_Var, 1, 0, 1, 1);
		
		grid2_Pane_var.add(Labeltxt_var1, 0, 1);
		grid2_Pane_var.add(unSelected_var1, 0, 2);
		grid2_Pane_var.add(Labeltext_2, 1, 1);
		grid2_Pane_var.add(selected_var2, 1, 2);
		HBox hbox_Var= new HBox();
                 text_1.setEditable(false);
                 hbox_Var.getChildren().addAll(Labeltxt6,text_1);

		grid2_Pane_var.add(menubar_Var, 0, 3);
		grid2_Pane_var.add(hbox_Var, 1, 3);
		
		grid2_Pane_var.add(Labeltxt_3, 0, 4);
		grid2_Pane_var.add(unSelect_var3, 0, 5);
		grid2_Pane_var.add(Labeltxt4, 1, 4);
		grid2_Pane_var.add(selected_var4,1, 5);
		   HBox hbox2_var= new HBox();
                 text2.setEditable(false);
                 hbox2_var.getChildren().addAll(Labeltxt7,text2);
		grid2_Pane_var.add(menubar_Var2, 0, 6);
		grid2_Pane_var.add(hbox2_var, 1, 6);
		
		grid2_Pane_var.add(hbox_var1, 0, 7, 2, 1);

		this.getChildren().add(grid2_Pane_var);
	}
	
	 
	public ObservableList<Module> getSelectedselTerm_Var() {
		return selTerm_Var;
	}
	public ObservableList<Module> getSelectedselT2_VAR() {
		return selT2_VAR;
	}
	public ObservableList<Module> getUnselectedunsTel_var() {
		return unsTel_var;
	}
	public ObservableList<Module> getUnselectedunTerm2_Var() {
		return unTerm2_Var;
	}
	
	 
	public Module getSelectedModuleTerm1Views() {
		return unSelected_var1.getSelectionModel().getSelectedItem();
	}
	
	public Module getSelectedModuleTerm2Views() {
		return unSelect_var3.getSelectionModel().getSelectedItem();
	}
	
	public Module getRemoveModuleTerm1Views() {
		return selected_var2.getSelectionModel().getSelectedItem();
	}
	
	public Module getRemoveModuleTerm2Views() {
		return selected_var4.getSelectionModel().getSelectedItem();
	}
	 public void populate_Module_s(Course course_Var) {
		allM_var.addAll(course_Var.getAllModulesOnCourse());

		for (Module m_var : allM_var) {
			if(m_var.getDelivery().toString() == "TERM_1" && m_var.isMandatory() == false) {
				unsTel_var.add(m_var);
			}

			if(m_var.getDelivery().toString() == "TERM_1" && m_var.isMandatory() == true) {
				selTerm_Var.add(m_var);
			}

			if(m_var.getDelivery().toString() == "TERM_2" && m_var.isMandatory() == false) {
				unTerm2_Var.add(m_var);
			}

			if(m_var.getDelivery().toString() == "TERM_2" && m_var.isMandatory() == true) {
				selT2_VAR.add(m_var);
			}

			if(m_var.getDelivery().toString() == "YEAR_LONG") {
				project_Var.add(m_var);
			}
			updateCombo_Box();
		}
	}

	
	public void clear_Txt() {
		allM_var.clear();
		unsTel_var.clear();
		selTerm_Var.clear();
		unTerm2_Var.clear();
		selT2_VAR.clear();
		project_Var.clear();
		updateCombo_Box();
	}
	 
	public void addModuleP_Selector_Event_Handler1_M(EventHandler<ActionEvent> handler) {
		add1Btn_Var.setOnAction(handler);			
	}
	
	public void addModule_P_Selector_EventHandler2_M(EventHandler<ActionEvent> handler) {
		add2Btn_Var.setOnAction(handler);	  		
	}
	
	public void addModuleP_RemoverEvent_Handler1_M(EventHandler<ActionEvent> handler) {
		remove1Btn_Var.setOnAction(handler);			
	}
	
	public void addModuleP_Remover_Event_Handler_2_M(EventHandler<ActionEvent> handler) {
		remove2Btn_Var.setOnAction(handler);			
	}
	
	public void addModuleP_Submit_Event_Handler_M(EventHandler<ActionEvent> handler) {
		submitBtn_Var.setOnAction(handler);			
	}
	
	public void add_Module_PReset_Event_Handler_M(EventHandler<ActionEvent> handler) {
		resetButton_Var.setOnAction(handler);			
	}
	
	public void updateCombo_Box() {
		int c =  15;
		int c1 = 15;
		for (Module m_Var : selTerm_Var) {
			c = c + m_Var.getModuleCredits();
		}
		for (Module m_Var : selT2_VAR) {
			c1 = c1 + m_Var.getModuleCredits();
		}
		 
                text_1.setText(""+c);
		text2.setText(""+c1);
	}
	}

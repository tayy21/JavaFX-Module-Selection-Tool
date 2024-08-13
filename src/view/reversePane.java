package view;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TitledPane;
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

public class reversePane extends VBox {
	private Label labeltxt_Var = new Label("Unselected Term 1 Modules: ");
	private ListView<Module> unselected ,selected_var, unSelected_Var, selected1_Var;
	private Label labeltext_2 = new Label("Reserved Term 1 Modules: ");
	private Label labeltxt_4 = new Label("Unselected Term 2 Modules: ");
	private Label lbl_txt = new Label("Reserved Term 2 Modules: ");
         TitledPane TitPane  ;
	 TitledPane TPane_2; 
         Accordion ac_Object_Var = new Accordion ();    
	private Button add1Button_Var, remove1Button_var, add2Button_Var, remove2Button_Var, submitButton_Var,  submit2Button_Var;
	private ObservableList<Module> all_Modules_List_View=  FXCollections.observableArrayList ();	
	private ObservableList<Module> unsTerm1_List_View_Var = FXCollections.observableArrayList ();	
	private ObservableList<Module> Reserved_Term1_List_View_Var = FXCollections.observableArrayList ();		
	private ObservableList<Module> uns_Term2_List_View = FXCollections.observableArrayList ();	
	private ObservableList<Module> Reserved_Term2_List_View_Var = FXCollections.observableArrayList (); 
	private Label l_Text_5 = new Label("Term 1 Credits: ");
	private Label label_text_Var = new Label("Term 2 Credits: ");
	TitledPane titledpAne_var = new TitledPane();
        private Label labelcredit2 = new Label("Reserve 30 credits worth of term 1 modules");
        private Label labelredit= new Label("Reserve 30 credits worth of term 2 modules");
	public reversePane() {
		labeltxt_Var.setMinWidth(Region.USE_PREF_SIZE);
                labeltext_2.setMinWidth(Region.USE_PREF_SIZE);
                labeltxt_4.setMinWidth(Region.USE_PREF_SIZE);
                 lbl_txt.setMinWidth(Region.USE_PREF_SIZE); 
		l_Text_5.setMinWidth(Region.USE_PREF_SIZE);
		l_Text_5.setAlignment(Pos.CENTER); 
		label_text_Var.setMinWidth(Region.USE_PREF_SIZE);
		label_text_Var.setAlignment(Pos.CENTER); 
		unselected = new ListView<Module>(unsTerm1_List_View_Var);
		unselected.setMinSize(163, 109);
		unselected.setPrefSize(1081, 361);
		 selected_var = new ListView<Module>(Reserved_Term1_List_View_Var);
		selected_var.setMinSize(163, 109);
		selected_var.setPrefSize(1081, 361);
		 unSelected_Var = new ListView<Module>(uns_Term2_List_View);
		unSelected_Var.setMinSize(163, 109);
		unSelected_Var.setPrefSize(1081, 361);
		 selected1_Var = new ListView<Module>(Reserved_Term2_List_View_Var);
		selected1_Var.setMinSize(163, 109);
		selected1_Var.setPrefSize(1081, 361);
		 
		add1Button_Var = new Button("Add");
		add1Button_Var.setMinWidth(Region.USE_PREF_SIZE);
		add1Button_Var.setMaxWidth(Region.USE_PREF_SIZE);
                remove1Button_var = new Button("Remove");
		remove1Button_var.setMinWidth(Region.USE_PREF_SIZE);
		remove1Button_var.setMaxWidth(Region.USE_PREF_SIZE);
                add2Button_Var = new Button("Add");
		add2Button_Var.setMinWidth(Region.USE_PREF_SIZE);
		add2Button_Var.setMaxWidth(Region.USE_PREF_SIZE);
                remove2Button_Var = new Button("Remove");
		remove2Button_Var.setMinWidth(Region.USE_PREF_SIZE);
		remove2Button_Var.setMaxWidth(Region.USE_PREF_SIZE);
                submitButton_Var = new Button("Confirm");
		submitButton_Var.setMinWidth(Region.USE_PREF_SIZE);
                submit2Button_Var = new Button("Confirm");
		submit2Button_Var.setMinWidth(Region.USE_PREF_SIZE); 
                 HBox hb_Box1 = new HBox();
		hb_Box1.setSpacing(10);
		hb_Box1.getChildren().addAll(labelcredit2,add1Button_Var,remove1Button_var,submit2Button_Var);
		 hb_Box1.setAlignment(Pos.CENTER);
		hb_Box1.setMinSize(324, 40);
		hb_Box1.setPrefSize(324, 40); 
                GridPane grid_2_var =  new GridPane();
		 HBox H_Box2 = new HBox();
		H_Box2.setSpacing(10);
		H_Box2.getChildren().addAll(labelredit,add2Button_Var,remove2Button_Var,submitButton_Var);
		 
		H_Box2.setAlignment(Pos.CENTER);
		H_Box2.setMinSize(324, 40);
		H_Box2.setPrefSize(324, 40);
               
                GridPane grid_3_var =  new GridPane();
		grid_2_var.setVgap(4);
		grid_2_var.setPadding(new Insets(10,10, 10, 10));
		grid_2_var.setHgap(10);
		grid_2_var.setAlignment(Pos.CENTER);
		 ColumnConstraints c_1_Var = new ColumnConstraints();
		RowConstraints rw_var = new RowConstraints();
		c_1_Var.setPercentWidth(50);
		rw_var.setPercentHeight(10);
		grid_2_var.getRowConstraints().add(rw_var);
		grid_2_var.getColumnConstraints().add(c_1_Var);
		 grid_2_var.add(labeltxt_Var, 0, 1);
		grid_2_var.add(unselected, 0, 2);
		grid_2_var.add(labeltext_2, 1, 1);
		grid_2_var.add(selected_var, 1, 2);
		 grid_2_var.add(l_Text_5, 1, 3);
		grid_2_var.add(hb_Box1, 0, 7, 2, 1);
                
		grid_3_var.add(labeltxt_4, 0, 1);
		grid_3_var.add(unSelected_Var, 0, 2);
		grid_3_var.add(lbl_txt, 1, 1);
		grid_3_var.add(selected1_Var,1, 2);
		 grid_3_var.add(label_text_Var, 1, 3);
		 grid_3_var.add(H_Box2, 0, 7, 2, 1);
                 TitPane = new TitledPane("Term 1 Modules",grid_2_var);
		 TPane_2 = new TitledPane("Term 2 Modules",grid_3_var);
		 ac_Object_Var.getPanes().addAll(TitPane,TPane_2);
                 this.ac_Object_Var.setExpandedPane(TitPane);
                 VBox v_Box =  new VBox();
               v_Box.getChildren().addAll(ac_Object_Var);
               this.getChildren().add(v_Box);
               
                 
	}
	 
	//Get Methods for Lists
	public ObservableList<Module> getReserved_Term1_List_View_Var() {
		return Reserved_Term1_List_View_Var;
	}
	public ObservableList<Module> getReserved_Term2_List_View_Var() {
		return Reserved_Term2_List_View_Var;
	}
	public ObservableList<Module> getunsTerm1_List_View_Var() {
		return unsTerm1_List_View_Var;
	}
	public ObservableList<Module> getuns_Term2_List_View() {
		return uns_Term2_List_View;
	}
 
	public Module getSelected_Module_T1_List_View_Method() {
		return unselected.getSelectionModel().getSelectedItem();
	}
	
	public Module getSelected_Module_T2_List_View_Module() {
		return unSelected_Var.getSelectionModel().getSelectedItem();
	}
	
	public Module getRemove_Module_T1_List_View_Module() {
		return selected_var.getSelectionModel().getSelectedItem();
	}
	
	public Module get_Remove_Module_T2_List_View_Module() {
		return selected1_Var.getSelectionModel().getSelectedItem();
	}
	 public void Populate1(Module m_var) {
		  unsTerm1_List_View_Var.add(m_var);
	 }
        public void Populate2(Module m_var) {
		  
			uns_Term2_List_View.add(m_var);
	 }

	
	public void clear_Combo_boxes() {
		 Reserved_Term1_List_View_Var.clear();
		 upated_Credits_Txt();
	}
	public void clear_Combo_Boxes2() {
		all_Modules_List_View.clear();
		unsTerm1_List_View_Var.clear();
		Reserved_Term1_List_View_Var.clear();
		uns_Term2_List_View.clear();
		Reserved_Term2_List_View_Var.clear();
		upated_Credits_Txt();
	}
	
	 public void addSelectorObj_EventHandler_M(EventHandler<ActionEvent> handler) {
		add1Button_Var.setOnAction(handler);			
	}
	
	public void add_Selector_EventHandler2_M(EventHandler<ActionEvent> handler) {
		add2Button_Var.setOnAction(handler);			
	}
	
	public void add_Remover_EventHandler_1M(EventHandler<ActionEvent> handler) {
		remove1Button_var.setOnAction(handler);			
	}
	
	public void add_Remover_EventHandler_2_M(EventHandler<ActionEvent> handler) {
		remove2Button_Var.setOnAction(handler);			
	}
	
	public void add_Submit_Event_Handler_M(EventHandler<ActionEvent> handler) {
		submitButton_Var.setOnAction(handler);			
	}
	public void add_Submit_Event_Handler_1_M(EventHandler<ActionEvent> handler) {
		submit2Button_Var.setOnAction(handler);			
	}
	 
	public void upated_Credits_Txt() {
            l_Text_5.setText("Term 1 Credits: "  );
            label_text_Var.setText("Term 2 Credits: " );
		int count1_Var =  0;
		int count2_Var = 0;
		for (Module m_Var : Reserved_Term1_List_View_Var) {
			count1_Var = count1_Var + m_Var.getModuleCredits();
		}
		for (Module m_Var : Reserved_Term2_List_View_Var) {
			count2_Var = count2_Var + m_Var.getModuleCredits();
		}
		l_Text_5.setText("Term 1 Credits: " + count1_Var);
		label_text_Var.setText("Term 2 Credits: " + count2_Var);
	}
       public void  nExT_Tab_pane(){
       
       this.ac_Object_Var.setExpandedPane(TPane_2);
       
       }
	}

package view;

import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.control.TabPane.TabClosingPolicy;
import javafx.scene.layout.BorderPane;


public class ModuleChooserRootPane extends BorderPane {

	private CreateStudentProfilePane cspp;
	private ModuleChooserMenuBar mstmb;
	private TabPane tp;
        private CreatemodulePane Cm_Var;
	private CreateOverView Over_var;
        private  reversePane reverse_Var;
	public ModuleChooserRootPane() {
		//create tab pane and disable tabs from being closed
		tp = new TabPane();
		tp.setTabClosingPolicy(TabClosingPolicy.UNAVAILABLE);
		
		//create panels
		cspp = new CreateStudentProfilePane();
		 Cm_Var = new CreatemodulePane();
		Over_var = new CreateOverView();
                reverse_Var = new reversePane() ;
		//create tabs with panes added
		Tab t1 = new Tab("Create Profile", cspp);
		Tab t_2_var = new Tab("Pick Your Modules", Cm_Var);
		Tab t_3_var= new Tab("Reserve Modules", reverse_Var);
		Tab t_4_Var = new Tab("Overview Selection", Over_var);
		
		//add tabs to tab pane
		tp.getTabs().addAll(t1,t_2_var,t_3_var,t_4_Var);
		
		//create menu bar
		mstmb = new ModuleChooserMenuBar();
		
		//add menu bar and tab pane to this root pane
		this.setTop(mstmb);
		this.setCenter(tp);
		 
	}

	//methods allowing sub-containers to be accessed by the controller.
	public CreateStudentProfilePane getCreateStudentProfilePane() {
		return cspp;
	}
	
	public ModuleChooserMenuBar getModuleSelectionToolMenuBar() {
		return mstmb;
	}
	
	//method to allow the controller to change tabs
	public void changeTab(int index) {
		tp.getSelectionModel().select(index);
	}
       public CreateStudentProfilePane getCspp() {
        return cspp;
    }

    public void setCspp(CreateStudentProfilePane cspp) {
        this.cspp = cspp;
    }

    public ModuleChooserMenuBar getMstmb() {
        return mstmb;
    }

    public void setMstmb(ModuleChooserMenuBar mstmb) {
        this.mstmb = mstmb;
    }

    public TabPane getTp() {
        return tp;
    }

    public void setTp(TabPane tp) {
        this.tp = tp;
    }

    public CreatemodulePane getCm_Var() {
        return Cm_Var;
    }

    public void setCm_Var(CreatemodulePane Cm_Var) {
        this.Cm_Var = Cm_Var;
    }

    public CreateOverView getOver_var() {
        return Over_var;
    }

    public void setOver_var(CreateOverView Over_var) {
        this.Over_var = Over_var;
    }

    public reversePane getReverse_Var() {
        return reverse_Var;
    }

    public void setReverse_Var(reversePane reverse_Var) {
        this.reverse_Var = reverse_Var;
    }
        
    
}

package controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.PrintWriter;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import model.Course;
import model.Schedule;
import model.Module;
import model.StudentProfile;
import view.ModuleChooserRootPane;
import view.CreateStudentProfilePane;
import view.ModuleChooserMenuBar;
import view.CreatemodulePane;
import view.reversePane;
import view.CreateOverView;

public class ModuleChooserController {
 
	private ModuleChooserRootPane view;
	private StudentProfile model;
	private CreateStudentProfilePane cspp;
	private ModuleChooserMenuBar mstmb;
        private CreatemodulePane mp_Var;
        private  reversePane rv_Var;
        private CreateOverView v_Var;
	public ModuleChooserController(ModuleChooserRootPane view, StudentProfile model) {
		//initialise view and model fields
		this.view = view;
		this.model = model;
		
		//initialise view subcontainer fields
		cspp = view.getCreateStudentProfilePane();
		mstmb = view.getModuleSelectionToolMenuBar();
                mp_Var=view.getCm_Var();
                rv_Var=view.getReverse_Var();
                v_Var=view.getOver_var();
		//add courses to combobox in create student profile pane using the generateAndGetCourses helper method below
		cspp.addCoursesToComboBox(generateAndGetCourses());

		//attach event handlers to view using private helper method
		this.attachEventHandlers();	
	}

	
	//helper method - used to attach event handlers
	private void attachEventHandlers() {
		//attach an event handler to the create student profile pane
		cspp.addCreateStudentProfileHandler(new CreateStudentProfileHandler());
		
		//attach an event handler to the menu bar that closes the application
		mstmb.addExitHandler(e -> System.exit(0));
                mstmb.addLoadHandler(new addLoadHandler());
                mstmb.addAboutHandler(new addAboutHandler());
                mstmb.addSaveHandler(new addSaveHandler());
                 mp_Var.addModuleP_RemoverEvent_Handler1_M(new addModuleP_RemoverEvent_Handler1_M());
                mp_Var.addModuleP_Remover_Event_Handler_2_M(new addModuleP_Remover_Event_Handler_2_M());
                mp_Var.add_Module_PReset_Event_Handler_M(new add_Module_PReset_Event_Handler_M());
                mp_Var.addModuleP_Selector_Event_Handler1_M(new addModuleP_Selector_Event_Handler1_M());
                mp_Var.addModule_P_Selector_EventHandler2_M(new addModule_P_Selector_EventHandler2_M());
                mp_Var.addModuleP_Submit_Event_Handler_M(new addModuleP_Submit_Event_Handler_M());
                rv_Var.add_Remover_EventHandler_1M(new add_Remover_EventHandler_1M());
                rv_Var.add_Remover_EventHandler_2_M(new add_Remover_EventHandler_2_M()); 
                rv_Var.addSelectorObj_EventHandler_M(new addSelectorObj_EventHandler_M());
                rv_Var.add_Selector_EventHandler2_M(new add_Selector_EventHandler2_M());
                rv_Var.add_Submit_Event_Handler_M(new add_Submit_Event_Handler_M());
                rv_Var.add_Submit_Event_Handler_1_M(new add_Submit_Event_Handler_1_M()); 
                v_Var.add_Overview_event_Handler_M(new add_Overview_event_Handler_M());
              
              
	}
        
	private void ADialog(Alert.AlertType type, String title, String header, String content) {
		Alert A_Var = new Alert(type);
		A_Var.setTitle(title);
		A_Var.setHeaderText(header);
		A_Var.setContentText(content);
		A_Var.showAndWait();
	}

	private void pop_Final_Tab() {
            
		view.getOver_var().setT1(
				"\n PNumber: " + model.getStudentPnumber() +
				"\n First Name: " + model.getStudentName().getFirstName() +
				"\n Last Name: " + model.getStudentName().getFamilyName() +
				"\n Email Address: " + model.getStudentEmail() +
				"\n Date: " + model.getSubmissionDate() + "\n\n");
		
		for (Module m_Var : model.getAllSelectedModules()) {
		view.getOver_var().setT2(view.getOver_var().getT2() + 
				"\n Module Code: " + m_Var.getModuleCode() + 
				"\n Module Name: " + m_Var.getModuleName() + 
				"\n Credits: " + m_Var.getModuleCredits() + 
				"\n Mandatory  ?  " + m_Var.isMandatory() + 
				"\n Delivery: " + m_Var.getDelivery().toString() + "\n");
		
		}
                for (Module m_Var : model.getAllReservedModules()) {
		view.getOver_var().setT3(view.getOver_var().getT3() + 
				"\n Module Code: " + m_Var.getModuleCode() + 
				"\n Module Name: " + m_Var.getModuleName() + 
				"\n Credits: " + m_Var.getModuleCredits() + 
				"\n Mandatory ? " + m_Var.isMandatory() + 
				"\n Delivery: " + m_Var.getDelivery().toString() + "\n");
		
		}
                
	}
        
           private class addLoadHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
                try (ObjectInputStream ois_Var = new ObjectInputStream(new FileInputStream("student_Profile.dat"));) {
					
					model = (StudentProfile) ois_Var.readObject();
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Load Successful");
					view.getCm_Var().clear_Txt();
					view.getCm_Var().populate_Module_s(model.getStudentCourse());
                               
					if (model.getAllSelectedModules().isEmpty() == false) {
						for (Module m_var : model.getAllSelectedModules()) {
							if (m_var.getDelivery().toString() == "TERM_1" && m_var.isMandatory() == false) {
								view.getCm_Var().getSelectedselTerm_Var().add(m_var);
								view.getCm_Var().getUnselectedunsTel_var().remove(m_var);
								view.getCm_Var().updateCombo_Box();
							}
							if (m_var.getDelivery().toString() == "TERM_2" && m_var.isMandatory() == false) {
								view.getCm_Var().getSelectedselT2_VAR().add(m_var);
								view.getCm_Var().getUnselectedunTerm2_Var().remove(m_var);
								view.getCm_Var().updateCombo_Box();
							}
						}
					}
		        }
		        catch (IOException ioExcep){
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Error Loading" +ioExcep);
		        }
				catch (ClassNotFoundException c) {
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Class Not Found");
		        }	
				pop_Final_Tab();
				view.getTp().getSelectionModel().select(3);
                
                
                }}
           
              private class addAboutHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
                ADialog(AlertType.INFORMATION, "About", "About", " final year modules.");
		
                
                
                }}
              
                 
                    private class addSaveHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
                try (ObjectOutputStream object_var = new ObjectOutputStream(new FileOutputStream("student_Profile.dat"));) {
					object_var.writeObject(model);
                                        object_var.flush();
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Student Profile saved to file.");
				}
				catch (IOException ioExcep){
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Error Saving");
					System.out.println(ioExcep);
				}
                
                
                }}
        
        
        
        private class add_Overview_event_Handler_M implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) { 
			    PrintWriter print_Writer_Var;
				try {
					print_Writer_Var = new PrintWriter (model.getStudentPnumber() + "_OverviewSelectionFile" + ".txt");
					print_Writer_Var.println (view.getOver_var().getT1());
					print_Writer_Var.close ();     
				} catch (FileNotFoundException ex) {
					ex.printStackTrace();
				}
                
                
                }}
	private class add_Remover_EventHandler_1M implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
                if (view.getReverse_Var().getRemove_Module_T1_List_View_Module() == null) {
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Select a Module!");
					return;
				}
				Module temp_Object = view.getReverse_Var().getRemove_Module_T1_List_View_Module();
				 
					view.getReverse_Var().getunsTerm1_List_View_Var().add(view.getReverse_Var().getRemove_Module_T1_List_View_Module());
					view.getReverse_Var().getReserved_Term1_List_View_Var().remove(temp_Object);
				
				view.getReverse_Var().upated_Credits_Txt();
                
                
                }}
private class add_Remover_EventHandler_2_M implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
                if (view.getReverse_Var().get_Remove_Module_T2_List_View_Module() == null) {
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Select a Module!");
					return;
				}
				Module temp_Var = view.getReverse_Var().get_Remove_Module_T2_List_View_Module();
				 
					view.getReverse_Var().getuns_Term2_List_View().add(view.getReverse_Var().get_Remove_Module_T2_List_View_Module());
					view.getReverse_Var().getReserved_Term2_List_View_Var().remove(temp_Var);
				 
				view.getReverse_Var().upated_Credits_Txt();
                
                
                }}


	//helper method - generates course and module data and returns courses within an array
	private Course[] generateAndGetCourses() {
		Module imat3423 = new Module("IMAT3423", "Systems Building: Methods", 15, true, Schedule.TERM_1);
		Module ctec3451 = new Module("CTEC3451", "Development Project", 30, true, Schedule.YEAR_LONG);
		Module ctec3902_SoftEng = new Module("CTEC3902", "Rigorous Systems", 15, true, Schedule.TERM_2);	
		Module ctec3902_CompSci = new Module("CTEC3902", "Rigorous Systems", 15, false, Schedule.TERM_2);
		Module ctec3110 = new Module("CTEC3110", "Secure Web Application Development", 15, false, Schedule.TERM_1);
		Module ctec3605 = new Module("CTEC3605", "Multi-service Networks 1", 15, false, Schedule.TERM_1);	
		Module ctec3606 = new Module("CTEC3606", "Multi-service Networks 2", 15, false, Schedule.TERM_2);	
		Module ctec3410 = new Module("CTEC3410", "Web Application Penetration Testing", 15, false, Schedule.TERM_2);
		Module ctec3904 = new Module("CTEC3904", "Functional Software Development", 15, false, Schedule.TERM_2);
		Module ctec3905 = new Module("CTEC3905", "Front-End Web Development", 15, false, Schedule.TERM_2);
		Module ctec3906 = new Module("CTEC3906", "Interaction Design", 15, false, Schedule.TERM_1);
		Module ctec3911 = new Module("CTEC3911", "Mobile Application Development", 15, false, Schedule.TERM_1);
		Module imat3410 = new Module("IMAT3104", "Database Management and Programming", 15, false, Schedule.TERM_2);
		Module imat3406 = new Module("IMAT3406", "Fuzzy Logic and Knowledge Based Systems", 15, false, Schedule.TERM_1);
		Module imat3611 = new Module("IMAT3611", "Computer Ethics and Privacy", 15, false, Schedule.TERM_1);
		Module imat3613 = new Module("IMAT3613", "Data Mining", 15, false, Schedule.TERM_1);
		Module imat3614 = new Module("IMAT3614", "Big Data and Business Models", 15, false, Schedule.TERM_2);
		Module imat3428_CompSci = new Module("IMAT3428", "Information Technology Services Practice", 15, false, Schedule.TERM_2);


		Course compSci = new Course("Computer Science");
		compSci.addModuleToCourse(imat3423);
		compSci.addModuleToCourse(ctec3451);
		compSci.addModuleToCourse(ctec3902_CompSci);
		compSci.addModuleToCourse(ctec3110);
		compSci.addModuleToCourse(ctec3605);
		compSci.addModuleToCourse(ctec3606);
		compSci.addModuleToCourse(ctec3410);
		compSci.addModuleToCourse(ctec3904);
		compSci.addModuleToCourse(ctec3905);
		compSci.addModuleToCourse(ctec3906);
		compSci.addModuleToCourse(ctec3911);
		compSci.addModuleToCourse(imat3410);
		compSci.addModuleToCourse(imat3406);
		compSci.addModuleToCourse(imat3611);
		compSci.addModuleToCourse(imat3613);
		compSci.addModuleToCourse(imat3614);
		compSci.addModuleToCourse(imat3428_CompSci);

		Course softEng = new Course("Software Engineering");
		softEng.addModuleToCourse(imat3423);
		softEng.addModuleToCourse(ctec3451);
		softEng.addModuleToCourse(ctec3902_SoftEng);
		softEng.addModuleToCourse(ctec3110);
		softEng.addModuleToCourse(ctec3605);
		softEng.addModuleToCourse(ctec3606);
		softEng.addModuleToCourse(ctec3410);
		softEng.addModuleToCourse(ctec3904);
		softEng.addModuleToCourse(ctec3905);
		softEng.addModuleToCourse(ctec3906);
		softEng.addModuleToCourse(ctec3911);
		softEng.addModuleToCourse(imat3410);
		softEng.addModuleToCourse(imat3406);
		softEng.addModuleToCourse(imat3611);
		softEng.addModuleToCourse(imat3613);
		softEng.addModuleToCourse(imat3614);

		Course[] courses = new Course[2];
		courses[0] = compSci;
		courses[1] = softEng;

		return courses;
	}
	private class addModuleP_Selector_Event_Handler1_M implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
                
                if (view.getCm_Var().getSelectedModuleTerm1Views() == null) {
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Select a Module!");	
					return;
				}
				Module temp_Var = view.getCm_Var().getSelectedModuleTerm1Views();
				int c = 0;
				for (Module m :view.getCm_Var().getSelectedselTerm_Var()) {
					c = c + m.getModuleCredits();
				}
				if (c + temp_Var.getModuleCredits() > 45) {
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Maximum credits per term is 60.");
					return;
				}
				else {
					view.getCm_Var().getSelectedselTerm_Var().add(view.getCm_Var().getSelectedModuleTerm1Views());
					view.getCm_Var().getUnselectedunsTel_var().remove(temp_Var);
				}
				view.getCm_Var().updateCombo_Box();
			
                
                
                }}

	private class addModule_P_Selector_EventHandler2_M implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
                if (view.getCm_Var().getSelectedModuleTerm2Views() == null) {
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Select a Module!");	
					return;
				}
				Module temp_Var = view.getCm_Var().getSelectedModuleTerm2Views();
				int count_Var = 0;
				for (Module m :view.getCm_Var().getSelectedselT2_VAR()) {
					count_Var = count_Var + m.getModuleCredits();
				}
				if (count_Var + temp_Var.getModuleCredits() > 45) {
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Maximum credits per term is 60.");
					return;
				}
				else {
					view.getCm_Var().getSelectedselT2_VAR().add(view.getCm_Var().getSelectedModuleTerm2Views());
					view.getCm_Var().getUnselectedunTerm2_Var().remove(temp_Var);
				}
				view.getCm_Var().updateCombo_Box();
                
                
                
                
                }}

	private class addModuleP_Submit_Event_Handler_M implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
                int count_Var = 30;
				for (Module m : view.getCm_Var().getSelectedselTerm_Var()) {
					count_Var = count_Var + m.getModuleCredits();
				}
				for (Module m : view.getCm_Var().getSelectedselT2_VAR()) {
					count_Var = count_Var + m.getModuleCredits();
				}
				
				if (count_Var != 120) {
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Select modules for 120 credits before you submit.");						
				}
				else {
					model.clearSelectedModules();
					for (Module m : view.getCm_Var().getSelectedselTerm_Var()) {
						model.addSelectedModule(m);
					}
					for (Module m : view.getCm_Var().getSelectedselT2_VAR()) {
						model.addSelectedModule(m);
					}
					for (Module m : view.getCm_Var().getUnselectedunsTel_var()) {
						 view.getReverse_Var().Populate1(m);
					}
					for (Module m : view.getCm_Var().getUnselectedunTerm2_Var()) {
					view.getReverse_Var().Populate2(m);
					}
					
					pop_Final_Tab();
					}
					view.getTp().getSelectionModel().select(2);
                
                
                }}
//event handler (currently empty), which can be used for creating a profile
	private class CreateStudentProfileHandler implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
			       if (view.getCreateStudentProfilePane().getSelectedCourse() == null){
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Please Select a Course");
					return;
				}
				
				if (view.getCreateStudentProfilePane().getTxtFirstName().length() == 0){
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Please Enter a Valid First Name");
					return;
				}
				if (view.getCreateStudentProfilePane().getTxtSurname().length() == 0){
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Please Enter Your Valid Last Name");
					return;
				}
				if (view.getCreateStudentProfilePane().getStudentEmail().contains("@") == false || 
						view.getCreateStudentProfilePane().getStudentEmail().contains(".") == false ){
					ADialog(AlertType.INFORMATION, "ALERT", null, "Please Enter a Valid Email Address");
					return;
				}
				 
				model.setStudentCourse(view.getCreateStudentProfilePane().getSelectedCourse());
				model.setStudentPnumber(view.getCreateStudentProfilePane().getStudentPnumber());
				model.setStudentName(view.getCreateStudentProfilePane().getStudentName());
				model.setStudentEmail(view.getCreateStudentProfilePane().getStudentEmail());
				model.setSubmissionDate(view.getCreateStudentProfilePane().getStudentDate());
				
				 
				view.getCm_Var().clear_Txt();
				view.getCm_Var() .populate_Module_s(model.getStudentCourse());
				view.getTp().getSelectionModel().select(1);	
			
		}
	}
	private class addSelectorObj_EventHandler_M implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
                if (view.getReverse_Var().getSelected_Module_T1_List_View_Method() == null) {
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Select a Module!");	
					return;
				}
				Module temp_Var = view.getReverse_Var().getSelected_Module_T1_List_View_Method();
				int c_Var = 0;
				for (Module m :view.getReverse_Var().getReserved_Term1_List_View_Var()) {
					c_Var = c_Var + m.getModuleCredits();
				}
				if (c_Var + temp_Var.getModuleCredits() > 30) {
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Maximum credits Reserved  is 30.");
					return;
				}
				else {
					view.getReverse_Var().getReserved_Term1_List_View_Var().add(view.getReverse_Var().getSelected_Module_T1_List_View_Method());
					view.getReverse_Var().getunsTerm1_List_View_Var().remove(temp_Var);
				}
				view.getReverse_Var().upated_Credits_Txt();
                
                
                }}
private class add_Selector_EventHandler2_M implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
                if (view.getReverse_Var().getSelected_Module_T2_List_View_Module() == null) {
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Select a Module!");	
					return;
				}
				Module temp_Var = view.getReverse_Var().getSelected_Module_T2_List_View_Module();
				int c = 0;
				for (Module m :view.getReverse_Var().getReserved_Term2_List_View_Var()) {
					c = c + m.getModuleCredits();
				}
				if (c + temp_Var.getModuleCredits() > 30) {
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Maximum credits Reserved is 30.");
					return;
				}
				else {
					view.getReverse_Var().getReserved_Term2_List_View_Var().add(view.getReverse_Var().getSelected_Module_T2_List_View_Module());
					view.getReverse_Var().getuns_Term2_List_View().remove(temp_Var);
				}
				view.getReverse_Var().upated_Credits_Txt();
                
                
                }}
private class add_Submit_Event_Handler_M implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
               int c = 0;
				for (Module m : view.getReverse_Var().getReserved_Term1_List_View_Var()) {
					c = c + m.getModuleCredits();
				}
				for (Module m : view.getReverse_Var().getReserved_Term2_List_View_Var()) {
					c = c + m.getModuleCredits();
				}
				
					for (Module m : view.getReverse_Var().getReserved_Term1_List_View_Var()) {
						model.addReservedModule(m);
					}
					for (Module m : view.getReverse_Var().getReserved_Term2_List_View_Var()) {
						model.addReservedModule(m);
                                        }
					
					pop_Final_Tab();
                                        
					view.getTp().getSelectionModel().select(3); 
                
                
                }}
private class add_Submit_Event_Handler_1_M implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
                	view.getReverse_Var().nExT_Tab_pane();	 
                
                
                }}
private class addModuleP_RemoverEvent_Handler1_M implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
                if (view.getCm_Var().getRemoveModuleTerm1Views() == null) {
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Select a Module!");
					return;
				}
				Module temp_Var = view.getCm_Var().getRemoveModuleTerm1Views();
				if (temp_Var.isMandatory() == true) {
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "This module is Mandatory for your course.");		    		
				}
				else {
					view.getCm_Var().getUnselectedunsTel_var().add(view.getCm_Var().getRemoveModuleTerm1Views());
					view.getCm_Var().getSelectedselTerm_Var().remove(temp_Var);
				}
				view.getCm_Var().updateCombo_Box();
                
                
                }}

private class addModuleP_Remover_Event_Handler_2_M implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
                if (view.getCm_Var().getRemoveModuleTerm2Views() == null) {
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "Select a Module!");
					return;
				}
				Module tempVar = view.getCm_Var().getRemoveModuleTerm2Views();
				if (tempVar.isMandatory() == true) {
					ADialog(Alert.AlertType.INFORMATION, "ALERT", null, "This module is Mandatory for your course.");		    		
				}
				else {
					view.getCm_Var().getUnselectedunTerm2_Var().add(view.getCm_Var().getRemoveModuleTerm2Views());
					view.getCm_Var().getSelectedselT2_VAR().remove(tempVar);
				}
				view.getCm_Var().updateCombo_Box();
                
                
                }}

	private class add_Module_PReset_Event_Handler_M implements EventHandler<ActionEvent> {
		public void handle(ActionEvent e) {
                
				view.getCm_Var().clear_Txt();
				view.getCm_Var().populate_Module_s(model.getStudentCourse());
		 	
                 
                 
                 
                 }}




}

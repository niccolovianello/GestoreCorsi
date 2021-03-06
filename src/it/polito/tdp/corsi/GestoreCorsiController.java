package it.polito.tdp.corsi;

import java.net.URL;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.ResourceBundle;

import it.polito.tdp.corsi.model.Corso;
import it.polito.tdp.corsi.model.GestoreCorsi;
import it.polito.tdp.corsi.model.Studente;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class GestoreCorsiController {

	private GestoreCorsi model;
	
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextArea txtResult;

    @FXML
    private TextField txtPeriodo;
    
    @FXML
    private TextField txtCorso;

    @FXML
    private Button btnCercaCorsi;

    @FXML
    private Button btnStatCorsi;
    
    @FXML
    private Button btnElencoStudenti;

    @FXML
    private Button btnStatCDS;

    @FXML
    void doCalcolaStatCorsi(ActionEvent event) {
    	
	    Integer periodo=0;
	    
	   	try {
	   		txtResult.clear();
	    	periodo = Integer.parseInt(txtPeriodo.getText());
	    	
	    	if(periodo!=1 && periodo!=2) {
			    txtResult.appendText("Devi inserire un periodo(1 o 2)");
			    return;
			}
			
		    Map<Corso,Integer> res=model.getIscrittiCorsi(Integer.parseInt(txtPeriodo.getText().trim()));
		    	
		    for(Entry entry: res.entrySet())
		    	this.txtResult.appendText(entry.toString()+"\n");
		    
		} catch(NumberFormatException e) {
		    txtResult.appendText("Devi inserire un periodo(1 o 2)");
		    return;
		 }
    	
    }


    @FXML
    void doCalcolaStatCds(ActionEvent event) {

    }
    
    @FXML
    void doElencoStudenti(ActionEvent event) {
    
    	String codins = txtCorso.getText();
    	List<Studente> studenti = this.model.elencaStudenti(codins);
    	for(Studente s : studenti) {
    		txtResult.appendText(s.toString()+"\n");
    	}
    }
    
    @FXML
    void doCercaCorsi(ActionEvent event) {
    	txtResult.clear();
    	int periodo;
    	try {
    		periodo = Integer.parseInt(txtPeriodo.getText());
    	} catch (NumberFormatException e) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}
    	if(periodo != 1 && periodo != 2) {
    		txtResult.appendText("Devi inserire un periodo (1 o 2)");
    		return;
    	}
    	
    	List<Corso> corsi = this.model.getCorsiByPeriodo(periodo);
    	for(Corso c : corsi) {
    		txtResult.appendText(c.toString() + "\n");
    	}
    	
    }

    @FXML // This method is called by the FXMLLoader when initialization is complete
    void initialize() {
        assert txtResult != null : "fx:id=\"txtResult\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert txtPeriodo != null : "fx:id=\"txtPeriodo\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnCercaCorsi != null : "fx:id=\"btnCercaCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnStatCorsi != null : "fx:id=\"btnStatCorsi\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnElencoStudenti != null : "fx:id=\"btnElencoStudenti\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
        assert btnStatCDS != null : "fx:id=\"btnStatCDS\" was not injected: check your FXML file 'GestoreCorsi.fxml'.";
    }
    
    public void setModel(GestoreCorsi model) {
    	this.model = model;
    }
    
}
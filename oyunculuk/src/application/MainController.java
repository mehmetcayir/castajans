package application;


import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import varliklar.Oyuncu;

public class MainController {
	public TextField tcNo_giris;
	public TextField dgYil_giris;
	public ListView<String> sonuc_listesi;
	
	public TextField tcNo_kayit;
	public TextField adSoyad_kayit;
	public TextField dgYil_kayit;
	public ComboBox<?> cinsiyetSec_kayit;
	public String cinisyetSecilen;
	public TextField telNo_kayit;
	public TextField ySehir_kayit;
	public ComboBox<?> projeSec_kayit;
	public String projeSecilen;
	public CheckBox dizi_kayit;
	public CheckBox film_kayit;
	public CheckBox kfilm_kayit;
	public CheckBox tiyatro_kayit;
	public CheckBox reklam_kayit;
	public CheckBox mklibi_kayit;
	
	public Label sonuc;
	
	
	public void Sorgula(ActionEvent e) {
		Oyuncu oc = new Oyuncu();
		oc.setTcNo(Long.parseLong(tcNo_giris.getText()));
		oc.setDgYili(Long.parseLong(dgYil_giris.getText()));
		if (oc.getTcNo()==1234 && oc.getDgYili()==1234) {
			try {
				FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("Admin.fxml"));
				Parent root1 = (Parent) fxmlLoader.load();
				Stage stage = new Stage();
				stage.setScene(new Scene(root1));  
				stage.show();
				
			} catch (Exception e2) {
				System.out.println("Ekran Açýlamadý");
			}
		}else {
			sonuc_listesi.getItems().clear();
			sonuc_listesi.getItems().add(oc.OyuncuSorgula());
			
		}
		
		
		
	}

	public void Basvur(ActionEvent e) {
		
		Oyuncu oc = new Oyuncu();
		try {
			oc.setTcNo(Long.parseLong(tcNo_kayit.getText()));
			oc.setAdSoyad(adSoyad_kayit.getText());
			oc.setDgYili(Long.parseLong(dgYil_kayit.getText()));
			oc.setCinsiyet(cinsiyetSec_kayit.getSelectionModel().getSelectedItem().toString());
			oc.setTelNo(Long.parseLong(telNo_kayit.getText()));
			oc.setySehir(ySehir_kayit.getText());
			oc.setProje(projeSec_kayit.getSelectionModel().getSelectedItem().toString());
			String dizi="",film="",tiyatro="",kfilm="",reklam="",mklibi="";
			
			if (dizi_kayit.isSelected()) {
				dizi="Dizi";
				oc.setCalistigiProje(dizi);
			}else if (film_kayit.isSelected()) {
				film="Film";
				oc.setCalistigiProje(film);
			}else if (kfilm_kayit.isSelected()) {
				kfilm="Kýsa Film";
				oc.setCalistigiProje(kfilm);
			}else if (tiyatro_kayit.isSelected()) {
				tiyatro="Tiyatro";
				oc.setCalistigiProje(tiyatro);
			}else if (reklam_kayit.isSelected()) {
				reklam="Reklam";
				oc.setCalistigiProje(reklam);
			}else if (mklibi_kayit.isSelected()) {
				mklibi="Müzik Klibi";
				oc.setCalistigiProje(mklibi);
			}else {
				oc.setCalistigiProje("Deneyim yok");				
			}
			oc.OyuncuEkle();
			sonuc.setText("Kayýt Baþarýlý");
		} catch (Exception e2) {

			sonuc.setText("Bilgileri Hatalý Girdiniz!");
		}
		
		
		
	}
}

package application;

import java.util.ArrayList;

import dosya.DosyaIslem;
import javafx.event.ActionEvent;
import javafx.scene.control.CheckBox;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import varliklar.Firma;
import varliklar.Oyuncu;

public class AdminController {

	public ListView<String> oyuncu_listesi;
	public ListView<String> firma_listesi;
	public Label Sonuc;

	public TextField firmaAdi_kayit;
	public TextField projeAdi_kayit;
	public TextField projeKonusu_kayit;
	public ComboBox<?> cinsiyet_kayit;
	public String cinsiyetSecilen;
	public TextField oyuncuSayisi_kayit;
	public ComboBox<?> projeTuru_kayit;
	public Label projeTuru_label;
	public TextField projeAdet;
	public String projeTuruSecilen;
	public Label sonuc_kayit;

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

	public void ListeGuncelle(ActionEvent e) {
		oyuncu_listesi.getItems().clear();
		firma_listesi.getItems().clear();
		ArrayList<String> okunan = new ArrayList<String>();
		DosyaIslem di = new DosyaIslem();
		okunan = di.OyuncuDosyaOkuma();
		for (int i = 0; i < okunan.size(); i++) {
			oyuncu_listesi.getItems().add(okunan.get(i));
		}
		okunan.clear();
		okunan = di.FirmaDosyaOkuma();
		for (int i = 0; i < okunan.size(); i++) {
			firma_listesi.getItems().add(okunan.get(i));
		}
	}

	public void OyuncuSil(ActionEvent e) {
		Oyuncu o = new Oyuncu();
		String oSil = oyuncu_listesi.getSelectionModel().getSelectedItem();
		o.OyuncuSil(oSil);
		ListeGuncelle(e);
		Sonuc.setText("Seçilen Oyuncu Silindi");

	}

	public void FirmaSil(ActionEvent e) {
		Firma f = new Firma();
		String fSil = firma_listesi.getSelectionModel().getSelectedItem();
		f.FirmaSil(fSil);
		ListeGuncelle(e);
		Sonuc.setText("Seçilen Firma Silindi");
	}

	public void Eslestir(ActionEvent e) {
		Oyuncu o = new Oyuncu();
		DosyaIslem di = new DosyaIslem();
		String oSec = oyuncu_listesi.getSelectionModel().getSelectedItem();
		String fSec = firma_listesi.getSelectionModel().getSelectedItem();

		String birlestir = oSec + " / " + fSec;
		di.EslestirDosyaYazma(birlestir);
		o.OyuncuSil(oSec);
		ListeGuncelle(e);
		Sonuc.setText("Eþleþtirme Baþarýlý");
	}

	public void FirmaKaydet(ActionEvent e) {
		Firma f = new Firma();
		try {
			f.setFirmaAdi(firmaAdi_kayit.getText());
			f.getPj().setProjeAdi(projeAdi_kayit.getText());
			f.getPj().setProjeKonusu(projeKonusu_kayit.getText());
			f.getPj().setCinsiyet(cinsiyet_kayit.getSelectionModel().getSelectedItem().toString());
			f.getPj().setOyuncuSayisi(Integer.parseInt(oyuncuSayisi_kayit.getText()));
			f.getPj().setProjeTuru(projeTuru_kayit.getSelectionModel().getSelectedItem().toString());
			if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Dizi")) {
				f.getDz().setBolumSayisi(Integer.parseInt(projeAdet.getText()));
				f.FirmaEkleDizi();
				
			}else if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Film")) {
				f.getFl().setSeriSayisi(Integer.parseInt(projeAdet.getText()));
				f.FirmaEkleFilm();

				
			}else if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Kýsa Film")) {
				f.getKf().setSahneSayisi(Integer.parseInt(projeAdet.getText()));
				f.FirmaEkleKFilm();
				
			}else if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Müzik Klibi")) {
				f.getMk().setSahneSayisi(Integer.parseInt(projeAdet.getText()));
				f.FirmaEkleMKlib();
				
			}else if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Reklam")) {
				f.getRk().setReklamAdeti(Integer.parseInt(projeAdet.getText()));
				f.FirmaEkleReklam();
				
			}else if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Tiyatro")) {
				f.getTy().setSahneSayisi(Integer.parseInt(projeAdet.getText()));
				f.FirmaEkleTiyatro();
				
			}
			ListeGuncelle(e);
			sonuc_kayit.setText("Firma Kaydý Baþarýlý.");

		} catch (Exception e2) {
			sonuc_kayit.setText("Girilen Bilgiler Hatalý!");
		}

	}

	public void OyuncuKaydet(ActionEvent e) {

		Oyuncu oc = new Oyuncu();
		try {
			oc.setTcNo(Long.parseLong(tcNo_kayit.getText()));
			oc.setAdSoyad(adSoyad_kayit.getText());
			oc.setDgYili(Long.parseLong(dgYil_kayit.getText()));
			oc.setCinsiyet(cinsiyetSec_kayit.getSelectionModel().getSelectedItem().toString());
			oc.setTelNo(Long.parseLong(telNo_kayit.getText()));
			oc.setySehir(ySehir_kayit.getText());
			oc.setProje(projeSec_kayit.getSelectionModel().getSelectedItem().toString());
			String dizi = "", film = "", tiyatro = "", kfilm = "", reklam = "", mklibi = "";

			if (dizi_kayit.isSelected()) {
				dizi = "Dizi";
				oc.setCalistigiProje(dizi);
			} else if (film_kayit.isSelected()) {
				film = "Film";
				oc.setCalistigiProje(film);
			} else if (kfilm_kayit.isSelected()) {
				kfilm = "Kýsa Film";
				oc.setCalistigiProje(kfilm);
			} else if (tiyatro_kayit.isSelected()) {
				tiyatro = "Tiyatro";
				oc.setCalistigiProje(tiyatro);
			} else if (reklam_kayit.isSelected()) {
				reklam = "Reklam";
				oc.setCalistigiProje(reklam);
			} else if (mklibi_kayit.isSelected()) {
				mklibi = "Müzik Klibi";
				oc.setCalistigiProje(mklibi);
			} else {
				oc.setCalistigiProje("Deneyim yok");
			}
			oc.OyuncuEkle();
			ListeGuncelle(e);
			sonuc.setText("Kayýt Baþarýlý");
		} catch (Exception e2) {

			sonuc.setText("Bilgileri Hatalý Girdiniz!");
		}

	}

	public void OyuncuGuncelle(ActionEvent e) {
		String oSec = oyuncu_listesi.getSelectionModel().getSelectedItem();
		Oyuncu oc = new Oyuncu();
		try {
			oc.setTcNo(Long.parseLong(tcNo_kayit.getText()));
			oc.setAdSoyad(adSoyad_kayit.getText());
			oc.setDgYili(Long.parseLong(dgYil_kayit.getText()));
			oc.setCinsiyet(cinsiyetSec_kayit.getSelectionModel().getSelectedItem().toString());
			oc.setTelNo(Long.parseLong(telNo_kayit.getText()));
			oc.setySehir(ySehir_kayit.getText());
			oc.setProje(projeSec_kayit.getSelectionModel().getSelectedItem().toString());
			String dizi = "", film = "", tiyatro = "", kfilm = "", reklam = "", mklibi = "";

			if (dizi_kayit.isSelected()) {
				dizi = "Dizi";
				oc.setCalistigiProje(dizi);
			} else if (film_kayit.isSelected()) {
				film = "Film";
				oc.setCalistigiProje(film);
			} else if (kfilm_kayit.isSelected()) {
				kfilm = "Kýsa Film";
				oc.setCalistigiProje(kfilm);
			} else if (tiyatro_kayit.isSelected()) {
				tiyatro = "Tiyatro";
				oc.setCalistigiProje(tiyatro);
			} else if (reklam_kayit.isSelected()) {
				reklam = "Reklam";
				oc.setCalistigiProje(reklam);
			} else if (mklibi_kayit.isSelected()) {
				mklibi = "Müzik Klibi";
				oc.setCalistigiProje(mklibi);
			} else {
				oc.setCalistigiProje("Deneyim yok");
			}
			oc.OyuncuGuncelle(oSec);
			ListeGuncelle(e);
			sonuc.setText("Güncelleme Baþarýlý");
		} catch (Exception e2) {

			sonuc.setText("Bilgileri Hatalý Girdiniz!");
		}

	}
	public void FirmaGuncelle(ActionEvent e) {
		String fSec = firma_listesi.getSelectionModel().getSelectedItem();
		Firma f = new Firma();
		try {
			f.setFirmaAdi(firmaAdi_kayit.getText());
			f.getPj().setProjeAdi(projeAdi_kayit.getText());
			f.getPj().setProjeKonusu(projeKonusu_kayit.getText());
			f.getPj().setCinsiyet(cinsiyet_kayit.getSelectionModel().getSelectedItem().toString());
			f.getPj().setOyuncuSayisi(Integer.parseInt(oyuncuSayisi_kayit.getText()));
			f.getPj().setProjeTuru(projeTuru_kayit.getSelectionModel().getSelectedItem().toString());
			if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Dizi")) {
				f.getDz().setBolumSayisi(Integer.parseInt(projeAdet.getText()));
				f.FirmaGuncelleDizi(fSec);
				
			}else if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Film")) {
				f.getFl().setSeriSayisi(Integer.parseInt(projeAdet.getText()));
				f.FirmaGuncelleFilm(fSec);

				
			}else if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Kýsa Film")) {
				f.getKf().setSahneSayisi(Integer.parseInt(projeAdet.getText()));
				f.FirmaGuncelleKFilm(fSec);
				
			}else if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Müzik Klibi")) {
				f.getMk().setSahneSayisi(Integer.parseInt(projeAdet.getText()));
				f.FirmaGuncelleMKlib(fSec);
				
			}else if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Reklam")) {
				f.getRk().setReklamAdeti(Integer.parseInt(projeAdet.getText()));
				f.FirmaGuncelleReklam(fSec);
				
			}else if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Tiyatro")) {
				f.getTy().setSahneSayisi(Integer.parseInt(projeAdet.getText()));
				f.FirmaGuncelleTiyatro(fSec);
				
			}
			ListeGuncelle(e);
			sonuc_kayit.setText("Güncelleme Baþarýlý."); 

		} catch (Exception e2) {
			sonuc_kayit.setText("Girilen Bilgiler Hatalý!");
		}
		
	}
	
	public void ProjeSec(ActionEvent e) {
		if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Dizi")) {
			projeTuru_label.setText("Bölüm Sayýsý");
			projeTuru_label.setVisible(true);
			projeAdet.setVisible(true);
		}else if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Film")) {
			projeTuru_label.setText("Sezon Sayýsý");
			projeTuru_label.setVisible(true);
			projeAdet.setVisible(true);
			
		}else if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Kýsa Film")) {
			projeTuru_label.setText("Sahne Sayýsý");
			projeTuru_label.setVisible(true);
			projeAdet.setVisible(true);
			
		}else if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Müzik Klibi")) {
			projeTuru_label.setText("Sahne Süresi");
			projeTuru_label.setVisible(true);
			projeAdet.setVisible(true);
			
		}else if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Reklam")) {
			projeTuru_label.setText("Reklam Adeti");
			projeTuru_label.setVisible(true);
			projeAdet.setVisible(true);
			
		}else if (projeTuru_kayit.getSelectionModel().getSelectedItem().equals("Tiyatro")) {
			projeTuru_label.setText("Sahne Sayýsý");
			projeTuru_label.setVisible(true);
			projeAdet.setVisible(true);
			
		}
	}

}

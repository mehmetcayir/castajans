package application;


import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.fxml.FXMLLoader;

//
public class Main extends Application  {
	
	  @Override public void start(Stage primaryStage) { try { AnchorPane root =
	  (AnchorPane)FXMLLoader.load(getClass().getResource("Main.fxml")); Scene scene
	  = new Scene(root,651,520);
	  scene.getStylesheets().add(getClass().getResource("application.css").
	  toExternalForm()); primaryStage.setScene(scene); primaryStage.show(); }
	  catch(Exception e) { e.printStackTrace(); } }
	 

	public static void main(String[] args) {
		launch(args);
		/*
		Oyuncu o = new Oyuncu();
		Firma f = new Firma();
		System.out.println("--------------------");
		System.out.println("1) Oyuncu Kaydet");
		System.out.println("2) Firma Kaydet");
		System.out.println("3) Oyuncu Listele");
		System.out.println("4) Firma Listele");
		System.out.println("5) Oyuncu Firma Eþleþtir");
		System.out.println("6) Oyuncu Sil");
		System.out.println("7) Firma Sil");
		System.out.println("8) Eþleþtirileri Listele");
		System.out.println("Ýþlem Numarasýný Giriniz:");
		
		Scanner scan = new Scanner(System.in);
		int giris = scan.nextInt();
		if (giris==1) {
			System.out.println("-------------");
			System.out.println("TC Giriniz:");
			Scanner tcscan = new Scanner(System.in);
			o.setTcNo(tcscan.nextInt());
			System.out.println("Ad Soyad Giriniz:");
			Scanner adsoyadscan = new Scanner(System.in);
			o.setAdSoyad(adsoyadscan.nextLine());
			System.out.println("Doðum Yýlý Giriniz:");
			Scanner dtscan = new Scanner(System.in);
			o.setDgYili(dtscan.nextInt());
			System.out.println("Cinsiyet Giriniz:");
			Scanner cscan = new Scanner(System.in);
			o.setCinsiyet(cscan.nextLine());
			System.out.println("Tel No Giriniz:");
			Scanner telscan = new Scanner(System.in);
			o.setTelNo(telscan.nextInt());
			System.out.println("Yaþadýðý Þehir Giriniz:");
			Scanner sscan = new Scanner(System.in);
			o.setySehir(sscan.nextLine());
			System.out.println("Çalýþmak Ýstediði Proje Giriniz:");
			Scanner pscan = new Scanner(System.in);
			o.setProje(pscan.nextLine());
			System.out.println("Önceden Çalýþtýðý Proje Giriniz:");
			Scanner oscan = new Scanner(System.in);
			o.setCalistigiProje(oscan.nextLine());
			o.OyuncuEkle();
			
			
		}else if(giris==2) {

			System.out.println("-------------");
			System.out.println("Fimra Adý Giriniz:");
			Scanner firmascan = new Scanner(System.in);
			f.setFirmaAdi(firmascan.nextLine());
			System.out.println("Proje Adý Giriniz:");
			Scanner projescan = new Scanner(System.in);
			f.getPj().setProjeAdi(projescan.nextLine());
			System.out.println("Proje Konusu Giriniz:");
			Scanner pkscan = new Scanner(System.in);
			f.getPj().setProjeKonusu(pkscan.nextLine());
			System.out.println("Oyuncu Sayýsý Giriniz:");
			Scanner osscan = new Scanner(System.in);
			f.getPj().setOyuncuSayisi(osscan.nextInt());
			System.out.println("Cinsiyet Giriniz:");
			Scanner cscan = new Scanner(System.in);
			f.getPj().setCinsiyet(cscan.nextLine());
			System.out.println("Baþlangýç Yýlý Giriniz:");
			Scanner byscan = new Scanner(System.in);
			f.getPj().setbTarihi(byscan.nextInt());
			System.out.println("Proje Türü Giriniz:");
			Scanner ptscan = new Scanner(System.in);
			f.getPj().setProjeTuru(ptscan.nextLine());
			f.FirmaEkle();
			
		}else if(giris==3) {
			System.out.println("-------------");
			o.OyuncuListele();
			
		}else if(giris==4) {
			System.out.println("-------------");
			f.FirmaListele();
			
		}else if(giris==5) {
			DosyaIslem es = new DosyaIslem();
			o.OyuncuListele();
			System.out.println("\nSeçtiðiniz Oyuncuyu Listedeki Formata Göre(- dahil) Giriniz:");
			Scanner girdi = new Scanner(System.in);
			String oyuncuscan=girdi.nextLine();
			
			String oyuncu = es.EslestirOyuncuSec(oyuncuscan);
			f.FirmaListele();
			System.out.println("\nSeçtiðiniz Firmanýn Bilgilerini Listedeki Formata Göre(- dahil) Giriniz:");
			Scanner girdi2 = new Scanner(System.in);
			String firmascan=girdi2.nextLine();
			String firma = es.EslestirFirmaSec(firmascan);
			System.out.println("Eþleþtirmeyi Yapmak Ýstiyor Musunuz?(1/2)");
			Scanner eOnay = new Scanner(System.in);
			int eOnay1=eOnay.nextInt();
			if (eOnay1==1) {
				String birlestir=oyuncu+" / "+firma;
				es.EslestirDosyaYazma(birlestir);
				o.OyuncuSil(oyuncuscan);
				}else {
				System.out.println("Ýþlem Ýptal Edildi.");
			}
			
		}else if(giris == 6) {
			o.OyuncuListele();
			System.out.println("Silmek Ýstediðiniz Oyuncuyu Listedeki Formata Uygun(- dahil!) yazýnýz!");
			Scanner oSil = new Scanner(System.in);
			String oSil1 = oSil.nextLine();
			o.OyuncuSil(oSil1);
			System.out.println("Silme Ýþlemi Baþarýlý.");
		}else if(giris == 7) {
			f.FirmaListele();
			System.out.println("Silmek Ýstediðiniz Firmayý Listedeki Formata Uygun(- dahil!) yazýnýz!");
			Scanner fSil = new Scanner(System.in);
			String fSil1 = fSil.nextLine();
			f.FirmaSil(fSil1);
			System.out.println("Silme Ýþlemi Baþarýlý.");
		}else if(giris==8) {
			DosyaIslem es = new DosyaIslem();
			es.EslestirDosyaOkuma();
			
		}
		*/
}
}

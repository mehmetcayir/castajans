package dosya;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.DataInputStream;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.util.ArrayList;


public class DosyaIslem {
	//EÞLERÞTÝR DOSYA ÝÞLEMLERÝ
	public void EslestirDosyaYazma(String a) {
		ArrayList<String> veri = new ArrayList<>();
		String st = a;
		veri.add(st);

		FileWriter fWriter = null;
		BufferedWriter writer = null;
		try {
			fWriter = new FileWriter("eslestir.txt", true);
			writer = new BufferedWriter(fWriter);
			for (int i = 0; i < veri.size(); i++) {
				writer.write(veri.get(i));
				writer.newLine();
				System.out.println(veri.get(i));
			}
			writer.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}
	
	public String EslestirOyuncuSorgula(Long girdi1, Long girdi2) {
		String str;
		String dondur="";
		ArrayList<String> veri = new ArrayList<String>();
		try {
			FileInputStream fStream = new FileInputStream("Eslestir.txt");
			DataInputStream dStream = new DataInputStream(fStream);
			@SuppressWarnings("resource")
			BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));
			while ((str=bReader.readLine()) != null) {
				veri.add(str);
			}
			dStream.close();
			Boolean a=false;
			int b=-1;
			for (int i = 0; i < veri.size(); i++) {
				String arama=veri.get(i);
				if (arama.contains(girdi1.toString()) && arama.contains(girdi2.toString())) {
					b=i;
					dondur=veri.get(i);
					a=true;
				}
			}
			if(a==true) {
				System.out.println(veri.get(b));
				
			}else {
				dondur="Maalesef Proje Bulunamadý";
				System.out.println("Maalesef Proje Bulunamadý");				
			}
			
		} catch (Exception e) {
			System.err.println("Hata: "+ e.getMessage());
		}

		return dondur;
	}

	//OYUNCU DOSYA ÝÞLEMLERÝ
	public ArrayList<String> OyuncuDosyaOkuma() {
		String str;
		ArrayList<String> veri = new ArrayList<String>();
		try {
			FileInputStream fStream = new FileInputStream("oyuncu_listesi.txt");
			DataInputStream dStream = new DataInputStream(fStream);
			@SuppressWarnings("resource")
			BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));

			while ((str = bReader.readLine()) != null) {
				veri.add(str);
			}
			dStream.close();

		} catch (Exception e) {
			System.err.println("Hata: " + e.getMessage());
		}
		for (int k = 0; k < veri.size(); k++) {
			System.out.println(veri.get(k));
		}
		return veri;
	}

	public void OyuncuDosyaYazma(String a) {
		ArrayList<String> veri = new ArrayList<>();
		String st = a;
		veri.add(st);

		FileWriter fWriter = null;
		BufferedWriter writer = null;
		try {
			fWriter = new FileWriter("oyuncu_listesi.txt", true);
			writer = new BufferedWriter(fWriter);
			for (int i = 0; i < veri.size(); i++) {
				writer.write(veri.get(i));
				writer.newLine();
				System.out.println(veri.get(i));
			}
			writer.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void OyuncuDosyaSilme(String s) {
		String str;
		ArrayList<String> veri = new ArrayList<String>();
		try {
			FileInputStream fStream = new FileInputStream("oyuncu_listesi.txt");
			DataInputStream dStream = new DataInputStream(fStream);
			@SuppressWarnings("resource")
			BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));

			while ((str = bReader.readLine()) != null) {
				veri.add(str);
			}
			for (int j = 0; j < veri.size(); j++) {
				String aranan = veri.get(j);
				if (aranan.contains(s)) {
					veri.remove(j);					
				}
			}
			dStream.close();
			FileWriter fWriter = null;
			BufferedWriter writer = null;
			try {
				fWriter = new FileWriter("oyuncu_listesi.txt");
				writer = new BufferedWriter(fWriter);
				for (int i = 0; i < veri.size(); i++) {
					writer.write(veri.get(i));
					writer.newLine();
					System.out.println(veri.get(i));
				}
				writer.close();

			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (Exception e) {
			System.err.println("Hata: " + e.getMessage());
		}
	}
	
	public void OyuncuDosyaGuncelle(String oSec, String yazi) {
		String str;
		ArrayList<String> veri = new ArrayList<String>();
		try {
			FileInputStream fStream = new FileInputStream("oyuncu_listesi.txt");
			DataInputStream dStream = new DataInputStream(fStream);
			@SuppressWarnings("resource")
			BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));

			while ((str = bReader.readLine()) != null) {
				veri.add(str);
			}
			for (int j = 0; j < veri.size(); j++) {
				String aranan = veri.get(j);
				if (aranan.contains(oSec)) {
					veri.remove(j);
					veri.add(yazi);
				}
			}
			dStream.close();
			FileWriter fWriter = null;
			BufferedWriter writer = null;
			try {
				fWriter = new FileWriter("oyuncu_listesi.txt");
				writer = new BufferedWriter(fWriter);
				for (int i = 0; i < veri.size(); i++) {
					writer.write(veri.get(i));
					writer.newLine();
					System.out.println(veri.get(i));
				}
				writer.close();

			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (Exception e) {
			System.err.println("Hata: " + e.getMessage());
		}
		
	}

	//FÝRMA DOSYA ÝÞLEMLERÝ
	public ArrayList<String> FirmaDosyaOkuma() {
		String str;
		ArrayList<String> veri = new ArrayList<String>();
		try {
			FileInputStream fStream = new FileInputStream("firma_listesi.txt");
			DataInputStream dStream = new DataInputStream(fStream);
			@SuppressWarnings("resource")
			BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));
			
			while ((str=bReader.readLine()) != null) {
				veri.add(str);
			}
			dStream.close();
			
		} catch (Exception e) {
			System.err.println("Hata: "+ e.getMessage());
		}
		for (int k = 0; k < veri.size(); k++) {
			System.out.println(veri.get(k));
		}
		return veri;
	}
	
	public void FirmaDosyaYazma(String a) {
		ArrayList<String> veri = new ArrayList<>();
		String st = a;
		veri.add(st);

		FileWriter fWriter = null;
		BufferedWriter writer = null;
		try {
			fWriter = new FileWriter("firma_listesi.txt", true);
			writer = new BufferedWriter(fWriter);
			for (int i = 0; i < veri.size(); i++) {
				writer.write(veri.get(i));
				writer.newLine();
				System.out.println(veri.get(i));
			}
			writer.close();

		} catch (Exception e) {
			// TODO: handle exception
		}

	}

	public void FirmaDosyaSilme(String s) {
		String str;
		ArrayList<String> veri = new ArrayList<String>();
		try {
			FileInputStream fStream = new FileInputStream("firma_listesi.txt");
			DataInputStream dStream = new DataInputStream(fStream);
			@SuppressWarnings("resource")
			BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));

			while ((str = bReader.readLine()) != null) {
				veri.add(str);
			}
			for (int j = 0; j < veri.size(); j++) {
				String aranan = veri.get(j);
				if (aranan.contains(s)) {
					veri.remove(j);					
				}
			}
			dStream.close();
			FileWriter fWriter = null;
			BufferedWriter writer = null;
			try {
				fWriter = new FileWriter("firma_listesi.txt");
				writer = new BufferedWriter(fWriter);
				for (int i = 0; i < veri.size(); i++) {
					writer.write(veri.get(i));
					writer.newLine();
					System.out.println(veri.get(i));
				}
				writer.close();

			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (Exception e) {
			System.err.println("Hata: " + e.getMessage());
		}
	}
	
	public void FirmaDosyaGuncelle(String fSec, String yazi) {
		String str;
		ArrayList<String> veri = new ArrayList<String>();
		try {
			FileInputStream fStream = new FileInputStream("firma_listesi.txt");
			DataInputStream dStream = new DataInputStream(fStream);
			@SuppressWarnings("resource")
			BufferedReader bReader = new BufferedReader(new InputStreamReader(dStream));

			while ((str = bReader.readLine()) != null) {
				veri.add(str);
			}
			for (int j = 0; j < veri.size(); j++) {
				String aranan = veri.get(j);
				if (aranan.contains(fSec)) {
					veri.remove(j);	
					veri.add(yazi);
				}
			}
			dStream.close();
			FileWriter fWriter = null;
			BufferedWriter writer = null;
			try {
				fWriter = new FileWriter("firma_listesi.txt");
				writer = new BufferedWriter(fWriter);
				for (int i = 0; i < veri.size(); i++) {
					writer.write(veri.get(i));
					writer.newLine();
					System.out.println(veri.get(i));
				}
				writer.close();

			} catch (Exception e) {
				// TODO: handle exception
			}

		} catch (Exception e) {
			System.err.println("Hata: " + e.getMessage());
		}
		
		
	}

}

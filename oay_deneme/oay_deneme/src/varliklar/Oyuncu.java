package varliklar;


import dosya.DosyaIslem;

public class Oyuncu {
	private long tcNo;
	private String adSoyad;
	private long dgYili;
	private String Cinsiyet;
	private long telNo;
	private String ySehir;
	private String proje;
	private String calistigiProje;
	
	
	public void OyuncuEkle() {
		String yazi =String.valueOf(getTcNo())+" - "+getAdSoyad()+" - "+String.valueOf(getDgYili())+" - "+getCinsiyet()+" - "+String.valueOf(getTelNo())+" - "+getySehir()+" - "+getProje()+" - "+getCalistigiProje();
		DosyaIslem di = new DosyaIslem();
		di.OyuncuDosyaYazma(yazi);
		
	}
	
	public void OyuncuSil(String s) {
		DosyaIslem di = new DosyaIslem();
		di.OyuncuDosyaSilme(s);
		
	}
	
	public String OyuncuSorgula() {
		String dongu="";
		DosyaIslem e = new DosyaIslem();
		dongu=e.EslestirOyuncuSorgula(this.getTcNo(), this.getDgYili());
		return dongu;
	}
	
	public void OyuncuGuncelle(String oSec) {
		String yazi =String.valueOf(getTcNo())+" - "+getAdSoyad()+" - "+String.valueOf(getDgYili())+" - "+getCinsiyet()+" - "+String.valueOf(getTelNo())+" - "+getySehir()+" - "+getProje()+" - "+getCalistigiProje();
		DosyaIslem di = new DosyaIslem();
		di.OyuncuDosyaGuncelle(oSec,yazi);
		
	}
	
	public long getTcNo() {
		return tcNo;
	}

	public void setTcNo(long tcNo) {
		this.tcNo = tcNo;
	}

	public String getAdSoyad() {
		return adSoyad;
	}

	public void setAdSoyad(String adSoyad) {
		this.adSoyad = adSoyad;
	}

	public long getDgYili() {
		return dgYili;
	}

	public void setDgYili(long dgYili) {
		this.dgYili = dgYili;
	}

	public String getCinsiyet() {
		return Cinsiyet;
	}

	public void setCinsiyet(String cinsiyet) {
		Cinsiyet = cinsiyet;
	}

	public long getTelNo() {
		return telNo;
	}

	public void setTelNo(long telNo) {
		this.telNo = telNo;
	}

	public String getySehir() {
		return ySehir;
	}

	public void setySehir(String ySehir) {
		this.ySehir = ySehir;
	}

	public String getProje() {
		return proje;
	}

	public void setProje(String proje) {
		this.proje = proje;
	}

	public String getCalistigiProje() {
		return calistigiProje;
	}

	public void setCalistigiProje(String calistigiProje) {
		this.calistigiProje = calistigiProje;
	}
	
	

}

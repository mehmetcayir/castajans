package projeler;

public class proje {
	
	private String projeAdi;
	private String projeKonusu;
	private int oyuncuSayisi;
	private String cinsiyet;
	private int bTarihi;
	private String projeTuru;
	
	
	
	
	public proje() {
		super();
	}
	
	public proje(String projeAdi, String projeKonusu, int oyuncuSayisi, String cinsiyet, int bTarihi,
			String projeTuru) {
		super();
		this.projeAdi = projeAdi;
		this.projeKonusu = projeKonusu;
		this.oyuncuSayisi = oyuncuSayisi;
		this.cinsiyet = cinsiyet;
		this.bTarihi = bTarihi;
		this.projeTuru = projeTuru;
	}

	
	public String getProjeAdi() {
		return projeAdi;
	}
	public void setProjeAdi(String projeAdi) {
		this.projeAdi = projeAdi;
	}
	public String getProjeKonusu() {
		return projeKonusu;
	}
	public void setProjeKonusu(String projeKonusu) {
		this.projeKonusu = projeKonusu;
	}
	public int getOyuncuSayisi() {
		return oyuncuSayisi;
	}
	public void setOyuncuSayisi(int oyuncuSayisi) {
		this.oyuncuSayisi = oyuncuSayisi;
	}
	public String getCinsiyet() {
		return cinsiyet;
	}
	public void setCinsiyet(String cinsiyet) {
		this.cinsiyet = cinsiyet;
	}
	public int getbTarihi() {
		return bTarihi;
	}
	public void setbTarihi(int bTarihi) {
		this.bTarihi = bTarihi;
	}
	public String getProjeTuru() {
		return projeTuru;
	}
	public void setProjeTuru(String projeTuru) {
		this.projeTuru = projeTuru;
	}

	
}

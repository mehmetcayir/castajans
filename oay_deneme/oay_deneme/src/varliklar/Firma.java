package varliklar;

import dosya.DosyaIslem;
import projeler.Dizi;
import projeler.Film;
import projeler.KisaFilm;
import projeler.MuzikKlibi;
import projeler.Reklam;
import projeler.Tiyatro;
import projeler.proje;

public class Firma {
	proje pj = new proje();
	Dizi dz = new Dizi();
	Film fl = new Film();
	KisaFilm kf = new KisaFilm();
	Reklam rk = new Reklam();
	MuzikKlibi mk = new MuzikKlibi();
	Tiyatro ty = new Tiyatro();
	private String firmaAdi;

	public Film getFl() {
		return fl;
	}

	public void setFl(Film fl) {
		this.fl = fl;
	}

	public KisaFilm getKf() {
		return kf;
	}

	public void setKf(KisaFilm kf) {
		this.kf = kf;
	}

	public Reklam getRk() {
		return rk;
	}

	public void setRk(Reklam rk) {
		this.rk = rk;
	}

	public MuzikKlibi getMk() {
		return mk;
	}

	public void setMk(MuzikKlibi mk) {
		this.mk = mk;
	}

	public Tiyatro getTy() {
		return ty;
	}

	public void setTy(Tiyatro ty) {
		this.ty = ty;
	}

	public Dizi getDz() {
		return dz;
	}

	public void setDz(Dizi dz) {
		this.dz = dz;
	}

	public proje getPj() {
		return pj;
	}

	public void setPj(proje pj) {
		this.pj = pj;
	}

	public String getFirmaAdi() {
		return firmaAdi;
	}

	public void setFirmaAdi(String firmaAdi) {
		this.firmaAdi = firmaAdi;
	}

	public void FirmaGuncelleDizi(String fSec) {
		String yazi = getFirmaAdi() + " - " + getPj().getProjeAdi() + " - " + getPj().getProjeKonusu() + " - "
				+ String.valueOf(getPj().getOyuncuSayisi()) + " - " + getPj().getCinsiyet() + " - "
				+ String.valueOf(getPj().getbTarihi()) + " - " + getPj().getProjeTuru() + " - "
				+ getDz().getBolumSayisi();
		DosyaIslem di = new DosyaIslem();
		di.FirmaDosyaGuncelle(fSec, yazi);

	}

	public void FirmaGuncelleFilm(String fSec) {
		String yazi = getFirmaAdi() + " - " + getPj().getProjeAdi() + " - " + getPj().getProjeKonusu() + " - "
				+ String.valueOf(getPj().getOyuncuSayisi()) + " - " + getPj().getCinsiyet() + " - "
				+ String.valueOf(getPj().getbTarihi()) + " - " + getPj().getProjeTuru() + " - "
				+ getFl().getSeriSayisi();
		DosyaIslem di = new DosyaIslem();
		di.FirmaDosyaGuncelle(fSec, yazi);

	}

	public void FirmaGuncelleKFilm(String fSec) {
		String yazi = getFirmaAdi() + " - " + getPj().getProjeAdi() + " - " + getPj().getProjeKonusu() + " - "
				+ String.valueOf(getPj().getOyuncuSayisi()) + " - " + getPj().getCinsiyet() + " - "
				+ String.valueOf(getPj().getbTarihi()) + " - " + getPj().getProjeTuru() + " - "
				+ getKf().getSahneSayisi();
		DosyaIslem di = new DosyaIslem();
		di.FirmaDosyaGuncelle(fSec, yazi);

	}

	public void FirmaGuncelleReklam(String fSec) {
		String yazi = getFirmaAdi() + " - " + getPj().getProjeAdi() + " - " + getPj().getProjeKonusu() + " - "
				+ String.valueOf(getPj().getOyuncuSayisi()) + " - " + getPj().getCinsiyet() + " - "
				+ String.valueOf(getPj().getbTarihi()) + " - " + getPj().getProjeTuru() + " - "
				+ getRk().getReklamAdeti();
		DosyaIslem di = new DosyaIslem();
		di.FirmaDosyaGuncelle(fSec, yazi);

	}

	public void FirmaGuncelleMKlib(String fSec) {
		String yazi = getFirmaAdi() + " - " + getPj().getProjeAdi() + " - " + getPj().getProjeKonusu() + " - "
				+ String.valueOf(getPj().getOyuncuSayisi()) + " - " + getPj().getCinsiyet() + " - "
				+ String.valueOf(getPj().getbTarihi()) + " - " + getPj().getProjeTuru() + " - "
				+ getMk().getSahneSayisi();
		DosyaIslem di = new DosyaIslem();
		di.FirmaDosyaGuncelle(fSec, yazi);

	}

	public void FirmaGuncelleTiyatro(String fSec) {
		String yazi = getFirmaAdi() + " - " + getPj().getProjeAdi() + " - " + getPj().getProjeKonusu() + " - "
				+ String.valueOf(getPj().getOyuncuSayisi()) + " - " + getPj().getCinsiyet() + " - "
				+ String.valueOf(getPj().getbTarihi()) + " - " + getPj().getProjeTuru() + " - "
				+ getTy().getSahneSayisi();
		DosyaIslem di = new DosyaIslem();
		di.FirmaDosyaGuncelle(fSec, yazi);

	}


	public void FirmaSil(String s) {
		DosyaIslem di = new DosyaIslem();
		di.FirmaDosyaSilme(s);

	}

	public void FirmaEkleDizi() {
		String yazi = getFirmaAdi() + " - " + getPj().getProjeAdi() + " - " + getPj().getProjeKonusu() + " - "
				+ String.valueOf(getPj().getOyuncuSayisi()) + " - " + getPj().getCinsiyet() + " - "
				+ String.valueOf(getPj().getbTarihi()) + " - " + getPj().getProjeTuru() + " - "
				+ getDz().getBolumSayisi();
		DosyaIslem di = new DosyaIslem();
		di.FirmaDosyaYazma(yazi);

	}

	public void FirmaEkleFilm() {
		String yazi = getFirmaAdi() + " - " + getPj().getProjeAdi() + " - " + getPj().getProjeKonusu() + " - "
				+ String.valueOf(getPj().getOyuncuSayisi()) + " - " + getPj().getCinsiyet() + " - "
				+ String.valueOf(getPj().getbTarihi()) + " - " + getPj().getProjeTuru() + " - "
				+ getFl().getSeriSayisi();
		DosyaIslem di = new DosyaIslem();
		di.FirmaDosyaYazma(yazi);

	}

	public void FirmaEkleKFilm() {
		String yazi = getFirmaAdi() + " - " + getPj().getProjeAdi() + " - " + getPj().getProjeKonusu() + " - "
				+ String.valueOf(getPj().getOyuncuSayisi()) + " - " + getPj().getCinsiyet() + " - "
				+ String.valueOf(getPj().getbTarihi()) + " - " + getPj().getProjeTuru() + " - "
				+ getKf().getSahneSayisi();
		DosyaIslem di = new DosyaIslem();
		di.FirmaDosyaYazma(yazi);

	}

	public void FirmaEkleReklam() {
		String yazi = getFirmaAdi() + " - " + getPj().getProjeAdi() + " - " + getPj().getProjeKonusu() + " - "
				+ String.valueOf(getPj().getOyuncuSayisi()) + " - " + getPj().getCinsiyet() + " - "
				+ String.valueOf(getPj().getbTarihi()) + " - " + getPj().getProjeTuru() + " - "
				+ getRk().getReklamAdeti();
		DosyaIslem di = new DosyaIslem();
		di.FirmaDosyaYazma(yazi);

	}

	public void FirmaEkleMKlib() {
		String yazi = getFirmaAdi() + " - " + getPj().getProjeAdi() + " - " + getPj().getProjeKonusu() + " - "
				+ String.valueOf(getPj().getOyuncuSayisi()) + " - " + getPj().getCinsiyet() + " - "
				+ String.valueOf(getPj().getbTarihi()) + " - " + getPj().getProjeTuru() + " - "
				+ getMk().getSahneSayisi();
		DosyaIslem di = new DosyaIslem();
		di.FirmaDosyaYazma(yazi);

	}

	public void FirmaEkleTiyatro() {
		String yazi = getFirmaAdi() + " - " + getPj().getProjeAdi() + " - " + getPj().getProjeKonusu() + " - "
				+ String.valueOf(getPj().getOyuncuSayisi()) + " - " + getPj().getCinsiyet() + " - "
				+ String.valueOf(getPj().getbTarihi()) + " - " + getPj().getProjeTuru() + " - "
				+ getTy().getSahneSayisi();
		DosyaIslem di = new DosyaIslem();
		di.FirmaDosyaYazma(yazi);

	}

}

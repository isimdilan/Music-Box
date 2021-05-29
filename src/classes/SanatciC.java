package classes;

import java.util.logging.StreamHandler;

public class SanatciC {
	private String idsanatci;
	private String adsanatci;
	private String ulkesanatci;
	public SanatciC() {
		super();
	}
	public SanatciC(String idsanatci, String adsanatci, String ulkesanatci) {
		super();
		this.idsanatci = idsanatci;
		this.adsanatci = adsanatci;
		this.ulkesanatci = ulkesanatci;
	}
	
	public String getIdsanatci() {
		return idsanatci;
	}
	public void setIdsanatci(String idsanatci) {
		this.idsanatci = idsanatci;
	}
	public String getAdsanatci() {
		return adsanatci;
	}
	public void setAdsanatci(String adsanatci) {
		this.adsanatci = adsanatci;
	}
	public String getUlkesanatci() {
		return ulkesanatci;
	}
	public void setUlkesanatci(String ulkesanatci) {
		this.ulkesanatci = ulkesanatci;
	}
	@Override
	public String toString() {
		if(adsanatci==null && ulkesanatci==null) {return idsanatci;}
		else if(ulkesanatci==null && idsanatci==null) {return adsanatci;}
		else
		return " "+idsanatci + "  " + adsanatci + "  " + ulkesanatci;
	}
	

}

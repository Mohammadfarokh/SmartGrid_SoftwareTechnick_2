package homePageDTOs;

public class solarPanelData {
 public String name;
 public int sunrise;
 public int production;
 boolean status;
public solarPanelData(String name, int sunrise, int production, boolean status) {
	super();
	this.name = name;
	this.sunrise = sunrise;
	this.production = production;
	this.status = status;
}
 public solarPanelData() {
	 
 }

}

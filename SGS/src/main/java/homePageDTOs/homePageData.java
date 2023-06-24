package homePageDTOs;

import java.util.ArrayList;

public class homePageData {
	public ArrayList<solarPanelData> solarPanelArray=new ArrayList<solarPanelData>();
	
	public homePageData() {
		
	}

	public homePageData(ArrayList<solarPanelData> array) {
		super();
		this.solarPanelArray = array;
	}
	
}

import { Component ,OnInit} from '@angular/core';
import { HomeService } from '../services/home.service';
import { HomeData, solarPanel } from '../types/HomeData';
import { HttpClient } from '@angular/common/http';
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {

  smartgridData!: any[];
  solarPanels: any[] | undefined;
  turbine: any[] | undefined;
  difference : number | undefined;
  

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.getAllSolarPanels();
    this.getAllTurbine();
    this.getSmartgridData();
    
  
    
   
      
    /*  setInterval(() => {
        this.getAllSolarPanels();
      }, 2000);

       setInterval(() => {
       this.getAllTurbine();
       }, 2500);

      setInterval(() => {
       this.getSmartgridData();
       }, 2000);

      setInterval(() => {
       this.calculateAdjustedConsumed();
      }, 2500); */
 
  }

// ElectricityProduced
getSmartgridData() {
  this.http.get<any[]>('http://localhost:9595/smartgrid/all').subscribe(
    response => {
      this.smartgridData = response;
    });
}

// updateSmartgrid
updateSmartgridData(SmartgridData: any) {
  this.http.put<any>('http://localhost:9595/smartgrid/update', SmartgridData)
    .subscribe();
}

//Difference
calculateAdjustedConsumed(): number {
  const electricityProduced = this.smartgridData[0]?.electricityProducedv ;
  const electricityConsumed = this.smartgridData[0]?.lectricityConsumed ;

  return electricityProduced - electricityConsumed;
}



  // Solarpanell
  getAllSolarPanels() {
    this.http.get<any[]>('http://localhost:9595/solarpanel/all')
      .subscribe(
        response => {
          this.solarPanels = response;
        },
        error => {
          console.error('Error retrieving solar panels:', error);
        }
      );
  }
  updateSolarpanel(solarpanel: any) {
    solarpanel.status = !solarpanel.status;
    this.http.put<any>('http://localhost:9595/solarpanel/update', solarpanel)
      .subscribe(
        response => {
          console.log('Solarpanel updated successfully:', response);
        },
        error => {
          console.error('Error updating solarpanel:', error);
        }
      );
  }

  // Turbine
  getAllTurbine() {
    this.http.get<any[]>('http://localhost:9595/turbine/all')
      .subscribe(
        response => {
          this.turbine = response;
        },
        error => {
          console.error('Error retrieving solar panels:', error);
        }
      );
  }
  updateTurbine(turbine: any) {
    turbine.status = !turbine.status;
    this.http.put<any>('http://localhost:9595/turbine/update', turbine)
      .subscribe(
        response => {
          console.log('Solarpanel updated successfully:', response);
        },
        error => {
          console.error('Error updating solarpanel:', error);
        }
      );
  }


}

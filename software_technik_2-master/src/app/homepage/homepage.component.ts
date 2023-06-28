import { Component ,OnInit} from '@angular/core';
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
  factories: any[] | undefined;
  batteries: any[]| undefined;
  difference : number | undefined;

  constructor(private http: HttpClient) {}

  ngOnInit() {
   
    this.getAllTurbine();
    this.getAllSolarPanels();
    this.getSmartgridData();
    this.calculateAdjustedConsumed();
   
    /*
      setInterval(() => {
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
  this.http.get<any[]>('http://localhost:9595/smartgrid/all').subscribe({
    next:response => {
      console.log('Smart grid data:', response);
      this.smartgridData = response;
    },
    error:  error => {
        console.error('Error retrieving smart grid data:', error);
      }
    });
}

// updateSmartgrid
updateSmartgridData(SmartgridData: any) {
  this.http.put<any>('http://localhost:9595/smartgrid/update', SmartgridData)
    .subscribe();
}

//Difference
calculateAdjustedConsumed(): number {
  if (this.smartgridData && this.smartgridData.length > 0) {
  const electricityProduced = this.smartgridData[0]?.electricityProducedv ;
  const electricityConsumed = this.smartgridData[0]?.lectricityConsumed ;
  if (electricityProduced !== undefined && electricityConsumed !== undefined) {
    return electricityProduced - electricityConsumed;
  }

}
return 0;
}

  // Solarpanell
  getAllSolarPanels() {
    this.http.get<any[]>('http://localhost:9595/solarpanel/all')
      .subscribe({
        next: response => {
          console.log('SolarPanel', response);
          this.solarPanels = response;
        },
        error: error => {
          console.error('Error retrieving solar panels:', error);
        }
  });
  }
  updateSolarpanel(solarpanel: any) {
    solarpanel.status = !solarpanel.status;
    this.http.put<any>('http://localhost:9595/solarpanel/update', solarpanel)
      .subscribe({
        next:   response => {
          console.log('Solarpanel updated successfully:', response);
        },
        error:error => {
          console.error('Error updating solarpanel:', error);
        }
  });
  }

  // Turbine
  getAllTurbine() {
    this.http.get<any[]>('http://localhost:9595/turbine/all')
      .subscribe({
        next: response => {
          this.turbine = response;
        },
        error:error => {
          console.error('Error retrieving solar panels:', error);
        }
      } );
  }
  updateTurbine(turbine: any) {
    turbine.status = !turbine.status;
    this.http.put<any>('http://localhost:9595/turbine/update', turbine)
      .subscribe({
        next: response => {
          console.log('Solarpanel updated successfully:', response);
        },
        error: error => {
          console.error('Error updating solarpanel:', error);
        }
      });
  }
  
  // factory
getAllfactories() {
  this.http.get<any[]>('http://localhost:9595/factory/all')
    .subscribe({
      next: response => {
        this.turbine = response;
      },
      error:error => {
        console.error('Error retrieving solar panels:', error);
      }
    } );
}
updateFactory(factory: any) {
  factory.status = !factory.status;
  this.http.put<any>('http://localhost:9595/factory/update', factory)
    .subscribe({
      next: response => {
        console.log('factory updated successfully:', response);
      },
      error: error => {
        console.error('Error updating factory:', error);
      }
    });
}

  
// Battery
getAllBatteries() {
  this.http.get<any[]>('http://localhost:9595/battery/all')
    .subscribe({
      next: response => {
        this.turbine = response;
      },
      error:error => {
        console.error('Error retrieving battery panels:', error);
      }
    } );
}
updateBattery(battery: any) {
  battery.status = !battery.status;
  this.http.put<any>('http://localhost:9595/battery/update', battery)
    .subscribe({
      next: response => {
        console.log('Solarpanel updated successfully:', response);
      },
      error: error => {
        console.error('Error updating battery:', error);
      }
    });
}

}

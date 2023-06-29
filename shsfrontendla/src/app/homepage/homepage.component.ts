import { HttpClient } from '@angular/common/http';

import { Component, OnInit } from '@angular/core';

interface Battery {
  name :string,
  capacity:number
}
interface StandardConsumer {
  name :string,
  consumed:number,
  artDerTarif:string
}
interface VariableConsumer {
  name :string,
  consumed:number
  artDerTarif:string
}
interface SolarPanel {
  name :string,
  maxOutput:number
}
interface Turbine {
  name :string,
  maxOutput:number
}

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  value1:String ='';
  value2:String ='';
  Batteries :Battery[]=[];
  StandardConsumers :StandardConsumer[]=[];
  VariableConsumers :VariableConsumer[]=[];
  SolarPanels :SolarPanel[]=[];
  Turbines :Turbine[]=[];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.ConsumptionProductionValue();
    this.getAddedBatterys();
    this.getAddedSolarPanels();
    this.getAddedTurbines();
    this.getAddedStandardConsumers();
    this.getAddedVariableConsumers();

  }
  getAddedBatterys() {
    this.http.get<Battery[]>('your-backend-url/smart-homes').subscribe({
      next: (response: Battery[]) => {
        this.Batteries = response;
      },
      error: (error: any) => {
        console.log('Error fetching Batterys:', error);
      },
    });
  }
  getAddedStandardConsumers() {
    this.http.get<StandardConsumer[]>('your-backend-url/smart-homes').subscribe({
      next: (response: StandardConsumer[]) => {
        this.StandardConsumers = response;
      },
      error: (error: any) => {
        console.log('Error fetching Standard Consumers:', error);
      },
    });
  }
  getAddedVariableConsumers() {
    this.http.get<VariableConsumer[]>('your-backend-url/smart-homes').subscribe({
      next: (response: VariableConsumer[]) => {
        this.VariableConsumers = response;
      },
      error: (error: any) => {
        console.log('Error fetching Variable Consumers:', error);
      },
    });
  }
  getAddedSolarPanels() {
    this.http.get<SolarPanel[]>('your-backend-url/smart-homes').subscribe({
      next: (response: SolarPanel[]) => {
        this.SolarPanels = response;
      },
      error: (error: any) => {
        console.log('Error fetching Solar Panels:', error);
      },
    });
  }
  getAddedTurbines() {
    this.http.get<Turbine[]>('your-backend-url/smart-homes').subscribe({
      next: (response: Turbine[]) => {
        this.Turbines = response;
      },
      error: (error: any) => {
        console.log('Error fetching Turbines:', error);
      },
    });
  }

  ConsumptionProductionValue() {
    this.http.get<any>('Backend-link').subscribe(
      (response) => {
        this.value1 = response.value1;
        this.value2 = response.value2;
      },
      (error) => {
        console.log('Error occurred while fetching values from the backend:', error);
      }
    );
  }


}
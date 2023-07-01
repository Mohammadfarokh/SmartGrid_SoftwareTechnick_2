import { HttpClient } from '@angular/common/http';

import { Component, OnInit } from '@angular/core';
import { interval } from 'rxjs';



@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css'],
})
export class HomepageComponent implements OnInit {
  value1:number | undefined;
  value2: number | undefined;
  Batteries:any[]| undefined;
  StandardConsumers:any[] | undefined;
  
  SolarPanels: any[] | undefined;
  Turbines: any[] | undefined;

  constructor(private http: HttpClient) {}

  ngOnInit() {
/*    this.ConsumptionProductionValue();*/
    this.getAddedBatterys();
    this.getAddedSolarPanels();
    this.getAddedTurbines();
    this.getAddedStandardConsumers();
    
  }
  getAddedBatterys() {
    this.http.get<any[]>('http://localhost:9595/api/v1/home-battary/home-battary-show').subscribe({
      next: (response: any[]) => {
        this.Batteries = response;
      },
      error: (error: any) => {
        console.log('Error fetching Batterys:', error);
      },
    });
  }
  getAddedStandardConsumers() {
    this.http
      .get<any[]>('http://localhost:9595/api/v1/energy-consumer/consumer-show')
      .subscribe({
        next: respons => {
          console.log("IAM HEREEEEstandardconsumer");
          this.StandardConsumers = respons;
        },
        error: (error: any) => {
          console.log('Error fetching Standard Consumers:', error);
        },
      });
  }
 
  getAddedSolarPanels() {
    this.http.get<any[]>('http://localhost:9595/api/v1/energy-producer/solar-panel-show').subscribe({
      next: response=> {
        console.log("IAM HEREEEE");
        this.SolarPanels = response;
      },
      error: (error: any) => {
        console.log('Error fetching Solar Panels:', error);
      },
    });
  }
  getAddedTurbines() {
    this.http.get<any[]>('http://localhost:9595/api/v1/energy-producer/turbine-show').subscribe({
      next: response => {
        console.log("IAM HEREEEETURBINE");
        this.Turbines = response;
      },
      error: (error: any) => {
        console.log('Error fetching Turbines:', error);
      },
    });
  }
/*
  ConsumptionProductionValue() {
    this.http.get<any>('Backend-link').subscribe(
      (response) => {
        this.value1 = response.value1;
        this.value2 = response.value2;
      },
      (error) => {
        console.log(
          'Error occurred while fetching values from the backend:',
          error
        );
      }
    );
  }
  /*
  batteryToggleButton(battery: any) {
    const button = document.getElementById('batteryButton');
    if (button?.innerHTML === 'OFF') {
      button.innerHTML = 'ON';
      button.classList.add('on');
      button.classList.remove('off');
      setInterval(() => {
        this.http
          .put<any>('Backend-link', battery)
          .subscribe({
            next: (response) => {
              console.log('battery updated successfully:', response);
            },
            error: (error) => {
              console.error('Error updating battery:', error);
            },
          });
      }, 2000);
    } else {
      button?.innerHTML === 'OFF';
      button?.classList.add('off');
      button?.classList.remove('on');
    }
  }

  StandardConsumerToggleButton(StandardConsumer: any) {
    const button = document.getElementById('StandardConsumerButton');
    if (button?.innerHTML === 'OFF') {
      button.innerHTML = 'ON';
      button.classList.add('on');
      button.classList.remove('off');
      setInterval(() => {
        this.http
          .put<any>('Backend-link', StandardConsumer)
          .subscribe({
            next: (response) => {
              console.log('StandardConsumer updated successfully:', response);
            },
            error: (error) => {
              console.error('Error updating StandardConsumer:', error);
            },
          });
      }, 2000);
    } else {
      button?.innerHTML === 'OFF';
      button?.classList.add('off');
      button?.classList.remove('on');
    }
  }
  VariableConsumerToggleButton(VariableConsumer: any) {
    const button = document.getElementById('VariableConsumerButton');
    if (button?.innerHTML === 'OFF') {
      button.innerHTML = 'ON';
      button.classList.add('on');
      button.classList.remove('off');
      setInterval(() => {
        this.http
          .put<any>('Backend-link', VariableConsumer)
          .subscribe({
            next: (response) => {
              console.log('VariableConsumer updated successfully:', response);
            },
            error: (error) => {
              console.error('Error updating VariableConsumer:', error);
            },
          });
      }, 2000);
    } else {
      button?.innerHTML === 'OFF';
      button?.classList.add('off');
      button?.classList.remove('on');
    };
  }

  SolarPanelToggleButton(SolarPanel: any) {
    const button = document.getElementById('SolarPanelButton');
    if (button?.innerHTML === 'OFF') {
      button.innerHTML = 'ON';
      button.classList.add('on');
      button.classList.remove('off');
      setInterval(() => {
        this.http
          .put<any>('Backend-link', SolarPanel)
          .subscribe({
            next: (response) => {
              console.log('SolarPanel updated successfully:', response);
            },
            error: (error) => {
              console.error('Error updating SolarPanel:', error);
            },
          });
      }, 2000);
    } else {
      button?.innerHTML === 'OFF';
      button?.classList.add('off');
      button?.classList.remove('on');
    }
  }

  TurbineToggleButton(Turbine: any) {
    const button = document.getElementById('TurbineButton');
    if (button?.innerHTML === 'OFF') {
      button.innerHTML = 'ON';
      button.classList.add('on');
      button.classList.remove('off');
      setInterval(() => {
        this.http
          .put<any>('Backend-link', Turbine)
          .subscribe({
            next: (response) => {
              console.log('Turbine updated successfully:', response);
            },
            error: (error) => {
              console.error('Error updating Turbine:', error);
            },
          });
      }, 2000);
    } else {
      button?.innerHTML === 'OFF';
      button?.classList.add('off');
      button?.classList.remove('on');
    }
  }
  
}

*/
}

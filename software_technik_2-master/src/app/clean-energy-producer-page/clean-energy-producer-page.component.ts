import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
/*
interface Battery {
  name: string;
  location: string;
  capacity: number;
}
interface CleanEnergyDevice {
  weater: string;
  location: string;
}
interface Factory {
  name: string;
  location: string;
}
*/
@Component({
  selector: 'app-clean-energy-producer-page',
  templateUrl: './clean-energy-producer-page.component.html',
  styleUrls: ['./clean-energy-producer-page.component.css'],
})
export class CleanEnergyProducerPageComponent implements OnInit {
  /*
  Batterys: Battery[] = [];
  Factorys: Factory[] = [];
  CleanEnergyDevices: CleanEnergyDevice[] = [];
 */
  ngOnInit() {
     /* zum löschen
    this.getAddedBatterys();
    this.getAddedCleanEnergyDevices();
    this.getAddedFactorys();
    */
  }

  constructor(private http: HttpClient) {}
  getElement(element: HTMLButtonElement) {
    if (element.innerHTML === 'not working') {
      element.innerHTML = 'working';
    } else {
      element.innerHTML = 'not working';
    }
    // Perform any other operations with the button element
  }
  //add Factory
  submitForm1(form: any) {
    const factoryData = {
      name: form.value.name,
      location: form.value.location,
    };
    this.http.post('http://localhost:9595/factory/add', factoryData).subscribe({
      next: (response) => {
        form.reset();
        alert('Successfully added:');
      },
      error: (error) => {
        console.log('Error submitting form:', error);
        
      },
    });
  }
   //add Battery
  submitForm3(form3: any) {
    const data = {
      name: form3.value.name3,
      location: form3.value.location3,
      capacity: form3.value.capacity3,
    };
    this.http.post('http://localhost:9595/battery/add', data).subscribe({
      next: (response) => {
        form3.reset();
        alert('Successfully added:');
      },
      error: (error) => {
        alert('Error');
        console.log('Error submitting form:', error);
        
      },
    });
  }

  // Add Clean Energy Device 
  submitForm2(form2: any) {

    const turbineData = {
      name:form2.value.name,
      location : form2.value.location2
    };

    const solarpanelData = {
      name:form2.value.name,
      location : form2.value.location2
    };

    // Add Turbine
    if(form2.value.type == "turbine"){
    this.http.post('http://localhost:9595/turbine/add', turbineData).subscribe({
      next: (response) => {
        form2.reset();
        alert('Successfully added:');
      },
      error: (error) => {
        console.log('Error submitting form:', error);
        
      },
    });

    }

    // Add solarPanel
    else if(form2.value.type == "solarpanel"){
      this.http.post('http://localhost:9595/solarpanel/add', solarpanelData).subscribe({
        next: (response) => {
          form2.reset();
          alert('Successfully added:');
        },
        error: (error) => {
          console.log('Error submitting form:', error);
          
        },
      });
  
      }
      else{
        alert('Select a Type!');
      }


  }

  

}

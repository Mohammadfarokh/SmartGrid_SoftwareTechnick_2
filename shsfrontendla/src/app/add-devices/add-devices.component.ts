import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';



interface Battery {
  name: string;
  capacity: number;
}
interface CleanEnergyDevice {
  name: string;
 
}

interface VariableConsumer {
  name: string;
  consumed: number;
}
interface StandardConsumer {
  name: string;
  consumed: number;
}
@Component({
  selector: 'app-add-devices-producer-page',
  templateUrl: './add-devices.component.html',
  styleUrls: ['./add-devices.component.css'],
})
export class AddDevicesComponent implements OnInit {
  Batteries: Battery[] = [];
  VariableConsumers: VariableConsumer[] = [];
  StandardConsumers: StandardConsumer[] = [];
  CleanEnergyDevices: CleanEnergyDevice[] = [];
 
  ngOnInit() {
   
  }

  constructor(private http: HttpClient) {}
  
  //add stansardconsumer
  submitForm1(form1: any) {
    const stansardconsumerData = {
      name: form1.value.name,
      consumed: form1.value.consumed,
     
    };
    
    this.http.post('http://localhost:9595/api/v1/energy-consumer/standart-consumer-add', stansardconsumerData).subscribe({
      next: (response) => {
        form1.reset();
        alert('Successfully added:');
      },
      error: (error) => {
        console.log('Error submitting form:', error);
        
      },
    });
  }
  //add variableconsumer
  submitForm4(form4: any) {
    const variableconsumerData = {
      name: form4.value.name,
      location: form4.value.consumed,
    };
    this.http.post('http://localhost:9595/variableconsumer/add', variableconsumerData).subscribe({
      next: (response) => {
        form4.reset();
        alert('Successfully added:');
      },
      error: (error) => {
        console.log('Error submitting form:', error);
        
      },
    });
  }
   //add Battery
  submitForm3(form2: any) {
    const Batterydata = {
      name: form2.value.name,
      capacity: form2.value.capacity,
    };
    this.http.post('http://localhost:9595/battery/add', Batterydata).subscribe({
      next: (response) => {
        form2.reset();
        alert('Successfully added:');
      },
      error: (error) => {
        console.log('Error submitting form:', error);
        
      },
    });
  }

  // Add Clean Energy Device 
  submitForm2(form3: any) {

    const turbineData = {
      name:form3.value.name,
     
    };

    const solarpanelData = {
      name:form3.value.name,
      
    };

    // Add Turbine
    if(form3.value.type == "turbine"){
    this.http.post('http://localhost:9595/api/v1/energy-producer', turbineData).subscribe({
      next: (response) => {
        form3.reset();
        alert('Successfully added:');
      },
      error: (error) => {
        console.log('Error submitting form:', error);
        
      },
    });

    }

    // Add solarPanel
    else if(form3.value.type == "solarpanel"){
      this.http.post('http://localhost:9595/solarpanel/add', solarpanelData).subscribe({
        next: (response) => {
          form3.reset();
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

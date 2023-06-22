import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';
interface Battery {
  name: string;
  location: string;
  capacity: number;
}
interface CleanEnergyDevice {
  name: string;
  location: string;
}
interface Factory {
  name: string;
  location: string;
}

@Component({
  selector: 'app-clean-energy-producer-page',
  templateUrl: './clean-energy-producer-page.component.html',
  styleUrls: ['./clean-energy-producer-page.component.css'],
})
export class CleanEnergyProducerPageComponent implements OnInit {
  Batterys: Battery[] = [];
  Factorys: Factory[] = [];
  CleanEnergyDevices: CleanEnergyDevice[] = [];
  ngOnInit() {
    this.getAddedBatterys();
    this.getAddedCleanEnergyDevices();
    this.getAddedFactorys();
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
  submitForm1(form: any) {
    const data = {
      name: form.value.name,
      location: form.value.location,
    };
    this.http.post('deine-url-hier', data).subscribe({
      next: (response) => {
        console.log('Erfolgreich gesendet:', response);
        const newFactory: Factory = {
          name: data.name,
          location: data.location,
        };
        this.Factorys.push(newFactory);
        form.reset();
      },
      error: (error) => {
        console.log('Error submitting form:', error);
      },
    });
  }
  submitForm2(form: any) {
    const data = {
      name: form.value.name,
      location: form.value.location,
    };
    this.http.post('deine-url-hier', data).subscribe({
      next: (response) => {
        console.log('Erfolgreich gesendet:', response);
        const newCleanEnergyDevice: CleanEnergyDevice = {
          name: data.name,
          location: data.location,
        };
        this.CleanEnergyDevices.push(newCleanEnergyDevice);
        form.reset();
      },
      error: (error) => {
        console.log('Error submitting form:', error);
      },
    });
  }
  getAddedBatterys() {
    this.http.get<Battery[]>('your-backend-url/smart-homes').subscribe({
      next: (response: Battery[]) => {
        this.Batterys = response;
      },
      error: (error: any) => {
        console.log('Error fetching Batterys:', error);
      },
    });
  }
  getAddedFactorys() {
    this.http.get<Factory[]>('your-backend-url/smart-homes').subscribe({
      next: (response: Factory[]) => {
        this.Factorys = response;
      },
      error: (error: any) => {
        console.log('Error fetching Factorys:', error);
      },
    });
  }
  getAddedCleanEnergyDevices() {
    this.http
      .get<CleanEnergyDevice[]>('your-backend-url/smart-homes')
      .subscribe({
        next: (response: CleanEnergyDevice[]) => {
          this.CleanEnergyDevices = response;
        },
        error: (error: any) => {
          console.log('Error fetching CleanEnergyDevice:', error);
        },
      });
  }
  submitForm3(form: any) {
    const data = {
      name: form.value.name,
      location: form.value.location,
      capacity: form.value.capacity,
    };
    this.http.post('deine-url-hier', data).subscribe({
      next: (response) => {
        console.log('Erfolgreich gesendet:', response);
        const newBattery: Battery = {
          name: data.name,
          location: data.location,
          capacity: data.location,
        };
        this.Batterys.push(newBattery);
        form.reset();
      },
      error: (error) => {
        console.log('Error submitting form:', error);
      },
    });
  }
}

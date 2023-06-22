import { Component, OnInit } from '@angular/core';
import { HttpClient } from '@angular/common/http';

interface SmartHome {
  name: string;
  tarif: string;
  location: string;
}

@Component({
  selector: 'app-smart-home',
  templateUrl: './smart-home.component.html',
  styleUrls: ['./smart-home.component.css'],
})
export class SmartHomeComponent implements OnInit {
  smartHomes: SmartHome[] = [];

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.getRegisteredSmartHomes();
  }

  submitForm(form: any) {
    if (form.valid) {
      const formValue = {
        name: form.value.name,
        tarif: form.value.tarif,
        location: form.value.location,
      };

      this.http
        .post<any>('your-backend-url/register-smart-home', formValue)
        .subscribe({
          next: (response) => {
            console.log('Form submitted successfully:', response);
            const newSmartHome: SmartHome = {
              name: formValue.name,
              tarif: formValue.tarif,
              location: formValue.location,
            };
            this.smartHomes.push(newSmartHome);

            // Reset the form
            form.reset();
          },
          error: (error) => {
            console.log('Error submitting form:', error);
          },
        });
    }
  }

  getRegisteredSmartHomes() {
    this.http.get<SmartHome[]>('your-backend-url/smart-homes').subscribe({
      next: (response: SmartHome[]) => {
        this.smartHomes = response;
      },
      error: (error: any) => {
        console.log('Error fetching smart homes:', error);
      },
    });
  }
}

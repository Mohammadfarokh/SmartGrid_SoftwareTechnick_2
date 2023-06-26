import { HttpClient } from '@angular/common/http';

import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
  value1: string = '';
  value2: string = '';

  constructor(private http: HttpClient) {}

  ngOnInit() {
    this.fetchValuesFromBackend();
  }

  fetchValuesFromBackend() {
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

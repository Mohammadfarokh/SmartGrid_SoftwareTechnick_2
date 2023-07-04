import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http'
import { Observable, forkJoin  } from 'rxjs';
import {HomeData} from '../types/HomeData';
import {SmartHome} from '../types/SmartHome';


@Injectable({
  providedIn: 'root'
})
export class HomeService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };
baseUrl:string ="http://localhost:9595/"



  constructor(private http:HttpClient) { }
  getInfo():Observable<{homeData: HomeData, smartHome: SmartHome}>{
    const homeDataEndpoint: string = this.baseUrl + "api/v1/home";
    const smartHomeEndpoint: string = this.baseUrl + "api/v1/smart-home";
    const homeDataRequest = this.http.get<HomeData>(homeDataEndpoint);
  const smartHomeRequest = this.http.get<SmartHome>(smartHomeEndpoint);
return forkJoin({ homeData: homeDataRequest, smartHome: smartHomeRequest });
  }
  
}

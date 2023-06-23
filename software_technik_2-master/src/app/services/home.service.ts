import { Injectable } from '@angular/core';
import { HttpClient,HttpHeaders } from '@angular/common/http'
import { Observable } from 'rxjs';
import {HomeData} from '../types/HomeData';
@Injectable({
  providedIn: 'root'
})
export class HomeService {
  httpOptions = {
    headers: new HttpHeaders({
      'Content-Type': 'application/json',
    }),
  };
baseUrl:string ="http://localhost:9090/"



  constructor(private http:HttpClient) { }
  getInfo():Observable<HomeData>{
const endpoint :String=this.baseUrl+"api/v1/home";
return this.http.get<HomeData>(endpoint.toString());
  }
}

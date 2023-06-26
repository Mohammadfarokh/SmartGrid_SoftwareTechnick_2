import { Component ,OnInit} from '@angular/core';
import { HomeService } from '../services/home.service';
import { HomeData, solarPanel,Turbine,cepo,Battery } from '../types/HomeData';

@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
constructor(private homeservive:HomeService){
 } 
 solarPanelTable : solarPanel[] | undefined ;
 TurbineTable : Turbine[] | undefined ;
 cepoTable : cepo[] | undefined ;
 BatteryTable : Battery[] | undefined ;

  ngOnInit(): void {
    this.homeservive.getInfo().subscribe(res=>{
      console.log(res);
      this.solarPanelTable=res.homeData.solarPanelArray;
      this.TurbineTable=res.homeData.TurbineArray;
      this.cepoTable=res.homeData.cepoArray;
      this.BatteryTable=res.homeData.BatteryArray;
    });
    
  }
  tableDataList: any[] = [
    [
      { column1: 'Data 1', column2: 'Data 2', column3: 'Data 3', column4: 'Data 4' },
      { column1: 'Data 5', column2: 'Data 6', column3: 'Data 7', column4: 'Data 8' }
    ],
    [
      { column1: 'Data 9', column2: 'Data 10', column3: 'Data 11', column4: 'Data 12' },
      { column1: 'Data 13', column2: 'Data 14', column3: 'Data 15', column4: 'Data 16' }
    ]
  ];
  
}

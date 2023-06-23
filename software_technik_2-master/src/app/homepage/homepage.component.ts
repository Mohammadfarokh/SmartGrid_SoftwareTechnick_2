import { Component ,OnInit} from '@angular/core';
import { HomeService } from '../services/home.service';
import { HomeData, solarPanel } from '../types/HomeData';
@Component({
  selector: 'app-homepage',
  templateUrl: './homepage.component.html',
  styleUrls: ['./homepage.component.css']
})
export class HomepageComponent implements OnInit {
constructor(private homeservive:HomeService){
 } 
 cleanenergyTable : solarPanel[] | undefined ;
  ngOnInit(): void {
    this.homeservive.getInfo().subscribe(re=>{
      console.log(re);
      this.cleanenergyTable=re.solarPanelArray;
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

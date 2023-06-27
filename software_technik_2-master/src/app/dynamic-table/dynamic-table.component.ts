import { Component, Input } from '@angular/core';
import { HomeData, solarPanel,Turbine,cepo,Battery } from '../types/HomeData';

@Component({
  selector: 'app-dynamic-table',
  templateUrl: './dynamic-table.component.html',
  template: `<div (click)="getElement(this)">Click Me</div>`,
  styleUrls: ['./dynamic-table.component.css']
})
export class DynamicTableComponent {
  word: string = 'Initial';
  changed: boolean = false;

  @Input() tableDataList1: solarPanel[] |undefined ;

  @Input() tableDataList2: Turbine[] |undefined ;

  @Input() tableDataList3: cepo[] |undefined;
  @Input() tableDataList4: Battery[] |undefined;
  @Input() tableDataList5: any[] = [
    { column1: 'Table 2 - Data 1', column2: 'Table 2 - Data 2', column3: 'Table 2 - Data 3', column4: 'Table 2 - Data 4' },
    { column1: 'Table 2 - Data 5', column2: 'Table 2 - Data 6', column3: 'Table 2 - Data 7', column4: 'Table 2 - Data 8' }
  ];

  getElement(element: HTMLButtonElement) {

    if(element.innerHTML==="not working"){
      element.innerHTML="working"

    }
    else{
      element.innerHTML= "not working";

    }
    
  }
}

import { Component, Input } from '@angular/core';

@Component({
  selector: 'app-dynamic-table',
  templateUrl: './dynamic-table.component.html',
  template: `<div (click)="getElement(this)">Click Me</div>`,
  styleUrls: ['./dynamic-table.component.css']
})
export class DynamicTableComponent {
  word: string = 'Initial';
  changed: boolean = false;

  @Input() tableDataList1: any[] = [
    { column1: 'Table 1 - Data 1', column2: 'Table 1 - Data 2', column3: 'Table 1 - Data 3', column4: 'Table 1 - Data 4' },
    { column1: 'Table 1 - Data 5', column2: 'Table 1 - Data 6', column3: 'Table 1 - Data 7', column4: 'Table 1 - Data 8' }
  ];

  @Input() tableDataList2: any[] = [
    { column1: 'Table 2 - Data 1', column2: 'Table 2 - Data 2', column3: 'Table 2 - Data 3', column4: 'Table 2 - Data 4' },
    { column1: 'Table 2 - Data 5', column2: 'Table 2 - Data 6', column3: 'Table 2 - Data 7', column4: 'Table 2 - Data 8' }
  ];

  @Input() tableDataList3: any[] = [
    { column1: 'Table 2 - Data 1', column2: 'Table 2 - Data 2', column3: 'Table 2 - Data 3', column4: 'Table 2 - Data 4' },
    { column1: 'Table 2 - Data 5', column2: 'Table 2 - Data 6', column3: 'Table 2 - Data 7', column4: 'Table 2 - Data 8' }
  ];
  @Input() tableDataList4: any[] = [
    { column1: 'Table 2 - Data 1', column2: 'Table 2 - Data 2', column3: 'Table 2 - Data 3', column4: 'Table 2 - Data 4' },
    { column1: 'Table 2 - Data 5', column2: 'Table 2 - Data 6', column3: 'Table 2 - Data 7', column4: 'Table 2 - Data 8' }
  ];
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

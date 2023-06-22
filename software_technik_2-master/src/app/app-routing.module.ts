
import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { HomepageComponent } from './homepage/homepage.component';

import { CleanEnergyProducerPageComponent } from './clean-energy-producer-page/clean-energy-producer-page.component';
import { SmartHomeComponent } from './smart-home/smart-home.component';
const routes: Routes = [
  { path: '', component: HomepageComponent },
  
  { path: 'SGS/src/app/clean-energy-producer-page', component: CleanEnergyProducerPageComponent },
  { path: 'SGS/src/app/homepage', component: HomepageComponent},
  { path: 'SGS/src/app/smart-home', component: SmartHomeComponent }
];


@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})


export class AppRoutingModule { }

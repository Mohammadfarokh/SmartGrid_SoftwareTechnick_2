
import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { FormsModule } from '@angular/forms';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomepageComponent } from './homepage/homepage.component';



import { CleanEnergyProducerPageComponent } from './clean-energy-producer-page/clean-energy-producer-page.component';

import { DynamicTableComponent } from './dynamic-table/dynamic-table.component';
import { SmartHomeComponent } from './smart-home/smart-home.component';
import { HttpClientModule } from '@angular/common/http';

@NgModule({
  declarations: [
    AppComponent,
    HomepageComponent,
    CleanEnergyProducerPageComponent,
         SmartHomeComponent,
         DynamicTableComponent,
         SmartHomeComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

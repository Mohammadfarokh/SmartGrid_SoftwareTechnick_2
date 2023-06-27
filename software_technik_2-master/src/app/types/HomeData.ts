
export interface HomeData{
  solarPanelArray: solarPanel[]
    

}

export interface solarPanel{
  name: string;
  sunrise:number;
  production_amount:number;
  status:boolean;
}



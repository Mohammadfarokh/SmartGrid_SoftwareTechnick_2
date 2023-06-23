
export interface HomeData{
  solarPanelArray: solarPanel[]
    

}

export interface solarPanel{
    name: string;
    sunrise:number;
  production:number;
  status:boolean;
}



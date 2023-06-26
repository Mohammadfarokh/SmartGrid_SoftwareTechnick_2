
export interface HomeData{
  solarPanelArray: solarPanel[];
  Turbine: Turbine[]
  cepo: cepo[]
  Battery: Battery[]
}

export interface solarPanel{
    name: string;
    sunrise:number;
  production:number;
  status:boolean;
}

export interface Turbine{
  name: string;
  windspeed:number;
production:number;
status:boolean;
}
export interface cepo{
  name: string;
production:number;
status:boolean;
}

export interface Battery{
  name: string;
  capacity:number;  //sollen wir amout oder capaciry nicht mehr machen (vergessen)yyy
production:number;
status:boolean;
location: string;
}

export interface HomeData{
  solarPanelArray: solarPanel[];
  TurbineArray: Turbine[]
  cepoArray: cepo[]
  BatteryArray: Battery[]
}

export interface solarPanel{
  name: string;
  sunrise:number;
  production_amount:number;
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
  status:boolean;
production:number;
location: string;
}
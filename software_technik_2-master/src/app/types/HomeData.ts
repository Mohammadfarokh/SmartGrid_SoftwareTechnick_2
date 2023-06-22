//homepage an misha schicken 
export interface HomeData{
    cleanEnergy: CleanEnergy[]
    

}

interface CleanEnergy{
    name: string;
    sunriseSunsate:Date;
  production:number;
  status:boolean;
}

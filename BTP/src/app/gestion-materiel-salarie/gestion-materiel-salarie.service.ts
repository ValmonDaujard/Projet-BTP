import { Injectable } from '@angular/core';
import {Salarie} from "../model/salarie";

@Injectable({
  providedIn: 'root'
})
export class GestionMaterielSalarieService {

  private salaries: Array<Salarie> = new Array<Salarie>();

  constructor() { }
}

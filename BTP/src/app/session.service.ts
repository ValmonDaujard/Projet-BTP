import {Injectable} from '@angular/core';
import {Utilisateur} from "./model/utilisateur";

@Injectable({
  providedIn: 'root'
})
export class SessionService {

  constructor() {
  }

  getUser(): Utilisateur {
    return JSON.parse(sessionStorage.getItem('user'));
  }

  setUser(utilisateur: Utilisateur) {
    sessionStorage.setItem('user', JSON.stringify(utilisateur));
  }
}

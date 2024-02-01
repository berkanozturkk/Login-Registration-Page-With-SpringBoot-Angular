import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';

@Injectable({
  providedIn: 'root'
})
export class LoginserviceService {

  loggedInUsername: string = "";

  constructor(private http:HttpClient) { }

  getUserData(username: string,password: string){
    return this.http.get('http://localhost:8080/user/'+username+'/'+password);
  }
}

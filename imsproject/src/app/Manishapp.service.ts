import { Injectable } from "@angular/core";
import{ HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { Manishapp } from "./Manishapp";

@Injectable({
    providedIn: 'root'
})
export class ManishappService{
    private basePath = 'http://localhost:8090/rest/manishapp';

    constructor(private http: HttpClient){
    }
    getAllManishapps(): Observable<Manishapp[]> {
        return this.http.get<Manishapp[]>(`${this.basePath}/all6`);
      }
    
      deleteOneManishapp(id: number): Observable<any> {
        return this.http.delete(`${this.basePath}/remove6/${id}`, {responseType: 'text'});
      }
    
      createManishapp(manishapp: Manishapp): Observable<any> {
        return this.http.post(`${this.basePath}/save6`, manishapp, {responseType: 'text'});
      }
    
      
      getOneManishapp(id: number): Observable<Manishapp> {
        return this.http.get<Manishapp>(`${this.basePath}/one6/${id}`);
      }
    
      updateManishapp(id: number, manishapp: Manishapp): Observable<any> {
        return this.http.put(`${this.basePath}/modify6/${id}`, manishapp, {responseType : 'text'});
      }
}
import { Injectable } from "@angular/core";
import{ HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { Manish } from "./manish";

@Injectable({
    providedIn: 'root'
})
export class ManishService{
    private basePath = 'http://localhost:8090/rest/manish';

    constructor(private http: HttpClient){
    }
    getAllManishs(): Observable<Manish[]> {
        return this.http.get<Manish[]>(`${this.basePath}/all4`);
      }
    
      deleteOneManish(id: number): Observable<any> {
        return this.http.delete(`${this.basePath}/remove4/${id}`, {responseType: 'text'});
      }
    
      createManish(manish: Manish): Observable<any> {
        return this.http.post(`${this.basePath}/save4`, manish, {responseType: 'text'});
      }
    
      
      getOneManish(id: number): Observable<Manish> {
        return this.http.get<Manish>(`${this.basePath}/one4/${id}`);
      }
    
      updateManish(id: number, manish: Manish): Observable<any> {
        return this.http.put(`${this.basePath}/modify4/${id}`, manish, {responseType : 'text'});
      }
}
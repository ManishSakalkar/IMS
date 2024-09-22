import { Injectable } from "@angular/core";
import{ HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { Category } from "./category";


@Injectable({
    providedIn: 'root'
})
export class CategoryService{
    private basePath = 'http://localhost:8090/rest/category';

    constructor(private http: HttpClient){
    }
    getAllCategorys(): Observable<Category[]> {
        return this.http.get<Category[]>(`${this.basePath}/all3`);
      }
    
      deleteOneCategory(id: number): Observable<any> {
        return this.http.delete(`${this.basePath}/remove3/${id}`, {responseType: 'text'});
      }
    
      createCategory(category: Category): Observable<any> {
        return this.http.post(`${this.basePath}/save3`, category, {responseType: 'text'});
      }
    
      
      getOneCategory(id: number): Observable<Category> {
        return this.http.get<Category>(`${this.basePath}/one3/${id}`);
      }
    
      updateCategory(id: number, category: Category): Observable<any> {
        return this.http.put(`${this.basePath}/modify3/${id}`, category, {responseType : 'text'});
      }
}
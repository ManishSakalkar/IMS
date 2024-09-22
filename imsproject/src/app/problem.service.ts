import { Injectable } from "@angular/core";
import{ HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { Problem } from "./problem";


@Injectable({
    providedIn: 'root'
})
export class ProblemService{
    private basePath = 'http://localhost:8090/rest/problem';

    constructor(private http: HttpClient){
    }
    getAllProblems(): Observable<Problem[]> {
        return this.http.get<Problem[]>(`${this.basePath}/all5`);
      }
    
      deleteOneProblem(id: number): Observable<any> {
        return this.http.delete(`${this.basePath}/remove5/${id}`, {responseType: 'text'});
      }
    
      createProblem(problem: Problem): Observable<any> {
        return this.http.post(`${this.basePath}/save5`, problem, {responseType: 'text'});
      }
    
      
      getOneProblem(id: number): Observable<Problem> {
        return this.http.get<Problem>(`${this.basePath}/one5/${id}`);
      }
    
      updateProblem(id: number, problem: Problem): Observable<any> {
        return this.http.put(`${this.basePath}/modify5/${id}`, problem, {responseType : 'text'});
      }
}
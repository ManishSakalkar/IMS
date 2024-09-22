import { Injectable } from "@angular/core";
import{ HttpClient } from '@angular/common/http';
import { Observable } from "rxjs";
import { Customer } from './customer'

@Injectable({
    providedIn: 'root'
})
export class CustomerService{
    private basePath = 'http://localhost:8090/rest/customer';

    constructor(private http: HttpClient){
    }
    getAllCustomers(): Observable<Customer[]> {
        return this.http.get<Customer[]>(`${this.basePath}/all`);
      }
    
      deleteOneCustomer(id: number): Observable<any> {
        return this.http.delete(`${this.basePath}/remove/${id}`, {responseType: 'text'});
      }
    
      createCustomer(customer: Customer): Observable<any> {
        return this.http.post(`${this.basePath}/save`, customer, {responseType: 'text'});
      }
    
      
      getOneCustomer(id: number): Observable<Customer> {
        return this.http.get<Customer>(`${this.basePath}/one/${id}`);
      }
    
      updateCustomer(id: number, customer: Customer): Observable<any> {
        return this.http.put(`${this.basePath}/modify/${id}`, customer, {responseType : 'text'});
      }
}
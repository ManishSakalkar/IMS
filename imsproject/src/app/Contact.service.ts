import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Contact } from './Contact';

@Injectable({
  providedIn: 'root'
})
export class ContactService {

  private basePath = 'http://localhost:8090/rest/contact';

  constructor(private http: HttpClient) { }


  getAllContact(): Observable<Contact[]> {
    return this.http.get<Contact[]>(`${this.basePath}/all8`);
  }

  deleteOneContact(id: number): Observable<any> {
    return this.http.delete(`${this.basePath}/remove8/${id}`, {responseType: 'text'});
  }

  createContact(contact: Contact): Observable<any> {
    return this.http.post(`${this.basePath}/save8`, contact, {responseType: 'text'});
  }

  
  getOneContact(id: number): Observable<Contact> {
    return this.http.get<Contact>(`${this.basePath}/one8/${id}`);
  }

  updateContact(id: number, contact: Contact): Observable<any> {
    return this.http.put(`${this.basePath}/modify8/${id}`, contact, {responseType : 'text'});
  }

}

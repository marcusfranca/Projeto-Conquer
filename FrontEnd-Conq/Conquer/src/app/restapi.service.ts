
import { Create } from './conquer/create/create.model';
import { Injectable } from '@angular/core';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class RestapiService {

  baseUrl = "http://localhost:8080/conquer/user"

  constructor(private http: HttpClient) { }


  public login(username: string, password: string) {
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.http.get(this.baseUrl, { headers, responseType: 'text' as 'json' })
  }


  Users() {
    let username = 'conquer'
    let password = 'conquer123'
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.http.get(this.baseUrl, { headers });
  }

  Create(create: Create) {
    let username = 'conquer'
    let password = 'conquer123'
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    return this.http.post<Create>(this.baseUrl, create, { headers });
  }

  readById(id: string) {
    let username = 'conquer'
    let password = 'conquer123'
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    const url = ` ${this.baseUrl}/${id}`;
    return this.http.get<Create>(url, { headers });
  }

  Update(create: Create) {
    let username = 'conquer'
    let password = 'conquer123'
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    const url = ` ${this.baseUrl}/update`;
    return this.http.put<Create>(url, create, { headers });
  }

  Delete(id: number) {
    let username = 'conquer'
    let password = 'conquer123'
    const headers = new HttpHeaders({ Authorization: 'Basic ' + btoa(username + ':' + password) });
    const url = ` ${this.baseUrl}/delete/${id}`;
    return this.http.delete<Create>(url, { headers });
  }

}
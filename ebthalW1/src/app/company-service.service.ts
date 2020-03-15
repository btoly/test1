import { Injectable } from '@angular/core';

import { Observable } from 'rxjs';
import { Company } from './company';
import { HttpClient, HttpHeaders } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class CompanyServiceService {
  private companyUrl: string;
  private companyUr2: string;
  constructor(private http: HttpClient) { 
    this.companyUrl = 'http://localhost:8080/api/';
    this.companyUr2 = 'http://localhost:8080/api/employees/';
  }
 
  findAll(): Observable<any> {  
    return this.http.get(this.companyUrl+'company');  
  }  
 
  getEmployee(cr: String): Observable<any> {
    return this.http.get(`${this.companyUr2}/${cr}`);
  }

   createCompany(company: any): Observable<any>{
    return this.http.post<Company>(this.companyUrl+'companysave', company);
  }

  deleteEmployee(cr: String): Observable<any> {
    return this.http.delete(`${this.companyUr2}/${cr}`, { responseType: 'text' });
  }
  
  updateEmployee(cr: String, value: any): Observable<Object> {
    return this.http.put(`${this.companyUr2}/${cr}`, value);
  }

}


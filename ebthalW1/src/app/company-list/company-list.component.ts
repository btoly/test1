import { Component, OnInit } from '@angular/core';
import { Company } from '../company';
import { CompanyServiceService } from '../company-service.service';
import { Observable } from 'rxjs';
import { error } from '@angular/compiler/src/util';
import { Router } from '@angular/router';

@Component({
  selector: 'app-company-list',
  templateUrl: './company-list.component.html',
  styleUrls: ['./company-list.component.css']
})
export class CompanyListComponent implements OnInit {

 
  company: Observable<Company[]>;
  deleteMessage=false;  

  
  constructor(private companyServiceService: CompanyServiceService,
    private router: Router) {}




  ngOnInit() {
    this.companyServiceService.findAll().subscribe(data => {
      this.company = data;
    });
  }

  reloadData() {
    this.company = this.companyServiceService.findAll();
  }
  deleteEmployee(cr: String) {
    this.companyServiceService.deleteEmployee(cr)
      .subscribe(
        data => {
          console.log(data);
          this.reloadData();
        },
        error => console.log(error));
  }
  updateEmployee(cr: String){
    this.router.navigate(['update', cr]);
  }
}
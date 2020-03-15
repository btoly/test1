import { Component, OnInit } from '@angular/core';

import { Observable } from 'rxjs';
import { ActivatedRoute, Router } from '@angular/router';
import { CompanyServiceService } from './../company-service.service';
import { Company } from '../company';
@Component({
  selector: 'app-company-form',
  templateUrl: './company-form.component.html',
  styleUrls: ['./company-form.component.css']
})
export class CompanyFormComponent implements OnInit {
  company: Company = new Company();
  submitted = false;
  constructor(  private companyServiceService: CompanyServiceService ) {
 }

  ngOnInit() {
  }

  newCompany(): void {
    this.submitted = false;
    this.company = new Company();
  }
  onSubmit() {
    this.submitted = true;
    this.save();
  }
  save() {
    this.companyServiceService.createCompany(this.company)
      .subscribe(
        data => {
          console.log(data);
          this.submitted = true;
        },
        error => console.log(error));
    this.company = new Company();
  }
}

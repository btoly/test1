import { Component, OnInit } from '@angular/core';
import { Company } from '../company';
import { Router, ActivatedRoute } from '@angular/router';
import { CompanyServiceService } from '../company-service.service';

@Component({
  selector: 'app-update-company',
  templateUrl: './update-company.component.html',
  styleUrls: ['./update-company.component.css']
})
export class UpdateCompanyComponent implements OnInit {

  cr: String;
  ccompany: Company;

  constructor(private route: ActivatedRoute,private router: Router,
    private companyServiceService: CompanyServiceService) { }

  ngOnInit() {
    this.ccompany = new Company();

    this.cr = this.route.snapshot.params['cr'];
    
    this.companyServiceService.getEmployee(this.cr)
      .subscribe(data => {
        console.log(data)
        this.ccompany = data;
      }, error => console.log(error));
  }

  updateEmployee() {
    this.companyServiceService.updateEmployee(this.cr, this.ccompany)
      .subscribe(data => console.log(data), error => console.log(error));
    this.ccompany = new Company();
    this.gotoList();
  }
 


  onSubmit() {
    this.updateEmployee();    
  }

  gotoList() {
    this.router.navigate(['/company']);
  }

}

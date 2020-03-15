package com.example.Whathg_Database.controller;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.Whathg_Database.DTO.CompanyDTO;
import com.example.Whathg_Database.Error.ResourceNotFoundException;
import com.example.Whathg_Database.model.Company;

import com.example.Whathg_Database.repository.CompanyRepository;
import com.example.Whathg_Database.service.CompanyService;



@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping("/api")
  public class Company_Contoller {
	
	 @Autowired
	 CompanyService companyService; 

@Autowired
CompanyRepository comRepository;



@PutMapping("/employees/{CRR}")
public ResponseEntity<Company> updateEmployee(@PathVariable(value = "CRR") String CRR,
     @Valid @RequestBody Company comapanyDetails) throws ResourceNotFoundException {
	Company company = comRepository.findById(CRR)
    .orElseThrow(() -> new ResourceNotFoundException("Company not found for this CRR :: " + CRR));
	company.setEmail(comapanyDetails.getEmail());
	company.setPhoneNumber(comapanyDetails.getPassword());
	company.setAddress(comapanyDetails.getAddress());

	
    final Company updatedCompany= comRepository.save(company);
    return ResponseEntity.ok(updatedCompany);
}




//################
@DeleteMapping("/employees/{CRR}")
public Map<String, Boolean> deleteEmployee(@PathVariable(value = "CRR") String CRR)
     throws ResourceNotFoundException {
	Company company = comRepository.findById(CRR)
   .orElseThrow(() -> new ResourceNotFoundException("Comany not found for this CRR :: " + CRR));

    comRepository.delete(company);
    Map<String, Boolean> response = new HashMap<>();
    response.put("deleted", Boolean.TRUE);
    return response;
}



@PostMapping(value="/companysave")
public ResponseEntity<Company> save(@RequestBody CompanyDTO companyDTO){
	   System.out.println("company save call");
	  return companyService.createcompanyDTO(companyDTO); 
}
	
@RequestMapping("/updateEmailCompany")
public CompanyDTO updateEmail(){
	 return  companyService.updateEmailcompanyDTO("47446337634254", "Ellm77@elm.sa");
	 
// return companyDTO;
}
@RequestMapping("/findCompany")
public String find(){
	 companyService.getById("47446337634254"); 
return "Done for Company";
}

@GetMapping("/company")
 public ResponseEntity<List<Company>> getCompanes() {
	  return companyService.getCompanis();
 }


@RequestMapping("/deleteCompany")
public String  deleteCompany(){
	   companyService.deleteCompany("47446337634254"); 
	   
return "Done for Company";
}



 
}
  
  
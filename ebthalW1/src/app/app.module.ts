import { CompanyServiceService } from './company-service.service';
import { CompanyListComponent } from './company-list/company-list.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { AppRoutingModule } from './app-routing.module';
import { FormsModule } from '@angular/forms';
import { HttpClientModule, HttpClient } from '@angular/common/http';
import { AppComponent } from './app.component';

import { CompanyFormComponent } from './company-form/company-form.component';

import { HeaderComponent } from './header/header.component';
import { NavbarComponent } from './navbar/navbar.component';
import { RegisterComponent } from './register/register.component';
import { UpdateCompanyComponent } from './update-company/update-company.component';
/* 
import {TranslateModule, TranslateLoader} from '@ngx-translate/core';
import {TranslateHttpLoader} from '@ngx-translate/http-loader';
export const createTranslateLoader = (http: HttpClient) => {
  return new TranslateHttpLoader(http, './assets/i18n/', '.json');
};
 */
 
@NgModule({
  declarations: [
    AppComponent,
    CompanyListComponent,
    CompanyFormComponent,

    HeaderComponent,
    NavbarComponent,
    RegisterComponent,
    UpdateCompanyComponent,
    
  
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,

    HttpClientModule,
    FormsModule,
    HttpClientModule
   /*  TranslateModule.forRoot({
        loader: {
            provide: TranslateLoader,
            useFactory: (createTranslateLoader),
            deps: [HttpClient]
        }     }) */

  ],
  providers: [CompanyServiceService],
  bootstrap: [AppComponent]
})
export class AppModule { }
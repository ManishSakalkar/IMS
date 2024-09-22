import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';
import { HttpClientModule } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CustomerdashboardComponent } from './customerdashboard/customerdashboard.component'; 
import { AdminComponent } from './admin/admin.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { HomeComponent } from './home/home.component';
import { FormsModule } from '@angular/forms';
import { LoginComponent } from './login/login.component';
import { CustomerhomepageComponent } from './customerhomepage/customerhomepage.component';
import { CustomercreateComponent } from './customercreate/customercreate.component';
import { HistoryComponent } from './history/history.component';
import { OwlOptions } from 'ngx-owl-carousel-o';
import { ReactiveFormsModule } from '@angular/forms';
import { CustomerallComponent } from './customerall/customerall.component';
import { CustomereditComponent } from './customeredit/customeredit.component';
import { CategoryComponent } from './category/category.component';

import { PolicydashboardComponent } from './policydashboard/policydashboard.component';
import { NgbModule } from '@ng-bootstrap/ng-bootstrap';

import { CategoryallComponent } from './categoryall/categoryall.component';
import { CategoryeditComponent } from './categoryedit/categoryedit.component';
import { CategorycreateComponent } from './categorycreate/categorycreate.component';
import { ManishcreateComponent } from './manishcreate/manishcreate.component';
import { ManishallComponent } from './manishall/manishall.component';
import { ManisheditComponent } from './manishedit/manishedit.component';
import { ManishviewComponent } from './manishview/manishview.component';
import { CategoryviewComponent } from './categoryview/categoryview.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { LoginadminComponent } from './loginadmin/loginadmin.component';
import { ProblemallComponent } from './problemall/problemall.component';
import { ProblemcreateComponent } from './problemcreate/problemcreate.component';
import { ProblemeditComponent } from './problemedit/problemedit.component';
import { ProblemviewComponent } from './problemview/problemview.component';
import { ManishappcreateComponent } from './manishappcreate/manishappcreate.component';
import { ManishappallComponent } from './manishappall/manishappall.component';
import { ManishappeditComponent } from './manishappedit/manishappedit.component';
import { ManishappviewComponent } from './manishappview/manishappview.component';
import { ThankyouimageComponent } from './thankyouimage/thankyouimage.component';
import { ContactcreateComponent } from './contactcreate/contactcreate.component';
import { ContactallComponent } from './contactall/contactall.component';
import { ContacteditComponent } from './contactedit/contactedit.component';



@NgModule({
  declarations: [
    AppComponent,
    AdminComponent,
    AboutusComponent,
    ContactusComponent,
    HomeComponent,
    LoginComponent,
    CustomerhomepageComponent,
    CustomerdashboardComponent,
    CustomercreateComponent,

    HistoryComponent,
    CustomerallComponent,
    CustomereditComponent,
    CategoryComponent,
   
    PolicydashboardComponent,
  
   
    
    CategoryallComponent,
    CategoryeditComponent,
    CategorycreateComponent,
    ManishcreateComponent,
    ManishallComponent,
    ManisheditComponent,
    ManishviewComponent,
    CategoryviewComponent,
    AdminhomeComponent,
    LoginadminComponent,
    ProblemallComponent,
    ProblemcreateComponent,
    ProblemeditComponent,
    ProblemviewComponent,
    ManishappcreateComponent,
    ManishappallComponent,
    ManishappeditComponent,
    ManishappviewComponent,
    ThankyouimageComponent,
    ContactcreateComponent,
    ContactallComponent,
    ContacteditComponent,
   
    
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    NgbModule,
    ReactiveFormsModule

    
    
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

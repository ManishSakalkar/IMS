import { Component, NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
/*Home Page */
import { CustomerdashboardComponent } from './customerdashboard/customerdashboard.component';
import { AdminComponent } from './admin/admin.component';
import { AboutusComponent } from './aboutus/aboutus.component';
import { ContactusComponent } from './contactus/contactus.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { CustomerhomepageComponent } from './customerhomepage/customerhomepage.component';
import { CustomercreateComponent } from './customercreate/customercreate.component';

import { PolicydashboardComponent } from './policydashboard/policydashboard.component';
import { HistoryComponent } from './history/history.component';

/* Customer Coponent */
import { CustomerallComponent } from './customerall/customerall.component';
import { CustomereditComponent } from './customeredit/customeredit.component';
import { CategoryComponent } from './category/category.component';

/*Policy Component */

import { CategorycreateComponent } from './categorycreate/categorycreate.component';
import { CategoryallComponent } from './categoryall/categoryall.component';
import { CategoryeditComponent } from './categoryedit/categoryedit.component';
import { ManishcreateComponent } from './manishcreate/manishcreate.component';
import { ManishallComponent } from './manishall/manishall.component';
import { ManisheditComponent } from './manishedit/manishedit.component';
import { CategoryviewComponent } from './categoryview/categoryview.component';
import { ManishviewComponent } from './manishview/manishview.component';
import { AdminhomeComponent } from './adminhome/adminhome.component';
import { LoginadminComponent } from './loginadmin/loginadmin.component';
import { ProblemcreateComponent } from './problemcreate/problemcreate.component';
import { ProblemallComponent } from './problemall/problemall.component';
import { ProblemeditComponent } from './problemedit/problemedit.component';
import { ProblemviewComponent } from './problemview/problemview.component';
import { ManishappcreateComponent } from './manishappcreate/manishappcreate.component';
import { ManishappallComponent } from './manishappall/manishappall.component';
import { ManishappeditComponent } from './manishappedit/manishappedit.component';
import { ManishappviewComponent } from './manishappview/manishappview.component';
import { ThankyouimageComponent } from './thankyouimage/thankyouimage.component';
import { ContactcreateComponent } from './contactcreate/contactcreate.component';


const routes: Routes = [
  /* Home Coponent */
  {path:'',component:HomeComponent},
  {path: 'home', component:HomeComponent },
  {path: 'customerdashboard', component:CustomerdashboardComponent },
  {path: 'aboutus', component:AboutusComponent },
  {path: 'contactus', component:ContactusComponent },
  
  {path: 'login', component: LoginComponent},
  {path: 'adminhome', component: AdminhomeComponent},
  {path: 'loginadmin', component: LoginadminComponent},

  /*Customer Create / Update/ Delete */
  {path: 'add', component: CustomercreateComponent},
  {path: 'all', component: CustomerallComponent},
  {path : 'edit/:id', component: CustomereditComponent},

  /*Customer Dashboard */
  {path: 'customerhomepage', component:CustomerhomepageComponent },
  {path: 'history', component: HistoryComponent},

  

  /*Admin Page */
  {path: 'admin', component:AdminComponent },
  {path: 'category', component: CategoryComponent},
  {path: 'policydashboard', component: PolicydashboardComponent},
 
 /*Policy Create Update Delete View */ 
 {path : 'add4', component: ManishcreateComponent},
 {path : 'all4', component: ManishallComponent},
 {path : 'edit4/:id', component: ManisheditComponent},
 {path : 'view', component: ManishviewComponent},
 {path : 'all4', component: ManishviewComponent},
 

/*Category create update delete */
  {path : 'add3', component: CategorycreateComponent},
  {path : 'all3', component: CategoryallComponent},
  {path : 'edit3/:id', component: CategoryeditComponent},
  {path : 'categoryview', component: CategoryviewComponent},
  {path : 'all3', component: CategoryviewComponent},
  


/*Questions Update Delete Edit */
{path : 'add5', component: ProblemcreateComponent},
{path : 'all5', component: ProblemallComponent},
{path : 'edit5/:id', component: ProblemeditComponent},
{path : 'problemview', component: ProblemviewComponent},
{path : 'all5', component: ProblemviewComponent},



/*Apply Policy Approved Disapproved */

{path : 'add6', component: ManishappcreateComponent},
{path : 'all6', component: ManishappallComponent},
{path : 'edit6/:id', component: ManishappeditComponent},
{path : 'manishappview', component: ManishappviewComponent},
{path : 'all6', component: ManishappviewComponent},

{path : 'thankyou', component: ThankyouimageComponent},

{path: 'add8', component:ContactcreateComponent },


  {path: '', redirectTo: 'all', pathMatch:'full'},
  
  
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

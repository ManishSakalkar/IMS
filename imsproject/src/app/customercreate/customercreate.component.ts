import { Component, OnInit } from '@angular/core';
import { CustomerService } from '../customer.service';
import { Customer } from '../customer';
@Component({
  selector: 'app-customercreate',
  templateUrl: './customercreate.component.html',
  styleUrls: ['./customercreate.component.css']
})
export class CustomercreateComponent implements OnInit {
// form backing object
  // form backing object
  customer: Customer = new Customer(0,0,'','','','','','');
  // message to ui
  // message to ui
  message: string = '';

  // inject service class
  constructor(private service: CustomerService) { }

  ngOnInit(): void {
    // when page is loaded clear form data
    this.customer = new Customer(0,0,'','','','','','');
  }

  // tslint:disable-next-line: typedef
  createCustomer() {
    this.service.createCustomer(this.customer)
    .subscribe(data => {
      this.message = data; // read message
      this.customer = new Customer(0,0,'','','','','',''); // clear form
    }, error => {
      console.log(error);
    });
  }

}
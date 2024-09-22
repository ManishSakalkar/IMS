import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-customeredit',
  templateUrl: './customeredit.component.html',
  styleUrls: ['./customeredit.component.css']
})
export class CustomereditComponent implements OnInit {
// declare variables
  // declare variables
  id!: number;
  customer!: Customer;

  // inject service and acivated Route param
  constructor(private service: CustomerService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    // read id sent by all component as /edit/id
    // tslint:disable-next-line: no-string-literal
    this.id = this.activatedRoute.snapshot.params['id'];
    // make service call to get employee object
    this.service.getOneCustomer(this.id).subscribe(
      data => {
      this.customer = data;
      console.log(this.customer);
    }, error => {
      console.log(error);
    });
  }

  // tslint:disable-next-line: typedef
  updateCustomer() {
    this.service.updateCustomer(this.id, this.customer)
    .subscribe( data => {
      console.log(data);
      this.router.navigate(['all']);
    });
  }

  images = ['../../assets/admin.png']
}

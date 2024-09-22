import { Component, OnInit } from '@angular/core';
import { Customer } from '../customer';
import { CustomerService } from '../customer.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-customerall',
  templateUrl: './customerall.component.html',
  styleUrls: ['./customerall.component.css']
})
export class CustomerallComponent implements OnInit {
// send this data to UI
customers: Customer[] = [];
message: string ='';
// inject service layer
constructor(private service: CustomerService, private router: Router) { }

// on page load call this method
ngOnInit(): void {
  this.getAllCustomers();
}
// fetch data from backend application using service
// tslint:disable-next-line: typedef
getAllCustomers() {
  return this.service.getAllCustomers()
  .subscribe(
    data => {
      this.customers = data;
    }, error => {
      console.log(error);
    }
  );
}

// tslint:disable-next-line: typedef
deleteCustomer(id: number) {
  if (confirm('Do you want to delete?')) {
    this.service.deleteOneCustomer(id)
    .subscribe(data => {
      this.message = data;
      this.getAllCustomers();
    }, error => {
      console.log(error);
    });
  } else {
    this.message = '';
  }
}

// tslint:disable-next-line: typedef
editCustomer(id: number) {
  this.router.navigate(['edit', id]);
}

images = ['../../assets/admin.png']
}

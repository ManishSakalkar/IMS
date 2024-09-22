import { Component, OnInit } from '@angular/core';
import { Manishapp } from '../Manishapp';
import { ManishappService } from '../Manishapp.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-manishappall',
  templateUrl: './manishappall.component.html',
  styleUrls: ['./manishappall.component.css']
})
export class ManishappallComponent implements OnInit {

  // send this data to UI
  manishapps: Manishapp[] = [];
  message: string ='';
  // inject service layer
  constructor(private service: ManishappService, private router: Router) { }

  // on page load call this method
  ngOnInit(): void {
    this.getAllManishapps();
  }
  // fetch data from backend application using service
  // tslint:disable-next-line: typedef
  getAllManishapps() {
    return this.service.getAllManishapps()
    .subscribe(
      data => {
        this.manishapps = data;
      }, error => {
        console.log(error);
      }
    );
  }

  // tslint:disable-next-line: typedef
  deleteManishapp(id: number) {
    if (confirm('Do you want to disapprove?')) {
      this.service.deleteOneManishapp(id)
      .subscribe(data => {
        this.message = data;
        this.getAllManishapps();
      }, error => {
        console.log(error);
      });
    } else {
      this.message = '';
    }
  }

  // tslint:disable-next-line: typedef
  editManishapp(id: number) {
    this.router.navigate(['edit6', id]);
  }
  images = ['../../assets/admin.png'];
}



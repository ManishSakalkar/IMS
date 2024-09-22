import { Component, OnInit } from '@angular/core';
import { Manishapp } from '../Manishapp';
import { ManishappService } from '../Manishapp.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-manishappview',
  templateUrl: './manishappview.component.html',
  styleUrls: ['./manishappview.component.css']
})
export class ManishappviewComponent implements OnInit {

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

  
  images = ['../../assets/men.jpg'];
}




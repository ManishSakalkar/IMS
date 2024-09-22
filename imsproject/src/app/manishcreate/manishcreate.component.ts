import { Component, OnInit } from '@angular/core';
import { Manish } from '../manish';
import { ManishService } from '../manish.service';

@Component({
  selector: 'app-manishcreate',
  templateUrl: './manishcreate.component.html',
  styleUrls: ['./manishcreate.component.css']
})
export class ManishcreateComponent implements OnInit {
// form backing object
  // form backing object
  manish: Manish = new Manish(0,'','','','','');
  // message to ui
  // message to ui
  message: string = '';

  // inject service class
  constructor(private service: ManishService) { }

  ngOnInit(): void {
    // when page is loaded clear form data
    this.manish = new Manish(0,'','','','','');
  }

  // tslint:disable-next-line: typedef
  createManish() {
    this.service.createManish(this.manish)
    .subscribe(data => {
      this.message = data; // read message
      this.manish = new Manish(0,'','','','',''); // clear form
    }, error => {
      console.log(error);
    });
  }


  images = ['../../assets/admin.png']

}


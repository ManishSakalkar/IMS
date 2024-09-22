import { Component, OnInit } from '@angular/core';
import { Manishapp } from '../Manishapp';
import { ManishappService } from '../Manishapp.service';
@Component({
  selector: 'app-manishappcreate',
  templateUrl: './manishappcreate.component.html',
  styleUrls: ['./manishappcreate.component.css']
})
export class ManishappcreateComponent implements OnInit {
// form backing object
  // form backing object
  manishapp: Manishapp = new Manishapp(0,'','','','','');
  // message to ui
  // message to ui
  message: string = '';

  // inject service class
  constructor(private service: ManishappService) { }

  ngOnInit(): void {
    // when page is loaded clear form data
    this.manishapp = new Manishapp(0,'','','','','');
  }

  // tslint:disable-next-line: typedef
  createManishapp() {
    this.service.createManishapp(this.manishapp)
    .subscribe(data => {
      this.message = data; // read message
      this.manishapp = new Manishapp(0,'','','','',''); // clear form
    }, error => {
      console.log(error);
    });
  }


  images = ['../../assets/men.jpg']

}



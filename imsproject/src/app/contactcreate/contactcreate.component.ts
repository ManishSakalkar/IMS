import { Component, OnInit } from '@angular/core';
import { Contact } from '../Contact';
import { ContactService } from '../Contact.service';

@Component({
  selector: 'app-contactcreate',
  templateUrl: './contactcreate.component.html',
  styleUrls: ['./contactcreate.component.css']
})
export class ContactcreateComponent implements OnInit {

  //form backing object
  contact: Contact = new Contact (0,'','','','');
//message to UI
message: string = '';

//inject service class
  constructor(private service: ContactService) { }

  ngOnInit(): void {
    //when page is loaded clear form data
    this.contact = new Contact(0,'','','','');
  }

  //tslint:disable-nect-line:typedef
  createContact(){
    this.service.createContact(this.contact)
    .subscribe(data => {
      this.message = data; //read messgae
      this.contact = new Contact(0,'','','',''); //clear form
    }, error => {
      console.log(error);
    });
  }

}

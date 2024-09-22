import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Manish } from '../manish';
import { ManishService } from '../manish.service';

@Component({
  selector: 'app-manishall',
  templateUrl: './manishall.component.html',
  styleUrls: ['./manishall.component.css']
})
export class ManishallComponent implements OnInit {
// send this data to UI
manishs: Manish[] = [];
message: string ='';
// inject service layer
constructor(private service: ManishService, private router: Router) { }

// on page load call this method
ngOnInit(): void {
  this.getAllManishs();
}
// fetch data from backend application using service
// tslint:disable-next-line: typedef
getAllManishs() {
  return this.service.getAllManishs()
  .subscribe(
    data => {
      this.manishs = data;
    }, error => {
      console.log(error);
    }
  );
}

// tslint:disable-next-line: typedef
deleteManish(id: number) {
  if (confirm('Do you want to delete?')) {
    this.service.deleteOneManish(id)
    .subscribe(data => {
      this.message = data;
      this.getAllManishs();
    }, error => {
      console.log(error);
    });
  } else {
    this.message = '';
  }
}

// tslint:disable-next-line: typedef
editManish(id: number) {
  this.router.navigate(['edit4', id]);
}

images = ['../../assets/admin.png']
}


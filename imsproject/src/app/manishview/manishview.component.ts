import { Component, OnInit } from '@angular/core';
import { Manish } from '../manish';
import { ManishService } from '../manish.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-manishview',
  templateUrl: './manishview.component.html',
  styleUrls: ['./manishview.component.css']
})
export class ManishviewComponent implements OnInit {
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

images = ['../../assets/admin.png']
}
import { Component, OnInit } from '@angular/core';
import { Manish } from '../manish';
import { ManishService } from '../manish.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-manishapply',
  templateUrl: './manishapply.component.html',
  styleUrls: ['./manishapply.component.css']
})
export class ManishapplyComponent implements OnInit {
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
editManish(id: number) {
  this.router.navigate(['edit4', id]);
}

images = ['../../assets/men.jpg']
}

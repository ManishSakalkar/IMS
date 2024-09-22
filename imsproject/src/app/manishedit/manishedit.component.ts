import { Component, OnInit } from '@angular/core';
import { Manish } from '../manish';
import { ManishService } from '../manish.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-manishedit',
  templateUrl: './manishedit.component.html',
  styleUrls: ['./manishedit.component.css']
})
export class ManisheditComponent implements OnInit {
// declare variables
  // declare variables
  id!: number;
  manish!: Manish;

  // inject service and acivated Route param
  constructor(private service: ManishService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    // read id sent by all component as /edit/id
    // tslint:disable-next-line: no-string-literal
    this.id = this.activatedRoute.snapshot.params['id'];
    // make service call to get employee object
    this.service.getOneManish(this.id).subscribe(
      data => {
      this.manish = data;
      console.log(this.manish);
    }, error => {
      console.log(error);
    });
  }

  // tslint:disable-next-line: typedef
  updateManish() {
    this.service.updateManish(this.id, this.manish)
    .subscribe( data => {
      console.log(data);
      this.router.navigate(['all4']);
    });
  }

  images = ['../../assets/admin.png']
}


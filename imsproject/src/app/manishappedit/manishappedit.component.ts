import { Component, OnInit } from '@angular/core';
import { Manishapp } from '../Manishapp';
import { ManishappService } from '../Manishapp.service';
import { ActivatedRoute, Router } from '@angular/router';

@Component({
  selector: 'app-manishappedit',
  templateUrl: './manishappedit.component.html',
  styleUrls: ['./manishappedit.component.css']
})
export class ManishappeditComponent implements OnInit {
// declare variables
  // declare variables
  id!: number;
  manishapp!: Manishapp;

  // inject service and acivated Route param
  constructor(private service: ManishappService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    // read id sent by all component as /edit/id
    // tslint:disable-next-line: no-string-literal
    this.id = this.activatedRoute.snapshot.params['id'];
    // make service call to get employee object
    this.service.getOneManishapp(this.id).subscribe(
      data => {
      this.manishapp = data;
      console.log(this.manishapp);
    }, error => {
      console.log(error);
    });
  }

  // tslint:disable-next-line: typedef
  updateManishapp() {
    this.service.updateManishapp(this.id, this.manishapp)
    .subscribe( data => {
      console.log(data);
      this.router.navigate(['all6']);
    });
  }

  images = ['../../assets/admin.png']
}


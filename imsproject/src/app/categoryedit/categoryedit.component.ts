import { Component, OnInit } from '@angular/core';
import { Category } from '../category';
import { CategoryService } from '../category.service';
import { ActivatedRoute,Router } from '@angular/router';

@Component({
  selector: 'app-categoryedit',
  templateUrl: './categoryedit.component.html',
  styleUrls: ['./categoryedit.component.css']
})
export class CategoryeditComponent implements OnInit {

 // declare variables
  // declare variables
  id!: number;
  category!: Category;

  // inject service and acivated Route param
  constructor(private service: CategoryService, private router: Router, private activatedRoute: ActivatedRoute) { }

  ngOnInit(): void {
    // read id sent by all component as /edit/id
    // tslint:disable-next-line: no-string-literal
    this.id = this.activatedRoute.snapshot.params['id'];
    // make service call to get employee object
    this.service.getOneCategory(this.id).subscribe(
      data => {
      this.category = data;
      console.log(this.category);
    }, error => {
      console.log(error);
    });
  }

  // tslint:disable-next-line: typedef
  updatePolicy() {
    this.service.updateCategory(this.id, this.category)
    .subscribe( data => {
      console.log(data);
      this.router.navigate(['all3']);
    });
  }

  images = ['../../assets/men.jpg']
}

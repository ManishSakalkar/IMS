import { Component, OnInit } from '@angular/core';
import { CategoryService } from '../category.service';
import { Category } from '../category';

@Component({
  selector: 'app-categorycreate',
  templateUrl: './categorycreate.component.html',
  styleUrls: ['./categorycreate.component.css']
})
export class CategorycreateComponent implements OnInit {
// form backing object
  // form backing object
  category: Category = new Category(0,'','');
  // message to ui
  // message to ui
  message: string = '';

  // inject service class
  constructor(private service: CategoryService) { }

  ngOnInit(): void {
    // when page is loaded clear form data
    this.category = new Category(0,'','');
  }

  // tslint:disable-next-line: typedef
  createCategory() {
    this.service.createCategory(this.category)
    .subscribe(data => {
      this.message = data; // read message
      this.category = new Category(0,'',''); // clear form
    }, error => {
      console.log(error);
    });
  }


  images = ['../../assets/admin.png']

}

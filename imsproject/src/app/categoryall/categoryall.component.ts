import { Component, OnInit } from '@angular/core';
import { Category } from '../category';
import { CategoryService } from '../category.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-categoryall',
  templateUrl: './categoryall.component.html',
  styleUrls: ['./categoryall.component.css']
})
export class CategoryallComponent implements OnInit {
// send this data to UI
categorys: Category[] = [];
message: string ='';
// inject service layer
constructor(private service: CategoryService, private router: Router) { }

// on page load call this method
ngOnInit(): void {
  this.getAllCategorys();
}
// fetch data from backend application using service
// tslint:disable-next-line: typedef
getAllCategorys() {
  return this.service.getAllCategorys()
  .subscribe(
    data => {
      this.categorys = data;
    }, error => {
      console.log(error);
    }
  );
}

// tslint:disable-next-line: typedef
deleteCategory(id: number) {
  if (confirm('Do you want to delete?')) {
    this.service.deleteOneCategory(id)
    .subscribe(data => {
      this.message = data;
      this.getAllCategorys();
    }, error => {
      console.log(error);
    });
  } else {
    this.message = '';
  }
}

// tslint:disable-next-line: typedef
editCategory(id: number) {
  this.router.navigate(['edit3', id]);
}

images = ['../../assets/admin.png']
}

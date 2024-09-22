import { Component, OnInit } from '@angular/core';
import { Category } from '../category';
import { CategoryService } from '../category.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-categoryview',
  templateUrl: './categoryview.component.html',
  styleUrls: ['./categoryview.component.css']
})
export class CategoryviewComponent implements OnInit {
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

images = ['../../assets/admin.png']
}

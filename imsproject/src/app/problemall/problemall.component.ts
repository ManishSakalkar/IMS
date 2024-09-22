import { Component, OnInit } from '@angular/core';
import { Problem } from '../problem';
import { ProblemService } from '../problem.service';
import { Router } from '@angular/router';

@Component({
  selector: 'app-problemall',
  templateUrl: './problemall.component.html',
  styleUrls: ['./problemall.component.css']
})
export class ProblemallComponent implements OnInit {

  // send this data to UI
  problems: Problem[] = [];
  message: string ='';
  // inject service layer
  constructor(private service: ProblemService, private router: Router) { }

  // on page load call this method
  ngOnInit(): void {
    this.getAllProblems();
  }
  // fetch data from backend application using service
  // tslint:disable-next-line: typedef
  getAllProblems() {
    return this.service.getAllProblems()
    .subscribe(
      data => {
        this.problems = data;
      }, error => {
        console.log(error);
      }
    );
  }

  // tslint:disable-next-line: typedef
  deleteProblem(id: number) {
    if (confirm('Do you want to delete?')) {
      this.service.deleteOneProblem(id)
      .subscribe(data => {
        this.message = data;
        this.getAllProblems();
      }, error => {
        console.log(error);
      });
    } else {
      this.message = '';
    }
  }

  // tslint:disable-next-line: typedef
  editProblem(id: number) {
    this.router.navigate(['edit5', id]);
  }
  images = ['../../assets/admin.png'];
}



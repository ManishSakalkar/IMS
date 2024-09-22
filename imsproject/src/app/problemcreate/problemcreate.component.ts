import { Component, OnInit } from '@angular/core';
import { Problem } from '../problem';
import { ProblemService } from '../problem.service';
@Component({
  selector: 'app-problemcreate',
  templateUrl: './problemcreate.component.html',
  styleUrls: ['./problemcreate.component.css']
})
export class ProblemcreateComponent implements OnInit {
// form backing object
  // form backing object
  problem: Problem = new Problem(0,'','','');
  // message to ui
  // message to ui
  message: string = '';

  // inject service class
  constructor(private service: ProblemService) { }

  ngOnInit(): void {
    // when page is loaded clear form data
    this.problem = new Problem(0,'','','');
  }

  // tslint:disable-next-line: typedef
  createProblem() {
    this.service.createProblem(this.problem)
    .subscribe(data => {
      this.message = data; // read message
      this.problem = new Problem(0,'','',''); // clear form
    }, error => {
      console.log(error);
    });
  }


  images = ['../../assets/men.jpg']

}


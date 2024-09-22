import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-adminhome',
  templateUrl: './adminhome.component.html',
  styleUrls: ['./adminhome.component.css']
})
export class AdminhomeComponent implements OnInit {

  constructor() { }

  ngOnInit(): void {
  }
  images = ['../../assets/9.jpg','../../assets/Car_1.jpg','../../assets/Car_2.jpg'];

}

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { CustomerallComponent } from './customerall.component';

describe('CustomerallComponent', () => {
  let component: CustomerallComponent;
  let fixture: ComponentFixture<CustomerallComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ CustomerallComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(CustomerallComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

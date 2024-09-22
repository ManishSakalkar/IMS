import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PolicydashboardComponent } from './policydashboard.component';

describe('PolicydashboardComponent', () => {
  let component: PolicydashboardComponent;
  let fixture: ComponentFixture<PolicydashboardComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PolicydashboardComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(PolicydashboardComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

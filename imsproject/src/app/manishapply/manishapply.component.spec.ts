import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManishapplyComponent } from './manishapply.component';

describe('ManishapplyComponent', () => {
  let component: ManishapplyComponent;
  let fixture: ComponentFixture<ManishapplyComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManishapplyComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManishapplyComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

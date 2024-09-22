import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManishcreateComponent } from './manishcreate.component';

describe('ManishcreateComponent', () => {
  let component: ManishcreateComponent;
  let fixture: ComponentFixture<ManishcreateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManishcreateComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManishcreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

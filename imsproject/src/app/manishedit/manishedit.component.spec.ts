import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ManisheditComponent } from './manishedit.component';

describe('ManisheditComponent', () => {
  let component: ManisheditComponent;
  let fixture: ComponentFixture<ManisheditComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ ManisheditComponent ]
    })
    .compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(ManisheditComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

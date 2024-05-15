import { ComponentFixture, TestBed } from '@angular/core/testing';

import { PassUpdateComponent } from './pass-update.component';

describe('PassUpdateComponent', () => {
  let component: PassUpdateComponent;
  let fixture: ComponentFixture<PassUpdateComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [ PassUpdateComponent ]
    })
    .compileComponents();

    fixture = TestBed.createComponent(PassUpdateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

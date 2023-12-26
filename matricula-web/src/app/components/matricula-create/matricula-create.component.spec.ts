import { ComponentFixture, TestBed } from '@angular/core/testing';

import { MatriculaCreateComponent } from './matricula-create.component';

describe('MatriculaCreateComponent', () => {
  let component: MatriculaCreateComponent;
  let fixture: ComponentFixture<MatriculaCreateComponent>;

  beforeEach(() => {
    TestBed.configureTestingModule({
      declarations: [MatriculaCreateComponent]
    });
    fixture = TestBed.createComponent(MatriculaCreateComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

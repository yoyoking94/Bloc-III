import { ComponentFixture, TestBed } from '@angular/core/testing';

import { TachesDuProjetComponent } from './taches-du-projet.component';

describe('TachesDuProjetComponent', () => {
  let component: TachesDuProjetComponent;
  let fixture: ComponentFixture<TachesDuProjetComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [TachesDuProjetComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(TachesDuProjetComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ProjetMembersComponent } from './projet-members.component';

describe('ProjetMembersComponent', () => {
  let component: ProjetMembersComponent;
  let fixture: ComponentFixture<ProjetMembersComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ProjetMembersComponent]
    })
    .compileComponents();

    fixture = TestBed.createComponent(ProjetMembersComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

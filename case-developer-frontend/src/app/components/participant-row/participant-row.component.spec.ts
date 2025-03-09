import { ComponentFixture, TestBed } from '@angular/core/testing';

import { ParticipantRowComponent } from './participant-row.component';

describe('ParticipantRowComponent', () => {
  let component: ParticipantRowComponent;
  let fixture: ComponentFixture<ParticipantRowComponent>;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      imports: [ParticipantRowComponent]
    })
    .compileComponents();
    
    fixture = TestBed.createComponent(ParticipantRowComponent);
    component = fixture.componentInstance;
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });
});

import { ComponentFixture, TestBed, fakeAsync, tick } from '@angular/core/testing';
import { HttpClientTestingModule } from '@angular/common/http/testing';
import { of } from 'rxjs';

import { BirthdayComponent } from './birthday.component';
import { HttpClient } from '@angular/common/http';

describe('BirthdayComponent', () => {
  let component: BirthdayComponent;
  let fixture: ComponentFixture<BirthdayComponent>;
  let httpClient: HttpClient;

  beforeEach(async () => {
    await TestBed.configureTestingModule({
      declarations: [BirthdayComponent],
      imports: [HttpClientTestingModule]
    }).compileComponents();
  });

  beforeEach(() => {
    fixture = TestBed.createComponent(BirthdayComponent);
    component = fixture.componentInstance;
    httpClient = TestBed.inject(HttpClient);
    fixture.detectChanges();
  });

  it('should create', () => {
    expect(component).toBeTruthy();
  });

  it('should calculate days left', fakeAsync(() => {
    const daysLeft = 10; // Mocked days left value
    spyOn(httpClient, 'post').and.returnValue(of({ daysLeft }));

    component.birthdate = '1992-06-14'; // Provide a sample birthdate
    component.calculateDays();
    tick();

    expect(component.daysLeft).toEqual(daysLeft);
  }));
});

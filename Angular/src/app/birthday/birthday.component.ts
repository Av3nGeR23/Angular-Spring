import { Component, ChangeDetectorRef } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Component({
  selector: 'app-birthday',
  templateUrl: './birthday.component.html',
  styleUrls: ['./birthday.component.css']
})
export class BirthdayComponent {
  birthdate: string = '';
  daysLeft: number | undefined;
  hoursLeft: number | undefined;   
  secondsLeft: number | undefined;  

  constructor(private http: HttpClient, private cdr: ChangeDetectorRef) { }

  calculateDays() {
    console.log('Calculating days...');
    console.log('Birthdate:', this.birthdate);

    this.http.post<any>('http://localhost:8080/api/calculate-days', { birthdate: this.birthdate }).subscribe(data => {
      console.log('Response from backend:', data);

      this.daysLeft = data.days;
      this.hoursLeft = data.hours;
      this.secondsLeft = data.seconds;
      
      this.cdr.detectChanges(); // Forzar detección de cambios
    });
  }
}

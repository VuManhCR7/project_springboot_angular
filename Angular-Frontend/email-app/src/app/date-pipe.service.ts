import { Injectable, OnInit } from '@angular/core';
import { Email } from './email';

@Injectable({
  providedIn: 'root'
})
export class DatePipeService implements OnInit {
  email!: Email;
  dayCreated = this.email.ngay_tao;
  dayFixed = this.email.ngay_sua;
  constructor() { }

  ngOnInit(): void {
    throw new Error('Method not implemented.');
  }


}

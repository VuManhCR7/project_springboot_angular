import { Component, Input, OnInit } from '@angular/core';
import { Observable } from 'rxjs';
import { Email } from '../email';
import { Router } from '@angular/router';
import { EmailService } from '../email.service';

@Component({
  selector: 'app-email-list',
  templateUrl: './email-list.component.html',
  styleUrls: ['./email-list.component.css']
})
export class EmailListComponent implements OnInit {
  emails!: Observable<Email[]>;

  constructor(private emailService: EmailService,
    private router: Router) {}

  ngOnInit() {
      this.reloadData();
  }

  reloadData() {
    this.emails = this.emailService.getEmails();
  }

  deleteEmail(id: number) {
    this.emailService.deleteEmail(id).
    subscribe (
      data => {
        console.log(data);
        this.reloadData();
      }
    );
  }

  editEmail(id: number) {
    this.router.navigate(['update', id]);
  }

}

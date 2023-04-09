import { Component, OnInit } from '@angular/core';
import { Router } from '@angular/router';
import { Email } from '../email';
import { EmailService } from '../email.service';

@Component({
  selector: 'app-create-email',
  templateUrl: './create-email.component.html',
  styleUrls: ['./create-email.component.css']
})
export class CreateEmailComponent implements OnInit{
  email: Email = new Email();
  submitted = false;

  constructor(private emailService: EmailService,
    private router: Router) { }

    ngOnInit() {

    }

    newEmail(): void {
      this.submitted = false;
      this.email = new Email();
    }

    save() {
      this.emailService.addEmail(this.email).
       subscribe(
          data => {
          console.log(data);
          this.email = new Email();
          this.goToList();
        }
      );
    }

    onSubmit() {
      this.submitted = true;
      this.save();
    }

    goToList() {
      this.router.navigate(['/emails']);
    }
}

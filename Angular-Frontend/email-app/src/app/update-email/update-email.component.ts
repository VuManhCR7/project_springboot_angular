import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { Email } from '../email';
import { EmailService } from '../email.service';

@Component({
  selector: 'app-update-email',
  templateUrl: './update-email.component.html',
  styleUrls: ['./update-email.component.css']
})
export class UpdateEmailComponent implements OnInit {
  id!: number;
  email!: Email;
  submitted = false;

  constructor(private route: ActivatedRoute, private router: Router,
    private emailService: EmailService) { }
    
    ngOnInit() {
      this.email = new Email();
      this.id = this.route.snapshot.params['id'];
      this.emailService.getEmail(this.id).subscribe (
        data => {
          console.log(data);
          this.email = data;
        }
      );
    }

    editEmail() {
      this.submitted = false;
      this.emailService.editEmail(this.id, this.email).
      subscribe (
        data => {
          console.log(data);
          this.email = new Email();
          this.goToList();
        }
      );
    }

    onSubmit() {
      this.submitted = true;
      this.editEmail();
    }

    goToList() {
      this.router.navigate(['/emails'])
    }
}

import { Component, OnInit } from '@angular/core';
import { ActivatedRoute, Router } from '@angular/router';
import { EmailService } from '../email.service';

@Component({
  selector: 'app-delete-email',
  templateUrl: './delete-email.component.html',
  styleUrls: ['./delete-email.component.css']
})
export class DeleteEmailComponent implements OnInit {
  id!: number;
  data: any;

  constructor(private route: ActivatedRoute, private router: Router,
    private emailService: EmailService) { }
    
    ngOnInit(): void {
      this.id = this.route.snapshot.params['id'];
      this.route.queryParams.subscribe (
        (param) => {
          console.log(this.id);
          this.id = +param['id'];
          this.reloadData();
        }
      );
    }

    private reloadData() {
      this.emailService.getEmail(this.id).subscribe(
        (data) => {
          this.data = data;
          console.log(data);
        }
      );
    }

    public exit(){
      this.router.navigate(["/emails"]);
    }
  
    public confirmDelete(id: number){
      this.emailService.deleteEmail(id).subscribe((data) =>{
        console.log(data);
        this.router.navigate(["/emails"]);
      });
    }
}

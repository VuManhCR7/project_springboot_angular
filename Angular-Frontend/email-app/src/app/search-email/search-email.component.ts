import { Component, OnInit } from '@angular/core';
import { EmailService } from '../email.service';
import { ActivatedRoute, Router } from '@angular/router';
import { FormControl, FormGroup, ReactiveFormsModule } from '@angular/forms';

@Component({
  selector: 'app-search-email',
  templateUrl: './search-email.component.html',
  styleUrls: ['./search-email.component.css']
})
export class SearchEmailComponent implements OnInit {
  public keyword: any;
  public data: any;
  public totalPages: any;
  public pages: number[] = [];
  constructor(private emailService: EmailService, private router: Router,
    private route: ActivatedRoute) {
    
  }

  ngOnInit(): void {
    //Called after the constructor method, initializing input properties, and
    //the first call to ngOnChanges.
  }

  public post = new FormGroup({
    id: new FormControl(''),
    ma: new FormControl(''),
    noi_dung: new FormControl(''),
    nguoi_tao: new FormControl(''),
    ngay_tao: new FormControl(''),
    nguoi_sua: new FormControl(''),
    ngay_sua: new FormControl('')
  });

  public SearchByPagingCriteria(page: any){
    console.log(this.post.value);
    this.emailService.getEmailsByPagingCriteria(this.post.value, page).subscribe((data)=> {
    this.data = data;
    })
    this.pages = [];
    this.SearchByCriteria();
  }

  public SearchByCriteria() {
    this.emailService.getCountEmailsByCriteria(this.post.value).subscribe(
      (data) => {
        console.log(data);
        if(data % 2 == 0) {
          this.totalPages = data/4;
        }
        else {
          this.totalPages = Math.floor(data/4) + 1;
        }

        for (let i = 0; i < this.totalPages; i++) {
          this.pages.push(i);
        }
      }
    )
  }

  deleteEmail(id: number) {
    this.emailService.deleteEmail(id).
    subscribe (
      (data: any) => {
        console.log(data);
      }
    );
  }

  editEmail(id: number) {
    this.router.navigate(['update', id]);
  }
  
}

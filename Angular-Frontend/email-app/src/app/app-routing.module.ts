import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { CreateEmailComponent } from './create-email/create-email.component';
import { DeleteEmailComponent } from './delete-email/delete-email.component';
import { EmailListComponent } from './email-list/email-list.component';
import { SearchEmailComponent } from './search-email/search-email.component';
import { UpdateEmailComponent } from './update-email/update-email.component';

const routes: Routes = [
  { path: '', redirectTo: 'email', pathMatch: 'full' },
  { path: 'emails', component: EmailListComponent },
  { path: 'addemail', component: CreateEmailComponent },
  { path: 'search', component: SearchEmailComponent },
  {path: 'emails/:id', component: DeleteEmailComponent },
  { path: 'update/:id', component: UpdateEmailComponent},
];
//Thư mục cấu hình đường dẫn thực thi tương ứng với mỗi Component
//Tức là mỗi Component sẽ được ánh xạ tới một đường dẫn để Angular Router biết Component nào sẽ hiển thị
//dựa trên url trên thanh địa chỉ của trình duyệt
@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }

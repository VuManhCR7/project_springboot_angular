import { HttpClientModule } from '@angular/common/http';
import { NgModule } from '@angular/core';
import { FormsModule, ReactiveFormsModule } from '@angular/forms';
import { BrowserModule } from '@angular/platform-browser';
import { HTTP_INTERCEPTORS } from '@angular/common/http';
import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { CreateEmailComponent } from './create-email/create-email.component';
import { EmailListComponent } from './email-list/email-list.component';
import { UpdateEmailComponent } from './update-email/update-email.component';
import { BrowserAnimationsModule } from '@angular/platform-browser/animations';
import { SearchEmailComponent } from './search-email/search-email.component';
import { DeleteEmailComponent } from './delete-email/delete-email.component';
import { LoginFormComponent } from './login-form/login-form.component';

@NgModule({
  declarations: [
    AppComponent,
    CreateEmailComponent,
    EmailListComponent,
    UpdateEmailComponent,
    SearchEmailComponent,
    DeleteEmailComponent,
    LoginFormComponent,
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule,
    ReactiveFormsModule,
    BrowserAnimationsModule,
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

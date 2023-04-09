import { Injectable } from '@angular/core';
import { HttpClient, HttpErrorResponse, HttpHeaders } from '@angular/common/http'
import { catchError, Observable, throwError } from 'rxjs';
import { Email } from './email';

const httpOptions = {
  headers: new HttpHeaders({'Content-Type': 'Application/Json'})
}

@Injectable({
  providedIn: 'root'
}
)
export class EmailService {
  private baseURL = "http://localhost:8085/emails";

  constructor(private http : HttpClient) { }

  getEmails(): Observable<Email[]> {
    return this.http.get<Email[]>(this.baseURL);
  }
  
  getEmail(id: number): Observable<any> {
    return this.http.get(`${this.baseURL}/${id}`);
  }

  addEmail(email: Object): Observable<Object> {
    let uri = "http://localhost:8085/addemail";
    return this.http.post(`${uri}`, email);
  }

  editEmail(id: number, value: any): Observable<Object> {
    return this.http.put(`${this.baseURL}/${id}`, value);
  }

  deleteEmail(id: number): Observable<any> {
    return this.http.delete(`${this.baseURL}/${id}`, { responseType: 'text' });
  }

  public getCountEmailsByCriteria(data: Object): Observable<any>{
    const url = `http://localhost:8085/count-emails-by-criteria`;
    return this.http.post<any>(url, data, httpOptions).pipe(catchError(this.handleError));
  }

  public getEmailsByPagingCriteria(data: Object, page: any): Observable<any>{
    const url = `http://localhost:8085/emails?page=${page}`;
    return this.http.post<any>(url, data, httpOptions).pipe(catchError(this.handleError));
  }

  private handleError(error: HttpErrorResponse) {
    if (error.status === 0) {
      // A client-side or network error occurred. Handle it accordingly.
      console.error('An error occurred:', error.error);
    } else {
      // The backend returned an unsuccessful response code.
      // The response body may contain clues as to what went wrong.
      console.error(
        `Backend returned code ${error.status}, body was: `, error.error);
    }
    // Return an observable with a user-facing error message.
    return throwError(() => new Error('Something bad happened; please try again later.'));
  }

}


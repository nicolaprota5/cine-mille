import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { environment } from 'src/environments/environment';

@Injectable({
  providedIn: 'root'
})
export class FilmService {

  private url: string = "v1/film/";

  constructor(private httpClient: HttpClient) {

  }

  public getAllFilms(): Observable<any> {
    return this.httpClient.get(environment.WS_BASE_URL + this.url);
  }
}

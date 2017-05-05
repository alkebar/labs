import { Local } from './../domain/local';
import { Page } from './../domain/page';

import { Injectable } from '@angular/core';
import { Http } from '@angular/http';
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Rx';
import { Headers, RequestOptions } from '@angular/http';



@Injectable()
export class LocalService {

   private url: string = "http://localhost:8080/sduSpring/api/locais";

  constructor(private http: Http) { }

  getLocais() {
    return this.http.get(this.url)
      .map(res => <Page<Local>>res.json());
  }

}

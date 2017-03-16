import { Material } from './../domain/material';
import { Page } from './../domain/page';
import { Injectable } from '@angular/core';
import { Http } from "@angular/http";
import 'rxjs/add/operator/map';
import { Observable } from 'rxjs/Rx';
import { Headers, RequestOptions } from '@angular/http';

@Injectable()
export class MaterialService {


  private url: string = "http://localhost:8080/sduSpring/api/materiais";

  constructor(private http: Http) { }

  getMaterial() {
    return this.http.get(this.url)
      .map(res => <Page<Material>>res.json());
  }

}

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

  getMateriais() {
    return this.http.get(this.url)
      .map(res => <Page<Material>>res.json());
  }





   getMaterial(id){
    return this.http.get(this.getMaterialUrl(id))
      .map(res => res.json());
  }

updateMaterial(material){
    return this.http.put(this.getMaterialUrl(material.id), material)
      .map(res => <Material>res.json());
  }

 addMaterial(material){
    return this.http.post(this.url, material)
      .map(res => <Material>res.json());
  }

  deleteMaterial(id){
    return this.http.delete(this.getMaterialUrl(id));
  }


private getMaterialUrl(id){
    return this.url + "/" + id;
  }
   
}

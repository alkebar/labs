import { Movimentacao } from './../domain/movimentacao';
import { Page } from './../domain/page';
import { Http } from '@angular/http';
import { Injectable } from '@angular/core';

@Injectable()
export class MovimentacaoService {



  private url: string = "http://localhost:8080/sduSpring/api/movimentacoes";

  constructor(private http: Http) { }

  getMovimentacoes() {
    return this.http.get(this.url)
      .map(res => <Page<Movimentacao>>res.json());
  }

  getMovimentacao(id) {
    return this.http.get(this.url + "/" + id)
      .map(res => res.json());
  }

 addMovimentacao(movimentacao){
    return this.http.post(this.url, movimentacao)
      .map(res => <Movimentacao>res.json());
  }

  updateMovimentacao(movimentacao){
    return this.http.put(this.getMovimentacaoUrl(movimentacao.id), movimentacao)
      .map(res => <Movimentacao>res.json());
  }

  private getMovimentacaoUrl(id){
    return this.url + "/" + id;
  }

}

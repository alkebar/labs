import { MovimentacaoService } from './../../../../service/movimentacao.service';
import { ActivatedRoute, Router } from '@angular/router';
import { Movimentacao } from './../../../../domain/movimentacao';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-movimentacao-edit',
  templateUrl: './movimentacao-edit.component.html',
  styleUrls: ['./movimentacao-edit.component.css']
})
export class MovimentacaoEditComponent implements OnInit {

  movimentacao: Movimentacao = new Movimentacao();
  title: string;
  
  

  constructor(private route: ActivatedRoute, 
              private router: Router,
              private movimentacaoService: MovimentacaoService) { 

  }

  ngOnInit() {
    this.route.params.subscribe(params =>{
      var id = params['id'];
      this.title = id ? 'Alterar Movimentacao' : 'Nova Movimentacao';

      if (!id)
        return;

      this.movimentacaoService.getMovimentacao(id)
        .subscribe(movimentacao => this.movimentacao = movimentacao)
    });
  }

  salvar(){

  }

  cancelar(){
    
  }

}

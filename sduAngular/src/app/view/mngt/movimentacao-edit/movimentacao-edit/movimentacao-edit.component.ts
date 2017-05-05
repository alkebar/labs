import { Page } from './../../../../domain/page';
import { MaterialService } from './../../../../service/material.service';
import { Material } from './../../../../domain/material';
import { ItemMovimentacao } from './../../../../domain/itemMovimentacao';
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
  novoItemMovimentacao: ItemMovimentacao = new ItemMovimentacao();
  itensMovimentacaoList: ItemMovimentacao[] = [];
    page: Page<Material> = new Page<Material>();
  
  

  constructor(private route: ActivatedRoute, 
              private router: Router,
              private movimentacaoService: MovimentacaoService,
              private materialService: MaterialService) { 

  }

  ngOnInit() {
    this.route.params.subscribe(params =>{
      var id = params['id'];
      this.title = id ? 'Alterar Movimentacao' : 'Nova Movimentacao';

      if (!id)
        return;

        //preenche o combo de Material
        this.materialService.getMateriais()
      .subscribe((page: Page<Material>) => this.page = page);

      this.movimentacaoService.getMovimentacao(id)
        .subscribe(movimentacao => this.movimentacao = movimentacao)
    });
  }

  addItem(){
    this.movimentacao.itensMovimentacao.push(this.novoItemMovimentacao);
    this.novoItemMovimentacao = new ItemMovimentacao();
    console.log(this.movimentacao.itensMovimentacao);
  }

  salvar(){
if (this.movimentacao.id){
      this.movimentacaoService.updateMovimentacao(this.movimentacao)
       .subscribe(
        response => this.router.navigate(['materiais']))

    } else {
      this.movimentacaoService.addMovimentacao(this.movimentacao)
      .subscribe(
        response => this.router.navigate(['materiais']))
    }
  }
  cancelar(){
    
  }

}

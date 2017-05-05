import { MovimentacaoService } from './../../../service/movimentacao.service';
import { ITdDataTableColumn } from '@covalent/core';
import { Movimentacao } from './../../../domain/movimentacao';
import { Page } from './../../../domain/page';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-movimentacao-list',
  templateUrl: './movimentacao-list.component.html',
  styleUrls: ['./movimentacao-list.component.css']
})
export class MovimentacaoListComponent implements OnInit {

  
  page: Page<Movimentacao> = new Page<Movimentacao>();



  columns: ITdDataTableColumn[] = [
    { name: 'id', label: 'Id' },
    { name: 'codMovimentacao', label: 'Cod. Movimentacao' },
    { name: 'localOrigem.nome', label: 'Origem' },
    { name: 'localDestino.nome', label: 'Destino' },
    { name: 'dtMovimentacao', label: 'Data da Movimentação' }
  ];

 constructor(private movimentacaoService: MovimentacaoService) { }
  
  ngOnInit() {
   this.findAll();
  }

  findAll() {
    this.movimentacaoService.getMovimentacoes()
      .subscribe((page: Page<Movimentacao>) => this.page = page);
  }

}

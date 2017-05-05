import { Router } from '@angular/router';
import { Material } from './../../../domain/material';
import { Page } from './../../../domain/page';
import { ITdDataTableColumn, TdDialogService } from '@covalent/core';
import { MaterialService } from './../../../service/material.service';
import { Component, OnInit } from '@angular/core';

@Component({
  selector: 'app-material-list',
  templateUrl: './material-list.component.html',
  styleUrls: ['./material-list.component.css']
})
export class MaterialListComponent implements OnInit {

  page: Page<Material> = new Page<Material>();



  columns: ITdDataTableColumn[] = [
    { name: 'id', label: 'Id' },
    { name: 'nome', label: 'Nome' },
    { name: 'peso', label: 'Peso' },
    { name: 'valorUnitario', label: 'ValorUnitario' },
    { name: 'materialType', label: 'MaterialType' }
  ];

  constructor(
    private materialService: MaterialService,
    private router: Router,
    private _dialogService: TdDialogService) { }

  ngOnInit() {
    this.findAll();
  }

  findAll() {
    this.materialService.getMateriais()
      .subscribe((page: Page<Material>) => this.page = page);
  }

  deleteMaterial(id: number) {

    this._dialogService.openConfirm({
      message: 'Deseja excluir este material?',
      disableClose: true,
      title: 'Exclusão', //OPTIONAL, hides if not provided
      cancelButton: 'Não', //OPTIONAL, defaults to 'CANCEL'
      acceptButton: 'Sim', //OPTIONAL, defaults to 'ACCEPT'
    }).afterClosed().subscribe((aceitou: boolean) => {
      if (aceitou) {
        this.materialService.deleteMaterial(id)
          .subscribe(() => this.findAll());
      } else {
        console.log("Não aceitou excluir o material");
      }
    });
  }

}
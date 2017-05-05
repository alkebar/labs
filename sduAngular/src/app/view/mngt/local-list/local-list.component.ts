import { LocalService } from './../../../service/local.service';
import { ITdDataTableColumn } from '@covalent/core';
import { Local } from './../../../domain/local';
import { Page } from './../../../domain/page';
import { Component, OnInit } from '@angular/core';


@Component({
  selector: 'app-local-list',
  templateUrl: './local-list.component.html',
  styleUrls: ['./local-list.component.css']
})
export class LocalListComponent implements OnInit {


  page: Page<Local> = new Page<Local>();



  columns: ITdDataTableColumn[] = [
    { name: 'nome', label: 'Nome' },
    { name: 'email', label: 'Email' },
    { name: 'numeroZona', label: 'Número da Zona' },
    { name: 'localType', label: 'LocalType' }
  ];

 constructor(private localService: LocalService) { }
  
  ngOnInit() {
   this.findAll();
  }

  findAll() {
    this.localService.getLocais()
      .subscribe((page: Page<Local>) => this.page = page);
  }

}

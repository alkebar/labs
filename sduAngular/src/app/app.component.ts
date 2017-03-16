import { Page } from './domain/page';
import { MaterialService } from './service/material.service';
import { Material } from './domain/material';
import { Component, ViewContainerRef, AfterViewInit, OnInit } from '@angular/core';
import { MdIconRegistry } from '@angular/material'
import { DomSanitizer } from '@angular/platform-browser'
import { TdDialogService, TdLoadingService, LoadingType, ILoadingOptions, ITdDataTableColumn } from '@covalent/core';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements OnInit {

    title = 'app works!';

    //items: Object[];

    page: Page<Material>;

    materiais: Material[];

    columns: ITdDataTableColumn[] = [
        { name: 'id', label: 'Id' },
        { name: 'nome', label: 'Nome' },
        { name: 'peso', label: 'Peso' },
        { name: 'valorUnitario', label: 'ValorUnitario' },
        { name: 'descricao', label: 'Descricao' },
        { name: 'ordemRelevancia', label: 'OrdemRelevancia' },
        { name: 'materialType', label: 'MaterialType' }
    ];

    constructor(private materialService: MaterialService,
                private loadingService: TdLoadingService) {
    }

    ngOnInit(): void {
        this.loadingService.register('materiais.load');
        this.materialService.getMaterial()
            .subscribe(page => {
                
                    this.page = page
                    console.log(this.page);
                    this.materiais = page.content;
                    this.loadingService.resolve('materiais.load');
               
            });
    }
}

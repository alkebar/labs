import { Page } from './domain/page';
import { MaterialService } from './service/material.service';
import { Material } from './domain/material';
import { Component, ViewContainerRef, AfterViewInit, OnInit, AfterContentInit } from '@angular/core';
import { MdIconRegistry } from '@angular/material'
import { DomSanitizer } from '@angular/platform-browser'
import { TdDialogService, TdLoadingService, LoadingType, ILoadingOptions, ITdDataTableColumn, TdMediaService } from '@covalent/core';

@Component({
    selector: 'app-root',
    templateUrl: './app.component.html',
    styleUrls: ['./app.component.css']
})
export class AppComponent implements AfterViewInit, OnInit {

    title = 'app works!';

    page: Page<Material> = new Page<Material>();

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
        private loadingService: TdLoadingService,
        public media: TdMediaService) {
    }

    ngOnInit(): void {
        this.findAll();
    }

    ngAfterViewInit(): void {
    }

    findAll() {
        this.materialService.getMaterial()
            .subscribe((page: Page<Material>) => this.page = page );
    }
}

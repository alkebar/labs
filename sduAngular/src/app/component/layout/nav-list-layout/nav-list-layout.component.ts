import { Local } from './../../../domain/local';
import { LocalService } from './../../../service/local.service';
import { Material } from './../../../domain/material';
import { Page } from './../../../domain/page';
import { MaterialService } from './../../../service/material.service';

import { Component, OnInit, AfterViewInit, Input } from '@angular/core';



import { TdMediaService } from '@covalent/core';

@Component({
  selector: 'nav-list-layout',
  templateUrl: './nav-list-layout.component.html',
  styleUrls: ['./nav-list-layout.component.css']
})
export class NavListLayoutComponent implements OnInit, AfterViewInit {

  @Input() formTitle: string;
  materialCount: number = 0;
  localCount: number = 0;
  menu: string = ''

  constructor( public media: TdMediaService,
   private materialService: MaterialService,
   private localService: LocalService) { }


  ngOnInit() {
 this.materialService.getMateriais()
                            .subscribe((page: Page<Material>) => this.materialCount = page.numberOfElements)
  this.localService.getLocais()
                            .subscribe((page: Page<Local>) => this.localCount = page.numberOfElements)

  }


  ngAfterViewInit(): void {
    this.media.broadcast();
    // broadcast to all listener observables when loading the page
  }




}

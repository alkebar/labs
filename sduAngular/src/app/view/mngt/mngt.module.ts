import { MovimentacaoService } from './../../service/movimentacao.service';
import { LocalService } from './../../service/local.service';
import { MaterialService } from './../../service/material.service';
import { NavListLayoutComponent } from './../../component/layout/nav-list-layout/nav-list-layout.component';
import { BrowserModule } from '@angular/platform-browser';
import { NgModule, ModuleWithProviders } from '@angular/core';
import { FormsModule } from '@angular/forms';
import { HttpModule } from '@angular/http';

import { MaterialModule } from '@angular/material';
import { CovalentCoreModule, CovalentLayoutModule, CovalentExpansionPanelModule } from '@covalent/core';
import { MngtDashboardComponent } from './@dashboard/mngt-dashboard.component';
import { MngtRoutingModule } from './mngt-routing.module.';
import { MaterialListComponent } from './material-list/material-list.component';
import { LocalListComponent } from './local-list/local-list.component';
import { MovimentacaoListComponent } from './movimentacao-list/movimentacao-list.component';
import { MaterialEditComponent } from './material-edit/material-edit.component';
import { MovimentacaoEditComponent } from './movimentacao-edit/movimentacao-edit/movimentacao-edit.component';


@NgModule({
  declarations: [
    MngtDashboardComponent,
    MaterialListComponent,
    NavListLayoutComponent,
    LocalListComponent,
    MovimentacaoListComponent,
    MaterialEditComponent,
    MovimentacaoEditComponent
  ],
  imports: [
    BrowserModule,
    FormsModule,
    HttpModule,
    MaterialModule.forRoot(),
    CovalentCoreModule.forRoot(),
    CovalentLayoutModule.forRoot(),
    MngtRoutingModule
  ],
  providers:[MaterialService, LocalService, MovimentacaoService]
})
export class MngtModule {
  static forRoot(): ModuleWithProviders {
    return {
      ngModule: MngtModule,
      providers: []
    }
  }
}
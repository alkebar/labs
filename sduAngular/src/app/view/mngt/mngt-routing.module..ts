import { MovimentacaoEditComponent } from './movimentacao-edit/movimentacao-edit/movimentacao-edit.component';
import { MaterialEditComponent } from './material-edit/material-edit.component';
import { MovimentacaoListComponent } from './movimentacao-list/movimentacao-list.component';
import { LocalListComponent } from './local-list/local-list.component';
import { MaterialListComponent } from './material-list/material-list.component';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';
import { MngtDashboardComponent } from './@dashboard/mngt-dashboard.component';


const mgntRoutes: Routes = [
    { path: '', component: MngtDashboardComponent },
    {
        path: 'materiais', children: [
            { path: '', component: MaterialListComponent },
            { path: 'list', component: MaterialListComponent },
            { path: 'edit',  children:[
                { path: '', component: MaterialEditComponent },
                { path: ':id', component: MaterialEditComponent },
            ]}
        ],
    },
    {
        path: 'locais', children: [
            { path: '', component: LocalListComponent },
            { path: 'list', component: LocalListComponent }
        ],
    },
    {
        path: 'movimentacoes', children: [
            { path: '', component: MovimentacaoListComponent },
            { path: 'list', component: MovimentacaoListComponent },
            { path: 'edit', children:[
                { path: '', component: MovimentacaoEditComponent },
                { path: ':id', component: MovimentacaoEditComponent },
            ] }
        ],
    }


];

@NgModule({
    imports: [
        RouterModule.forChild(mgntRoutes)
    ],
    exports: [
        RouterModule
    ]
})

export class MngtRoutingModule { }
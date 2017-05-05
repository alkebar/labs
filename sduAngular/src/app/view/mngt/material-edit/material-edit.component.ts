import { materiaisType } from './../../../domain/constantes';

import { MaterialService } from './../../../service/material.service';
import { Material } from './../../../domain/material';
import { Component, OnInit, Input } from '@angular/core';
import { ActivatedRoute, Router } from "@angular/router";


@Component({
  selector: 'app-material-edit',
  templateUrl: './material-edit.component.html',
  styleUrls: ['./material-edit.component.css']
})
export class MaterialEditComponent implements OnInit {


// tiposMaterial: String[]=[];
  
  material: Material = new Material();
  
 title: string;

  constructor(private route: ActivatedRoute, private materialService: MaterialService, private router: Router) { }

  ngOnInit() {

 
    var id = this.route.params.subscribe(params => {
    var id = params['id'];
    this.title = id ? 'Alterar Material' : 'Novo Material';

    if (!id)
        return;
/**
 * a função subscribe retorna 3 parametros de callback
 * .subscribe(success, failure, complete);
 */
      this.materialService.getMaterial(id)
        .subscribe(
        material => this.material = material,
        response => {
          if (response.status == 404) {
            this.router.navigate(['NotFound']);
          }
        });
    });
  }


salvar(){
if (this.material.id){
      this.materialService.updateMaterial(this.material)
       .subscribe(
        response => this.router.navigate(['materiais']))

    } else {
      this.materialService.addMaterial(this.material)
      .subscribe(
        response => this.router.navigate(['materiais']))
    }

 
}


   cancelar(){
    this.router.navigate(['/materiais/list']);
  }

  getMAterialType(){
    return materiaisType;
  }

}

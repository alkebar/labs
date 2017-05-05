import { Local } from './local';
import { ItemMovimentacao } from './itemMovimentacao';
import { Page } from './page';

export class Movimentacao {

    id: number;
    codMovimentacao: string;
  //  itensMovimentacao: ItemMovimentacao = new ItemMovimentacao();
   itensMovimentacao: ItemMovimentacao[] = [];
    dtMovimentacao?: Date;
    dtConfirmacaoRecebimento?: Date;
    observacao?: string;
    localDestino: Local = new Local();
    localOrigem: Local = new Local()


    constructor(){
    }
    
}
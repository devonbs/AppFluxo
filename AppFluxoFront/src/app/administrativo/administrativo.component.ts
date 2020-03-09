import { Component, OnInit } from '@angular/core';
import { SystemService } from '../system.service';

@Component({
  selector: 'app-administrativo',
  templateUrl: './administrativo.component.html',
  styleUrls: ['./administrativo.component.css']
})
export class AdministrativoComponent implements OnInit {

  listagem: Array<any>;

  objetoAprovado = {
    idSolicitacao: null,
    nomePessoa: null,
    status: 'APROVADO',
    observacao: null,
    descricaoProduto: null,
    precoProduto: null
  };

  objetoReprovado = {
    idSolicitacao: null,
    nomePessoa: null,
    status: 'REPROVADO',
    observacao: null,
    descricaoProduto: null,
    precoProduto: null
  };

  constructor(private listaAdministrativo: SystemService) { }

  ngOnInit() {
    this.listar();
  }

  listar() {
    this.listaAdministrativo.filtrar(null).subscribe(dados => this.listagem = dados);
  }

  filtrar(filtro: any) {
    this.listaAdministrativo.filtrar(filtro).subscribe(filtro);
  }

}

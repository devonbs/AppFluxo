import { Component, OnInit } from '@angular/core';
import { SystemService } from '../system.service';

@Component({
  selector: 'app-listagem',
  templateUrl: './listagem.component.html',
  styleUrls: ['./listagem.component.css']
})
export class ListagemComponent implements OnInit {

  listagem: Array<any>;

  constructor(private listagemService: SystemService) { }

  ngOnInit() {
    this.listar();
  }

  listar() {
    this.listagemService.listar().subscribe(dados => this.listagem = dados);
  }

  aprovar(item: any) {
    this.listagemService.aprovar(item).subscribe(item);
    this.listar();
  }

  reprovar(item: any) {
    this.listagemService.reprovar(item).subscribe(item);
    this.listar();
  }

}

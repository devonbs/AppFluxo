import { Component, OnInit } from '@angular/core';
import { FormGroup } from '@angular/forms';
import { SystemService } from '../system.service';
import { EventEmitter } from 'events';

@Component({
  selector: 'app-formulario',
  templateUrl: './formulario.component.html',
  styleUrls: ['./formulario.component.css']
})
export class FormularioComponent implements OnInit {

  emitirItemCadastrado = new EventEmitter();

  constructor(private servico: SystemService) { }

  item: any;

  ngOnInit() {
    this.item = {};
  }

  adicionar(frm: FormGroup) {
    this.servico.adicionar(this.item).subscribe(resposta => {
      this.item = resposta;
    });
 }
}

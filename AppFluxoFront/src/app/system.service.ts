import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class SystemService {

  appFluxoUrl = 'http://localhost:8080/AppFluxo/buscarProdutosParaAprovacao';
  appNovaSolicitacao = 'http://localhost:8080/AppFluxo/novaSolicitacao';
  appAprovarSolicitacao = 'http://localhost:8080/AppFluxo/aprovarSolicitacao';
  appReprovarSolicitacao = 'http://localhost:8080/AppFluxo/reprovarSolicitacao';
  filtrarLista = 'http://localhost:8080/AppFluxo/filtrarLista';


  constructor(private http: HttpClient) { }

  listar() {
    return this.http.get<any[]>(`${this.appFluxoUrl}`);
  }

  adicionar(item: any) {
    return this.http.post(this.appNovaSolicitacao, item);
  }

  aprovar(item: any) {
    return this.http.post(this.appAprovarSolicitacao, item, {responseType: 'text'});
  }

  reprovar(item: any) {
    return this.http.post(this.appReprovarSolicitacao, item, {responseType: 'text'});
  }

  filtrar(item: any) {
    console.log(item);
    return this.http.post<any[]>(this.filtrarLista, item);
  }


}

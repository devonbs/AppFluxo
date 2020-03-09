import { NgModule, ModuleWithProviders } from '@angular/core';
import { CommonModule } from '@angular/common';
import { Routes, RouterModule } from '@angular/router';
import { FormularioComponent } from './formulario/formulario.component';
import { ListagemComponent } from './listagem/listagem.component';
import { AdministrativoComponent } from './administrativo/administrativo.component';


const routes: Routes = [
  {path: 'formulario', component: FormularioComponent},
  {path: 'listagem', component: ListagemComponent},
  {path: 'administrativo', component: AdministrativoComponent}
];

export const routing: ModuleWithProviders = RouterModule.forRoot(routes);

@NgModule({
  declarations: [],
  imports: [
    CommonModule
  ]
})
export class AppRoutingModule { }

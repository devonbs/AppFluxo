import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { HttpClientModule } from '@angular/common/http';
import { FormsModule } from '@angular/forms';

import { AppComponent } from './app.component';
import { SystemService } from './system.service';
import { ListagemComponent } from './listagem/listagem.component';
import { FormularioComponent } from './formulario/formulario.component';
import { AppRoutingModule, routing } from './app-routing.module';
import { DialogComponent } from './dialog/dialog.component';
import { AdministrativoComponent } from './administrativo/administrativo.component';

@NgModule({
  declarations: [
    AppComponent,
    ListagemComponent,
    FormularioComponent,
    DialogComponent,
    AdministrativoComponent
  ],
  imports: [
    BrowserModule,
    HttpClientModule,
    FormsModule,
    AppRoutingModule,
    routing
  ],
  providers: [ SystemService ],
  bootstrap: [AppComponent]
})
export class AppModule { }

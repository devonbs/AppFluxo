import { Component } from '@angular/core';


@Component({
  selector: 'app-root',
  templateUrl: './app.component.html',
  styleUrls: ['./app.component.css']
})
export class AppComponent {
  title = 'AppFluxoFront';

  loadComponente = false;

  click() {
    this.loadComponente = true;
    console.log(this.loadComponente);
  }

  carregarComponente() {
    this.loadComponente = true;
  }
}

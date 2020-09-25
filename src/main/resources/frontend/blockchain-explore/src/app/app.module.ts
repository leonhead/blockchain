import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { BlockListComponent } from './components/block-list/block-list.component';
import { HttpClientModule } from '@angular/common/http';


const routes: Routes = [
	{ path: 'blocks', component: BlockListComponent }
	]

@NgModule({
  declarations: [
    AppComponent,
    BlockListComponent
  ],
  imports: [
    BrowserModule,
	HttpClientModule,
	RouterModule.forRoot(routes),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }

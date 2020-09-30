import { BrowserModule } from '@angular/platform-browser';
import { NgModule } from '@angular/core';
import { Routes, RouterModule } from '@angular/router';

import { AppComponent } from './app.component';
import { BlockListComponent } from './components/block-list/block-list.component';
import { HttpClientModule } from '@angular/common/http';
import { TransactionListComponent } from './components/transaction-list/transaction-list.component';
import { BlockDetailsComponent } from './components/block-details/block-details.component';


const routes: Routes = [
	{ path: 'blocks', component: BlockListComponent },
	{ path: 'blocks/:hash', component: BlockDetailsComponent },
	{ path: 'transactions', component: TransactionListComponent },
	{ path: 'transactions/search/:keyword', component: TransactionListComponent },
	]

@NgModule({
  declarations: [
    AppComponent,
    BlockListComponent,
    TransactionListComponent,
    BlockDetailsComponent,
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

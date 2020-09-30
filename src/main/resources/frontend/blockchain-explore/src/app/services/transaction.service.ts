import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Transaction } from '../entity/transaction';

@Injectable({
	providedIn: 'root'
})
export class TransactionService {

	private transactionUrl = 'http://localhost:8080/api/transactions';

	constructor(private httpClient: HttpClient) { }


	getTransactions(): Observable<Transaction[]> {
		return this.httpClient.get<Transaction[]>(this.transactionUrl);
	}

	getTransactionsByBlock(block: string): Observable<Transaction[]> {
		return this.httpClient.get<Transaction[]>(`${this.transactionUrl}/search/findByBlockHash?block=${block}`);
	}
}

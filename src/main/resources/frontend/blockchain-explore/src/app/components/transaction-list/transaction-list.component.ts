import { Component, OnInit } from '@angular/core';
import { TransactionService } from 'src/app/services/transaction.service';
import { ActivatedRoute } from '@angular/router';
import { Transaction } from 'src/app/entity/transaction';

@Component({
	selector: 'app-transaction-list',
	templateUrl: './transaction-list.component.html',
	styleUrls: ['./transaction-list.component.css']
})
export class TransactionListComponent implements OnInit {

	transactions: Transaction[];

	constructor(private transactionService: TransactionService, private route: ActivatedRoute) { }

	ngOnInit(): void {
		this.route.paramMap.subscribe(() => {
			this.listTransactions();
		});
	}

	listTransactions() {
		const hasKeyword = this.route.snapshot.paramMap.has('keyword');
		if (hasKeyword) {
			this.findTransactionsByBlock();
		}
		else {
			this.findAllTransactions();
		}

	}

	findTransactionsByBlock() {
		const block = this.route.snapshot.paramMap.get('keyword');
		this.transactionService.getTransactionsByBlock(block).subscribe(data => {
			this.transactions = data;
		});
	}

	findAllTransactions() {
		this.transactionService.getTransactions().subscribe(data => {
			this.transactions = data;
		});
	}

}

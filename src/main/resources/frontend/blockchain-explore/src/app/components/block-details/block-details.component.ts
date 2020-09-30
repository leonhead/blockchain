import { Component, OnInit } from '@angular/core';
import { Block } from 'src/app/entity/block';
import { BlockService } from 'src/app/services/block.service';
import { ActivatedRoute } from '@angular/router';

@Component({
	selector: 'app-block-details',
	templateUrl: './block-details.component.html',
	styleUrls: ['./block-details.component.css']
})
export class BlockDetailsComponent implements OnInit {

	block: Block;

	constructor(private blockService: BlockService, private route: ActivatedRoute) { }

	ngOnInit(): void {
		this.getBlockDetails();
	}
	
	getBlockDetails(){
		const blockHash = this.route.snapshot.paramMap.get('hash');
		console.log(blockHash);
		this.blockService.getBlock(blockHash).subscribe((data) => {
			this.block = data;
		});
	}
}

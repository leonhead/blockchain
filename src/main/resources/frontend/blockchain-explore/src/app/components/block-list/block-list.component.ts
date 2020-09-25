import { Component, OnInit } from '@angular/core';
import { Block } from 'src/app/entity/block';
import { BlockService } from 'src/app/services/block.service';
import { ActivatedRoute } from '@angular/router';

@Component({
	selector: 'app-block-list',
	templateUrl: './block-list.component.html',
	styleUrls: ['./block-list.component.css']
})
export class BlockListComponent implements OnInit {

	constructor(private blockService: BlockService, private route: ActivatedRoute) { }

	blocks: Block[];

	ngOnInit(): void {
		this.route.paramMap.subscribe(() => {
			this.listBlock();
		});

	}


	listBlock() {
		this.blockService.getBlocks().subscribe((data) => {
			this.blocks = data;
		});
	}

}

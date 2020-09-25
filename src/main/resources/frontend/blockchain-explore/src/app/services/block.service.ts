import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { Block } from '../entity/block';
import { HttpClient } from '@angular/common/http';

@Injectable({
	providedIn: 'root'
})
export class BlockService {

	private blockUrl = 'http://localhost:8080/blocks/list';

	constructor(private httpClient: HttpClient) { }


	getBlocks(): Observable<Block[]> {
		return this.httpClient.get<Block[]>(this.blockUrl);
	}
}

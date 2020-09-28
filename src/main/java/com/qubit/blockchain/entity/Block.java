package com.qubit.blockchain.entity;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "block")
public class Block {

	@Id
	@Column(name = "hash")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String hash;

	@Column(name = "ver")
	private int ver;

	@Column(name = "next_block")
	private String nextBlock;

	@Column(name = "prev_block")
	private String prevBlock;

	@Column(name = "time")
	private long time;

	@Column(name = "bits")
	private int bits;

	@Column(name = "fee")
	private long fee;

	@Column(name = "n_tx")
	private long n_tx;

	@Column(name = "size")
	private int size;

	@Column(name = "block_index")
	private int blockIndex;

	@Column(name = "main_chain")
	private boolean mainChain;

	@Column(name = "height")
	private int height;

	@Column(name = "weight")
	private int weight;

	@OneToMany(fetch = FetchType.LAZY, mappedBy = "block", cascade = CascadeType.ALL)
	@JsonIgnore
	private List<Transaction> tx = new ArrayList<Transaction>();

	protected Block() {
	}

	public Block(String hash) {
		this.hash = hash;
	}

	public String getHash() {
		return hash;
	}

	public void setHash(String hash) {
		this.hash = hash;
	}

	public int getVer() {
		return ver;
	}

	public void setVer(int ver) {
		this.ver = ver;
	}

	public String getNextBlock() {
		return nextBlock;
	}

	public void setNextBlock(String nextBlock) {
		this.nextBlock = nextBlock;
	}

	public String getPrevBlock() {
		return prevBlock;
	}

	public void setPrevBlock(String prevBlock) {
		this.prevBlock = prevBlock;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getBits() {
		return bits;
	}

	public void setBits(int bits) {
		this.bits = bits;
	}

	public long getFee() {
		return fee;
	}

	public void setFee(long fee) {
		this.fee = fee;
	}

	public long getN_tx() {
		return n_tx;
	}

	public void setN_tx(long n_tx) {
		this.n_tx = n_tx;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getBlockIndex() {
		return blockIndex;
	}

	public void setBlockIndex(int blockIndex) {
		this.blockIndex = blockIndex;
	}

	public boolean isMainChain() {
		return mainChain;
	}

	public void setMainChain(boolean mainChain) {
		this.mainChain = mainChain;
	}

	public int getHeight() {
		return height;
	}

	public void setHeight(int height) {
		this.height = height;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public List<Transaction> getTx() {
		return tx;
	}

	public void setTx(List<Transaction> tx) {
		this.tx = tx;
	}

	public void addTx(Transaction transaction) {
		this.tx.add(transaction);
	}
}

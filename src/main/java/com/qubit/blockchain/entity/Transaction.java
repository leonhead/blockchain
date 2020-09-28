package com.qubit.blockchain.entity;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "transaction")
public class Transaction {

	@Id
	@Column(name = "hash")
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private String hash;

	@Column(name = "ver")
	private int ver;

	@Column(name = "vin_sz")
	private int vinSz;

	@Column(name = "vout_sz")
	private int voutSz;

	@Column(name = "size")
	private int size;

	@Column(name = "weight")
	private int weight;

	@Column(name = "fee")
	private long fee;

	@Column(name = "relayed_by")
	private String relayedBy;

	@Column(name = "lock_time")
	private int lockTime;

	@Column(name = "tx_index")
	private int txIndex;

	@Column(name = "double_spend")
	private boolean doubleSpend;

	@Column(name = "result")
	private long result;

	@Column(name = "balance")
	private long balance;

	@Column(name = "time")
	private long time;

	@Column(name = "block_index")
	private int blockIndex;

	@Column(name = "block_height")
	private int blockHeight;

	@ManyToOne(cascade = { CascadeType.DETACH, CascadeType.MERGE, CascadeType.PERSIST, CascadeType.REFRESH })
	@JoinColumn(name = "block_hash")
	@JsonIgnore
	private Block block;

	public Transaction() {
	}

	public Transaction(String hash, Block block) {
		this.hash = hash;
		this.block = block;
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

	public int getVinSz() {
		return vinSz;
	}

	public void setVinSz(int vinSz) {
		this.vinSz = vinSz;
	}

	public int getVoutSz() {
		return voutSz;
	}

	public void setVoutSz(int voutSz) {
		this.voutSz = voutSz;
	}

	public int getSize() {
		return size;
	}

	public void setSize(int size) {
		this.size = size;
	}

	public int getWeight() {
		return weight;
	}

	public void setWeight(int weight) {
		this.weight = weight;
	}

	public long getFee() {
		return fee;
	}

	public void setFee(long fee) {
		this.fee = fee;
	}

	public String getRelayedBy() {
		return relayedBy;
	}

	public void setRelayedBy(String relayedBy) {
		this.relayedBy = relayedBy;
	}

	public int getLockTime() {
		return lockTime;
	}

	public void setLockTime(int lockTime) {
		this.lockTime = lockTime;
	}

	public int getTxIndex() {
		return txIndex;
	}

	public void setTxIndex(int txIndex) {
		this.txIndex = txIndex;
	}

	public boolean isDoubleSpend() {
		return doubleSpend;
	}

	public void setDoubleSpend(boolean doubleSpend) {
		this.doubleSpend = doubleSpend;
	}

	public long getResult() {
		return result;
	}

	public void setResult(long result) {
		this.result = result;
	}

	public long getBalance() {
		return balance;
	}

	public void setBalance(long balance) {
		this.balance = balance;
	}

	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public int getBlockIndex() {
		return blockIndex;
	}

	public void setBlockIndex(int blockIndex) {
		this.blockIndex = blockIndex;
	}

	public int getBlockHeight() {
		return blockHeight;
	}

	public void setBlockHeight(int blockHeight) {
		this.blockHeight = blockHeight;
	}

	public Block getBlock() {
		return block;
	}

	public void setBlock(Block block) {
		this.block = block;
	}

}

public class Block {
  // The previous block hash
  private String previousBlockHash;

  // The timestamp of the block
  private long timestamp;

  // The transactions in the block
  private List<Transaction> transactions;

  // The nonce used in the block's hash
  private int nonce;

  // The block reward
  private double blockReward;

  // The address of the miner
  private String minerAddress;

  // Constructor
  public Block(List<Transaction> transactions) {
    this.previousBlockHash = "";
    this.timestamp = System.currentTimeMillis();
    this.transactions = transactions;
    this.nonce = 0;
    this.blockReward = 0;
    this.minerAddress = "";
  }

  // Get the previous block hash
  public String getPreviousBlockHash() {
    return previousBlockHash;
  }

  // Set the previous block hash
  public void setPreviousBlockHash(String previousBlockHash) {
    this.previousBlockHash = previousBlockHash;
  }

  // Get the timestamp of the block
  public long getTimestamp() {
    return timestamp;
  }

  // Get the transactions in the block
  public List<Transaction> getTransactions() {
    return transactions;
  }

  // Get the nonce used in the block's hash
  public int getNonce() {
    return nonce;
  }

  // Increment the nonce
  public void incrementNonce() {
    nonce++;
  }

  // Get the block reward
  public double getBlockReward() {
    return blockReward;
  }

  // Set the block reward
  public void setBlockReward(double blockReward) {
    this.blockReward = blockReward;
  }

  // Get the address of the miner
  public String getMinerAddress() {
    return minerAddress;
  }

  // Set the address of the miner
  public void setMinerAddress(String minerAddress) {
    this.minerAddress = minerAddress;
  }

  // Compute the hash of the block
  public String computeHash() {
    // Concatenate the block's data into a string
    String data = previousBlockHash + timestamp + minerAddress + nonce + transactions;

    // Compute the hash of the string
    return HashUtil.sha256(data);
  }
}

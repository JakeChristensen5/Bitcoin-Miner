public class Wallet {
  // The address of the wallet
  private String address;

  // The private key of the wallet
  private String privateKey;

  // The balance of the wallet
  private double balance;

  // Constructor
  public Wallet(String address, String privateKey) {
    this.address = address;
    this.privateKey = privateKey;
    this.balance = 0;
  }

  // Get the address of the wallet
  public String getAddress() {
    return address;
  }

  // Get the private key of the wallet
  public String getPrivateKey() {
    return privateKey;
  }

  // Get the balance of the wallet
  public double getBalance() {
    return balance;
  }

  // Add some bitcoins to the wallet
  public void addBitcoins(double bitcoins) {
    balance += bitcoins;
  }

  // Spend some bitcoins from the wallet
  public void spendBitcoins(double bitcoins) {
    if (balance >= bitcoins) {
      balance -= bitcoins;
    } else {
      throw new IllegalArgumentException("Insufficient funds: cannot spend this amount");
    }
  }

  // Check if a wallet address is valid
  public static boolean isValidAddress(String address) {
    // Check if the address is a valid hexadecimal string of length 40
    return address.matches("^[0-9a-fA-F]{40}$");
  }

  // Get a wallet with a given address
  public static Wallet getWallet(String address) {
    // Check if the address is valid
    if (!isValidAddress(address)) {
      throw new IllegalArgumentException("Invalid address: cannot get wallet with this address");
    }

    // Return the wallet with the given address
    return wallets.get(address);
  }
}

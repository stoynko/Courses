package _09_Workshop.repositories;

import _09_Workshop.entities.wallet.Wallet;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

public class WalletRepository implements Repository<Wallet, UUID> {

    private Map<UUID, Wallet> wallets;

    public WalletRepository() {
        this.wallets = new HashMap<>();
    }

    @Override
    public void save(UUID id, Wallet wallet) {
        this.wallets.put(id, wallet);
    }

    @Override
    public Wallet getById(UUID id) {
        return this.wallets.get(id);
    }

    @Override
    public List<Wallet> getAll() {
        return this.wallets.values().stream().toList();
    }
}

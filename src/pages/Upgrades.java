package pages;

import implementation.StartNavigation;
import input.ActionsInput;

public final class Upgrades extends ActionsInput implements Page {
    private boolean error;

    public Upgrades() { }
    public Upgrades(final int count) {
        super(count, 0);
    }

    @Override
    public void action() {
    }

    public void buyTokens() {
        error = false;
        int balance = StartNavigation.getStartNavigation().getCurrentUser()
                .getCredentials().getBalance();
        if (balance >= this.getCount()) {
            int tokensCount = StartNavigation.getStartNavigation().getCurrentUser()
                    .getTokensCount();
            StartNavigation.getStartNavigation().getCurrentUser().getCredentials()
                    .setBalance(balance - this.getCount());
            StartNavigation.getStartNavigation().getCurrentUser()
                    .setTokensCount(tokensCount + this.getCount());
        } else {
            error = true;
        }
    }

    public void buyPremiumAccount() {
        error = false;
        int tokensCount = StartNavigation.getStartNavigation().getCurrentUser().getTokensCount();
        if (tokensCount >= 10) {
            StartNavigation.getStartNavigation().getCurrentUser().setTokensCount(tokensCount - 10);
            StartNavigation.getStartNavigation().getCurrentUser().getCredentials()
                    .setAccountType("premium");
        } else {
            error = true;
        }
    }

    public boolean isError() {
        return error;
    }
}

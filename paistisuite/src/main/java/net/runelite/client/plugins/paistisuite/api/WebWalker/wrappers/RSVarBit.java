package net.runelite.client.plugins.paistisuite.api.WebWalker.wrappers;

import net.runelite.api.Client;
import net.runelite.client.plugins.paistisuite.api.PUtils;

public class RSVarBit {
    int value;

    private RSVarBit(int value) {
        this.value = value;
    }

    public int getValue() {
        return this.value;
    }

    public static RSVarBit get(int varbitId){
        Client client = PUtils.getClient();
        return new RSVarBit(client.getVarbitValue(varbitId));
    }
}
